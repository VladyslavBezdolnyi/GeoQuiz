package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;

import android.widget.TextView;



import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    GeoTimer geo;
    TextView timeView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void pushButton(View view){
        timeView = findViewById(R.id.num);
        if(!GeoTimer.isRun){
            geo = new GeoTimer(timeView);
        }

    }

    public void setText(final TextView text,final String value){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                text.setText(value);
            }
        });
    }

    public void testMe(View view){

        TextView booleanTest = findViewById(R.id.bool_test);

        if(GeoTimer.isRun){
            booleanTest.setText("True");
        }
        else{
            booleanTest.setText("False");
        }

    }

}





