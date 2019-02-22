package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.entity.Statistic;
import com.valsoft.cardiodiary.data.local.model.StatisticWithDiary;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.StatisticDataStore;
import com.valsoft.cardiodiary.domain.repositories.statistic.StatisticRepository;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class StatisticRepositoryImpl implements StatisticRepository {

    private StatisticDataStore mDataStore;

    public StatisticRepositoryImpl(StatisticDataStore dataStore){
        mDataStore = dataStore;
    }

    @Override
    public Flowable<List<Statistic>> getAllStatistics() {
        return mDataStore.getAllStatistics();
    }

    @Override
    public Single<List<Statistic>> getStatisticByDate(int month, int year) {
        return mDataStore.getStatisticByDate(month, year);
    }

    @Override
    public Single<Statistic> getStatisticById(long id) {
        return mDataStore.getStatisticById(id);
    }

    @Override
    public Single<StatisticWithDiary> getStatisticWithDiary(long id) {
        return mDataStore.getStatisticWithDiary(id);
    }
}
