package com.valsoft.cardiodiary.data.local.datasource.heartwork;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.dao.PressureDao;
import com.valsoft.cardiodiary.data.local.entity.Pressure;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class PressureLocalSourceImpl implements PressureLocalSource {


    private PressureDao mDao;

    public PressureLocalSourceImpl(PressureDao dao){
        mDao = dao;
    }

    @Override
    public Flowable<List<Pressure>> getAllItems() {
        return mDao.getAllItems();
    }

    @Override
    public Maybe<List<Pressure>> getItemsByDate(Date beginningOfTheDay, Date endingOfTheDay) {
        return mDao.getItemsByDate(beginningOfTheDay, endingOfTheDay);
    }

    @Override
    public Single<Pressure> getItemById(int id) {
        return mDao.getItemById(id);
    }

    @Override
    public void insertItem(Pressure item) {
        mDao.insertItem(item);
    }

    @Override
    public void deleteAllItems() {
        mDao.deleteAllItems();
    }

    @Override
    public void deleteItem(Pressure item) {
        mDao.deleteItem(item);
    }
}
