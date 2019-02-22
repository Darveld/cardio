package com.valsoft.cardiodiary.di.reminding.get;

import com.valsoft.cardiodiary.data.local.datasource.reminding.RemindingLocalSource;
import com.valsoft.cardiodiary.data.repository.RemindingRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.datastore.reminding.RemindingDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.reminding.RemindingDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.reminding.RemindingRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class GetRemindingModule {

    @Provides
    @GetRemindingScope
    RemindingDataStore providesRemindingDataStore(RemindingLocalSource localSource){
        return new RemindingDataStoreImpl(localSource);
    }

    @Provides
    @GetRemindingScope
    RemindingRepository providesRemindingRepository(RemindingDataStore dataStore){
        return new RemindingRepositoryImpl(dataStore);
    }

}
