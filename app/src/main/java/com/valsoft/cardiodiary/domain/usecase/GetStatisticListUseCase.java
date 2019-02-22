package com.valsoft.cardiodiary.domain.usecase;

import com.valsoft.cardiodiary.data.local.entity.Statistic;

import java.util.List;

import io.reactivex.Flowable;

public interface GetStatisticListUseCase {

    Flowable<List<Statistic>> getStatistic();
}
