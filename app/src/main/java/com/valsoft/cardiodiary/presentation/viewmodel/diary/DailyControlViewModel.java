package com.valsoft.cardiodiary.presentation.viewmodel.diary;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;
import com.valsoft.cardiodiary.domain.repositories.dailyindexes.DailyControlRepository;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DailyControlViewModel extends ViewModel{

    @Inject
    DailyControlRepository mRepository;

    private MutableLiveData<List<DailyIndexes>> liveData = new MutableLiveData<>();
    private Disposable mDisposable;
    public DailyControlViewModel(){
        CardioApp.getInstance().getComponentStorage().addGetDailyIndexesComponent().inject(this);
        getDailyIndexes();
    }

    private void getDailyIndexes(){
        mDisposable = mRepository.getAllItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> {
                    Collections.reverse(list);
                    liveData.setValue(list);
                });
    }

    public LiveData<List<DailyIndexes>> getLiveData(){
        return liveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mDisposable.dispose();
        CardioApp.getInstance().getComponentStorage().clearGetDailyIndexesComponent();
    }
}
