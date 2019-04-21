package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;

import java.io.Serializable;
import java.util.Random;
/**
 * the planet class
 */
public class Planet implements Serializable {
    private int[] coords;
    private final String name;
    private final Tech t_lvl;
    private final RadicalEvent event;
    private  Resources resources;
    private Market market;
    private final SolarSystem homesystem;

    /**
     * The constructor which initializes a splanet with coordinates, a planet name and a home SolarSystem
     * @param coordinates an array representing its position in the SolarSystem
     * @param planetName A string representing the name of the Planet
     * @param system A instance of the SolarSystem class representing the home system of the planet
     */
    private Planet(int[] coordinates, String planetName, SolarSystem system){
        Log.d("UniverseLogCat", "inside planet constructor before coords");
        if(coordinates.length >= 2){
            coords = coordinates;
        } else{
            coords[1] = 0;
            coords[0] = 0;
        }
        name = planetName;
        t_lvl = Tech.values()[new Random().nextInt(Tech.values().length)];
        event = RadicalEvent.values()[new Random().nextInt(RadicalEvent.values().length)];
        resources = Resources.values()[new Random().nextInt(Resources.values().length)];
        market = new Market(this);
        homesystem = system;

    }

    /**
     * A constructor for the planet class
     * @param coordinates The new coordinates of the planet
     * @param planetName The new name for the planet
     * @param system The planet's home system
     * @param res The planet's specific resources
     */
    public Planet(int[] coordinates, String planetName, SolarSystem system, Resources res){
        this(coordinates, planetName, system);
        resources = res;

    }

    /**
     * A planet constructor for testing the market class
     * @param planetName the name to be given to the planet
     * @param res the resource classification of the planet
     * @param tech The Tech level of the new planet
     */
    public Planet(String planetName, Resources res, Tech tech) {
        name = planetName;
        t_lvl = tech;
        event = RadicalEvent.values()[new Random().nextInt(RadicalEvent.values().length)];
        resources = Resources.values()[new Random().nextInt(Resources.values().length)];
        homesystem = new SolarSystem("DummySystem");
    }



    /**
     * a getter function for the coords variable
     * @return  returns an array of ints representing the coords of the planet
     */
    public int[] getCoords() {
        return coords;
    }

    /**
     * toString functions
     * @return  returns the name of the planet
     */
    @Override
    public String toString() {
        /*" -Planet{" +
                "coords=" + Arrays.toString(coords) +
                ", name='" + name + '\'' +
                "Radical_Event = " + event + '\'' +
                '}';*/
        return name;
    }

    /**
     * getter for the name variable
     * @return  returns the name of the planet
     */
    public String getName() {
        return name;
    }

    /**
     * getter for the event variable
     * @return  returns the event on the planet
     */
    public RadicalEvent getEvent() {
        return event;
    }


    /**
     * getter for the level of the planet's tech
     * @return  returns the tech level of the of the planet
     */
    public int getT_lvl() {
        return t_lvl.getLvl();
    }

    /**
     * creates a new market on this planet
     */
    public void playerLandedOn(){
        market = new Market(this);
    }

    /**
     * getter for the market variable
     * @return  returns the market of the planet
     */
    public Market getMarket() {return market;}


    /**
     * getter for the homesystem variable
     * @return  returns the homesystem of the planet
     */
    public SolarSystem getHomesystem() {
        return homesystem;
    }

    public Resources getResources() {
        return resources;
    }
}
