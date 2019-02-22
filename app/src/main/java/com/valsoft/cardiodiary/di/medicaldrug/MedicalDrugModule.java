package com.valsoft.cardiodiary.di.medicaldrug;

import com.valsoft.cardiodiary.data.local.database.CardioDataBase;
import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSourceImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class MedicalDrugModule {

    @Provides
    @MedicalDrugScope
    MedicalDrugLocalSource providesMedicalDrugLocalSource(CardioDataBase dataBase){
        return new MedicalDrugLocalSourceImpl(dataBase.mDrugDao());
    }
}
