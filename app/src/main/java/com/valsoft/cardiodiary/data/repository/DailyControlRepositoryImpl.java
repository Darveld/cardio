package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;
import com.valsoft.cardiodiary.data.repository.datastore.dailyindexes.DailyIndexesDataStore;
import com.valsoft.cardiodiary.domain.repositories.dailyindexes.DailyControlRepository;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class DailyControlRepositoryImpl implements DailyControlRepository{

    private DailyIndexesDataStore mDataStore;

    public DailyControlRepositoryImpl(DailyIndexesDataStore dataStore){
        mDataStore = dataStore;
    }

    @Override
    public Flowable<List<DailyIndexes>> getAllItems() {
        return mDataStore.getAllItems();
    }

    @Override
    public Maybe<List<DailyIndexes>> getItemsByDate(Date date) {
        return mDataStore.getItemsByDate(date);
    }

    @Override
    public Single<DailyIndexes> getItemById(long id) {
        return mDataStore.getItemById(id);
    }
}
