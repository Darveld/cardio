package com.valsoft.cardiodiary.domain.repositories.medicalrecord;

import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;
import com.valsoft.cardiodiary.data.local.model.MedicalRecordWithDrugs;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface MedicalRecordsRepository {

    Flowable<List<MedicalRecord>> getAllRecords();

    Maybe<List<MedicalRecord>> getRecordsByDate(Date date);

    Single<MedicalRecord> getRecordById(long id);

    Single<MedicalRecordWithDrugs> getRecordWithDrugs(long id );

}
