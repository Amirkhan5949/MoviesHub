package com.example.moviehub.room.typeconverter;

import com.example.moviehub.model.MovieInfo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import androidx.room.TypeConverter;

public class BelongsToCollectionConverter {
    @TypeConverter
    public static MovieInfo.BelongsToCollection storedStringToBelongsToCollections(String data) {
        Gson gson = new Gson();
        Type listType = new TypeToken<MovieInfo.BelongsToCollection>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String myObjectsToStoredString(MovieInfo.BelongsToCollection myObjects) {
        Gson gson = new Gson();
        return gson.toJson(myObjects);
    }
}
