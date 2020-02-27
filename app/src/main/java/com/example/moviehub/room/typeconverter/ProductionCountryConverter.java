package com.example.moviehub.room.typeconverter;

import com.example.moviehub.model.MovieInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import androidx.room.TypeConverter;

public class ProductionCountryConverter {
    @TypeConverter
    public static List<MovieInfo.ProductionCountry> storedStringToProductionCountrys(String data) {
        Gson gson = new Gson();
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<MovieInfo.ProductionCountry>>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String myObjectsToStoredString(List<MovieInfo.ProductionCountry> myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}
