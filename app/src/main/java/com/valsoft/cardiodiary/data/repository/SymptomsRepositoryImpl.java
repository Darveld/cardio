package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.entity.Symptoms;
import com.valsoft.cardiodiary.data.repository.datastore.symptom.SymptomsDataStore;
import com.valsoft.cardiodiary.domain.repositories.symptom.SymptomsRepository;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class SymptomsRepositoryImpl implements SymptomsRepository {

    private SymptomsDataStore mDataStore;

    public SymptomsRepositoryImpl(SymptomsDataStore dataStore){
        mDataStore = dataStore;
    }

    @Override
    public Flowable<List<Symptoms>> getAllItems() {
        return mDataStore.getAllItems();
    }

    @Override
    public Maybe<List<Symptoms>> getItemsByDate(Date date) {
        return mDataStore.getItemsByDate(date);
    }

    @Override
    public Single<Symptoms> getItemById(long id) {
        return mDataStore.getItemById(id);
    }
}
