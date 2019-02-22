package com.valsoft.cardiodiary.data.local.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.TypeConverters;

import com.valsoft.cardiodiary.data.local.entity.Statistic;
import com.valsoft.cardiodiary.data.local.model.StatisticWithDiary;
import com.valsoft.cardiodiary.data.local.typeconverter.Converter;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

@Dao
@TypeConverters(Converter.class)
public interface StatisticDao {

    @Query("SELECT * FROM statistic_table")
    Flowable<List<Statistic>> getAllStatistics();

    @Query("SELECT * FROM statistic_table WHERE statistic_month =:month and statistic_year =:year")
    Single<List<Statistic>> getStatisticByDate(int month, int year);

    @Query("SELECT * FROM statistic_table WHERE id =:id")
    Single<Statistic> getStatisticById(long id);

    @Query("SELECT id, statistic_month, statistic_year FROM statistic_table WHERE id =:id")
    Single<StatisticWithDiary> getStatisticWithDiary(long id);

    @Insert
    long insertStatistic(Statistic statistic);

    @Query("DELETE FROM statistic_table")
    void deleteAllStatistic();

    @Delete
    void deleteStatistic(Statistic statistic);

}
