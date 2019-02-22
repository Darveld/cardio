package com.valsoft.cardiodiary.presentation.viewmodel.diary.questionary;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableInt;
import android.util.Log;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.domain.repositories.dailyindexes.CreatingDailyIndexesRepository;
import com.valsoft.cardiodiary.domain.usecase.CreateDailyIndexesUseCase;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class DailyFormViewModel  extends ViewModel{

    @Inject
    CreateDailyIndexesUseCase mUseCase;

    private ObservableInt feelings = new ObservableInt();
    private ObservableInt activity = new ObservableInt();
    private ObservableInt mood = new ObservableInt();
    private ObservableInt anxiety = new ObservableInt();
    private ObservableInt irritation = new ObservableInt();
    private ObservableInt concentration = new ObservableInt();
    private ObservableInt fatigue = new ObservableInt();
    private ObservableInt psychoemotionalStress = new ObservableInt();
    private ObservableInt sleep = new ObservableInt();
    private Date date;

    private MutableLiveData<Boolean> savingStatus = new MutableLiveData<>();


    public DailyFormViewModel(){
        CardioApp.getInstance().getComponentStorage().addCreateDailyIndexesComponent().inject(this);
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
    }

    public void saveData(){
        mUseCase.createDailyIndexes(feelings.get(),
                activity.get(),
                mood.get(),
                anxiety.get(),
                irritation.get(),
                concentration.get(),
                fatigue.get(),
                psychoemotionalStress.get(),
                sleep.get(),
                date)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        savingStatus.setValue(true);
                    }

                    @Override
                    public void onError(Throwable e) {
                        savingStatus.setValue(false);
                        Log.d("Request error ", e.toString());
                    }
                });
    }

    public LiveData<Boolean> getLiveData(){
        return savingStatus;
    }

    public ObservableInt getFeelings() {
        return feelings;
    }

    public void setFeelings(ObservableInt feelings) {
        this.feelings = feelings;
    }

    public ObservableInt getActivity() {
        return activity;
    }

    public void setActivity(ObservableInt activity) {
        this.activity = activity;
    }

    public ObservableInt getMood() {
        return mood;
    }

    public void setMood(ObservableInt mood) {
        this.mood = mood;
    }

    public ObservableInt getAnxiety() {
        return anxiety;
    }

    public void setAnxiety(ObservableInt anxiety) {
        this.anxiety = anxiety;
    }

    public ObservableInt getIrritation() {
        return irritation;
    }

    public void setIrritation(ObservableInt irritation) {
        this.irritation = irritation;
    }

    public ObservableInt getConcentration() {
        return concentration;
    }

    public void setConcentration(ObservableInt concentration) {
        this.concentration = concentration;
    }

    public ObservableInt getFatigue() {
        return fatigue;
    }

    public void setFatigue(ObservableInt fatigue) {
        this.fatigue = fatigue;
    }

    public ObservableInt getPsychoemotionalStress() {
        return psychoemotionalStress;
    }

    public void setPsychoemotionalStress(ObservableInt psychoemotionalStress) {
        this.psychoemotionalStress = psychoemotionalStress;
    }

    public ObservableInt getSleep() {
        return sleep;
    }

    public void setSleep(ObservableInt sleep) {
        this.sleep = sleep;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        CardioApp.getInstance().getComponentStorage().clearCreateDailyIndexesComponent();
    }
}
