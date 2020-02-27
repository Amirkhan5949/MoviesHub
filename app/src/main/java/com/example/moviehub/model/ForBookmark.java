package com.example.moviehub.model;

import com.example.moviehub.room.typeconverter.MTvConverter;
import com.example.moviehub.utils.Type;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(foreignKeys = @ForeignKey(entity = MovieInfo.class,
        parentColumns = "id",
        childColumns = "minfo",
        onDelete = ForeignKey.CASCADE))
@TypeConverters({MTvConverter.class})
public class ForBookmark {

    @PrimaryKey(autoGenerate = true)
    int mid;

    Long minfo;

     Type.MovieOrTvshow type;


    public ForBookmark(Long minfo, Type.MovieOrTvshow type) {
        this.minfo = minfo;
        this.type = type;
    }

    @TypeConverters({MTvConverter.class})
    public Type.MovieOrTvshow getType() {
        return type;
    }

    public void setType(Type.MovieOrTvshow type) {
        this.type = type;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public Long getMinfo() {
        return minfo;
    }

    public void setMinfo(Long minfo) {
        this.minfo = minfo;
    }
}

