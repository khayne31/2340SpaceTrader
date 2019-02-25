package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.util.ArrayList;
import java.util.Random;

public class Universe {
    private ArrayList<SolarSystem> solarsystems;
    private int sizeOfUniverse;


    public Universe(int size){
        solarsystems = new ArrayList<>();
        sizeOfUniverse = size;
        generateUniverse(sizeOfUniverse);

    }

    private void generateUniverse(int size){
        for(int i =0; i < size; i++){
            solarsystems.add(new SolarSystem(new Random().nextInt(20)+10));
        }
    }


}
