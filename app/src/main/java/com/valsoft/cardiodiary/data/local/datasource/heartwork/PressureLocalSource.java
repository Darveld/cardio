package com.valsoft.cardiodiary.data.local.datasource.heartwork;

import com.valsoft.cardiodiary.data.local.entity.Pressure;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface PressureLocalSource {



    Flowable<List<Pressure>> getAllItems();

    Maybe<List<Pressure>> getItemsByDate(Date beginningOfTheDay, Date endingOfTheDay);

    Single<Pressure> getItemById(int id);

    void insertItem(Pressure item);

    void deleteAllItems();

    void deleteItem(Pressure item);

}
