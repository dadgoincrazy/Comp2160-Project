package com.trucs.comp2160_project;

import android.app.Application;
import android.arch.persistence.room.Room;

/**
 * Created by owner on 29/11/2017.
 */

public class App extends Application {

    public static App INSTANCE;
    private static final String DATABASE_NAME = "MyDatabase";

    private AppDatabase database;

    public static App get() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Create database
        database = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();

        INSTANCE = this;
    }

    public AppDatabase getDB() {
        return database;
    }
}
