package com.valsoft.cardiodiary.di.quality.create;

import com.valsoft.cardiodiary.data.local.datasource.quality.QualityOfLifeLocalSource;
import com.valsoft.cardiodiary.data.repository.CreatingQualityRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.datastore.quality.CreatingQualityDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.quality.CreatingQualityDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.quality.CreatingQualityRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class CreateQualityModule {

    @Provides
    @CreateQualityScope
    CreatingQualityDataStore providesCreatingQualityDataStore(QualityOfLifeLocalSource localSource){
        return new CreatingQualityDataStoreImpl(localSource);
    }

    @Provides
    @CreateQualityScope
    CreatingQualityRepository providesCreatingQualityRepository(CreatingQualityDataStore dataStore){
        return new CreatingQualityRepositoryImpl(dataStore);
    }
}
