package com.valsoft.cardiodiary.di.symptomscope.get;

import com.valsoft.cardiodiary.data.local.datasource.symptoms.SymptomsLocalSource;
import com.valsoft.cardiodiary.data.repository.SymptomsRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.datastore.symptom.SymptomsDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.symptom.SymptomsDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.symptom.SymptomsRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class GetSymptomModule {

    @Provides
    @GetSymptomScope
    SymptomsDataStore providesSymptomsDataStore(SymptomsLocalSource localSource){
        return new SymptomsDataStoreImpl(localSource);
    }

    @Provides
    @GetSymptomScope
    SymptomsRepository providesSymptomsRepository(SymptomsDataStore dataStore){
        return new SymptomsRepositoryImpl(dataStore);
    }
}
