package com.valsoft.cardiodiary.di.medicaldrug;


import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSource;
import com.valsoft.cardiodiary.di.AppComponent;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = MedicalDrugModule.class)
@MedicalDrugScope
public interface MedicalDrugComponent {
    MedicalDrugLocalSource medicalDrugLocalSource();
}
