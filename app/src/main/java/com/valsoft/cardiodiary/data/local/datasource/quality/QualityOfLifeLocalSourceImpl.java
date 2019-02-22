package com.valsoft.cardiodiary.data.local.datasource.quality;

import com.valsoft.cardiodiary.data.local.dao.QualityOfLifeDao;
import com.valsoft.cardiodiary.data.local.entity.QualityOfLife;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class QualityOfLifeLocalSourceImpl implements QualityOfLifeLocalSource {

    private QualityOfLifeDao mDao;

    public QualityOfLifeLocalSourceImpl(QualityOfLifeDao dao){
        mDao = dao;
    }

    @Override
    public Flowable<List<QualityOfLife>> getItems() {
        return mDao.getItems();
    }

    @Override
    public Single<QualityOfLife> getItemById(long id) {
        return mDao.getItemById(id);
    }

    @Override
    public Single<List<QualityOfLife>> getItemByDate(Date date) {
        return mDao.getItemByDate(date);
    }

    @Override
    public void insertItem(QualityOfLife qualityOfLife) {
        mDao.insertItem(qualityOfLife);
    }

    @Override
    public void deleteItem(QualityOfLife qualityOfLife) {
        mDao.deleteItem(qualityOfLife);
    }

    @Override
    public void deleteAllItems() {
        mDao.deleteAllItems();
    }
}
