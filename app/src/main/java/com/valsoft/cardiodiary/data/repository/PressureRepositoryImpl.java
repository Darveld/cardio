package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.entity.Pressure;
import com.valsoft.cardiodiary.data.repository.datastore.pressure.PressureDataStore;
import com.valsoft.cardiodiary.domain.repositories.pressure.PressureRepository;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class PressureRepositoryImpl implements PressureRepository {

    private PressureDataStore mPressureDataStore;

    public PressureRepositoryImpl(PressureDataStore pressureDataStore){
        mPressureDataStore = pressureDataStore;
    }

    @Override
    public Flowable<List<Pressure>> getAllItems() {
        return mPressureDataStore.getAllItems();
    }

    @Override
    public Maybe<List<Pressure>> getItemsByDate(Date beginningOfTheDay, Date endingOfTheDay) {
        return mPressureDataStore.getItemsByDate(beginningOfTheDay, endingOfTheDay);
    }

    @Override
    public Single<Pressure> getItemById(int id) {
        return mPressureDataStore.getItemById(id);
    }
}
