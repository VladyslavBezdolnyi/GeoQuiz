package com.example.geoquiz;

import java.util.Random;

class Country{

    String name;
    char[] encryptedNameList;

    Country(String[] countries){
        this.name = countries[new RandomCountryNum(countries.length).getNum()];
        encrypting(); // encrypting name char letters
    }

    private void encrypting(){
        Random random = new Random();
        int maxCharacterNum = 32;

        if (name.length() > maxCharacterNum - 3){
            System.out.println("Ошибка. Невозможно создать страну с таким количеством символов.");
            // !!!Изменить на алерт и выход из приложения
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
