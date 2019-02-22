package com.valsoft.cardiodiary.data.local.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.valsoft.cardiodiary.data.local.typeconverter.Converter;

import java.util.Date;

@Entity(tableName = "reminding_table")
@TypeConverters(Converter.class)
public class Reminding {

    @PrimaryKey(autoGenerate = true)
    private long id;

    private String title;

    private String description;

    @ColumnInfo(name = "type_of_reminding")
    private String typeOfReminding;

    @ColumnInfo(name = "first_date")
    private Date firstDate;

    @ColumnInfo(name = "secondary_date")
    private Date secondaryDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTypeOfReminding() {
        return typeOfReminding;
    }

    public void setTypeOfReminding(String typeOfReminding) {
        this.typeOfReminding = typeOfReminding;
    }

    public Date getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(Date firstDate) {
        this.firstDate = firstDate;
    }

    public Date getSecondaryDate() {
        return secondaryDate;
    }

    public void setSecondaryDate(Date secondaryDate) {
        this.secondaryDate = secondaryDate;
    }
}
