package com.valsoft.cardiodiary.di.pressurescope;

import com.valsoft.cardiodiary.data.local.datasource.heartwork.PressureLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSource;
import com.valsoft.cardiodiary.di.AppComponent;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = PressureModule.class)
@PressureScope
public interface PressureComponent {
    PressureLocalSource pressureLocalSource();
    StatisticLocalSource statisticLocalSource();
}
