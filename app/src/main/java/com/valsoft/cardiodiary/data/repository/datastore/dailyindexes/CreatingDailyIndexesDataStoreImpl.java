package com.valsoft.cardiodiary.data.repository.datastore.dailyindexes;

import com.valsoft.cardiodiary.data.local.datasource.dailyindexes.DailyIndexesLocalSource;
import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;

public class CreatingDailyIndexesDataStoreImpl implements CreatingDailyIndexesDataStore {

    private DailyIndexesLocalSource mLocalSource;

    public CreatingDailyIndexesDataStoreImpl(DailyIndexesLocalSource localSource){
        mLocalSource = localSource;
    }

    @Override
    public void createDailyIndexes(DailyIndexes dailyIndexes) {
        mLocalSource.insertItem(dailyIndexes);
    }
}
