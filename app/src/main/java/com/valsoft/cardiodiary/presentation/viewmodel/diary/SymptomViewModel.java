package com.valsoft.cardiodiary.presentation.viewmodel.diary;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.Symptoms;
import com.valsoft.cardiodiary.domain.repositories.symptom.SymptomsRepository;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SymptomViewModel extends ViewModel{

    @Inject
    SymptomsRepository mRepository;

    private MutableLiveData<List<Symptoms>> liveData = new MutableLiveData<>();
    private Disposable mDisposable;
    public SymptomViewModel(){
        CardioApp.getInstance().getComponentStorage().addGetSymptomComponent().inject(this);
        getSymptomsList();
    }


    private void getSymptomsList(){
        mDisposable = mRepository.getAllItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list ->{
                    Collections.reverse(list);
                    liveData.setValue(list);
                });
    }

    public LiveData<List<Symptoms>> getLiveData(){
        return liveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mDisposable.dispose();
        CardioApp.getInstance().getComponentStorage().clearGetSymptomComponent();
    }
}
