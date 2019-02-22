package com.valsoft.cardiodiary.data.repository.datastore.medicalrecord;

import com.valsoft.cardiodiary.data.local.datasource.medicalrecord.MedicalRecordLocalSource;
import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;
import com.valsoft.cardiodiary.data.local.model.MedicalRecordWithDrugs;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class MedicalRecordDataStoreImpl implements MedicalRecordDataStore {

    private MedicalRecordLocalSource mLocalSource;

    public MedicalRecordDataStoreImpl(MedicalRecordLocalSource localSource){
        mLocalSource = localSource;
    }

    @Override
    public Flowable<List<MedicalRecord>> getAllRecords() {
        return mLocalSource.getAllRecords();
    }

    @Override
    public Maybe<List<MedicalRecord>> getRecordsByDate(Date date) {
        return mLocalSource.getRecordsByDate(date);
    }

    @Override
    public Single<MedicalRecord> getRecordById(long id) {
        return mLocalSource.getRecordById(id);
    }

    @Override
    public Single<MedicalRecordWithDrugs> getRecordWithDrugs(long id) {
        return mLocalSource.getRecordWithDrugs(id);
    }
}
