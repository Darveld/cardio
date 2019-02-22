package com.valsoft.cardiodiary.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.valsoft.cardiodiary.data.local.entity.Reminding;
import com.valsoft.cardiodiary.data.local.model.RemindingWithDrugs;
import com.valsoft.cardiodiary.data.local.typeconverter.Converter;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
@TypeConverters(Converter.class)
public interface RemindingDao {

    @Query("SELECT * FROM reminding_table")
    Flowable<List<Reminding>> getAllReminding();

    @Query("SELECT * FROM reminding_table WHERE first_date = :date")
    Maybe<List<Reminding>> getRemindingByDate(Date date);

    @Query("SELECT * FROM reminding_table WHERE id = :id")
    Single<Reminding> getRemindingById(long id);

    @Query("SELECT id, title, description, type_of_reminding, first_date, secondary_date FROM reminding_table WHERE id = :id")
    Single<RemindingWithDrugs> getRemindingWithDrugs(long id);

    @Insert
    long insertReminding(Reminding reminding);

    @Query("DELETE FROM reminding_table")
    void deleteAllReminding();

    @Delete
    void deleteReminding(Reminding reminding);
}
