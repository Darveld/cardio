package com.valsoft.cardiodiary.di.pressurescope.get;

import com.valsoft.cardiodiary.data.repository.datastore.pressure.PressureDataStore;
import com.valsoft.cardiodiary.di.pressurescope.PressureComponent;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.PressureViewModel;

import dagger.Component;

@Component(dependencies = PressureComponent.class, modules = GetPressureModule.class)
@GetPressureScope
public interface GetPressureComponent {
    PressureDataStore pressureDataStore();
    void inject(PressureViewModel pressureViewModel);
}
