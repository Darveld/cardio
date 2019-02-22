package com.valsoft.cardiodiary.presentation.viewmodel.diary;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.Symptoms;
import com.valsoft.cardiodiary.domain.repositories.symptom.SymptomsRepository;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SymptomDetailViewModel extends ViewModel {

    @Inject
    SymptomsRepository mRepository;
    private Disposable mDisposable;
    private MutableLiveData<Symptoms> liveData = new MutableLiveData<>();
    public SymptomDetailViewModel() {
        CardioApp.getInstance().getComponentStorage().addGetSymptomComponent().inject(this);
    }

    public void getSymptoms(long id){
        mDisposable = mRepository.getItemById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        item ->{
                            liveData.setValue(item);
                },
                        error ->{
                            Log.d("Error ", error.getMessage());
                });
    }

    public LiveData<Symptoms> getLiveData(){
        return liveData;
    }

    @Override
    protected void onCleared() {
        mDisposable.dispose();
        CardioApp.getInstance().getComponentStorage().clearGetSymptomComponent();
        super.onCleared();

    }
}
