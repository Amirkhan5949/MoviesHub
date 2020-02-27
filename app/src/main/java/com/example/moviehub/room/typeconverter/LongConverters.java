package com.example.moviehub.room.typeconverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import androidx.room.TypeConverter;

public class LongConverters {
    @TypeConverter
    public static List<Long> storedStringToLongs(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<Long>>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String myObjectsToStoredString(List<Long> myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}
