package com.valsoft.cardiodiary.di.dailycontrolscope.get;

import com.valsoft.cardiodiary.data.local.datasource.dailyindexes.DailyIndexesLocalSource;
import com.valsoft.cardiodiary.data.repository.DailyControlRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.datastore.dailyindexes.DailyIndexesDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.dailyindexes.DailyIndexesDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.dailyindexes.DailyControlRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class GetDailyIndexesModule {

    @Provides
    @GetDailyIndexesScope
    DailyIndexesDataStore providesDailyIndexesDataStore(DailyIndexesLocalSource localSource){
        return new DailyIndexesDataStoreImpl(localSource);
    }

    @Provides
    @GetDailyIndexesScope
    DailyControlRepository providesDailyControlRepository(DailyIndexesDataStore dataStore){
        return new DailyControlRepositoryImpl(dataStore);
    }

}
