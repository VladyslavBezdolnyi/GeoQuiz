package com.example.geoquiz;
import java.util.ArrayList;
import java.util.Random;


public class CountrySequence{

    ArrayList<Integer> indexArray;
    int [] randomIndexSequence;

    double mean = 20; // cвязать amount с rank путем вызова функции
    Gaussian gaussian = new Gaussian(mean);

    CountrySequence(int amount){
        indexArray = fillArray(amount);
        randomIndexSequence = new int[amount];
        fillRandomArray(amount);
    }

    ArrayList<Integer> fillArray(int amount){
        ArrayList<Integer> indexArray = new ArrayList<Integer>();
        for ( int i = 0; i < amount; i++ ){
            indexArray.add(i);
        }
        return indexArray;
    }

    void fillRandomArray(int amount){
        int id = 0; // проверяем сколько записано в randomIndex
        while (id < amount){
            double value = gaussian.getGaussian(mean);
            if(value >= indexArray.size()){ // отзеркалить значение больше чем помещается в индекс
                value = indexArray.size() - 1 - (value - indexArray.size() - 1);
                if(value >= 0 && value < indexArray.size()){ // проверка на out of bounce
                    randomIndexSequence[id] = indexArray.get((int)value); id++;
                    indexArray.remove((int)value);
                }

            }
            if ( value < 0 ){ // отзеркалить значение меньше нуля
                value = -value;
                if (value >= 0 && value < indexArray.size()){
                    randomIndexSequence[id] = indexArray.get((int)value); id++;
                    indexArray.remove((int)value);
                }
            }
            else if (value >= 0 && value < indexArray.size()){
                randomIndexSequence[id] = indexArray.get((int)value); id++;
                indexArray.remove((int)value);
            }
            else { // когда deviation больше чем количество значений массива

                if (indexArray.size() == 0){
                    break;
                }
                value = new Random().nextInt(indexArray.size());
                randomIndexSequence[id] = indexArray.get((int)value); id++;
                indexArray.remove((int)value);
            }
            if ((int)mean > indexArray.size()){
                mean = indexArray.size(); // двигаем вершину вместе с мат ожиданием
            }
        }
    }
}

class Gaussian{

    double mean;
    double deviation;

    Gaussian(double mean, double deviation){
        this.mean = mean; this.deviation = deviation;
    }
    Gaussian(double mean){
        this.mean = mean; deviation = 5;
    }


    double getGaussian(double mean){
        double value = Math.sin(2 * Math.PI * Math.random()) * (-2 * Math.log(Math.random()));

        return Math.round((value * deviation) + mean);
    }
}


