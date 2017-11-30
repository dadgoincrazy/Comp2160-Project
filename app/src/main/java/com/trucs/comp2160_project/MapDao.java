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
public interface MapDao {
    @Query("SELECT * FROM map")
    List<Map> getAll();

    @Query("SELECT * FROM map WHERE id IN (:mapIds)")
    List<Map> loadAllByIds(int[] mapIds);

    @Query("SELECT * FROM map WHERE map_name LIKE :name LIMIT 1")
    Map findByName(String name);

    @Query("SELECT * FROM map WHERE id = :map_id LIMIT 1")
    Map get(Integer map_id);

    @Insert
    long insert(Map map);

    @Update
    void update(Map map);

    @Delete
    void delete(Map map);
}
