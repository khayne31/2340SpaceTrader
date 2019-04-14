package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * CoordinateSystem class
 */
 class CoordinateSystem implements Serializable {
    private final ArrayList<ArrayList<Planet>> system;
    private final ArrayList<Planet> allPlanets;
    private double populationProb;
    private final double MAX_PROB = .05;
    private final String systemName;
    private final int size;
    private final Resources resources;
    private final SolarSystem currentSolarSystem;
    private int  planetCounter = 0;

    /**
     * constructor for the CoordinateSystem class
     * @param sizeSystem the size of a side of the CoordinateSystem
     * @param solar the SolarSystem the CoordinateSystem is a part of
     * @param res the resource of the CoordinateSystem
     * @return The difficulty object based on the input
     */
    public CoordinateSystem(int sizeSystem, SolarSystem solar, Resources res){
        currentSolarSystem = solar;
        populationProb =  MAX_PROB * Math.random();
        systemName = solar.getSystemName();
        size = sizeSystem;
        system = new ArrayList<>();
        allPlanets = new ArrayList<>();


        generateSystem(size);

        resources = res;


    }

    /**
     * generates a system with instances of the Planet class  and nulls stored in an 2D ArrayList
     * representing a system
     * and then all the planets are stored in an ArrayList
     * @param size The size of one side of the square system
     */
    private void generateSystem(int size){

        for(int i = 0; i < size; i++){
            system.add(new ArrayList<Planet>());
            for(int j = 0; j < size; j++){
                double k = Math.random();
                if(k < populationProb){

                    Planet newPlanet =  new Planet(new int[] {i,j}, systemName +"-"+
                            planetCounter++ + "", currentSolarSystem, resources);
                    system.get(i).add(newPlanet);
                    allPlanets.add(newPlanet);
                } else{
                    system.get(i).add(j, null);
                }

            }
        }
        if(allPlanets.size() < 10){
            populationProb += .1*populationProb;
          generateSystem(size);
        }
    }

    /**
     * A method to return a difficulty object based on the type given
     * in the form of a string.
     * @return an ArrayList containing the planets that are in this CoordinateSystem
     */
    public ArrayList<Planet> getAllPlanets() {
        return allPlanets;
    }


}
