package com.valsoft.cardiodiary.di.reminding.create;

import com.valsoft.cardiodiary.data.repository.datastore.medicaldrug.CreatingMedicalDrugDataStore;
import com.valsoft.cardiodiary.data.repository.datastore.reminding.CreatingRemindingDataStore;
import com.valsoft.cardiodiary.di.reminding.RemindingComponent;
import com.valsoft.cardiodiary.presentation.viewmodel.reminders.RemindingCreateViewModel;

import dagger.Component;

@Component(dependencies = RemindingComponent.class, modules = CreateRemindingModule.class)
@CreateRemindingScope
public interface CreateRemindingComponent {

    CreatingMedicalDrugDataStore creatingMedicalDrugDataStore();
    CreatingRemindingDataStore creatingRemindingDataStore();
    void inject(RemindingCreateViewModel viewModel);
}
