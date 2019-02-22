package com.valsoft.cardiodiary.di.symptomscope;

import com.valsoft.cardiodiary.data.local.database.CardioDataBase;
import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSourceImpl;
import com.valsoft.cardiodiary.data.local.datasource.symptoms.SymptomsLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.symptoms.SymptomsLocalSourceImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class SymptomModule {

    @Provides
    @SymptomScope
    SymptomsLocalSource providesSymptomsLocalSource(CardioDataBase dataBase){
        return new SymptomsLocalSourceImpl(dataBase.mSymptomsDao());
    }

    @Provides
    @SymptomScope
    StatisticLocalSource providesStatisticLocalSource(CardioDataBase dataBase){
        return new StatisticLocalSourceImpl(dataBase.mStatisticDao());
    }
}
