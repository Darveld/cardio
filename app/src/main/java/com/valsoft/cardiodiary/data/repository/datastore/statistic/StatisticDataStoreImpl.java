package com.valsoft.cardiodiary.data.repository.datastore.statistic;

import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSource;
import com.valsoft.cardiodiary.data.local.entity.Statistic;
import com.valsoft.cardiodiary.data.local.model.StatisticWithDiary;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class StatisticDataStoreImpl implements StatisticDataStore {

    private StatisticLocalSource mLocalSource;

    public StatisticDataStoreImpl(StatisticLocalSource localSource) {
        mLocalSource = localSource;
    }

    @Override
    public Flowable<List<Statistic>> getAllStatistics() {
        return mLocalSource.getAllStatistics();
    }

    @Override
    public Single<List<Statistic>> getStatisticByDate(int month, int year) {
        return mLocalSource.getStatisticByDate(month, year);
    }

    @Override
    public Single<Statistic> getStatisticById(long id) {
        return mLocalSource.getStatisticById(id);
    }

    @Override
    public Single<StatisticWithDiary> getStatisticWithDiary(long id) {
        return mLocalSource.getStatisticWithDiary(id);
    }
}
