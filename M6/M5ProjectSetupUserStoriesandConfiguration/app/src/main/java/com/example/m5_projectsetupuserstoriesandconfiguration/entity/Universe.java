package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class Universe {
    private ArrayList<SolarSystem> solarsystems;
    private int sizeOfUniverse;
    private static final String TAG = "UniverseLogCat";


    public Universe(int size){
        solarsystems = new ArrayList<>();
        sizeOfUniverse = size;
        generateUniverse(sizeOfUniverse);

    }


    private void generateUniverse(int size){
        for(int i =0; i < size; i++){
            solarsystems.add(new SolarSystem(new Random().nextInt(20)+10));
        }
    }

    public static void generateLogCat(ArrayList<SolarSystem> universe) {
        int count = 10;
        while (count > 0) {
            SolarSystem solar = universe.get(count);
            Log.v(TAG,solar.toString() + "PopulationProb: "
                    + solar.getSystem().getPopulationProb() + "Planets:");
            for (int i = 0; i < solar.getSystem().getAllPlanets().size(); i++) {
                Log.v(TAG, solar.getSystem().getAllPlanets().get(i).getName());
            }
        }
    }



}
