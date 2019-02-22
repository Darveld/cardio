package com.valsoft.cardiodiary.data.repository.datastore.statistic;

import com.valsoft.cardiodiary.data.local.entity.Statistic;

public interface CreatingStatisticDataStore {

    long insertStatistic(Statistic statistic);
}
