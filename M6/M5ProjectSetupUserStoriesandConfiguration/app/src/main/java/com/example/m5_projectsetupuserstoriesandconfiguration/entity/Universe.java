package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class Universe {
    private ArrayList<ArrayList<SolarSystem>> universe;
    private ArrayList<SolarSystem> systems;
    private int sizeOfUniverse;
    private int systemsInUniverse;
    private static final String TAG = "UniverseLogCat";
    private final double SOLAR_SYSTEM_DISTRIBUTION_PROB = .25;


    public Universe(int size){
        universe = new ArrayList<>();
        sizeOfUniverse = size >= 10 ? size : 10;
        systems = new ArrayList<>();
        generateUniverse(sizeOfUniverse);
        systemsInUniverse = systems.size();

    }


    private void generateUniverse(int size){
        ArrayList<String> listOfNames = new ArrayList<>();
        for(int j = 0; j < size; j++){
            universe.add(new ArrayList<SolarSystem>());
            for(int i =0; i < size; i++){
                if(Math.random() < SOLAR_SYSTEM_DISTRIBUTION_PROB){
                    SolarSystem currentSystem = new SolarSystem(new Random().nextInt(20)+10, new int[] {j,i});
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

    public static void generateLogCat(ArrayList<SolarSystem> universe) {
        int count = 10;
        while (count-- > 0) {
            SolarSystem solar = universe.get(count-1);
            Log.v(TAG,solar.toString());
            for (int i = 0; i < solar.getSystem().getAllPlanets().size(); i++) {
                Log.v(TAG, solar.getPlanets().get(i).getName());
            }
        }
    }



}
