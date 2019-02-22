package com.valsoft.cardiodiary.domain.model;

public class DailyIndexesItem {

    private int yFeelings;

    private int yActivity;

    private int yMood;

    private int yAnxiety;

    private int yIrritation;

    private int yConcentration;

    private int yFatigue;

    private int yPsychoemotionalStress;

    private int ySleep;

    private int xDay;

    public DailyIndexesItem(int yFeelings, int yActivity, int yMood, int yAnxiety, int yIrritation, int yConcentration, int yFatigue, int yPsychoemotionalStress, int ySleep, int xDay) {
        this.yFeelings = yFeelings;
        this.yActivity = yActivity;
        this.yMood = yMood;
        this.yAnxiety = yAnxiety;
        this.yIrritation = yIrritation;
        this.yConcentration = yConcentration;
        this.yFatigue = yFatigue;
        this.yPsychoemotionalStress = yPsychoemotionalStress;
        this.ySleep = ySleep;
        this.xDay = xDay;
    }

    public int getyFeelings() {
        return yFeelings;
    }

    public void setyFeelings(int yFeelings) {
        this.yFeelings = yFeelings;
    }

    public int getyActivity() {
        return yActivity;
    }

    public void setyActivity(int yActivity) {
        this.yActivity = yActivity;
    }

    public int getyMood() {
        return yMood;
    }

    public void setyMood(int yMood) {
        this.yMood = yMood;
    }

    public int getyAnxiety() {
        return yAnxiety;
    }

    public void setyAnxiety(int yAnxiety) {
        this.yAnxiety = yAnxiety;
    }

    public int getyIrritation() {
        return yIrritation;
    }

    public void setyIrritation(int yIrritation) {
        this.yIrritation = yIrritation;
    }

    public int getyIoncentration() {
        return yConcentration;
    }

    public void setyIoncentration(int yConcentration) {
        this.yConcentration = yConcentration;
    }

    public int getyFatigue() {
        return yFatigue;
    }

    public void setyFatigue(int yFatigue) {
        this.yFatigue = yFatigue;
    }

    public int getyPsychoemotionalStress() {
        return yPsychoemotionalStress;
    }

    public void setyPsychoemotionalStress(int yPsychoemotionalStress) {
        this.yPsychoemotionalStress = yPsychoemotionalStress;
    }

    public int getySleep() {
        return ySleep;
    }

    public void setySleep(int ySleep) {
        this.ySleep = ySleep;
    }

    public int getxDay() {
        return xDay;
    }

    public void setxDay(int xDay) {
        this.xDay = xDay;
    }
}
