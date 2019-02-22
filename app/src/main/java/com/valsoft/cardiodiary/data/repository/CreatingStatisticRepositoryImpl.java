package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.entity.Statistic;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.CreatingStatisticDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.CreatingStatisticDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.statistic.CreatingStatisticRepository;

import io.reactivex.Completable;

public class CreatingStatisticRepositoryImpl implements CreatingStatisticRepository {

    private CreatingStatisticDataStore mDataStore;

    public CreatingStatisticRepositoryImpl(CreatingStatisticDataStore dataStore){
        mDataStore = dataStore;
    }

    @Override
    public long insertStatistic(Statistic statistic) {
        return mDataStore.insertStatistic(statistic);
    }
}
