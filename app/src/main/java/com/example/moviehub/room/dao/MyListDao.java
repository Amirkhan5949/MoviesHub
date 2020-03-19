package com.example.moviehub.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.moviehub.model.MyList;
import com.example.moviehub.model.MyList;
import com.example.moviehub.utils.Type;

import java.util.List;

@Dao
public interface MyListDao {

    @Query("SELECT * FROM MyList WHERE MyList.type = :type")
    List<MyList> getAll(Type.MovieOrTvshow type);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MyList list);

    @Delete
    void delte(MyList list);

    @Update
    void update(MyList list);
}
