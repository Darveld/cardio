package com.valsoft.cardiodiary.di.pressurescope.get;

import com.valsoft.cardiodiary.data.local.datasource.heartwork.PressureLocalSource;
import com.valsoft.cardiodiary.data.repository.PressureRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.datastore.pressure.PressureDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.pressure.PressureDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.pressure.PressureRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class GetPressureModule {

    @Provides
    @GetPressureScope
    PressureDataStore providesPressureDataStore(PressureLocalSource localSource){
        return new PressureDataStoreImpl(localSource);
    }

    @Provides
    @GetPressureScope
    PressureRepository providesPressureRepository(PressureDataStore dataStore){
        return new PressureRepositoryImpl(dataStore);
    }
}
