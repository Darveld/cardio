package com.valsoft.cardiodiary.di.reminding;

import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.reminding.RemindingLocalSource;
import com.valsoft.cardiodiary.di.AppComponent;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = RemindingModule.class)
@RemindingScope
public interface RemindingComponent {

    RemindingLocalSource remindingLocalSource();
    MedicalDrugLocalSource medicalDrugLocalSource();
}
