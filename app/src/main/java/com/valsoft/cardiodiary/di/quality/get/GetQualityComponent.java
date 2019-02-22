package com.valsoft.cardiodiary.di.quality.get;

import com.valsoft.cardiodiary.data.repository.datastore.quality.QualityDataStore;
import com.valsoft.cardiodiary.di.quality.QualityComponent;
import com.valsoft.cardiodiary.presentation.ui.quality.QualityService;
import com.valsoft.cardiodiary.presentation.viewmodel.quality.QualityListViewModel;
import com.valsoft.cardiodiary.presentation.viewmodel.quality.QualityViewModel;

import dagger.Component;

@Component(dependencies = QualityComponent.class, modules = GetQualityModule.class)
@GetQualityScope
public interface GetQualityComponent {
    QualityDataStore qualityDataStore();
    void inject(QualityListViewModel qualityListViewModel);
    void inject(QualityViewModel qualityViewModel);
    void inject(QualityService qualityService);
}
