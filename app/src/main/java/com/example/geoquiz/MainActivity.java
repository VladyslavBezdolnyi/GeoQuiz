package com.example.geoquiz;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    String[] countries;
    private ImageView countryTeg;
    private CustomRandom customRandom = new CustomRandom(9); // tie to array.length
    int imageId;


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

        Animation.AnimationListener animationListener = new Animation.AnimationListener() {

            @Override
            public void onAnimationEnd(Animation animation) {
                countryTeg.postOnAnimation(new Runnable() {
                    @Override
                    public void run() {
                        String templateIndex = customRandom.leadToTemplate();
                        String uri = "@drawable/country_image_" + templateIndex;
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

    }
}



class CustomRandom{

    Random random = new Random();
    int arraySize;
    int isRepeating;
    int randomIndex;

    CustomRandom(int arraySize){

        this.arraySize = arraySize;

    }

    private void changeRandomIndex(){

        randomIndex = random.nextInt(arraySize -1 ) + 1;
        if(randomIndex == isRepeating){
            // recursion until random number no longer repeats
            changeRandomIndex();
        }

        isRepeating = randomIndex;

    }

    String leadToTemplate(){

        changeRandomIndex();

        if (randomIndex <= 0 || randomIndex > 1000){
            //exception
            return "001";
        }
        if (randomIndex < 10){
            return "00" + randomIndex;
        }
        else if (randomIndex > 10 && randomIndex < 100){
            return "0" + randomIndex;
        }
        else{
            return "" + randomIndex;
        }
    }
}










