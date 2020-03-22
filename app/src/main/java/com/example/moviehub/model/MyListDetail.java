package com.example.moviehub.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.example.moviehub.room.typeconverter.MTvConverter;
import com.example.moviehub.utils.Type;

@TypeConverters({MTvConverter.class
})
@Entity
        (foreignKeys = {
                @ForeignKey(entity = MyList.class,
                parentColumns="id",
                childColumns = "mlid"),

                @ForeignKey(entity = MovieInfo.class,
                        parentColumns="id",
                        childColumns = "minfoid"),


        })
public class MyListDetail {
    @PrimaryKey(autoGenerate = true)
    long id;

    long mlid;

    long minfoid;

    Type.MovieOrTvshow type;



    public  MyListDetail(long mlid,long minfoid,Type.MovieOrTvshow type){
        this.mlid=mlid;
        this.minfoid=minfoid;
        this.type=type;

    }

    public long getMlid() {
        return mlid;
    }

    public void setMlid(long mlid) {
        this.mlid = mlid;
    }

    public long getMinfoid() {
        return minfoid;
    }

    public void setMinfoid(long minfoid) {
        this.minfoid = minfoid;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    @TypeConverters({MTvConverter.class})
    public Type.MovieOrTvshow getType() {
        return type;
    }

    public void setType(Type.MovieOrTvshow type) {
        this.type = type;
    }
}


