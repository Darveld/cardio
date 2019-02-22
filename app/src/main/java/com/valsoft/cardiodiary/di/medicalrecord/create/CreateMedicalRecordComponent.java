package com.valsoft.cardiodiary.di.medicalrecord.create;

import com.valsoft.cardiodiary.data.repository.datastore.medicaldrug.CreatingMedicalDrugDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.medicalrecord.CreatingMedicalRecordDataStore;
import com.valsoft.cardiodiary.di.medicaldrug.create.CreateMedicalDrugComponent;
import com.valsoft.cardiodiary.di.medicalrecord.MedicalRecordComponent;
import com.valsoft.cardiodiary.presentation.viewmodel.medicalcard.MedicalRecordFormViewModel;

import dagger.Component;

@Component(dependencies = {MedicalRecordComponent.class}, modules = CreateMedicalRecordModule.class)
@CreateMedicalRecordScope
public interface CreateMedicalRecordComponent {
    CreatingMedicalDrugDataStore creatingMedicalDrugDataStore();
    CreatingMedicalRecordDataStore creatingMedicalRecordDataStore();
    void inject(MedicalRecordFormViewModel medicalRecordFormViewModel);
}
