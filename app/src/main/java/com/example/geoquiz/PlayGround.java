package com.example.geoquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Flow;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import org.apmem.tools.layouts.FlowLayout;
import java.util.Random;

public class PlayGround extends AppCompatActivity {

    FlowLayout flowLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_ground);

        flowLayout = findViewById(R.id.flowLayout);


        AddButtons("Ukraine");
    }



    public void AddButtons(String countryShifName){

        for (char c : countryShifName.toCharArray()){
            FlowLayout.LayoutParams testParams = new FlowLayout.LayoutParams(
                    FlowLayout.LayoutParams.WRAP_CONTENT,
                    FlowLayout.LayoutParams.WRAP_CONTENT);
            testParams.setMargins(10,0,10,0);
            View dynamicButton = getLayoutInflater().inflate(R.layout.borderless_button, null, false);
            Button button = (Button)dynamicButton;
            String stringC = c + "";
            button.setText(stringC);

            flowLayout.addView(button, testParams);
        }
    }

}