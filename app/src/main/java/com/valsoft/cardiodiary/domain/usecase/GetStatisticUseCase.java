package com.valsoft.cardiodiary.domain.usecase;

import com.valsoft.cardiodiary.domain.model.StatisticItem;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface GetStatisticUseCase {

    Single<StatisticItem> getStatisticItem(long id);
}
