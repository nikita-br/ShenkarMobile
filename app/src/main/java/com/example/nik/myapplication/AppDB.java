package com.example.nik.myapplication;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Student.class},version = 2)
public abstract class AppDB extends RoomDatabase {
    public abstract studentDB studentDB();
}
