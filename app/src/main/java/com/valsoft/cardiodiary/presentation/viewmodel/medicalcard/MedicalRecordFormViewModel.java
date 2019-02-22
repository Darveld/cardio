package com.valsoft.cardiodiary.presentation.viewmodel.medicalcard;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.net.Uri;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;
import com.valsoft.cardiodiary.domain.repositories.medicalrecord.CreatingMedicalRecordRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Consumer;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MedicalRecordFormViewModel extends ViewModel {

    @Inject
    CreatingMedicalRecordRepository mRepository;
    private MutableLiveData<Boolean> liveData = new MutableLiveData<>();

    public MedicalRecordFormViewModel() {
        CardioApp.getInstance().getComponentStorage().addCreateMedicalRecordComponent().inject(this);
    }

    public LiveData<Boolean> getLiveData(){
        return liveData;
    }

    public void createRecord(String title, String advice, String plannedInspections,
                             String plannedVisits, List<MedicalDrug> drugList, List<Uri> uriList){
        List<String> uries = new ArrayList<>();
        MedicalRecord record = new MedicalRecord();
        record.setTitle(title);
        record.setMedicalNotes(advice);
        record.setPlannedInspection(plannedInspections);
        record.setPlannedVisits(plannedVisits);
        for (Uri item:uriList) {
            uries.add(item.toString());
        }
        record.setImages(uries);
        record.setDate(Calendar.getInstance().getTime());
        mRepository.insertMedicalRecords(record, drugList)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        liveData.setValue(true);
                    }

                    @Override
                    public void onError(Throwable e) {
                        liveData.setValue(false);
                    }
                });

    }

    @Override
    protected void onCleared() {
        CardioApp.getInstance().getComponentStorage().clearCreateMedicalRecordComponent();
        super.onCleared();
    }
}
