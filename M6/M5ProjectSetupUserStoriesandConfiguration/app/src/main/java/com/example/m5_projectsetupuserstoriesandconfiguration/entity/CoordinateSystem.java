package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.util.ArrayList;

public class CoordinateSystem {
    private ArrayList<ArrayList<Planet>> system;
    private ArrayList<Planet> allPlanets;
    private double populationProb;
    private final double MAX_PROB = .5;
    private String systemName;

    public CoordinateSystem(int sizeSystem, String name){

        populationProb = Math.random() - MAX_PROB;
        populationProb = populationProb >= 0 ? populationProb : populationProb + MAX_PROB;
        systemName = name;
        system = new ArrayList<>();
        allPlanets = new ArrayList<>();
        generateSystem(sizeSystem);

    }

    private void generateSystem(int size){
        int planetCounter = 0;
        for(int i = 0; i < size; i++){
            system.add(new ArrayList<Planet>());
            for(int j = 0; j < size; j++){
                if(Math.random() < populationProb && ! (system.get(i).get(j) instanceof Planet)){
                    Planet newPlanet =  new Planet(new int[] {i,j}, systemName + ++planetCounter + "");
                    system.get(i).set(j, newPlanet);
                    allPlanets.add(newPlanet);
                } else if(! (system.get(i).get(j) instanceof Planet)){
                    system.get(i).set(j, null);
                }
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
