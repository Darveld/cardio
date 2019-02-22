package com.valsoft.cardiodiary.di.dailycontrolscope.get;


import com.valsoft.cardiodiary.data.repository.datastore.dailyindexes.DailyIndexesDataStore;
import com.valsoft.cardiodiary.di.dailycontrolscope.DailyControlComponent;
import com.valsoft.cardiodiary.presentation.ui.diary.DailyControlDetailFragment;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.DailyControlDetailViewModel;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.DailyControlViewModel;

import dagger.Component;

@Component(dependencies = DailyControlComponent.class, modules = GetDailyIndexesModule.class)
@GetDailyIndexesScope
public interface GetDailyIndexesComponent {

    DailyIndexesDataStore dailyIndexesDataStore();
    void inject(DailyControlViewModel dailyControlViewModel);
    void inject(DailyControlDetailViewModel dailyControlDetailViewModel);
}
