package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * The universe class which holds a universe variable and systems variable
 */
public class Universe implements Serializable {
    private final List<ArrayList<SolarSystem>> universe;
    private final ArrayList<SolarSystem> systems;
    private final int sizeOfUniverse;
    private final int systemsInUniverse;
    private final double SOLAR_SYSTEM_DISTRIBUTION_PROB = .25;
    public final int MAX_SIZE = 20;
    public final int MIN_SIZE = 10;

    /**
     * getter method for the systems variable
     *
     * @return returns the array list which holds all the instances of the SolarSystem class
     */
    public ArrayList<SolarSystem> getSystems() {
        return systems;
    }

    /**
     * getter method for the universe variable
     *
     * @return returns the 2D array list which represents the universe
     */
    public List<ArrayList<SolarSystem>> getUniverse() {
        return universe;
    }

    /**
     * The constructor which initializes a size x size universe
     *
     * @param size The inputted string to check for difficulty type
     */
    public Universe(int size) {
        universe = new ArrayList<>();
       if(size <= MIN_SIZE){
           sizeOfUniverse = MIN_SIZE;
       } else if(size >= MAX_SIZE){
           sizeOfUniverse = MAX_SIZE;
       } else{
           sizeOfUniverse = size;
       }
        systems = new ArrayList<>();
        generateUniverse(sizeOfUniverse);
        systemsInUniverse = systems.size();

    }


    /**
     * Generates a universe, represented bya  2D array with an array containing size arrays of
     * length size.
     * The 2D array holds instances of the SolarSystem class which hold instances of the
     * CoordinateSystem class which
     * which hold instances of the Planet class.
     *
     * @param size This is the size of one side of a square universe such that the generated
     *             the size of the
     *             universe, represented by a 2D array is size x size.
     */
    private void generateUniverse(int size) {
        List<String> listOfNames = new ArrayList<>();
        for (int j = 0; j < size; j++) {
            universe.add(new ArrayList<SolarSystem>());
            for (int i = 0; i < size; i++) {
                double k = Math.random();
                if (k < SOLAR_SYSTEM_DISTRIBUTION_PROB) {
                    SolarSystem currentSystem = new SolarSystem(new Random().nextInt(5)
                            + 10,
                            new int[]{j, i});
                    while (listOfNames.contains(currentSystem.getSystemName()))
                        currentSystem = new SolarSystem(new Random().nextInt(5) + 10,
                                new int[]{j, i});
                    universe.get(j).add(currentSystem);
                    systems.add(currentSystem);
                    listOfNames.add(currentSystem.getSystemName());
                } else {
                    universe.get(j).add(null);
                }

            }
        }

    }


    /**
     * A typical toString function
     *
     * @return a string that represents the universe
     */
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


    /**
     * returns the size of the universe
     *
     * @return returns the size of the universe
     */
    public int getSizeOfUniverse() {
        return sizeOfUniverse;
    }

    /**
     * Returns a string of the universe for the save
     *
     * @return returns a string for the save
     */
    public String toStringForSave() {
        return sizeOfUniverse
                + "\t" + universe
                + "\t" + systems
                + "\t" + systemsInUniverse
                + "\t" + SOLAR_SYSTEM_DISTRIBUTION_PROB;
    }

}


