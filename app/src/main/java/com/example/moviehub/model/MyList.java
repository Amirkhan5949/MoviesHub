package com.example.moviehub.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.moviehub.room.typeconverter.MTvConverter;
import com.example.moviehub.utils.Type;
@Entity
@TypeConverters({MTvConverter.class
})
public class MyList {

    @PrimaryKey(autoGenerate = true)
    Long id;
    String name;
    int size;
    Type.MovieOrTvshow type;

    public MyList(String name, int size, Type.MovieOrTvshow type) {
        this.name = name;
        this.size = size;
        this.type = type;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @TypeConverters({MTvConverter.class})
    public Type.MovieOrTvshow getType() {
        return type;
    }

    public void setType(Type.MovieOrTvshow type) {
        this.type = type;
    }
}
