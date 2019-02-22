package com.valsoft.cardiodiary.data.repository.datastore.symptom;

import com.valsoft.cardiodiary.data.local.entity.Symptoms;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface SymptomsDataStore {

    Flowable<List<Symptoms>> getAllItems();

    Maybe<List<Symptoms>> getItemsByDate(Date date);

    Single<Symptoms> getItemById(long id);

}
