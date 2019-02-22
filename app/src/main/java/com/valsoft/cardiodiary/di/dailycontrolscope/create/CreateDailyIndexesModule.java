package com.valsoft.cardiodiary.di.dailycontrolscope.create;

import com.valsoft.cardiodiary.data.local.datasource.dailyindexes.DailyIndexesLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSource;
import com.valsoft.cardiodiary.data.repository.CreatingDailyIndexesRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.CreatingStatisticRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.StatisticRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.datastore.dailyindexes.CreatingDailyIndexesDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.dailyindexes.CreatingDailyIndexesDataStoreImpl;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.CreatingStatisticDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.CreatingStatisticDataStoreImpl;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.StatisticDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.StatisticDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.dailyindexes.CreatingDailyIndexesRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.CreatingStatisticRepository;
import com.valsoft.cardiodiary.domain.repositories.statistic.StatisticRepository;
import com.valsoft.cardiodiary.domain.usecase.CreateDailyIndexesUseCase;
import com.valsoft.cardiodiary.domain.usecase.interactors.CreateDailyIndexesInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class CreateDailyIndexesModule {

    @Provides
    @CreateDailyIndexesScope
    CreatingDailyIndexesDataStore providesCreatingDailyIndexesDataStore(DailyIndexesLocalSource localSource){
        return new CreatingDailyIndexesDataStoreImpl(localSource);
    }

    @Provides
    @CreateDailyIndexesScope
    CreatingStatisticDataStore providesCreateStatisticDataStore(StatisticLocalSource statisticLocalSource){
        return new CreatingStatisticDataStoreImpl(statisticLocalSource);
    }

    @Provides
    @CreateDailyIndexesScope
    StatisticDataStore providesStatisticDataStore(StatisticLocalSource statisticLocalSource){
        return new StatisticDataStoreImpl(statisticLocalSource);
    }

    @Provides
    @CreateDailyIndexesScope
    CreatingStatisticRepository providesCreatingStatisticRepository(CreatingStatisticDataStore dataStore){
        return new CreatingStatisticRepositoryImpl(dataStore);
    }

    @Provides
    @CreateDailyIndexesScope
    StatisticRepository providesStatisticRepository(StatisticDataStore dataStore){
        return new StatisticRepositoryImpl(dataStore);
    }

    @Provides
    @CreateDailyIndexesScope
    CreatingDailyIndexesRepository providesCreatingDailyIndexesRepository(CreatingDailyIndexesDataStore dataStore){
        return new CreatingDailyIndexesRepositoryImpl(dataStore);
    }

    @Provides
    @CreateDailyIndexesScope
    CreateDailyIndexesUseCase providesCreateDailyIndexesUseCase(CreatingDailyIndexesRepository creatingDailyIndexesRepository,
                                                                CreatingStatisticRepository creatingStatisticRepository, StatisticRepository statisticRepository){
        return new CreateDailyIndexesInteractor(creatingDailyIndexesRepository, creatingStatisticRepository, statisticRepository);
    }
}
