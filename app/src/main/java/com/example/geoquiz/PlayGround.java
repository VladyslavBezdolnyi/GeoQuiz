package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


import android.view.animation.Animation;

public class PlayGround extends AppCompatActivity {
    ImageView imageView;
    Animation animation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);
        imageView = findViewById(R.id.country_tag);
        animation = AnimationUtils.loadAnimation(this, R.anim.maping_animation);
    }


    public void startAnimation(View view){
       imageView.startAnimation(animation);
    }
}