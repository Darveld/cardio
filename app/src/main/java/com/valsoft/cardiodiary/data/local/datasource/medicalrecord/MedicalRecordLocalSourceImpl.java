package com.valsoft.cardiodiary.data.local.datasource.medicalrecord;

import com.valsoft.cardiodiary.data.local.dao.MedicalRecordDao;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;
import com.valsoft.cardiodiary.data.local.model.MedicalRecordWithDrugs;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class MedicalRecordLocalSourceImpl implements MedicalRecordLocalSource {

    private MedicalRecordDao mDao;

    public MedicalRecordLocalSourceImpl(MedicalRecordDao dao){
        mDao = dao;
    }


    @Override
    public Flowable<List<MedicalRecord>> getAllRecords() {
        return mDao.getAllRecords();
    }

    @Override
    public Maybe<List<MedicalRecord>> getRecordsByDate(Date date) {
        return mDao.getRecordsByDate(date);
    }

    @Override
    public Single<MedicalRecord> getRecordById(long id) {
        return mDao.getRecordById(id);
    }

    @Override
    public Single<MedicalRecordWithDrugs> getRecordWithDrugs(long id) {
        return mDao.getRecordWithDrugs(id);
    }

    @Override
    public long insertRecord(MedicalRecord medicalRecord) {
        return mDao.insertRecord(medicalRecord);
    }



    @Override
    public void deleteAllRecords() {
        mDao.deleteAllRecords();
    }

    @Override
    public void deleteRecord(MedicalRecord medicalRecord) {
        mDao.deleteRecord(medicalRecord);
    }

}
