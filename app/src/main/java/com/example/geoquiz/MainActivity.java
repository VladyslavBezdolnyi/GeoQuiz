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


}

class Country{

    String name;
    char[] encryptedNameList;

    Country(String[] countries){
        this.name = countries[new RandomCountryNum(countries.length).getNum()];
        encrypting(); // encrypting name char letters
    }

    private void encrypting(){
        Random random = new Random();
        int maxCharacterNum = 14;

        if (name.length() > maxCharacterNum - 3){
            System.out.println("Ошибка. Невозможно создать страну с таким количеством символов."); // Изменить на алерт и выход из приложения
        }
        else{
            encryptedNameList = new char[name.length() + 3 + random.nextInt(maxCharacterNum - (name.length() + 1))];
            // Add current letters
            for (int i = 0; i < name.length(); i++){
                encryptedNameList[i] = name.charAt(i);
            }
            // Generate random letters
            for (int i = name.length(); i < encryptedNameList.length; i++){
                encryptedNameList[i] = (char)(random.nextInt(26) + 'a');
            }
            // Swap letters in random order
            for(int i=0; i < encryptedNameList.length - 1; i++){
                int j = random.nextInt(encryptedNameList.length-1);
                char temp = encryptedNameList[i];
                encryptedNameList[i] = encryptedNameList[j];
                encryptedNameList[j] = temp;
            }
        }
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







