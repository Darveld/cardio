package com.valsoft.cardiodiary.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.valsoft.cardiodiary.data.local.entity.QualityOfLife;
import com.valsoft.cardiodiary.data.local.typeconverter.Converter;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
@TypeConverters(Converter.class)
public interface QualityOfLifeDao {

    @Query("SELECT * FROM quality_table")
    Flowable<List<QualityOfLife>> getItems();

    @Query("SELECT * FROM quality_table WHERE id =:id")
    Single<QualityOfLife> getItemById(long id);

    @Query("SELECT * FROM quality_table WHERE date =:date")
    Single<List<QualityOfLife>> getItemByDate(Date date);

    @Insert
    void insertItem(QualityOfLife qualityOfLife);

    @Delete
    void deleteItem(QualityOfLife qualityOfLife);

    @Query("DELETE FROM symptoms_table")
    void deleteAllItems();
}
