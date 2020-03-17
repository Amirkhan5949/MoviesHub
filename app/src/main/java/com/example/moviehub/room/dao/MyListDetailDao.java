package com.example.moviehub.room.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.moviehub.model.MyList;
import com.example.moviehub.model.MyListDetail;

import java.util.List;

@Dao
public interface MyListDetailDao {

    @Query("SELECT * FROM MyListDetail")
    List<MyListDetail> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(MyListDetail list);

    @Delete
    void delte(MyListDetail list);

    @Update
    void update(MyListDetail list);

    @Query("SELECT * FROM MyListDetail where MyListDetail.minfoid == (:id) And MyListDetail.mlid == (:mlid)" )
    List<MyListDetail> checkListDetail(Long id,Long mlid);

}
