package com.valsoft.cardiodiary.di.dailycontrolscope.create;


import com.valsoft.cardiodiary.data.repository.datastore.dailyindexes.CreatingDailyIndexesDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.CreatingStatisticDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.StatisticDataStore;
import com.valsoft.cardiodiary.di.dailycontrolscope.DailyControlComponent;
import com.valsoft.cardiodiary.di.dailycontrolscope.DailyControlModule;
import com.valsoft.cardiodiary.domain.repositories.dailyindexes.CreatingDailyIndexesRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.CreatingStatisticRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.StatisticRepository;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.questionary.DailyFormViewModel;

import dagger.Component;

@Component(dependencies = DailyControlComponent.class, modules = CreateDailyIndexesModule.class)
@CreateDailyIndexesScope
public interface CreateDailyIndexesComponent {
    CreatingDailyIndexesDataStore creatingDailyIndexesDataStore();
    CreatingStatisticDataStore creatingStatisticDataStore();
    StatisticDataStore statisticDataStore();
    CreatingDailyIndexesRepository creatingDailyIndexesRepository();
    CreatingStatisticRepository creatingStatisticRepository();
    StatisticRepository statisticRepository();
    void inject(DailyFormViewModel dailyFormViewModel);
}
