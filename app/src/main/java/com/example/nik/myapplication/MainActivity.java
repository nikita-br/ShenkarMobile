package com.example.nik.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //String exersises[] = new String [] {"ex1","ex2","ex3"};

    ArrayList<String> exersises;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        exersises = new ArrayList<>();

        //for (int i = 0; i < 10; i++) {
           // exersises.add("nikita");
        //}
        exersises.add("calculator");
        exersises.add("bithdays");

        
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecAdapter(exersises);
        recyclerView.setAdapter(adapter);

    }
}
