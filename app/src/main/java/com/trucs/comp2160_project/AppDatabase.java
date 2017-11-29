package com.trucs.comp2160_project;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Cody on 11/28/2017.
 */

@Database(entities = {Map.class, Marker.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MapDao mapDao();
    public abstract MarkerDao markerDao();
}
