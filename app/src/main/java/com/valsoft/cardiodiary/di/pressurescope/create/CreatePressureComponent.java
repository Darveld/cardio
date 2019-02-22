package com.valsoft.cardiodiary.di.pressurescope.create;

import com.valsoft.cardiodiary.data.repository.datastore.pressure.CreatingPressureDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.CreatingStatisticDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.StatisticDataStore;
import com.valsoft.cardiodiary.di.pressurescope.PressureComponent;
import com.valsoft.cardiodiary.domain.repositories.pressure.CreatingPressureRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.CreatingStatisticRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.StatisticRepository;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.questionary.PressureFormViewModel;

import dagger.Component;

@Component(dependencies = PressureComponent.class, modules = CreatePressureModule.class)
@CreatePressureScope
public interface CreatePressureComponent {
    CreatingPressureDataStore createPressureDataStore();
    CreatingStatisticDataStore creatingStatisticDataStore();
    StatisticDataStore statisticDataStore();
    CreatingPressureRepository creatingPressureRepository();
    CreatingStatisticRepository creatingStatisticRepository();
    StatisticRepository statisticRepository();
    void inject(PressureFormViewModel pressureFormViewModel);
}
