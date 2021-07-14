package com.example.geoquiz;
import java.util.ArrayList;
import java.util.Random;


class RandomIndexSequence{

    int [] randomIndexSequence;

    private double mean; // cвязать amount с rank путем вызова функции
    private double deviation;
    private Gaussian gaussian;

    private ArrayList<Integer> indexArray;

    RandomIndexSequence(double mean, double deviation, int amount){

        this.mean = mean;
        this.deviation = deviation;
        gaussian = new Gaussian(mean, deviation);

        indexArray = fillArray(amount);
        randomIndexSequence = new int[amount];
        fillRandomArray(amount);
    }

    private ArrayList<Integer> fillArray(int amount){
        ArrayList<Integer> indexArray = new ArrayList<Integer>();
        for ( int i = 0; i < amount; i++ ){
            indexArray.add(i);
        }
        return indexArray;
    }

    private void fillRandomArray(int amount){

        Random random = new Random();
        int id = 0; // проверяем сколько записано в randomIndex

        while (id < amount){

            double value = gaussian.getGaussian(mean);

            if(value >= indexArray.size()){ // отзеркалить значение больше чем помещается в индекс
                value = indexArray.size() - 1 - (value - indexArray.size() - 1);
            }
            if ( value < 0 ){ // отзеркалить значение меньше нуля
                value = -value;
            }
            if(value >= 0 && value < indexArray.size()){
                randomIndexSequence[id] = indexArray.get((int)value); id++;
                indexArray.remove((int)value);
            }
            else {
                value = random.nextInt(indexArray.size());
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

    private double mean;
    private double deviation;

    Gaussian(double mean, double deviation){

        this.mean = mean; this.deviation = deviation;
    }

    double getGaussian(double mean){

        double value = Math.sin(2 * Math.PI * Math.random()) * (-2 * Math.log(Math.random()));
        return Math.round((value * deviation) + mean);
    }
}


