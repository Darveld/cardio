package com.valsoft.cardiodiary.di.dailycontrolscope;

import com.valsoft.cardiodiary.data.local.database.CardioDataBase;
import com.valsoft.cardiodiary.data.local.datasource.dailyindexes.DailyIndexesLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.dailyindexes.DailyIndexesLocalSourceImpl;
import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSourceImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class DailyControlModule {

    @Provides
    @DailyControlScope
    DailyIndexesLocalSource providesDailyIndexesLocalSource(CardioDataBase dataBase){
        return new DailyIndexesLocalSourceImpl(dataBase.mDailyIndexesDao());
    }

    @Provides
    @DailyControlScope
    StatisticLocalSource providesStatisticLocalSource(CardioDataBase dataBase){
        return new StatisticLocalSourceImpl(dataBase.mStatisticDao());
    }
}
