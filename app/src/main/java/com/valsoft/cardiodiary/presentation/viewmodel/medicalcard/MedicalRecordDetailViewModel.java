package com.valsoft.cardiodiary.presentation.viewmodel.medicalcard;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;
import com.valsoft.cardiodiary.domain.repositories.medicalrecord.MedicalRecordsRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MedicalRecordDetailViewModel extends ViewModel {

    @Inject
    MedicalRecordsRepository mRepository;
    private Disposable mDisposable;
    private MutableLiveData<MedicalRecord> recordLiveData = new MutableLiveData<>();
    private MutableLiveData<List<MedicalDrug>> drugLiveData = new MutableLiveData<>();
    public MedicalRecordDetailViewModel() {
        CardioApp.getInstance().getComponentStorage().addGetMedicalRecordComponent().inject(this);
    }

    public void getData(long id){
        mDisposable = mRepository.getRecordWithDrugs(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(medicalRecordWithDrugs -> {
                   recordLiveData.setValue(medicalRecordWithDrugs.getMedicalRecord());
                   if (medicalRecordWithDrugs.getDrugList() != null){
                       drugLiveData.setValue(medicalRecordWithDrugs.getDrugList());
                   }
                });
    }

    public LiveData<MedicalRecord> getRecordLiveData(){
        return recordLiveData;
    }
    public LiveData<List<MedicalDrug>> getDrugLiveData(){
        return drugLiveData;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
