package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;

import java.io.Serializable;
import java.util.Random;

public class Planet implements Serializable {
    private int[] coords;
    private final String name;
    private final Tech t_lvl;
    private final RadicalEvent event;
    private  Resources resources;
    private Market market;
    private final SolarSystem homesystem;

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

    public Planet(int[] coordinates, String planetName, SolarSystem system, Resources res){
        this(coordinates, planetName, system);
        resources = res;

    }

    /**
     * A planet constructor for testing the market class
     * @param planetName the name to be given to the planet
     * @param res the resource classification of the planet
     */
    public Planet(String planetName, Resources res) {
        name = planetName;
        t_lvl = Tech.PRE;
        event = RadicalEvent.values()[new Random().nextInt(RadicalEvent.values().length)];
        resources = Resources.values()[new Random().nextInt(Resources.values().length)];
        homesystem = new SolarSystem("DummySystem");
    }




    public int[] getCoords() {
        return coords;
    }

    @Override
    public String toString() {
        /*" -Planet{" +
                "coords=" + Arrays.toString(coords) +
                ", name='" + name + '\'' +
                "Radical_Event = " + event + '\'' +
                '}';*/
        return name;
    }

    public String getName() {
        return name;
    }

    public RadicalEvent getEvent() {
        return event;
    }



    public int getT_lvl() {
        return t_lvl.getLvl();
    }


    public void playerLandedOn(){
        market = new Market(this);
    }

    public Market getMarket() {return market;}


    public SolarSystem getHomesystem() {
        return homesystem;
    }
}
