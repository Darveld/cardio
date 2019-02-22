package com.valsoft.cardiodiary.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.valsoft.cardiodiary.data.local.typeconverter.Converter;
import com.valsoft.cardiodiary.data.local.entity.Pressure;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
@TypeConverters(Converter.class)
public interface PressureDao {

    @Query("SELECT * FROM pressure ORDER BY datetime(date)")
    Flowable<List<Pressure>> getAllItems();

    @Query("SELECT * FROM pressure WHERE date BETWEEN :beginningOfTheDay and :endingOfTheDay ")
    Maybe<List<Pressure>> getItemsByDate(Date beginningOfTheDay, Date endingOfTheDay);

    @Query("SELECT * FROM pressure WHERE id = :id")
    Single<Pressure> getItemById(int id);

    @Insert
    void insertItem(Pressure item);

    @Query("DELETE FROM pressure")
    void deleteAllItems();

    @Delete
    void deleteItem(Pressure item);
}
