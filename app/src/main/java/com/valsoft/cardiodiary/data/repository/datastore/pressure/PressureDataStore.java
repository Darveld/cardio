package com.valsoft.cardiodiary.data.repository.datastore.pressure;

import com.valsoft.cardiodiary.data.local.entity.Pressure;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface PressureDataStore {
    Flowable<List<Pressure>> getAllItems();

    Maybe<List<Pressure>> getItemsByDate(Date beginningOfTheDay, Date endingOfTheDay);

    Single<Pressure> getItemById(int id);
}
