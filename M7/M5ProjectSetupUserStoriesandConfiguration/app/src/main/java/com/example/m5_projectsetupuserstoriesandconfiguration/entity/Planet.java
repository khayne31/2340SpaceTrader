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

    public Planet(int[] coordinates, String planetName, SolarSystem system){
        Log.d("UniverseLogCat", "inside planet constructor before coords");
        if(coordinates.length >= 2){
            Log.d("UniverseLogCat", coordinates[0]+", " + coordinates[1]+ ", "
                    + coordinates.length);
            coords = coordinates;
            Log.d("UniverseLogCat", coords+"");
            Log.d("UniverseLogCat", "inside planet constructor inside coords");
        } else{
            Log.d("UniverseLogCat", "inside planet constructor before coords");
            coords[1] = 0;
            coords[0] = 0;
        }
        Log.d("UniverseLogCat", "inside planet constructor after coords");
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

    public Resources getResources() {
        return resources;
    }

    public int getT_lvl() {
        return t_lvl.getLvl();
    }

    public void playerLandedOn(){
        market = new Market(this);
    }

    public Market getMarket() {return market;}

    public void setMarket(Market inputMarket) {market = inputMarket;}

    public SolarSystem getHomesystem() {
        return homesystem;
    }
}
