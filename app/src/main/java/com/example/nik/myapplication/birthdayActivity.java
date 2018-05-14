package com.example.nik.myapplication;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class birthdayActivity extends AppCompatActivity {

    private static final String TAG = "birthdayActivity";

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;
    Button dropButton;
    ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerBirthdays);
        students = new ArrayList<>();

        final AppDB db = Room.databaseBuilder(getApplicationContext(),AppDB.class,"bdays")
                .allowMainThreadQueries()
                .build();
        List<Student> students = db.studentDB().getAllUsers();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new myAdapter(students);
        recyclerView.setAdapter(adapter);

        fab = findViewById(R.id.fab);
        dropButton = findViewById(R.id.drop);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(birthdayActivity.this,BirthDay.class));
            }
        });

        dropButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db.studentDB().nukeTable();
                List<Student> students = db.studentDB().getAllUsers();
                //recyclerView.setLayoutManager(new LinearLayoutManager(this));
                adapter = new myAdapter(students);
                recyclerView.setAdapter(adapter);

            }
        });


    }

}
