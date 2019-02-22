package com.valsoft.cardiodiary.di.medicalrecord.get;

import com.valsoft.cardiodiary.data.local.datasource.medicalrecord.MedicalRecordLocalSource;
import com.valsoft.cardiodiary.data.repository.MedicalRecordsRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.datastore.medicalrecord.MedicalRecordDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.medicalrecord.MedicalRecordDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.medicalrecord.MedicalRecordsRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class GetMedicalRecordModule {

    @Provides
    @GetMedicalRecordScope
    MedicalRecordDataStore provideMedicalRecordDataStore(MedicalRecordLocalSource localSource){
        return new MedicalRecordDataStoreImpl(localSource);
    }

    @Provides
    @GetMedicalRecordScope
    MedicalRecordsRepository provideMedicalRecordsRepository(MedicalRecordDataStore dataStore){
        return new MedicalRecordsRepositoryImpl(dataStore);
    }

}
