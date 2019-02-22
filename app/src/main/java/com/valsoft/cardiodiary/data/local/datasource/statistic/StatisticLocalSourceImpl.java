package com.valsoft.cardiodiary.data.local.datasource.statistic;

import com.valsoft.cardiodiary.data.local.dao.StatisticDao;
import com.valsoft.cardiodiary.data.local.entity.Statistic;
import com.valsoft.cardiodiary.data.local.model.StatisticWithDiary;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class StatisticLocalSourceImpl implements StatisticLocalSource{

    private StatisticDao mDao;

    public StatisticLocalSourceImpl(StatisticDao dao){
        mDao = dao;
    }

    @Override
    public Flowable<List<Statistic>> getAllStatistics() {
        return mDao.getAllStatistics();
    }

    @Override
    public Single<List<Statistic>> getStatisticByDate(int month, int year) {
        return mDao.getStatisticByDate(month, year);
    }

    @Override
    public Single<Statistic> getStatisticById(long id) {
        return mDao.getStatisticById(id);
    }

    @Override
    public Single<StatisticWithDiary> getStatisticWithDiary(long id) {
        return mDao.getStatisticWithDiary(id);
    }

    @Override
    public long insertStatistic(Statistic statistic) {
        return mDao.insertStatistic(statistic);
    }

    @Override
    public void deleteAllStatistic() {
        mDao.deleteAllStatistic();
    }

    @Override
    public void deleteStatistic(Statistic statistic) {
        mDao.deleteStatistic(statistic);
    }
}
