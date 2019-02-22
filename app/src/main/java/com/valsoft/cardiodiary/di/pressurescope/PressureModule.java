package com.valsoft.cardiodiary.di.pressurescope;

import com.valsoft.cardiodiary.data.local.database.CardioDataBase;
import com.valsoft.cardiodiary.data.local.datasource.heartwork.PressureLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.heartwork.PressureLocalSourceImpl;
import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSourceImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class PressureModule {

    @Provides
    @PressureScope
    PressureLocalSource providesPressureLocalSource(CardioDataBase dataBase){
        return new PressureLocalSourceImpl(dataBase.mPressureDao());
    }

    @Provides
    @PressureScope
    StatisticLocalSource providesStatisticLocalSource(CardioDataBase dataBase){
        return new StatisticLocalSourceImpl(dataBase.mStatisticDao());
    }

}
