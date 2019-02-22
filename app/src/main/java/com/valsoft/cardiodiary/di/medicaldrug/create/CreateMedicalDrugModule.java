package com.valsoft.cardiodiary.di.medicaldrug.create;

import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSource;
import com.valsoft.cardiodiary.data.repository.CreatingMedicalDrugRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.datastore.medicaldrug.CreatingMedicalDrugDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.medicaldrug.CreatingMedicalDrugDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.medicaldrug.CreatingMedicalDrugRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class CreateMedicalDrugModule {

    @Provides
    @CreateMedicalDrugScope
    CreatingMedicalDrugDataStore providesCreatingMedicalDrugDataStore(MedicalDrugLocalSource localSource){
        return new CreatingMedicalDrugDataStoreImpl(localSource);
    }

    @Provides
    @CreateMedicalDrugScope
    CreatingMedicalDrugRepository provideCreatingMedicalDrugRepository(CreatingMedicalDrugDataStore dataStore){
        return new CreatingMedicalDrugRepositoryImpl(dataStore);
    }

}
