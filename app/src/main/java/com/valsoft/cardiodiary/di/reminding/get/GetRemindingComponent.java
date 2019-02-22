package com.valsoft.cardiodiary.di.reminding.get;

import com.valsoft.cardiodiary.data.repository.datastore.reminding.RemindingDataStore;
import com.valsoft.cardiodiary.di.reminding.RemindingComponent;
import com.valsoft.cardiodiary.presentation.viewmodel.reminders.RemindersViewModel;
import com.valsoft.cardiodiary.presentation.viewmodel.reminders.RemindingFormViewModel;

import dagger.Component;

@Component(dependencies = RemindingComponent.class, modules = GetRemindingModule.class)
@GetRemindingScope
public interface GetRemindingComponent {
    RemindingDataStore remindingDataStore();
    void inject(RemindersViewModel remindersViewModel);
    void inject(RemindingFormViewModel remindingFormViewModel);
}
