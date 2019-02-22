package com.valsoft.cardiodiary.di.medicalrecord;

import com.valsoft.cardiodiary.data.local.database.CardioDataBase;
import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSourceImpl;
import com.valsoft.cardiodiary.data.local.datasource.medicalrecord.MedicalRecordLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.medicalrecord.MedicalRecordLocalSourceImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MedicalRecordModule {

    @Provides
    @MedicalRecordScope
    MedicalRecordLocalSource providesMedicalRecordLocalSource(CardioDataBase dataBase){
        return new MedicalRecordLocalSourceImpl(dataBase.mRecordDao());
    }

    @Provides
    @MedicalRecordScope
    MedicalDrugLocalSource providesMedicalDrugLocalSource(CardioDataBase dataBase){
        return new MedicalDrugLocalSourceImpl(dataBase.mDrugDao());
    }
}
