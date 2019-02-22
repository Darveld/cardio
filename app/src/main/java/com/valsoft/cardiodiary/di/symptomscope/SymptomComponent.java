package com.valsoft.cardiodiary.di.symptomscope;


import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.symptoms.SymptomsLocalSource;
import com.valsoft.cardiodiary.di.AppComponent;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = SymptomModule.class)
@SymptomScope
public interface SymptomComponent {
    SymptomsLocalSource symptomsLocalSource();
    StatisticLocalSource statisticLocalSource();
}
