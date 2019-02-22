package com.valsoft.cardiodiary.presentation.viewmodel.medicalcard;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;
import com.valsoft.cardiodiary.domain.repositories.medicalrecord.MedicalRecordsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MedicalRecordsViewModel extends ViewModel {

    @Inject
    MedicalRecordsRepository mRepository;
    private Disposable mDisposable;
    private MutableLiveData<List<MedicalRecord>> liveData = new MutableLiveData<>();

    public MedicalRecordsViewModel() {
        CardioApp.getInstance().getComponentStorage().addMedicalRecordComponent();
        CardioApp.getInstance().getComponentStorage().addGetMedicalRecordComponent().inject(this);
        getMedicalRecords();
    }

    private void getMedicalRecords(){
        mDisposable = mRepository.getAllRecords()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        list ->{
                            liveData.setValue(list);
                        },
                        error ->{
                            Log.d("Error ", error.getMessage());
                        }
                );
    }

    public LiveData<List<MedicalRecord>> getLiveData(){
        return liveData;
    }

    @Override
    protected void onCleared() {
        mDisposable.dispose();
        CardioApp.getInstance().getComponentStorage().clearMedicalRecordComponent();
        super.onCleared();
    }
}
