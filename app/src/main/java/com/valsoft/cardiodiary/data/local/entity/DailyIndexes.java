package com.valsoft.cardiodiary.data.local.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.valsoft.cardiodiary.data.local.typeconverter.Converter;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "daily_indexes_table", foreignKeys = @ForeignKey(entity = Statistic.class, parentColumns = "id", childColumns = "statistic_id", onDelete = CASCADE))
@TypeConverters(Converter.class)
public class DailyIndexes {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "statistic_id")
    private Long statisticId;

    private int feelings;

    private int activity;

    private int mood;

    private int anxiety;

    private int irritation;

    private int concentration;

    private int fatigue;

    private int psychoemotionalStress;

    private int sleep;

    private Date date;

    public DailyIndexes(int feelings, int activity, int mood, int anxiety, int irritation, int concentration, int fatigue, int psychoemotionalStress, int sleep, Date date, long statisticId) {
        this.feelings = feelings;
        this.activity = activity;
        this.mood = mood;
        this.anxiety = anxiety;
        this.irritation = irritation;
        this.concentration = concentration;
        this.fatigue = fatigue;
        this.psychoemotionalStress = psychoemotionalStress;
        this.sleep = sleep;
        this.date = date;
        this.statisticId = statisticId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getFeelings() {
        return feelings;
    }

    public void setFeelings(int feelings) {
        this.feelings = feelings;
    }

    public int getActivity() {
        return activity;
    }

    public void setActivity(int activity) {
        this.activity = activity;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getAnxiety() {
        return anxiety;
    }

    public void setAnxiety(int anxiety) {
        this.anxiety = anxiety;
    }

    public int getIrritation() {
        return irritation;
    }

    public void setIrritation(int irritation) {
        this.irritation = irritation;
    }

    public int getConcentration() {
        return concentration;
    }

    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public int getPsychoemotionalStress() {
        return psychoemotionalStress;
    }

    public void setPsychoemotionalStress(int psychoemotionalStress) {
        this.psychoemotionalStress = psychoemotionalStress;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(Long statisticId) {
        this.statisticId = statisticId;
    }
}

