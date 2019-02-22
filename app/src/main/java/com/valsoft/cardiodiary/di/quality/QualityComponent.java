package com.valsoft.cardiodiary.di.quality;

import com.valsoft.cardiodiary.data.local.datasource.quality.QualityOfLifeLocalSource;
import com.valsoft.cardiodiary.di.AppComponent;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = QualityModule.class)
@QualityScope
public interface QualityComponent {

    QualityOfLifeLocalSource qualityOfLifeLocalSource();
}
