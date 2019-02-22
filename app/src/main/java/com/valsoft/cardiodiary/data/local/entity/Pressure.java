package com.valsoft.cardiodiary.data.local.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.util.Log;

import com.valsoft.cardiodiary.data.local.typeconverter.Converter;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "pressure", foreignKeys = @ForeignKey(entity = Statistic.class, parentColumns = "id", childColumns = "statistic_id", onDelete = CASCADE))
@TypeConverters(Converter.class)
public class Pressure {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "statistic_id")
    private Long statisticId;

    private int diastolic;

    private int systolic;

    private int frequency;

    private Date date;

    public Pressure(int diastolic, int systolic, int frequency, Date date, long statisticId){
        this.diastolic = diastolic;
        this.systolic = systolic;
        this.frequency = frequency;
        this.date = date;
        this.statisticId = statisticId;
    }

    public Long getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(Long statisticId) {
        this.statisticId = statisticId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDiastolic() {
        return diastolic;
    }

    public void setDiastolic(int diastolic) {
        this.diastolic = diastolic;
    }

    public int getSystolic() {
        return systolic;
    }

    public void setSystolic(int systolic) {
        this.systolic = systolic;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
