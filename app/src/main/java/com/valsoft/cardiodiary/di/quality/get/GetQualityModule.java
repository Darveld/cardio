package com.valsoft.cardiodiary.di.quality.get;

import com.valsoft.cardiodiary.data.local.datasource.quality.QualityOfLifeLocalSource;
import com.valsoft.cardiodiary.data.repository.QualityRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.datastore.quality.QualityDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.quality.QualityDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.quality.QualityRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class GetQualityModule {

    @Provides
    @GetQualityScope
    QualityDataStore providesQualityDataStore(QualityOfLifeLocalSource localSource){
        return new QualityDataStoreImpl(localSource);
    }

    @Provides
    @GetQualityScope
    QualityRepository providesQualityRepository(QualityDataStore dataStore){
        return new QualityRepositoryImpl(dataStore);
    }
}
