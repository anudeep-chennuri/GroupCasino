package com.github.zipcodewilmington.casino.games;

import java.util.ArrayList;
import java.util.Random;

public class DiceRoll {
    private static int tosses;

    public static final ArrayList<Integer> rollResultsDice=new ArrayList<>();


    public static void GetDiceRoll(int numberOfTosses) {
        DiceRoll.tosses=numberOfTosses;

    }
//Create a Simulation class whose Constructor takes arguments: numberOfDies to throw numberOfTosses to run
//
//Create a simulation where two dies are thrown one million times. Keep track of all results.


    public static int runSimulation() {
        Random rd = new Random();


        int diceRoll;
        int sumOfRoll=0;

        int max=12;
        int min=1;

        for (int i = 0; i < tosses; i++) {
            diceRoll= rd.nextInt(max - min + 1) + min;
            sumOfRoll += diceRoll;
        }
        rollResultsDice.add(sumOfRoll);
        System.out.println(sumOfRoll);
        return sumOfRoll;

    }
    public static ArrayList<Integer> results()
    {
        return rollResultsDice;
    }
}
