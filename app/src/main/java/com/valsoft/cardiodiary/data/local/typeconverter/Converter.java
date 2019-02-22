package com.valsoft.cardiodiary.data.local.typeconverter;

import android.arch.persistence.room.TypeConverter;

import java.util.Date;

public class Converter {

    @TypeConverter
    public Long dateToTimestamp(Date date) {
        if (date == null) {
            return null;
        } else {
            return date.getTime();
        }
    }

    @TypeConverter
    public Date dateFromTimestamp(Long date){
        return new Date(date);
    }
}
