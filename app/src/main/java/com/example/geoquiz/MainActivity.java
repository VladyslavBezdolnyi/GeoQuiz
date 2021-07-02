package com.example.geoquiz;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Animation.AnimationListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.view.animation.AnimationUtils;
import android.widget.TextView;


import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

public class MainActivity extends AppCompatActivity {
    GeoTimer geo;
    TextView timeView;
    String[] countries;

    //test
    private ImageView[] countries_image_list;
    private ImageView countryTeg;
    private Random random = new Random();
    int imageId;
    //test

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        countries = getResources().getStringArray(R.array.countries);


    }

    @Override
    protected void onStart() {
        super.onStart();
        pushAnimation();
    }

    @Override
    protected void onPause() {
        super.onPause();
        countryTeg.clearAnimation();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countryTeg.clearAnimation();
    }

    public void startGame(View view) {
        Intent intent = new Intent(this, PlayGround.class);
        startActivity(intent);
    }

    private void pushAnimation(){
        //Animation>
        Animation.AnimationListener animationListener = new Animation.AnimationListener() {

            @Override
            public void onAnimationEnd(Animation animation) {
                countryTeg.postOnAnimation(new Runnable() {
                    @Override
                    public void run() {
                        int runNum = random.nextInt(8) + 1;
                        String uri = "@drawable/country_image_0" + runNum;
                        imageId = getResources().getIdentifier(uri, null, getPackageName());
                        countryTeg.setImageResource(imageId);
                        countryTeg.startAnimation(animation);
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {
            }
        };

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.maping_animation);
        animation.setAnimationListener(animationListener);
        countryTeg = findViewById(R.id.country_tag);
        countryTeg.startAnimation(animation);
        //Animation>
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







