package com.valsoft.cardiodiary.domain.model;

import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;

import java.util.List;

public class MiddleValuesOfFeelings {

    private int middleFeelings;
    private int middleActivity;
    private int middleMood;
    private int middleAnxiety;
    private int middleIrritation;
    private int middleConcentration;
    private int middleFatigue;
    private int middlePsychoemotionalStress;
    private int middleSleep;
    private int countOfValues;
    public MiddleValuesOfFeelings(List<DailyIndexes> list) {
        countOfValues = 9;
        calculateMiddleValue(list);
    }

    private void calculateMiddleValue(List<DailyIndexes> list){
        for (DailyIndexes item:list){
            middleFeelings+=item.getFeelings();
            middleActivity+=item.getActivity();
            middleMood+=item.getMood();
            middleAnxiety+=item.getAnxiety();
            middleIrritation+=item.getIrritation();
            middleConcentration+=item.getConcentration();
            middleFatigue+=item.getFatigue();
            middlePsychoemotionalStress+=item.getPsychoemotionalStress();
            middleSleep+=item.getSleep();
        }
        middleFeelings/=list.size();
        middleActivity/=list.size();
        middleMood/=list.size();
        middleAnxiety/=list.size();
        middleIrritation/=list.size();
        middleConcentration/=list.size();
        middleFatigue/=list.size();
        middlePsychoemotionalStress/=list.size();
        middleSleep/=list.size();
    }

    public int getMiddleFeelings() {
        return middleFeelings;
    }

    public void setMiddleFeelings(int middleFeelings) {
        this.middleFeelings = middleFeelings;
    }

    public int getMiddleActivity() {
        return middleActivity;
    }

    public void setMiddleActivity(int middleActivity) {
        this.middleActivity = middleActivity;
    }

    public int getMiddleMood() {
        return middleMood;
    }

    public void setMiddleMood(int middleMood) {
        this.middleMood = middleMood;
    }

    public int getMiddleAnxiety() {
        return middleAnxiety;
    }

    public void setMiddleAnxiety(int middleAnxiety) {
        this.middleAnxiety = middleAnxiety;
    }

    public int getMiddleIrritation() {
        return middleIrritation;
    }

    public void setMiddleIrritation(int middleIrritation) {
        this.middleIrritation = middleIrritation;
    }

    public int getMiddleConcentration() {
        return middleConcentration;
    }

    public void setMiddleConcentration(int middleConcentration) {
        this.middleConcentration = middleConcentration;
    }

    public int getMiddleFatigue() {
        return middleFatigue;
    }

    public void setMiddleFatigue(int middleFatigue) {
        this.middleFatigue = middleFatigue;
    }

    public int getMiddlePsychoemotionalStress() {
        return middlePsychoemotionalStress;
    }

    public void setMiddlePsychoemotionalStress(int middlePsychoemotionalStress) {
        this.middlePsychoemotionalStress = middlePsychoemotionalStress;
    }

    public int getMiddleSleep() {
        return middleSleep;
    }

    public void setMiddleSleep(int middleSleep) {
        this.middleSleep = middleSleep;
    }
}
