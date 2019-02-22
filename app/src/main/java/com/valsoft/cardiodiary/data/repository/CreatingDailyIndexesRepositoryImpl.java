package com.valsoft.cardiodiary.data.repository;

import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;
import com.valsoft.cardiodiary.data.repository.datastore.dailyindexes.CreatingDailyIndexesDataStore;
import com.valsoft.cardiodiary.domain.repositories.dailyindexes.CreatingDailyIndexesRepository;

import java.util.Date;

public class CreatingDailyIndexesRepositoryImpl implements CreatingDailyIndexesRepository{

    private CreatingDailyIndexesDataStore mDataStore;

    public CreatingDailyIndexesRepositoryImpl(CreatingDailyIndexesDataStore dataStore){
        mDataStore = dataStore;
    }

    @Override
    public void createDailyIndexes(int feelings, int activity, int mood, int anxiety, int irritation, int concentration, int fatigue, int psychoemotionalStress, int sleep, Date date, long statisticId) {
        DailyIndexes dailyIndexes = new DailyIndexes(feelings, activity, mood, anxiety, irritation, concentration, fatigue, psychoemotionalStress, sleep, date, statisticId);
        mDataStore.createDailyIndexes(dailyIndexes);
    }
}
