package com.valsoft.cardiodiary.data.repository.datastore.quality;

import com.valsoft.cardiodiary.data.local.datasource.quality.QualityOfLifeLocalSource;
import com.valsoft.cardiodiary.data.local.entity.QualityOfLife;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Single;

public class QualityDataStoreImpl implements QualityDataStore{

    private QualityOfLifeLocalSource mLocalSource;

    public QualityDataStoreImpl(QualityOfLifeLocalSource localSource){
        mLocalSource = localSource;
    }

    @Override
    public Flowable<List<QualityOfLife>> getItems() {
        return mLocalSource.getItems();
    }

    @Override
    public Single<QualityOfLife> getItemById(long id) {
        return mLocalSource.getItemById(id);
    }

    @Override
    public Single<List<QualityOfLife>> getItemByDate(Date date) {
        return mLocalSource.getItemByDate(date);
    }
}
