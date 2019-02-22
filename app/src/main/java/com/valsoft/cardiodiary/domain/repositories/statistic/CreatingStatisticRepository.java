package com.valsoft.cardiodiary.domain.repositories.statistic;

import com.valsoft.cardiodiary.data.local.entity.Statistic;

import io.reactivex.Completable;

public interface CreatingStatisticRepository {

    long insertStatistic(Statistic statistic);
}
