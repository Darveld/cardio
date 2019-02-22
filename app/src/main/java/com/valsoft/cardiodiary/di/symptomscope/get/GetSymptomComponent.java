package com.valsoft.cardiodiary.di.symptomscope.get;

import com.valsoft.cardiodiary.data.repository.datastore.symptom.SymptomsDataStore;
import com.valsoft.cardiodiary.di.symptomscope.SymptomComponent;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.SymptomViewModel;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.SymptomDetailViewModel;

import dagger.Component;

@Component(dependencies = SymptomComponent.class, modules = GetSymptomModule.class)
@GetSymptomScope
public interface GetSymptomComponent {
    SymptomsDataStore symptomsDataStore();
    void inject(SymptomViewModel symptomViewModel);
    void inject(SymptomDetailViewModel symptomDetailViewModel);
}
