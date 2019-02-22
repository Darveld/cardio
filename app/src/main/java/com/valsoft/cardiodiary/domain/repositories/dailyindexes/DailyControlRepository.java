package com.valsoft.cardiodiary.domain.repositories.dailyindexes;

import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;

import java.util.Date;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;

public interface DailyControlRepository {

    Flowable<List<DailyIndexes>> getAllItems();

    Maybe<List<DailyIndexes>> getItemsByDate(Date date);

    Single<DailyIndexes> getItemById(long id);

}
