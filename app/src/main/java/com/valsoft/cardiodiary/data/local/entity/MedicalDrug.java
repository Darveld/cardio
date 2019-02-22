package com.valsoft.cardiodiary.data.local.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.valsoft.cardiodiary.data.local.typeconverter.Converter;

import java.util.Date;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "medical_drugs_table",
        foreignKeys = {@ForeignKey(entity = MedicalRecord.class, parentColumns = "id", childColumns = "medical_record_id", onDelete = CASCADE),
        @ForeignKey(entity = Reminding.class, parentColumns = "id", childColumns = "reminding_id", onDelete = CASCADE)})
@TypeConverters(Converter.class)
public class MedicalDrug {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String name;

    private String dosage;

    @ColumnInfo(name = "time_usage")
    private String timeUsage;

    @ColumnInfo(name = "special_condition")
    private String specialCondition;

    @ColumnInfo(name = "medical_record_id")
    private Integer medicalRecordId;

    @ColumnInfo(name = "reminding_id")
    private Integer remindingId;

    public Integer getRemindingId() {
        return remindingId;
    }

    public void setRemindingId(Integer remindingId) {
        this.remindingId = remindingId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getTimeUsage() {
        return timeUsage;
    }

    public void setTimeUsage(String timeUsage) {
        this.timeUsage = timeUsage;
    }

    public String getSpecialCondition() {
        return specialCondition;
    }

    public void setSpecialCondition(String specialCondition) {
        this.specialCondition = specialCondition;
    }

    public Integer getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(Integer medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }
}
