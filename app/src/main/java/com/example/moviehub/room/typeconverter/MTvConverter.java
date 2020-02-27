package com.example.moviehub.room.typeconverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;


import java.lang.reflect.Type;

import java.util.List;



public class MTvConverter {

    @androidx.room.TypeConverter
    public static com.example.moviehub.utils.Type.MovieOrTvshow storedStringToTypeMovieOrTvshows(String data) {
        Gson gson = new Gson();

        Type listType = new TypeToken<com.example.moviehub.utils.Type.MovieOrTvshow>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @androidx.room.TypeConverter
    public static String myObjectsToStoredString(com.example.moviehub.utils.Type.MovieOrTvshow myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}
