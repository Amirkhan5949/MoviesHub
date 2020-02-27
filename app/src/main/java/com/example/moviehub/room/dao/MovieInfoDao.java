package com.example.moviehub.room.dao;

import com.example.moviehub.model.MovieInfo;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface MovieInfoDao {
    @Query("SELECT * FROM MovieInfo")
    List<MovieInfo> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MovieInfo result);

    @Delete
    void delete(MovieInfo result);

    @Update
    void update(MovieInfo result);


}
