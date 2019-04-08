package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

public class Player2 {

    private String name;
    private int pilotPoints;
    private int engineerPoints;
    private int traderPoints;
    private int fighterPoints;
    private int credits;
    private int id;
    private Difficulty diff;
    private Ship myShip;
    private Planet currentPlanet;
    private SolarSystem currentSystem;
    private Universe currentUniverse;

    public Player2(Player p, String name, int fPoints, int tPoints, int ePoints, int pPoints, Difficulty difficulty) {
        name = p.getName();
        fPoints = p.getFighterPoints();
        tPoints = p.getTraderPoints();
        ePoints = p.getEngineerPoints();
        pPoints = p.getPilotPoints();
        difficulty = p.getDiff();
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

    public int getEngineerPoints() {return engineerPoints;}

    public void setEngineerPoints(int engineerPoints) {this.engineerPoints = engineerPoints; }

    public int getTraderPoints() {return traderPoints;}

    public void setTraderPoints(int traderPoints) {this.traderPoints = traderPoints;}

    public int getFighterPoints() {return fighterPoints;}

    public void setFighterPoints(int fighterPoints) {this.fighterPoints = fighterPoints;}

    public int getId() {return id;}

    public Ship getMyShip() { return myShip; }

    public Difficulty getDiff() {
        return diff;
    }

}
