package com.valsoft.cardiodiary.di.medicalrecord.create;

import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.medicalrecord.MedicalRecordLocalSource;
import com.valsoft.cardiodiary.data.repository.CreatingMedicalRecordRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.datastore.medicaldrug.CreatingMedicalDrugDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.medicaldrug.CreatingMedicalDrugDataStoreImpl;
import com.valsoft.cardiodiary.data.repository.datastore.medicalrecord.CreatingMedicalRecordDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.medicalrecord.CreatingMedicalRecordDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.medicalrecord.CreatingMedicalRecordRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class CreateMedicalRecordModule {

    @Provides
    @CreateMedicalRecordScope
    CreatingMedicalRecordDataStore providesCreatingMedicalRecordDataStore(MedicalRecordLocalSource localSource){
        return new CreatingMedicalRecordDataStoreImpl(localSource);
    }

    @Provides
    @CreateMedicalRecordScope
    CreatingMedicalDrugDataStore providesCreatingMedicalDrugDataStore(MedicalDrugLocalSource localSource){
        return new CreatingMedicalDrugDataStoreImpl(localSource);
    }

    @Provides
    @CreateMedicalRecordScope
    CreatingMedicalRecordRepository providesCreatingMedicalRecordRepository(CreatingMedicalRecordDataStore recordDataStore,
                                                                            CreatingMedicalDrugDataStore drugDataStore){
        return new CreatingMedicalRecordRepositoryImpl(recordDataStore, drugDataStore);
    }

}
