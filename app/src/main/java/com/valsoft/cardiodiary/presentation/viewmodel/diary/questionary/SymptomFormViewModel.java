package com.valsoft.cardiodiary.presentation.viewmodel.diary.questionary;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.data.local.entity.Symptoms;
import com.valsoft.cardiodiary.domain.repositories.symptom.CreatingSymptomsRepository;
import com.valsoft.cardiodiary.domain.usecase.CreateSymptomsUseCase;

import java.util.Calendar;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SymptomFormViewModel extends ViewModel{

    @Inject
    CreateSymptomsUseCase mCreateSymptomsUseCase;
    private Symptoms.Builder mBuilder;
    private Calendar mCalendar;

    public ObservableField<String> natureOfHeartPain = new ObservableField<>();
    private ObservableField<String> localization = new ObservableField<>();
    private ObservableField<String> irradiation = new ObservableField<>();
    private ObservableInt heartPainIntensity = new ObservableInt();
    private ObservableInt heartPainDuration = new ObservableInt();
    private ObservableField<String> heartPainCondition = new ObservableField<>();
    private ObservableBoolean heartInterruptions = new ObservableBoolean();
    private ObservableField<String> heartInterruptionFrequency = new ObservableField<>();
    private ObservableBoolean palpitation = new ObservableBoolean();
    private ObservableField<String> palpitationFrequency = new ObservableField<>();
    private ObservableBoolean headache = new ObservableBoolean();
    private ObservableField<String> headacheDuration = new ObservableField<>();
    private ObservableField<String> dyspnea = new ObservableField<>();
    private ObservableField<String> conditionOfDyspnea = new ObservableField<>();
    private ObservableBoolean dizziness = new ObservableBoolean();
    private ObservableField<String> dizzinesDiastolic = new ObservableField<>();
    private ObservableField<String> dizzinesSystolic = new ObservableField<>();
    private ObservableField<String> dizzinesFrequency = new ObservableField<>();
    private ObservableBoolean lossOfConsciousness = new ObservableBoolean();
    private ObservableField<String> consciousnessDiastolic = new ObservableField<>();
    private ObservableField<String> consciousnessSystolic = new ObservableField<>();
    private ObservableField<String> consciousnessFrequency = new ObservableField<>();
    private ObservableField<String> edema = new ObservableField<>();
    private ObservableBoolean anotherTypeOfHeart = new ObservableBoolean();
    private MutableLiveData<Boolean> savingStatus = new MutableLiveData<>();

    public SymptomFormViewModel(){
        CardioApp.getInstance().getComponentStorage().addCreateSymptomComponent().inject(this);
        mCalendar = Calendar.getInstance();
        mBuilder = new Symptoms.Builder(mCalendar.getTime());
    }

    public LiveData<Boolean> getStatusLiveData(){
        return savingStatus;
    }

    public void saveData(){
        mCreateSymptomsUseCase.createSymptoms(mBuilder.build())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onComplete() {
                        savingStatus.setValue(true);
                        Log.d("Complete ", "zbs");
                    }

                    @Override
                    public void onError(Throwable e) {
                        savingStatus.setValue(false);
                        Log.d("Complete ", e.toString());
                    }
                });


    }

    @Override
    protected void onCleared() {
        super.onCleared();
        CardioApp.getInstance().getComponentStorage().clearCreateSymptomComponent();
    }

    public ObservableBoolean getAnotherTypeOfHeart() {
        return anotherTypeOfHeart;
    }

    public void setAnotherTypeOfHeart(Boolean anotherTypeOfHeart) {
        this.anotherTypeOfHeart.set(anotherTypeOfHeart);
        this.natureOfHeartPain.set("");
    }

    public ObservableField<String> getNatureOfHeartPain() {
        return natureOfHeartPain;
    }

    public void setNatureOfHeartPain(String natureOfHeartPain) {
        this.natureOfHeartPain.set(natureOfHeartPain);
        mBuilder.addNatureOfHeartPain(natureOfHeartPain);
    }

    public ObservableField<String> getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization.set(localization);
        mBuilder.addLocalization(localization);
    }

    public ObservableField<String> getIrradiation() {
        return irradiation;
    }

    public void setIrradiation(String irradiation) {
        this.irradiation.set(irradiation);
        mBuilder.addIrradiation(irradiation);
    }

    public ObservableInt getHeartPainIntensity() {
        return heartPainIntensity;
    }

    public void setHeartPainIntensity(int heartPainIntensity) {
        this.heartPainIntensity.set(heartPainIntensity);
        mBuilder.addHeartPainIntensity(heartPainIntensity);
    }

    public ObservableInt getHeartPainDuration() {
        return heartPainDuration;
    }

    public void setHeartPainDuration(int heartPainDuration) {
        this.heartPainDuration.set(heartPainDuration);
        mBuilder.addHeartPainDuration(heartPainDuration);
    }

    public ObservableField<String> getHeartPainCondition() {
        return heartPainCondition;
    }

    public void setHeartPainCondition(String heartPainCondition) {
        this.heartPainCondition.set(heartPainCondition);
        mBuilder.addHeartPainCondition(heartPainCondition);
    }

    public ObservableBoolean getHeartInterruptions() {
        return heartInterruptions;
    }

    public void setHeartInterruptions(Boolean heartInterruptions) {
        this.heartInterruptions.set(heartInterruptions);
        mBuilder.addHeartInterruptions(heartInterruptions);
        if (!heartInterruptions) {
            mBuilder.addHeartInterruptionFrequency(0);
        }
    }

    public ObservableField<String> getHeartInterruptionFrequency() {
        return heartInterruptionFrequency;
    }

    public void setHeartInterruptionFrequency(String heartInterruptionFrequency) {
        this.heartInterruptionFrequency.set(heartInterruptionFrequency);
        if (heartInterruptionFrequency.length() != 0)mBuilder.addHeartInterruptionFrequency(Integer.parseInt(heartInterruptionFrequency));
    }

    public ObservableBoolean getPalpitation() {
        return palpitation;
    }

    public void setPalpitation(Boolean palpitation) {
        this.palpitation.set(palpitation);
        mBuilder.addPalpitation(palpitation);
        if (!palpitation){
            mBuilder.addPalpitationFrequency(0);
        }
    }

    public ObservableField<String> getPalpitationFrequency() {
        return palpitationFrequency;
    }

    public void setPalpitationFrequency(String palpitationFrequency) {
        this.palpitationFrequency.set(palpitationFrequency);
       if (palpitationFrequency.length() != 0) mBuilder.addPalpitationFrequency(Integer.parseInt(palpitationFrequency));
    }

    public ObservableBoolean getHeadache() {
        return headache;
    }

    public void setHeadache(Boolean headache) {
        this.headache.set(headache);
        mBuilder.addHeadache(headache);
        if (!headache){
            mBuilder.addHeadacheDuration(0);
        }
    }

    public ObservableField<String> getHeadacheDuration() {
        return headacheDuration;
    }

    public void setHeadacheDuration(String headacheDuration) {
        this.headacheDuration.set(headacheDuration);
        if (headacheDuration.length() != 0)mBuilder.addHeadacheDuration(Integer.parseInt(headacheDuration));
    }

    public ObservableField<String> getDyspnea() {
        return dyspnea;
    }

    public void setDyspnea(String dyspnea) {
        this.dyspnea.set(dyspnea);
        mBuilder.addDyspnea(dyspnea);
    }

    public ObservableField<String> getConditionOfDyspnea() {
        return conditionOfDyspnea;
    }

    public void setConditionOfDyspnea(String conditionOfDyspnea) {
        this.conditionOfDyspnea.set(conditionOfDyspnea);
        mBuilder.addConditionOfDyspnea(conditionOfDyspnea);
    }

    public ObservableBoolean getDizziness() {
        return dizziness;
    }

    public void setDizziness(Boolean dizziness) {
        this.dizziness.set(dizziness);
        mBuilder.addDizziness(dizziness);
        if (!dizziness){
            mBuilder.addDizzinesSystolic(0);
            mBuilder.addDizzinesDiastolic(0);
            mBuilder.addDizzinesFrequency(0);
        }
    }

    public ObservableField<String> getDizzinesDiastolic() {
        return dizzinesDiastolic;
    }

    public void setDizzinesDiastolic(String dizzinesDiastolic) {
        this.dizzinesDiastolic.set(dizzinesDiastolic);
        if (dizzinesDiastolic.length() != 0)mBuilder.addDizzinesSystolic(Integer.parseInt(dizzinesDiastolic));
    }

    public ObservableField<String> getDizzinesSystolic() {
        return dizzinesSystolic;
    }

    public void setDizzinesSystolic(String dizzinesSystolic) {
        this.dizzinesSystolic.set(dizzinesSystolic);
        if (dizzinesSystolic.length() != 0)mBuilder.addDizzinesSystolic(Integer.parseInt(dizzinesSystolic));
    }

    public ObservableField<String> getDizzinesFrequency() {
        return dizzinesFrequency;
    }

    public void setDizzinesFrequency(String dizzinesFrequency) {
        this.dizzinesFrequency.set(dizzinesFrequency);
        if (dizzinesFrequency.length() != 0)mBuilder.addDizzinesFrequency(Integer.parseInt(dizzinesFrequency));
    }

    public ObservableBoolean getLossOfConsciousness() {
        return lossOfConsciousness;
    }

    public void setLossOfConsciousness(Boolean lossOfConsciousness) {
        this.lossOfConsciousness.set(lossOfConsciousness);
        mBuilder.addLossOfConsciousness(lossOfConsciousness);
        if (!lossOfConsciousness){
            mBuilder.addConsciousnessDiastolic(0);
            mBuilder.addConsciousnessSystolic(0);
            mBuilder.addConsciousnessFrequency(0);
        }
    }

    public ObservableField<String> getConsciousnessDiastolic() {
        return consciousnessDiastolic;
    }

    public void setConsciousnessDiastolic(String consciousnessDiastolic) {
        this.consciousnessDiastolic.set(consciousnessDiastolic);
        if (consciousnessDiastolic.length() != 0)mBuilder.addConsciousnessDiastolic(Integer.parseInt(consciousnessDiastolic));
    }

    public ObservableField<String> getConsciousnessSystolic() {
        return consciousnessSystolic;
    }

    public void setConsciousnessSystolic(String consciousnessSystolic) {
        this.consciousnessSystolic.set(consciousnessSystolic);
        if (consciousnessSystolic.length() != 0)mBuilder.addConsciousnessSystolic(Integer.parseInt(consciousnessSystolic));
    }

    public ObservableField<String> getConsciousnessFrequency() {
        return consciousnessFrequency;
    }

    public void setConsciousnessFrequency(String consciousnessFrequency) {
        this.consciousnessFrequency.set(consciousnessFrequency);
        if (consciousnessFrequency.length() != 0)mBuilder.addConsciousnessFrequency(Integer.parseInt(consciousnessFrequency));
    }

    public ObservableField<String> getEdema() {
        return edema;
    }

    public void setEdema(String edema) {
        this.edema.set(edema);
        mBuilder.addEdema(edema);
    }
}
