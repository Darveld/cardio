package com.valsoft.cardiodiary.di.symptomscope.create;


import com.valsoft.cardiodiary.data.repository.datastore.statistic.CreatingStatisticDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.StatisticDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.symptom.CreatingSymptomsDataStore;
import com.valsoft.cardiodiary.di.symptomscope.SymptomComponent;
import com.valsoft.cardiodiary.domain.repositories.statistic.CreatingStatisticRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.StatisticRepository;
import com.valsoft.cardiodiary.domain.repositories.symptom.CreatingSymptomsRepository;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.questionary.SymptomFormViewModel;

import dagger.Component;

@Component(dependencies = SymptomComponent.class, modules = CreateSymptomModule.class)
@CreateSymptomScope
public interface CreateSymptomComponent {
    CreatingSymptomsDataStore creatingSymptomsDataStore();
    CreatingStatisticDataStore creatingStatisticDataStore();
    StatisticDataStore statisticDataStore();
    CreatingSymptomsRepository creatingSymptomsRepository();
    CreatingStatisticRepository creatingStatisticRepository();
    StatisticRepository statisticRepository();
    void inject (SymptomFormViewModel symptomFormViewModel);
}
