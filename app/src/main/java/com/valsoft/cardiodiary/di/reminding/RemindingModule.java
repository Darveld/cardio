package com.valsoft.cardiodiary.di.reminding;

import com.valsoft.cardiodiary.data.local.database.CardioDataBase;
import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSourceImpl;
import com.valsoft.cardiodiary.data.local.datasource.reminding.RemindingLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.reminding.RemindingLocalSourceImpl;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;

import dagger.Module;
import dagger.Provides;

@Module
public class RemindingModule {

    @Provides
    @RemindingScope
    RemindingLocalSource providesRemindingLocalSource(CardioDataBase dataBase){
        return new RemindingLocalSourceImpl(dataBase.mRemindingDao());
    }

    @Provides
    @RemindingScope
    MedicalDrugLocalSource providesMedicalDrugLocalSource(CardioDataBase dataBase){
        return new MedicalDrugLocalSourceImpl(dataBase.mDrugDao());
    }

}
