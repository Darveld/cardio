package com.valsoft.cardiodiary.di.reminding.create;

import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.reminding.RemindingLocalSource;
import com.valsoft.cardiodiary.data.repository.CreatingRemindingRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.datastore.medicaldrug.CreatingMedicalDrugDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.medicaldrug.CreatingMedicalDrugDataStoreImpl;
import com.valsoft.cardiodiary.data.repository.datastore.reminding.CreatingRemindingDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.reminding.CreatingRemindingDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.reminding.CreatingRemindingRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class CreateRemindingModule {

    @Provides
    @CreateRemindingScope
    CreatingRemindingDataStore providesCreatingRemindingDataStore(RemindingLocalSource localSource){
        return new CreatingRemindingDataStoreImpl(localSource);
    }

    @Provides
    @CreateRemindingScope
    CreatingMedicalDrugDataStore providesCreatingMedicalDrugDataStore(MedicalDrugLocalSource localSource){
        return new CreatingMedicalDrugDataStoreImpl(localSource);
    }

    @Provides
    @CreateRemindingScope
    CreatingRemindingRepository providesCreatingRemindingRepository(CreatingRemindingDataStore remindingDataStore,
                                                                    CreatingMedicalDrugDataStore drugDataStore){
        return new CreatingRemindingRepositoryImpl(remindingDataStore, drugDataStore);
    }

}
