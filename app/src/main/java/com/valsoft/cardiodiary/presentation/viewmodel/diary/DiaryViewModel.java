package com.valsoft.cardiodiary.presentation.viewmodel.diary;

import android.arch.lifecycle.ViewModel;
import android.util.Log;

import com.valsoft.cardiodiary.CardioApp;

public class DiaryViewModel extends ViewModel {

    public DiaryViewModel(){
        CardioApp.getInstance().getComponentStorage().addPressureComponent();
        CardioApp.getInstance().getComponentStorage().addSymptomComponent();
        CardioApp.getInstance().getComponentStorage().addDailyControlComponent();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        Log.d("OnCleared ", "Component is null");
        CardioApp.getInstance().getComponentStorage().clearDailyControlComponent();
        CardioApp.getInstance().getComponentStorage().clearPressureComponent();
        CardioApp.getInstance().getComponentStorage().clearSymptomComponent();
    }
}
