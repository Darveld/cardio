package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;
import com.valsoft.cardiodiary.data.local.model.MedicalRecordWithDrugs;
import com.valsoft.cardiodiary.data.repository.datastore.medicalrecord.MedicalRecordDataStore;
import com.valsoft.cardiodiary.domain.repositories.medicalrecord.MedicalRecordsRepository;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class MedicalRecordsRepositoryImpl implements MedicalRecordsRepository{

    private MedicalRecordDataStore mDataStore;

    public MedicalRecordsRepositoryImpl(MedicalRecordDataStore dataStore){
        mDataStore = dataStore;
    }

    @Override
    public Flowable<List<MedicalRecord>> getAllRecords() {
        return mDataStore.getAllRecords();
    }

    @Override
    public Maybe<List<MedicalRecord>> getRecordsByDate(Date date) {
        return mDataStore.getRecordsByDate(date);
    }

    @Override
    public Single<MedicalRecord> getRecordById(long id) {
        return mDataStore.getRecordById(id);
    }

    @Override
    public Single<MedicalRecordWithDrugs> getRecordWithDrugs(long id) {
        return mDataStore.getRecordWithDrugs(id);
    }
}
