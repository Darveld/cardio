package com.valsoft.cardiodiary.data.local.typeconverter;

import android.arch.persistence.room.TypeConverter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UriConverter {

    @TypeConverter
    public String fromArray(List<String> strings) {
        StringBuilder string = new StringBuilder();
        for(String s : strings) string.append(s).append(",");

        return string.toString();
    }

    @TypeConverter
    public List<String> toArray(String concatenatedStrings) {
        return new ArrayList<>(Arrays.asList(concatenatedStrings.split(",")));
    }
}
