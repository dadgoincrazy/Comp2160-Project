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

    @Query("SELECT * FROM marker WHERE id IN (:markerIds)")
    List<Marker> loadAllByIds(long[] markerIds);

    @Query("SELECT * FROM marker WHERE map_id = :map_id")
    List<Marker> getByMapId(long map_id);

    @Insert
    long insert(Marker marker);

    @Update
    void update(Marker marker);

    @Delete
    void delete(Marker marker);
}
