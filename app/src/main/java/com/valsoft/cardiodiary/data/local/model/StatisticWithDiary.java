package com.valsoft.cardiodiary.data.local.model;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;

import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;
import com.valsoft.cardiodiary.data.local.entity.Pressure;
import com.valsoft.cardiodiary.data.local.entity.Statistic;
import com.valsoft.cardiodiary.data.local.entity.Symptoms;

import java.util.List;

public class StatisticWithDiary {

    @Embedded
    private Statistic mStatistic;

    @Relation(parentColumn = "id", entityColumn = "statistic_id")
    private List<Symptoms> mSymptoms;

    @Relation(parentColumn = "id", entityColumn = "statistic_id")
    private List<Pressure> mPressures;

    @Relation(parentColumn = "id", entityColumn = "statistic_id")
    private List<DailyIndexes> mIndexesList;


    public Statistic getStatistic() {
        return mStatistic;
    }

    public void setStatistic(Statistic statistic) {
        mStatistic = statistic;
    }

    public List<Symptoms> getSymptoms() {
        return mSymptoms;
    }

    public void setSymptoms(List<Symptoms> symptoms) {
        mSymptoms = symptoms;
    }

    public List<Pressure> getPressures() {
        return mPressures;
    }

    public void setPressures(List<Pressure> pressures) {
        mPressures = pressures;
    }

    public List<DailyIndexes> getIndexesList() {
        return mIndexesList;
    }

    public void setIndexesList(List<DailyIndexes> indexesList) {
        mIndexesList = indexesList;
    }
}
