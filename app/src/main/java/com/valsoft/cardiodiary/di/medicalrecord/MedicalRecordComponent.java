package com.valsoft.cardiodiary.di.medicalrecord;

import com.valsoft.cardiodiary.data.local.datasource.medicaldrug.MedicalDrugLocalSource;
import com.valsoft.cardiodiary.data.local.datasource.medicalrecord.MedicalRecordLocalSource;
import com.valsoft.cardiodiary.di.AppComponent;

import dagger.Component;

@Component(dependencies = AppComponent.class, modules = MedicalRecordModule.class)
@MedicalRecordScope
public interface MedicalRecordComponent {
    MedicalRecordLocalSource medicalRecordLocalSource();
    MedicalDrugLocalSource medicalDrugLocalSource();
}
