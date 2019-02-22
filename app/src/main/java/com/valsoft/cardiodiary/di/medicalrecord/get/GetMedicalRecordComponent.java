package com.valsoft.cardiodiary.di.medicalrecord.get;


import com.valsoft.cardiodiary.data.repository.datastore.medicalrecord.MedicalRecordDataStore;
import com.valsoft.cardiodiary.di.medicalrecord.MedicalRecordComponent;
import com.valsoft.cardiodiary.presentation.viewmodel.medicalcard.MedicalRecordDetailViewModel;
import com.valsoft.cardiodiary.presentation.viewmodel.medicalcard.MedicalRecordsViewModel;

import dagger.Component;

@Component(dependencies = MedicalRecordComponent.class, modules = GetMedicalRecordModule.class)
@GetMedicalRecordScope
public interface GetMedicalRecordComponent {

    MedicalRecordDataStore medicalRecordDataStore();
    void inject(MedicalRecordsViewModel medicalRecordsViewModel);
    void inject(MedicalRecordDetailViewModel medicalRecordDetailViewModel);
}
