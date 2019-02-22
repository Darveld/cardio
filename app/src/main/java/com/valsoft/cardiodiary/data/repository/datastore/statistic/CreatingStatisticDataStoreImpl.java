package com.valsoft.cardiodiary.data.repository.datastore.statistic;

import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSource;
import com.valsoft.cardiodiary.data.local.entity.Statistic;

public class CreatingStatisticDataStoreImpl implements CreatingStatisticDataStore{

    private StatisticLocalSource mLocalSource;

    public CreatingStatisticDataStoreImpl(StatisticLocalSource localSource){
        mLocalSource = localSource;
    }

    @Override
    public long insertStatistic(Statistic statistic) {
        return mLocalSource.insertStatistic(statistic);
    }
}
