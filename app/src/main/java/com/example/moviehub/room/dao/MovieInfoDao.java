package com.example.moviehub.room.dao;

import com.example.moviehub.model.MovieInfo;
import com.example.moviehub.utils.Type;

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

    @Query("SELECT * FROM MovieInfo where MovieInfo.id == (:id)")
    List<MovieInfo> checkMovieinfo(Long id);

    @Query("Select * FROM  MovieInfo INNER JOIN MyListDetail ON  MyListDetail.minfoid==MovieInfo.id  Where MyListDetail.type==:type AND mlid==:mylistid ")
    List<MovieInfo> getdetail(Type.MovieOrTvshow type, long mylistid);




}
