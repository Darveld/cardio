package com.valsoft.cardiodiary.di.statistic;

import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSource;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.StatisticDataStore;
import com.valsoft.cardiodiary.di.AppComponent;
import com.valsoft.cardiodiary.domain.repositories.statistic.StatisticRepository;
import com.valsoft.cardiodiary.presentation.viewmodel.statistic.StatisticListViewModel;
import com.valsoft.cardiodiary.presentation.viewmodel.statistic.StatisticViewModel;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = StatisticModule.class)
@StatisticScope
public interface StatisticComponent {
    StatisticLocalSource statisticLocalSource();
    StatisticDataStore statisticDataStore();
    StatisticRepository statisticRepository();
    void inject(StatisticListViewModel statisticListViewModel);
    void inject(StatisticViewModel statisticViewModel);
}
