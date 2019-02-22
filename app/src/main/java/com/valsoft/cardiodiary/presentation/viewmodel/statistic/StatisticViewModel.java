package com.valsoft.cardiodiary.presentation.viewmodel.statistic;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.domain.model.StatisticItem;
import com.valsoft.cardiodiary.domain.usecase.GetStatisticUseCase;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class StatisticViewModel extends ViewModel {

    @Inject
    GetStatisticUseCase mUseCase;
    private MutableLiveData<StatisticItem> liveData = new MutableLiveData<>();
    private Disposable mDisposable;
    public StatisticViewModel(){
        CardioApp.getInstance().getComponentStorage().addStatisticComponent().inject(this);
    }

    public void getStatisticItem(long id){
        mDisposable = mUseCase.getStatisticItem(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        item -> liveData.setValue(item),
                        error -> Log.d("Request Error ", error.getMessage())
                );
    }

    public LiveData<StatisticItem> getLiveData(){
        return liveData;
    }

    @Override
    protected void onCleared() {
        mDisposable.dispose();
        super.onCleared();
    }
}
