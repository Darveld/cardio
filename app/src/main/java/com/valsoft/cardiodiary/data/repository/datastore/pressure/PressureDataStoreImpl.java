package com.valsoft.cardiodiary.data.repository.datastore.pressure;

import com.valsoft.cardiodiary.data.local.datasource.heartwork.PressureLocalSource;
import com.valsoft.cardiodiary.data.local.entity.Pressure;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class PressureDataStoreImpl implements PressureDataStore {

    private PressureLocalSource mPressureLocalSource;

    public PressureDataStoreImpl(PressureLocalSource pressureLocalSource){
        mPressureLocalSource = pressureLocalSource;
    }

    @Override
    public Flowable<List<Pressure>> getAllItems() {
        return mPressureLocalSource.getAllItems();
    }

    @Override
    public Maybe<List<Pressure>> getItemsByDate(Date beginningOfTheDay, Date endingOfTheDay) {
        return mPressureLocalSource.getItemsByDate(beginningOfTheDay, endingOfTheDay);
    }

    @Override
    public Single<Pressure> getItemById(int id) {
        return mPressureLocalSource.getItemById(id);
    }
}
