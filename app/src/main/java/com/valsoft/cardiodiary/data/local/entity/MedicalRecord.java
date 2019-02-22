package com.valsoft.cardiodiary.data.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.valsoft.cardiodiary.data.local.typeconverter.Converter;
import com.valsoft.cardiodiary.data.local.typeconverter.UriConverter;

import java.util.Date;
import java.util.List;

@Entity(tableName = "medical_records_table")
@TypeConverters({Converter.class, UriConverter.class})
public class MedicalRecord {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private Date date;

    private String title;

    @ColumnInfo(name = "medical_notes")
    private String medicalNotes;

    private List<String> images;

    @ColumnInfo(name = "planned_inspection")
    private String plannedInspection;

    @ColumnInfo(name = "planned_visits")
    private String plannedVisits;

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMedicalNotes() {
        return medicalNotes;
    }

    public void setMedicalNotes(String medicalNotes) {
        this.medicalNotes = medicalNotes;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getPlannedInspection() {
        return plannedInspection;
    }

    public void setPlannedInspection(String plannedInspection) {
        this.plannedInspection = plannedInspection;
    }

    public String getPlannedVisits() {
        return plannedVisits;
    }

    public void setPlannedVisits(String plannedVisits) {
        this.plannedVisits = plannedVisits;
    }
}
