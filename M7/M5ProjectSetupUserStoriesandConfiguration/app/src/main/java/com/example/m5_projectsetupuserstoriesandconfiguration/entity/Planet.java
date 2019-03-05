package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;

import java.util.Arrays;
import java.util.Random;

public class Planet {
    private int[] coords;
    private String name;
    private Tech t_lvl;
    private RadicalEvent event;
    private  Resources resources;
    private Market market;

    public Planet(int[] coordinates, String planetName){
        Log.d("UniverseLogCat", "inside planet constructor before coords");
        if(coordinates.length >= 2){
            Log.d("UniverseLogCat", coordinates[0]+", " + coordinates[1]+ ", "
                    + coordinates.length);
            coords = coordinates;
            Log.d("UniverseLogCat", coords+"");
            Log.d("UniverseLogCat", "inside planet constructor inside coords");
        } else{
            Log.d("UniverseLogCat", "inside planet constructor before cdoords");
            coords[1] = 0;
            coords[0] = 0;
        }
        Log.d("UniverseLogCat", "inside planet constructor after coords");
        name = planetName;
        t_lvl = Tech.values()[new Random().nextInt(Tech.values().length)];
        event = RadicalEvent.values()[new Random().nextInt(RadicalEvent.values().length)];
        market = new Market(this);

    }

    public Planet(int[] coordinates, String planetName, Resources res){
        this(coordinates, planetName);
        resources = res;
    }

    public Planet(int[] coordinates, String planetName, Tech techLevel){
        this(coordinates, planetName);
        t_lvl = techLevel;

    }


    public int[] getCoords() {
        return coords;
    }

    @Override
    public String toString() {
        return " -Planet{" +
                "coords=" + Arrays.toString(coords) +
                ", name='" + name + '\'' +
                "Radical_Event = " + event + '\'' +
                '}';
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
}
