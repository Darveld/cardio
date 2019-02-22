package com.valsoft.cardiodiary.di.quality;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.database.CardioDataBase;
import com.valsoft.cardiodiary.data.local.datasource.quality.QualityOfLifeLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.quality.QualityOfLifeLocalSourceImpl;

import dagger.Module;
import dagger.Provides;

@Module
public class QualityModule {

    @Provides
    @QualityScope
    QualityOfLifeLocalSource providesQualityOfLifeLocalSource(CardioDataBase dataBase){
        return new QualityOfLifeLocalSourceImpl(dataBase.mQualityOfLifeDao());
    }

}
