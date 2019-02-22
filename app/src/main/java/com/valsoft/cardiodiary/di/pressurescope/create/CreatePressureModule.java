package com.valsoft.cardiodiary.di.pressurescope.create;

import com.valsoft.cardiodiary.data.local.datasource.heartwork.PressureLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSource;
import com.valsoft.cardiodiary.data.repository.CreatingPressureRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.CreatingStatisticRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.StatisticRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.datastore.pressure.CreatingPressureDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.pressure.CreatingPressureDataStoreImpl;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.CreatingStatisticDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.CreatingStatisticDataStoreImpl;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.StatisticDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.StatisticDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.pressure.CreatingPressureRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.CreatingStatisticRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.StatisticRepository;
import com.valsoft.cardiodiary.domain.usecase.CreatePressureUseCase;
import com.valsoft.cardiodiary.domain.usecase.interactors.CreatePressureInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class CreatePressureModule {

    @Provides
    @CreatePressureScope
    CreatingPressureDataStore providesCreatePressureDataStore(PressureLocalSource pressureLocalSource){
        return new CreatingPressureDataStoreImpl(pressureLocalSource);
    }

    @Provides
    @CreatePressureScope
    CreatingStatisticDataStore providesCreateStatisticDataStore(StatisticLocalSource statisticLocalSource){
        return new CreatingStatisticDataStoreImpl(statisticLocalSource);
    }

    @Provides
    @CreatePressureScope
    StatisticDataStore providesStatisticDataStore(StatisticLocalSource statisticLocalSource){
        return new StatisticDataStoreImpl(statisticLocalSource);
    }

    @Provides
    @CreatePressureScope
    CreatingStatisticRepository providesCreatingStatisticRepository(CreatingStatisticDataStore dataStore){
        return new CreatingStatisticRepositoryImpl(dataStore);
    }

    @Provides
    @CreatePressureScope
    StatisticRepository providesStatisticRepository(StatisticDataStore dataStore){
        return new StatisticRepositoryImpl(dataStore);
    }

    @Provides
    @CreatePressureScope
    CreatingPressureRepository providesCreatePressureRepository(CreatingPressureDataStore creatingPressureDataStore){
        return new CreatingPressureRepositoryImpl(creatingPressureDataStore);
    }

    @Provides
    @CreatePressureScope
    CreatePressureUseCase providesCreatePressureUseCase(CreatingPressureRepository creatingPressureRepository,
                                                        CreatingStatisticRepository creatingStatisticRepository, StatisticRepository statisticRepository){
        return new CreatePressureInteractor(creatingPressureRepository, creatingStatisticRepository, statisticRepository);
    }
}
