package com.valsoft.cardiodiary.di.medicaldrug.create;

import com.valsoft.cardiodiary.data.repository.datastore.medicaldrug.CreatingMedicalDrugDataStore;
import com.valsoft.cardiodiary.di.medicaldrug.MedicalDrugComponent;

import dagger.Component;

@Component(dependencies = MedicalDrugComponent.class, modules = CreateMedicalDrugModule.class)
@CreateMedicalDrugScope
public interface CreateMedicalDrugComponent {
    CreatingMedicalDrugDataStore creatingMedicalDrugDataStore();
}
