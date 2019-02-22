package com.valsoft.cardiodiary.di.symptomscope.create;

import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.symptoms.SymptomsLocalSource;
import com.valsoft.cardiodiary.data.repository.CreatingStatisticRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.CreatingSymptomsRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.StatisticRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.CreatingStatisticDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.CreatingStatisticDataStoreImpl;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.StatisticDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.StatisticDataStoreImpl;
import com.valsoft.cardiodiary.data.repository.datastore.symptom.CreatingSymptomsDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.symptom.CreatingSymptomsDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.statistic.CreatingStatisticRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.StatisticRepository;
import com.valsoft.cardiodiary.domain.repositories.symptom.CreatingSymptomsRepository;
import com.valsoft.cardiodiary.domain.usecase.CreateSymptomsUseCase;
import com.valsoft.cardiodiary.domain.usecase.interactors.CreateSymptomsInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class CreateSymptomModule {

    @Provides
    @CreateSymptomScope
    CreatingSymptomsDataStore providesCreatingSymptomsDataStore(SymptomsLocalSource symptomsLocalSource){
        return new CreatingSymptomsDataStoreImpl(symptomsLocalSource);
    }

    @Provides
    @CreateSymptomScope
    CreatingStatisticDataStore providesCreateStatisticDataStore(StatisticLocalSource statisticLocalSource){
        return new CreatingStatisticDataStoreImpl(statisticLocalSource);
    }

    @Provides
    @CreateSymptomScope
    StatisticDataStore providesStatisticDataStore(StatisticLocalSource statisticLocalSource){
        return new StatisticDataStoreImpl(statisticLocalSource);
    }

    @Provides
    @CreateSymptomScope
    CreatingStatisticRepository providesCreatingStatisticRepository(CreatingStatisticDataStore dataStore){
        return new CreatingStatisticRepositoryImpl(dataStore);
    }

    @Provides
    @CreateSymptomScope
    StatisticRepository providesStatisticRepository(StatisticDataStore dataStore){
        return new StatisticRepositoryImpl(dataStore);
    }

    @Provides
    @CreateSymptomScope
    CreatingSymptomsRepository providesCreatingSymptomsRepository(CreatingSymptomsDataStore creatingSymptomsDataStore){
        return new CreatingSymptomsRepositoryImpl(creatingSymptomsDataStore);
    }

    @Provides
    @CreateSymptomScope
    CreateSymptomsUseCase providesCreateSymptomsUseCase(CreatingSymptomsRepository creatingSymptomsRepository,
                                                        CreatingStatisticRepository creatingStatisticRepository, StatisticRepository statisticRepository){
        return new CreateSymptomsInteractor(creatingSymptomsRepository, creatingStatisticRepository, statisticRepository);
    }

}
