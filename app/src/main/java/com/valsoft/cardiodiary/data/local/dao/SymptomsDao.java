package com.valsoft.cardiodiary.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.valsoft.cardiodiary.data.local.typeconverter.Converter;
import com.valsoft.cardiodiary.data.local.entity.Symptoms;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
@TypeConverters(Converter.class)
public interface SymptomsDao {

    @Query("SELECT * FROM symptoms_table ORDER BY datetime(date)")
    Flowable<List<Symptoms>> getAllItems();

    @Query("SELECT * FROM symptoms_table WHERE date = :date")
    Maybe<List<Symptoms>> getItemsByDate(Date date);

    @Query("SELECT * FROM symptoms_table WHERE id = :id")
    Single<Symptoms> getItemById(long id);

    @Insert
    void insertItem(Symptoms item);

    @Query("DELETE FROM symptoms_table")
    void deleteAllItems();

    @Delete
    void deleteItem(Symptoms item);

}
