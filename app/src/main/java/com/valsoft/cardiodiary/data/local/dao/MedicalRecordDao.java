package com.valsoft.cardiodiary.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.valsoft.cardiodiary.data.local.typeconverter.Converter;
import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;
import com.valsoft.cardiodiary.data.local.model.MedicalRecordWithDrugs;
import com.valsoft.cardiodiary.data.local.typeconverter.UriConverter;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
@TypeConverters({Converter.class, UriConverter.class})
public interface MedicalRecordDao {

    @Query("SELECT * FROM medical_records_table ORDER BY datetime(date)")
    Flowable<List<MedicalRecord>> getAllRecords();

    @Query("SELECT * FROM medical_records_table WHERE date = :date")
    Maybe<List<MedicalRecord>> getRecordsByDate(Date date);

    @Query("SELECT * FROM medical_records_table WHERE id = :id")
    Single<MedicalRecord> getRecordById(long id);

    @Query("SELECT id, date, title, medical_notes, images, planned_inspection, planned_visits FROM medical_records_table WHERE id = :id")
    Single<MedicalRecordWithDrugs> getRecordWithDrugs(long id );

    @Insert
    long insertRecord(MedicalRecord medicalRecord);

    @Query("DELETE FROM medical_records_table")
    void deleteAllRecords();

    @Delete
    void deleteRecord(MedicalRecord medicalRecord);

}
