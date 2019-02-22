package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.entity.QualityOfLife;
import com.valsoft.cardiodiary.data.repository.datastore.quality.QualityDataStore;
import com.valsoft.cardiodiary.domain.repositories.quality.QualityRepository;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class QualityRepositoryImpl implements QualityRepository {

    private QualityDataStore mDataStore;

    public QualityRepositoryImpl(QualityDataStore dataStore){
        mDataStore = dataStore;
    }

    @Override
    public Flowable<List<QualityOfLife>> getItems() {
        return mDataStore.getItems();
    }

    @Override
    public Single<QualityOfLife> getItemById(long id) {
        return mDataStore.getItemById(id);
    }

    @Override
    public Single<List<QualityOfLife>> getItemByDate(Date date) {
        return mDataStore.getItemByDate(date);
    }
}
