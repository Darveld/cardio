package com.valsoft.cardiodiary.data.repository.datastore.statistic;

import com.valsoft.cardiodiary.data.local.entity.Statistic;
import com.valsoft.cardiodiary.data.local.model.StatisticWithDiary;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface StatisticDataStore {

    Flowable<List<Statistic>> getAllStatistics();

    Single<List<Statistic>> getStatisticByDate(int month, int year);

    Single<Statistic> getStatisticById(long id);

    Single<StatisticWithDiary> getStatisticWithDiary(long id);

}
