package com.example.geoquiz;

import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;



class GeoTimer{



    TextView timeView;
    int seconds = 30;
    Timer timer = new Timer();
    static boolean isRun = false;

    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            seconds--;


            if (seconds <= 0){
                isRun = false;
                timer.cancel();


            }
        }
    };

    GeoTimer(TextView timeView){
        this.timeView = timeView;

        timer.schedule(task, 1000, 1000);


        isRun = true;
    }
}
