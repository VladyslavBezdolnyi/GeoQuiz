package com.example.geoquiz;

import java.util.Random;


class Country{

    String name;
    String mixedName;
    String dashName;

    char[] encryptedNameList;

    Country(String country){
        this.name = country;
        mixLetters();
        dashLetters();
    }

    private void mixLetters(){

        String resultName = "";
        Random random = new Random();
        char[] shiftedName = customSplit(name);
        shiftedName = deleteSpaces(shiftedName);
        int arraySize = shiftedName.length;

        for(int i =0; i < arraySize; i++){

            int randomValue = random.nextInt(arraySize);
            char vessel = shiftedName[i];
            shiftedName[i] = shiftedName[randomValue];
            shiftedName[randomValue] = vessel;

        }

        for (char c : shiftedName){
            resultName = resultName + c;
        }

        this.mixedName = resultName;

    }

    private char[] deleteSpaces(char[] letterArray){



        int noSpaceArrayLength = 0;
        for (int i = 0; i < name.length(); i++){

            if (letterArray[i] != ' '){
                noSpaceArrayLength++;
            }
        }

        char[] NoSpaceLetterArray = new char[noSpaceArrayLength];

        int counter = 0;
        for (char c : letterArray){
            if (c != ' '){
                NoSpaceLetterArray[counter] = c;
                counter++;
            }
        }

        return NoSpaceLetterArray;
    }

    private char[] customSplit(String strValue){

        int arraySize = strValue.length();
        char[] arraySplit = new char[arraySize];

        for (int i = 0; i < arraySize; i++){
            arraySplit[i] = strValue.charAt(i);
        }

        return arraySplit;

    }

    
    private void dashLetters(){

        String resultName = "";

        for (int i = 0; i < name.length(); i++){
            if (name.charAt(i) == ' '){
                resultName = resultName + " ";
            }
            else{
                resultName = resultName + "-";
            }
        }

        dashName = resultName;
    }


}
