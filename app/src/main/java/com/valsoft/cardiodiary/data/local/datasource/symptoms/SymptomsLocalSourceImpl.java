package com.valsoft.cardiodiary.data.local.datasource.symptoms;

import com.valsoft.cardiodiary.data.local.dao.SymptomsDao;
import com.valsoft.cardiodiary.data.local.entity.Symptoms;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class SymptomsLocalSourceImpl implements SymptomsLocalSource {

    private SymptomsDao mDao;

    public SymptomsLocalSourceImpl(SymptomsDao dao){
        mDao = dao;
    }

    @Override
    public Flowable<List<Symptoms>> getAllItems() {
        return mDao.getAllItems();
    }

    @Override
    public Maybe<List<Symptoms>> getItemsByDate(Date date) {
        return mDao.getItemsByDate(date);
    }

    @Override
    public Single<Symptoms> getItemById(long id) {
        return mDao.getItemById(id);
    }

    @Override
    public void insertItem(Symptoms item) {
        mDao.insertItem(item);
    }

    @Override
    public void deleteAllItems() {
        mDao.deleteAllItems();
    }

    @Override
    public void deleteItem(Symptoms item) {
        mDao.deleteItem(item);
    }
}
