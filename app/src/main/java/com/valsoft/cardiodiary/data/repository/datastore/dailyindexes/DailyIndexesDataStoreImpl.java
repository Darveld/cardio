package com.valsoft.cardiodiary.data.repository.datastore.dailyindexes;

import com.valsoft.cardiodiary.data.local.datasource.dailyindexes.DailyIndexesLocalSource;
import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class DailyIndexesDataStoreImpl implements DailyIndexesDataStore {

    private DailyIndexesLocalSource mLocalSource;

    public DailyIndexesDataStoreImpl(DailyIndexesLocalSource localSource){
        mLocalSource = localSource;
    }

    @Override
    public Flowable<List<DailyIndexes>> getAllItems() {
        return mLocalSource.getAllItems();
    }

    @Override
    public Maybe<List<DailyIndexes>> getItemsByDate(Date date) {
        return mLocalSource.getItemsByDate(date);
    }

    @Override
    public Single<DailyIndexes> getItemById(long id) {
        return mLocalSource.getItemById(id);
    }
}
