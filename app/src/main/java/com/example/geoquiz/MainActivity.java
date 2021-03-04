package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;

import android.widget.ListView;
import android.widget.TextView;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class MainActivity extends AppCompatActivity {
    GeoTimer geo;
    TextView timeView;
    String[] countries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         countries = getResources().getStringArray(R.array.countries);


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
            booleanTest.setText(new Country(countries).name);
        }
        else{
            booleanTest.setText("False");
        }

    }

}

class Country{

    String name;
    char[] encryptedNameList;

    Country(String[] countries){
        this.name = countries[new RandomCountryNum(countries.length).getNum()];
    }

    void encrypting(){

    }

}

class RandomCountryNum{
    private final int num;

    RandomCountryNum(int arraySize){

        num = numGenerator(Player.getRank(), arraySize);
    }

    int numGenerator(int rank, int arraySize){
        Random random = new Random();

        return random.nextInt(arraySize); // Change!
    }

    int getNum(){
        return num;
    }
}

class Player{
    private static int rank;

    static int getRank(){
        return rank;
    }

}





