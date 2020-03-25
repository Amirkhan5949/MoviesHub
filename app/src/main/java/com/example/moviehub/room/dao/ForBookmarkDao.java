package com.example.moviehub.room.dao;

import com.example.moviehub.model.ForBookmark;
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
public interface  ForBookmarkDao {

    @Query("SELECT * FROM ForBookmark")
    List<ForBookmark> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(ForBookmark bookmark);

    @Query("DELETE  FROM ForBookmark WHERE ForBookmark.minfo==(:mid)")
    void delte( long mid);

    @Update
    void update(ForBookmark bookmark);

    @Query("SELECT * FROM MovieInfo INNER JOIN ForBookmark ON MovieInfo.id == ForBookmark.minfo WHERE ForBookmark.type == (:type)")
    List<MovieInfo> getAllBookmarkMovieInfo(Type.MovieOrTvshow type);

    @Query("SELECT * FROM ForBookmark WHERE ForBookmark.minfo==(:mid) ")
    List<ForBookmark> getbookmarklist(long mid);
}
