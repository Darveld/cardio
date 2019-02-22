package com.valsoft.cardiodiary.data.local.datasource.dailyindexes;

import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface DailyIndexesLocalSource {

    Flowable<List<DailyIndexes>> getAllItems();

    Maybe<List<DailyIndexes>> getItemsByDate(Date date);

    Single<DailyIndexes> getItemById(long id);

    void insertItem(DailyIndexes item);

    void deleteAllItems();

    void deleteItem(DailyIndexes item);
}
