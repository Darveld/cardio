package com.valsoft.cardiodiary.presentation.viewmodel.diary;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;
import com.valsoft.cardiodiary.domain.repositories.dailyindexes.DailyControlRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DailyControlDetailViewModel extends ViewModel {

    @Inject
    DailyControlRepository mRepository;
    private Disposable mDisposable;
    private MutableLiveData<DailyIndexes> liveDate = new MutableLiveData<>();

    public DailyControlDetailViewModel() {
        CardioApp.getInstance().getComponentStorage().addGetDailyIndexesComponent().inject(this);
    }

    public void getDailyIndexes(long id){
        mDisposable = mRepository.getItemById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        item ->{
                            liveDate.setValue(item);
                        },
                        error ->{
                            Log.d("Error ", error.getMessage());
                        }
                );
    }

    public LiveData<DailyIndexes> getLiveData(){
        return liveDate;
    }

    @Override
    protected void onCleared() {
        mDisposable.dispose();
        CardioApp.getInstance().getComponentStorage().clearGetDailyIndexesComponent();
        super.onCleared();
    }
}
