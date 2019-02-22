package com.valsoft.cardiodiary.presentation.viewmodel.quality;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableInt;
import android.util.Log;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.QualityOfLife;
import com.valsoft.cardiodiary.domain.repositories.quality.CreatingQualityRepository;

import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class QualityCreateViewModel extends ViewModel {

    @Inject
    CreatingQualityRepository mRepository;

    private ObservableInt physicalCondition = new ObservableInt();
    private ObservableInt mood = new ObservableInt();
    private ObservableInt leisure = new ObservableInt();
    private ObservableInt sexualActivity = new ObservableInt();
    private ObservableInt dailyActivity = new ObservableInt();
    private ObservableInt socialActivity = new ObservableInt();
    private ObservableInt financialPosition = new ObservableInt();
    private ObservableInt accommodation = new ObservableInt();
    private ObservableInt work = new ObservableInt();
    private ObservableInt overallQualityOfLife = new ObservableInt();
    private Date date;

    private MutableLiveData<Boolean> savingStatus = new MutableLiveData<>();

    public QualityCreateViewModel(){
        CardioApp.getInstance().getComponentStorage().addCreateQualityComponent().inject(this);
        Calendar calendar = Calendar.getInstance();
        date = calendar.getTime();
    }

    public void createQuality(){
        QualityOfLife qualityOfLife = new QualityOfLife(date, physicalCondition.get(), mood.get(), leisure.get(), sexualActivity.get(),
                dailyActivity.get(), socialActivity.get(), financialPosition.get(), accommodation.get(), work.get(), overallQualityOfLife.get());
        Completable.fromAction(()->mRepository.creatingQuality(qualityOfLife))
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

    public LiveData<Boolean> getLiveDataStatus(){
        return savingStatus;
    }

    public ObservableInt getPhysicalCondition() {
        return physicalCondition;
    }

    public void setPhysicalCondition(ObservableInt physicalCondition) {
        this.physicalCondition = physicalCondition;
    }

    public ObservableInt getMood() {
        return mood;
    }

    public void setMood(ObservableInt mood) {
        this.mood = mood;
    }

    public ObservableInt getLeisure() {
        return leisure;
    }

    public void setLeisure(ObservableInt leisure) {
        this.leisure = leisure;
    }

    public ObservableInt getSexualActivity() {
        return sexualActivity;
    }

    public void setSexualActivity(ObservableInt sexualActivity) {
        this.sexualActivity = sexualActivity;
    }

    public ObservableInt getDailyActivity() {
        return dailyActivity;
    }

    public void setDailyActivity(ObservableInt dailyActivity) {
        this.dailyActivity = dailyActivity;
    }

    public ObservableInt getSocialActivity() {
        return socialActivity;
    }

    public void setSocialActivity(ObservableInt socialActivity) {
        this.socialActivity = socialActivity;
    }

    public ObservableInt getFinancialPosition() {
        return financialPosition;
    }

    public void setFinancialPosition(ObservableInt financialPosition) {
        this.financialPosition = financialPosition;
    }

    public ObservableInt getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(ObservableInt accommodation) {
        this.accommodation = accommodation;
    }

    public ObservableInt getWork() {
        return work;
    }

    public void setWork(ObservableInt work) {
        this.work = work;
    }

    public ObservableInt getOverallQualityOfLife() {
        return overallQualityOfLife;
    }

    public void setOverallQualityOfLife(ObservableInt overallQualityOfLife) {
        this.overallQualityOfLife = overallQualityOfLife;
    }

    @Override
    protected void onCleared() {
        CardioApp.getInstance().getComponentStorage().clearCreateQualityComponent();
        super.onCleared();
    }
}
