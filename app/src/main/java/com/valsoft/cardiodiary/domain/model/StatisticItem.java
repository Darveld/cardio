package com.valsoft.cardiodiary.domain.model;

import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;

import java.util.List;

public class StatisticItem {

    private List<PressureItem> pressureItems;

    private List<SymptomsItem> symptomsItems;

    private List<DailyIndexesItem> dailyIndexesItems;


    public StatisticItem(List<PressureItem> pressureItems, List<SymptomsItem> symptomsItems, List<DailyIndexesItem> dailyIndexesItems) {
        this.pressureItems = pressureItems;
        this.symptomsItems = symptomsItems;
        this.dailyIndexesItems = dailyIndexesItems;
    }

    public List<PressureItem> getPressureItems() {
        return pressureItems;
    }

    public void setPressureItems(List<PressureItem> pressureItems) {
        this.pressureItems = pressureItems;
    }

    public List<SymptomsItem> getSymptomsItems() {
        return symptomsItems;
    }

    public void setSymptomsItems(List<SymptomsItem> symptomsItems) {
        this.symptomsItems = symptomsItems;
    }

    public List<DailyIndexesItem> getDailyIndexesItems() {
        return dailyIndexesItems;
    }

    public void setDailyIndexesItems(List<DailyIndexesItem> dailyIndexesItems) {
        this.dailyIndexesItems = dailyIndexesItems;
    }
}
