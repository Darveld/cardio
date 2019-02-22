package com.valsoft.cardiodiary.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.valsoft.cardiodiary.data.local.typeconverter.Converter;
import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
@TypeConverters(Converter.class)
public interface DailyIndexesDao {

    @Query("SELECT * FROM daily_indexes_table ORDER BY datetime(date)")
    Flowable<List<DailyIndexes>> getAllItems();

    @Query("SELECT * FROM daily_indexes_table WHERE date = :date")
    Maybe<List<DailyIndexes>> getItemsByDate(Date date);

    @Query("SELECT * FROM daily_indexes_table WHERE id = :id")
    Single<DailyIndexes> getItemById(long id);

    @Insert
    void insertItem(DailyIndexes item);

    @Query("DELETE FROM daily_indexes_table")
    void deleteAllItems();

    @Delete
    void deleteItem(DailyIndexes item);


}
