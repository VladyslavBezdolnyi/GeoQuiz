package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Flow;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.timqi.sectorprogressview.SectorProgressView;

import org.apmem.tools.layouts.FlowLayout;
import java.util.Random;

public class PlayGround extends AppCompatActivity {

    FlowLayout flowLayout;
    GeoTimer timer;
    SectorProgressView sectorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);

        flowLayout = findViewById(R.id.flowLayout);
        sectorView = findViewById(R.id.sector_view);

        timer = new GeoTimer(180, sectorView, this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        addButtons("012345678901234567890123456789");
    }

    @Override
    protected void onStop() {
        super.onStop();
        timer.cancel();
    }

    public void addButtons(String countryShiftName) {

        for (char c : countryShiftName.toCharArray()) {
            FlowLayout.LayoutParams testParams = new FlowLayout.LayoutParams(
                    FlowLayout.LayoutParams.WRAP_CONTENT,
                    FlowLayout.LayoutParams.WRAP_CONTENT);
            testParams.setMargins(10, 0, 10, 0);
            View dynamicButton = getLayoutInflater().inflate(R.layout.borderless_button, null, false);
            Button button = (Button) dynamicButton;
            String stringC = c + "";
            button.setText(stringC);

            flowLayout.addView(button, testParams);
        }

    }

/*    public void changeCountry() {

    }

    public int iterate(int iterateI) {
        if () {
            return 0;
        else{

            }
        }
    }*/

}