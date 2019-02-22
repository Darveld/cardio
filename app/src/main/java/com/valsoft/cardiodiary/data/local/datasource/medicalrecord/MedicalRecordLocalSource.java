package com.valsoft.cardiodiary.data.local.datasource.medicalrecord;

import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;
import com.valsoft.cardiodiary.data.local.model.MedicalRecordWithDrugs;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface MedicalRecordLocalSource {

    Flowable<List<MedicalRecord>> getAllRecords();

    Maybe<List<MedicalRecord>> getRecordsByDate(Date date);

    Single<MedicalRecord> getRecordById(long id);

    Single<MedicalRecordWithDrugs> getRecordWithDrugs(long id );

    long insertRecord(MedicalRecord medicalRecord);

    void deleteAllRecords();

    void deleteRecord(MedicalRecord medicalRecord);

}
