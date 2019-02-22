package com.valsoft.cardiodiary.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
public interface MedicalDrugDao {

    @Query("SELECT * FROM medical_drugs_table")
    Flowable<List<MedicalDrug>> getAllDrugs();

    @Query("SELECT * FROM medical_drugs_table WHERE medical_record_id = :key")
    Maybe<List<MedicalDrug>> getDrugsByKey(long key);

    @Query("SELECT * FROM medical_drugs_table WHERE id = :id")
    Single<MedicalDrug> getDrugById(long id);

    @Insert
    void insertDrug(MedicalDrug medicalDrug);

    @Insert
    void insertDrugs(List<MedicalDrug> medicalDrugs);

    @Query("DELETE FROM medical_drugs_table")
    void deleteAllDrugs();

    @Delete
    void deleteDrug(MedicalDrug medicalDrug);
}
