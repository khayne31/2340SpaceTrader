package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class Universe {
    private ArrayList<ArrayList<SolarSystem>> universe;
    private ArrayList<SolarSystem> systems;
    private int sizeOfUniverse;
    private int systemsInUniverse;
    private final String TAG = "UniverseResults";
    private final String DEBUG = "UniverseLogCat";
    private final double SOLAR_SYSTEM_DISTRIBUTION_PROB = .25;


    public Universe(int size){
        universe = new ArrayList<>();
        sizeOfUniverse = size >= 10 ? size : 10;
        systems = new ArrayList<>();
        Log.d(DEBUG, "inside the universe constructor before generation");
        generateUniverse(sizeOfUniverse);
        Log.d(DEBUG, "inside universe constructor after generation");
        systemsInUniverse = systems.size();

    }


    private void generateUniverse(int size){
        ArrayList<String> listOfNames = new ArrayList<>();
        for(int j = 0; j < size; j++){
            universe.add(new ArrayList<SolarSystem>());
            Log.d(DEBUG, "inside first for loop. j: "+j);
            for(int i =0; i < size; i++){
                Log.d(DEBUG, "inside second for loop. i: "+i);
                double k = Math.random();
                if(k < SOLAR_SYSTEM_DISTRIBUTION_PROB){
                    Log.d(DEBUG, "inside first if k: "+k);
                    SolarSystem currentSystem = new SolarSystem(new Random().nextInt(20)+10, new int[] {j,i});
                    Log.d(DEBUG, "after the creation of the new SolarSystem");
                    while(listOfNames.contains(currentSystem.getSystemName()))
                        currentSystem = new SolarSystem(new Random().nextInt(20)+10, new int[] {j,i});
                    universe.get(j).add(currentSystem);
                    systems.add(currentSystem);
                    listOfNames.add(currentSystem.getSystemName());
                } else{
                    universe.get(j).add(null);
                }

            }
        }

    }

    @Override
    public String toString() {

        return " \n -Universe{" +
                ", \n sizeOfUniverse=" + sizeOfUniverse +
                ", \n universe=" + universe +
                ", \n systems=" + systems +
                ", \n systemsInUniverse=" + systemsInUniverse +
                ", \n SOLAR_SYSTEM_DISTRIBUTION_PROB=" + SOLAR_SYSTEM_DISTRIBUTION_PROB +
                '}';
    }

    public void generateLogCat() {
        int count = 10;
        int sum = 0;
        while (count-- > 0) {
            SolarSystem solar = systems.get(count-1);
            Log.v(DEBUG, "inside while loop in generateLogCat() " +
                    "after getting the solar instantiation");
            Log.v(TAG,solar.toString());
            sum += solar.getPlanets().size();
            for (int i = 0; i < solar.getPlanets().size(); i++) {
                Log.v(TAG, solar.getPlanets().get(i).getName());
            }

        }
        Log.v(TAG, sum+"");
    }



}


