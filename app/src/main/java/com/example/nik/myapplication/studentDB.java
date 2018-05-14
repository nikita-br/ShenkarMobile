package com.example.nik.myapplication;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;
@Dao
public interface studentDB {
    @Query("SELECT * FROM student ORDER BY SUBSTR(DATE('NOW'), 6)>SUBSTR(date, 6), SUBSTR(date, 6)")
    List<Student> getAllUsers();
    @Insert
    void insertAll(Student...students);
    @Query("DELETE FROM student")
    public void nukeTable();

    @Query("SELECT * FROM student ORDER BY date(date)")
    List<Student> orderTable();

}
