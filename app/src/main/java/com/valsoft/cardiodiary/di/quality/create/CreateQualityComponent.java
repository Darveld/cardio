package com.valsoft.cardiodiary.di.quality.create;

import com.valsoft.cardiodiary.data.repository.datastore.quality.CreatingQualityDataStore;
import com.valsoft.cardiodiary.di.quality.QualityComponent;
import com.valsoft.cardiodiary.presentation.viewmodel.quality.QualityCreateViewModel;

import dagger.Component;

@Component(dependencies = QualityComponent.class, modules = CreateQualityModule.class)
@CreateQualityScope
public interface CreateQualityComponent {
    CreatingQualityDataStore creatingQualityDataStore();
    void inject(QualityCreateViewModel qualityCreateViewModel);
}
