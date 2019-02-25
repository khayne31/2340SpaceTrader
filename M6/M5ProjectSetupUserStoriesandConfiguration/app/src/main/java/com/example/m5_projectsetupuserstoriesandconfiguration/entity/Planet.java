package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

public class Planet {
    private int[] coords;
    private  String name;

    public Planet(int[] coordinates, String planetName){
        if(coordinates.length >= 2){
            coords[0] = coordinates[0];
            coords[1] = coordinates[1];
        } else{
            coords[1] = 0;
            coords[0] = 0;
        }
        name = planetName;

    }
    public int[] getCoords() {
        return coords;
    }

    public String getName() {
        return name;
    }
}
