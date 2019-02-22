package com.valsoft.cardiodiary.data.repository.datastore.symptom;

import com.valsoft.cardiodiary.data.local.datasource.symptoms.SymptomsLocalSource;
import com.valsoft.cardiodiary.data.local.entity.Symptoms;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class SymptomsDataStoreImpl implements SymptomsDataStore {

    private SymptomsLocalSource mLocalSource;

    public SymptomsDataStoreImpl(SymptomsLocalSource localSource){
        mLocalSource = localSource;
    }

    @Override
    public Flowable<List<Symptoms>> getAllItems() {
        return mLocalSource.getAllItems();
    }

    @Override
    public Maybe<List<Symptoms>> getItemsByDate(Date date) {
        return mLocalSource.getItemsByDate(date);
    }

    @Override
    public Single<Symptoms> getItemById(long id) {
        return mLocalSource.getItemById(id);
    }
}
