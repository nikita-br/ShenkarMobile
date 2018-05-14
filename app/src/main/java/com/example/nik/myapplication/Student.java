package com.example.nik.myapplication;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.Calendar;

@Entity
public class Student {
    public Student(String name, String date) {
        this.name = name;
        this.date = date;
    }

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "date")
    private String date;



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getGil()
    {
        int x = Calendar.getInstance().get(Calendar.YEAR);
        int y = Integer.parseInt(this.getDate().substring(0,4));
        String str1 = Integer.toString(x-y) + " years old";
        return str1;
    }


}
