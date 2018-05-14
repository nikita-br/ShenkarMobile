package com.example.nik.myapplication;

import android.app.DatePickerDialog;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import android.text.format.DateFormat;


import java.util.Calendar;
import java.util.Date;

public class BirthDay extends AppCompatActivity {
    private static final String TAG = "birthdayActivity";
    EditText name;
    EditText b_day;
    int  gil;

    private TextView mDisplayDate;
    DatePickerDialog.OnDateSetListener mDateListner;

    Button addButton;
    Button dropButton;
    @Override

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_bday);

       name = findViewById(R.id.name);
       b_day = findViewById(R.id.day);
       addButton = findViewById(R.id.addButton);
       dropButton = findViewById(R.id.drop);
        mDisplayDate = (TextView)findViewById(R.id.tvDate);
        final AppDB db = Room.databaseBuilder(getApplicationContext(),AppDB.class,"bdays")
                .allowMainThreadQueries()
                .build();

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        BirthDay.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateListner,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        BirthDay.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateListner,year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });


        mDateListner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                int month= monthOfYear+1;
                String fm=""+month;
                String fd=""+dayOfMonth;
                if(month<10){
                    fm ="0"+month;
                }
                if (dayOfMonth<10){
                    fd="0"+dayOfMonth;
                }
                String date= ""+year+"-"+fm+"-"+fd;
                b_day.setText(date);




            }
        };

      addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student = new Student(name.getText().toString(),b_day.getText().toString());

                db.studentDB().insertAll(student);

                startActivity(new Intent(BirthDay.this,birthdayActivity.class));
            }
        });



    }



}
