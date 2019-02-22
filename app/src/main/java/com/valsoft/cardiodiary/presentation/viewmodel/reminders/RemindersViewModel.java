package com.valsoft.cardiodiary.presentation.viewmodel.reminders;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.Reminding;
import com.valsoft.cardiodiary.domain.repositories.reminding.RemindingRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class RemindersViewModel extends ViewModel {

    @Inject
    RemindingRepository mRepository;
    private MutableLiveData<List<Reminding>> liveData = new MutableLiveData<>();
    private Disposable mDisposable;

    public RemindersViewModel() {
        CardioApp.getInstance().getComponentStorage().addRemindingComponent();
        CardioApp.getInstance().getComponentStorage().addGetRemindingComponent().inject(this);
        getReminders();
    }

    private void getReminders(){
        mDisposable = mRepository.getAllReminding()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list ->
                   liveData.setValue(list)
                );
    }

    public LiveData<List<Reminding>> getLiveData(){
        return liveData;
    }

    @Override
    protected void onCleared() {
        mDisposable.dispose();
        CardioApp.getInstance().getComponentStorage().clearGetRemindingComponent();
        CardioApp.getInstance().getComponentStorage().clearRemindingComponent();
        super.onCleared();
    }
}
