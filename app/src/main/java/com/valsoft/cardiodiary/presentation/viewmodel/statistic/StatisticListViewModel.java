package com.valsoft.cardiodiary.presentation.viewmodel.statistic;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.Statistic;
import com.valsoft.cardiodiary.domain.usecase.GetStatisticListUseCase;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class StatisticListViewModel extends ViewModel {

    @Inject
    GetStatisticListUseCase mUseCase;

    private MutableLiveData<List<Statistic>> liveData = new MutableLiveData<>();
    private Disposable mDisposable;

    public StatisticListViewModel(){
        CardioApp.getInstance().getComponentStorage().addStatisticComponent().inject(this);
        getStatistics();
    }

    private void getStatistics(){
        mDisposable = mUseCase.getStatistic()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        list ->{
                            liveData.setValue(list);
                        },
                        throwable ->{

                        }
                );
    }

    public LiveData<List<Statistic>> getLiveData(){
        return liveData;
    }

    @Override
    protected void onCleared() {
        mDisposable.dispose();
        CardioApp.getInstance().getComponentStorage().clearStatisticComponent();
        super.onCleared();
    }
}
