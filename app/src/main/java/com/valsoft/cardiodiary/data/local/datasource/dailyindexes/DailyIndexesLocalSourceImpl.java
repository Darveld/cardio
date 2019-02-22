package com.valsoft.cardiodiary.data.local.datasource.dailyindexes;

import com.valsoft.cardiodiary.data.local.dao.DailyIndexesDao;
import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class DailyIndexesLocalSourceImpl implements DailyIndexesLocalSource {

    private DailyIndexesDao mDao;

    public DailyIndexesLocalSourceImpl(DailyIndexesDao dao){
        mDao = dao;
    }

    @Override
    public Flowable<List<DailyIndexes>> getAllItems() {
        return mDao.getAllItems();
    }

    @Override
    public Maybe<List<DailyIndexes>> getItemsByDate(Date date) {
        return mDao.getItemsByDate(date);
    }

    @Override
    public Single<DailyIndexes> getItemById(long id) {
        return mDao.getItemById(id);
    }

    @Override
    public void insertItem(DailyIndexes item) {
        mDao.insertItem(item);
    }
    @Override
    public void deleteAllItems() {
        mDao.deleteAllItems();
    }

    @Override
    public void deleteItem(DailyIndexes item) {
        mDao.deleteItem(item);
    }
}
