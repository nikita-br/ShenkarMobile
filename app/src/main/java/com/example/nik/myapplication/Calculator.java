package com.example.nik.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.view.View;
import android.widget.TextView;

import static java.lang.Integer.parseInt;


public class Calculator extends AppCompatActivity {
    private TextView calculateText;
    private TextView calculateText2;
    private TextView calculateText3;
    String delimiters = "[+-]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        calculateText = findViewById(R.id.calculate);


    }

    public  void buttonPressed(View view){

        String currentText = ((AppCompatButton)view).getText().toString();
        calculateText.setText(calculateText.getText().toString().concat(currentText));
        String[] Operands = currentText.split(delimiters);
    }



    public  void buttonEqual(View view){
        String delimiters = "[/*+-]+";
        String specs = "[^+-]+";

        String expression = calculateText.getText().toString();
        String[] Operands = expression .split(delimiters);
        String[] Operations = expression .split(specs);
        Integer Result = Integer.parseInt(Operands[0]);
        for (int i=0; i<(Operands.length-1);i++)
        {
            if (Operations[i+1].equals("+")){
                Result = Result + Integer.parseInt(Operands[i+1]);
            }else{
                Result = Result - Integer.parseInt(Operands[i+1]);
            }
            calculateText.setText(Result.toString());
        }

    }



}
