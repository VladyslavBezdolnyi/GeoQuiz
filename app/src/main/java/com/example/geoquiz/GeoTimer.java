package com.example.geoquiz;



import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.timqi.sectorprogressview.SectorProgressView;
import java.util.Timer;
import java.util.TimerTask;



class GeoTimer{

    float currentSecond;
    float totalSecond;

    Timer timer;
    SectorProgressView sectorView;
    AppCompatActivity activity;


    protected Runnable timerTick = new Runnable() {
        @Override
        public void run() {
            currentSecond = currentSecond - 1f;

            if(currentSecond <= 0){
                cancel();
                endGame();
            }

            float percent = (currentSecond/totalSecond)*100f;
            System.out.println(-percent);
            sectorView.setPercent(-percent);
        }
    };

    GeoTimer(float seconds, SectorProgressView sectorView, final AppCompatActivity activity){
        currentSecond = seconds;
        totalSecond = seconds;

        this.sectorView = sectorView;
        this.activity = activity;


        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                reRenderTimerView();
            }
        }, 1000, 1000);
    }

    protected void reRenderTimerView(){
        activity.runOnUiThread(timerTick);
    }

    protected void cancel(){
        timer.cancel();
    }

    public void endGame(){
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

}


