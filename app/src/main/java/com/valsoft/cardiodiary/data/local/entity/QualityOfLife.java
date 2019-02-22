package com.valsoft.cardiodiary.data.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.valsoft.cardiodiary.data.local.typeconverter.Converter;

import java.util.Date;

@Entity(tableName = "quality_table")
@TypeConverters(Converter.class)
public class QualityOfLife {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private Date date;

    @ColumnInfo(name = "physical_condition")
    private int physicalCondition;

    private int mood;

    private int leisure;

    @ColumnInfo(name = "sexual_activity")
    private int sexualActivity;

    @ColumnInfo(name = "daily_activity")
    private int dailyActivity;

    @ColumnInfo(name = "social_activity")
    private int socialActivity;

    @ColumnInfo(name = "financial_position")
    private int financialPosition;

    private int accommodation;

    private int work;

    @ColumnInfo(name = "overall_quality_of_life")
    private int overallQualityOfLife;

    public QualityOfLife(Date date, int physicalCondition, int mood, int leisure, int sexualActivity, int dailyActivity, int socialActivity,
                         int financialPosition, int accommodation, int work, int overallQualityOfLife) {
        this.date = date;
        this.physicalCondition = physicalCondition;
        this.mood = mood;
        this.leisure = leisure;
        this.sexualActivity = sexualActivity;
        this.dailyActivity = dailyActivity;
        this.socialActivity = socialActivity;
        this.financialPosition = financialPosition;
        this.accommodation = accommodation;
        this.work = work;
        this.overallQualityOfLife = overallQualityOfLife;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPhysicalCondition() {
        return physicalCondition;
    }

    public void setPhysicalCondition(int physicalCondition) {
        this.physicalCondition = physicalCondition;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getLeisure() {
        return leisure;
    }

    public void setLeisure(int leisure) {
        this.leisure = leisure;
    }

    public int getSexualActivity() {
        return sexualActivity;
    }

    public void setSexualActivity(int sexualActivity) {
        this.sexualActivity = sexualActivity;
    }

    public int getDailyActivity() {
        return dailyActivity;
    }

    public void setDailyActivity(int dailyActivity) {
        this.dailyActivity = dailyActivity;
    }

    public int getSocialActivity() {
        return socialActivity;
    }

    public void setSocialActivity(int socialActivity) {
        this.socialActivity = socialActivity;
    }

    public int getFinancialPosition() {
        return financialPosition;
    }

    public void setFinancialPosition(int financialPosition) {
        this.financialPosition = financialPosition;
    }

    public int getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(int accommodation) {
        this.accommodation = accommodation;
    }

    public int getWork() {
        return work;
    }

    public void setWork(int work) {
        this.work = work;
    }

    public int getOverallQualityOfLife() {
        return overallQualityOfLife;
    }

    public void setOverallQualityOfLife(int overallQualityOfLife) {
        this.overallQualityOfLife = overallQualityOfLife;
    }
}
