package com.valsoft.cardiodiary.di.dailycontrolscope;

import com.valsoft.cardiodiary.data.local.datasource.dailyindexes.DailyIndexesLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSource;
import com.valsoft.cardiodiary.di.AppComponent;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = DailyControlModule.class)
@DailyControlScope
public interface DailyControlComponent {
    DailyIndexesLocalSource dailyIndexesLocalSource();
    StatisticLocalSource statisticLocalSource();
}
