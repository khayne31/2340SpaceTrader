package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;

import java.util.ArrayList;

public class CoordinateSystem {
    private ArrayList<ArrayList<Planet>> system;
    private ArrayList<Planet> allPlanets;
    private double populationProb;
    private final double MAX_PROB = .1;
    private String systemName;
    private int size;
    private Resources resources;
    private SolarSystem currentSolarSystem;

    public CoordinateSystem(int sizeSystem, SolarSystem solar, Resources res){
        currentSolarSystem = solar;
        populationProb =  MAX_PROB * Math.random();
        systemName = solar.getSystemName();
        size = sizeSystem;
        system = new ArrayList<>();
        allPlanets = new ArrayList<>();
        Log.d("UniverseLogCat", "inside Coordinate System constructor before generate system");

        generateSystem(size);
        Log.d("UniverseLogCat", "inside Coordinate System constructor after generate system");
        resources = res;


    }

    private void generateSystem(int size){
        int planetCounter = 0;
        for(int i = 0; i < size; i++){
            system.add(new ArrayList<Planet>());
            Log.d("UniverseLogCat", "inside generate system for loop i: "+ i);
            for(int j = 0; j < size; j++){
                Log.d("UniverseLogCat", "inside generate system for loop j: "+ j);
                double k = Math.random();
                Log.d("UniverseLogCat", "inside generate system k: "+ k
                        + " populationProb: "+ populationProb);
                Log.d("UniverseLogCat", (system.get(i)) + "");
                if(k < populationProb){
                    Log.d("UniverseLogCat", "inside generate system before " +
                            "new Planet: ");
                    Planet newPlanet =  new Planet(new int[] {i,j}, systemName +"-"+ ++planetCounter + "", currentSolarSystem, resources);
                    Log.d("UniverseLogCat", "inside generate system after " +
                            "new Planet: ");
                    system.get(i).add(newPlanet);
                    allPlanets.add(newPlanet);
                } else{
                    Log.d("UniverseLogCat", "inside null loop before setting to null: "+ i);
                    system.get(i).add(j, null);
                    Log.d("UniverseLogCat", "inside null loop after setting to null: "+ i);
                }
                Log.d("UniverseLogCat", !(system.get(i).get(j) instanceof Planet) + "");

            }
        }
        if(allPlanets.size() < 10){
            populationProb += .1*populationProb;
          generateSystem(size);
        }
    }

    public String getSystemName() {
        return systemName;
    }

    public ArrayList<ArrayList<Planet>> getSystem() {
        return system;
    }

    public ArrayList<Planet> getAllPlanets() {
        return allPlanets;
    }

    public double getPopulationProb() {
        return populationProb;
    }

    public double getMAX_PROB() {
        return MAX_PROB;
    }
}
