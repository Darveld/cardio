package com.valsoft.cardiodiary.di.statistic;

import com.valsoft.cardiodiary.data.local.database.CardioDataBase;
import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.statistic.StatisticLocalSourceImpl;
import com.valsoft.cardiodiary.data.repository.StatisticRepositoryImpl;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.StatisticDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.statistic.StatisticDataStoreImpl;
import com.valsoft.cardiodiary.domain.repositories.statistic.StatisticRepository;
import com.valsoft.cardiodiary.domain.usecase.GetStatisticListUseCase;
import com.valsoft.cardiodiary.domain.usecase.GetStatisticUseCase;
import com.valsoft.cardiodiary.domain.usecase.interactors.GetStatisticInteractor;
import com.valsoft.cardiodiary.domain.usecase.interactors.GetStatisticItemInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class StatisticModule {

    @Provides
    @StatisticScope
    StatisticLocalSource providesStatisticLocalSource(CardioDataBase dataBase){
        return new StatisticLocalSourceImpl(dataBase.mStatisticDao());
    }

    @Provides
    @StatisticScope
    StatisticDataStore providesStatisticDataStore(StatisticLocalSource localSource){
        return new StatisticDataStoreImpl(localSource);
    }

    @Provides
    @StatisticScope
    StatisticRepository providesStatisticRepository(StatisticDataStore dataStore){
        return new StatisticRepositoryImpl(dataStore);
    }

    @Provides
    @StatisticScope
    GetStatisticListUseCase providesGetStatisticUseCase(StatisticRepository repository){
        return new GetStatisticInteractor(repository);
    }

    @Provides
    @StatisticScope
    GetStatisticUseCase providesGetStatisticItemUseCase(StatisticRepository repository){
        return new GetStatisticItemInteractor(repository);
    }
}
