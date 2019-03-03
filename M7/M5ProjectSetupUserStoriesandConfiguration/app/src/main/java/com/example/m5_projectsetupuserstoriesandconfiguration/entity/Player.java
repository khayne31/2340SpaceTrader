package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;

import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private int pilotPoints;
    private int engineerPoints;
    private int traderPoints;
    private int fighterPoints;
    private int credits;
    private int id;
    private Difficulty diff;
    private Ship myShip;

    //public User() {
    //}

    public Player(String name, int fPoints, int tPoints, int ePoints, int pPoints, Difficulty difficulty) {
        this.name = name;
        credits = 1000;
        fighterPoints = fPoints;
        traderPoints = tPoints;
        engineerPoints = ePoints;
        pilotPoints = pPoints;
        this.diff = difficulty;
        myShip = new Ship(Ship.makeGnat(), 50, 50);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getPilotPoints() {return pilotPoints;}

    public void setPilotPoints(int pilotPoints) {this.pilotPoints = pilotPoints;}

    public int getEngineerPoints() {return engineerPoints;};

    public void setEngineerPoints(int engineerPoints) {this.engineerPoints = engineerPoints; }

    public int getTraderPoints() {return traderPoints;}

    public void setTraderPoints(int traderPoints) {this.traderPoints = traderPoints;}

    public int getFighterPoints() {return fighterPoints;}

    public void setFighterPoints(int fighterPoints) {this.fighterPoints = fighterPoints;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

}
