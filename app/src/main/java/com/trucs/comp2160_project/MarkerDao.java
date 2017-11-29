package com.trucs.comp2160_project;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Cody on 11/28/2017.
 */

@Dao
public interface MarkerDao {
    @Query("SELECT * FROM marker")
    List<Marker> getAll();

    @Query("SELECT * FROM marker WHERE  IN (:mapIds)")
    List<Map> loadAllByIds(int[] mapIds);

    @Query("SELECT * FROM map WHERE map_name LIKE :name LIMIT 1")
    Map findByName(String name);

    @Insert
    void insert(Map map);

    @Update
    void update(Map map);

    @Delete
    void delete(Map map);
}
