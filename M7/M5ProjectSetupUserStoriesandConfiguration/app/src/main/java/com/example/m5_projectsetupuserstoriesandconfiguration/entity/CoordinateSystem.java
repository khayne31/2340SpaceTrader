package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * CoordinateSystem class
 */
 public class CoordinateSystem implements Serializable {
    private final List<ArrayList<Planet>> system;
    private final ArrayList<Planet> allPlanets;
    private double populationProb;
    private final String systemName;
    private final Resources resources;
    private final SolarSystem currentSolarSystem;
    private int  planetCounter;
    private int size;
    private static final double PROB = .05;
    private static final double MULTIPLIER = .1;


    /**
     * constructor for the CoordinateSystem class
     * @param sizeSystem the size of a side of the CoordinateSystem
     * @param solar the SolarSystem the CoordinateSystem is a part of
     * @param res the resource of the CoordinateSystem
     */
    public CoordinateSystem(int sizeSystem, SolarSystem solar, Resources res){
        if(sizeSystem <= Universe.MIN_SIZE){
            size = Universe.MIN_SIZE;
        } else if(sizeSystem >= Universe.MAX_SIZE){
            size = Universe.MAX_SIZE;
        } else{
            size = sizeSystem;
        }
        currentSolarSystem = solar;
        populationProb =  PROB * Math.random();
        systemName = solar.getSystemName();
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
                    planetCounter++;
                    Planet newPlanet =  new Planet(new int[] {i,j}, systemName +"-"+
                            planetCounter + "", currentSolarSystem, resources);
                    List<Planet> listOfPlanets = system.get(i);
                    listOfPlanets.add(newPlanet);
                    allPlanets.add(newPlanet);
                } else{
                    List<Planet> listOfPlanets = system.get(i);
                    listOfPlanets.add(j, null);
                }

            }
        }
        if(allPlanets.size() < 10){
            populationProb += MULTIPLIER * populationProb;
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

    public int getSize() {
        return size;
    }

    public int getPlanetCounter() {
        return planetCounter;
    }

    public String getSystemName() {
        return systemName;
    }
}
