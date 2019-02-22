package com.valsoft.cardiodiary.presentation.viewmodel.diary;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.Pressure;
import com.valsoft.cardiodiary.domain.repositories.pressure.PressureRepository;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PressureViewModel extends ViewModel{

    @Inject
    PressureRepository mRepository;

    private MutableLiveData<List<Pressure>> pressureLiveData = new MutableLiveData<>();
    private Disposable mDisposable;

    public PressureViewModel(){
        CardioApp.getInstance().getComponentStorage().addGetPressureComponent().inject(this);
        getPressureList();
    }

    private void getPressureList(){
        mDisposable = mRepository.getAllItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list ->{
                    Collections.reverse(list);
                    pressureLiveData.setValue(list);
                });
    }


    public LiveData<List<Pressure>> getLiveData(){
        return pressureLiveData;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        mDisposable.dispose();
        CardioApp.getInstance().getComponentStorage().cleareGetPressureComponent();
    }
}
