package com.valsoft.cardiodiary.domain.repositories.symptom;

import com.valsoft.cardiodiary.data.local.entity.Symptoms;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface SymptomsRepository {

    Flowable<List<Symptoms>> getAllItems();

    Maybe<List<Symptoms>> getItemsByDate(Date date);

    Single<Symptoms> getItemById(long id);
}
