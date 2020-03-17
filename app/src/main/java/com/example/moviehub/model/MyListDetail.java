package com.example.moviehub.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

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

    public MyListDetail(long mlid,long minfoid){
        this.mlid=mlid;
        this.minfoid=minfoid;
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
}
