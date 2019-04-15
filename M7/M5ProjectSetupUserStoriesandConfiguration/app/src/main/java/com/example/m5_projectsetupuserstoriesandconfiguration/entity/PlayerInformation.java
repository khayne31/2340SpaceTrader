package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

public class PlayerInformation {
    private String name;
    private int pilotPoints;
    private int engineerPoints;
    private int traderPoints;
    private int fighterPoints;
    private int credits;
    private int id;
    private Difficulty diff;
    private String myShip;

    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    public int getPilotPoints() {
        return pilotPoints;
    }

    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    public int getCredits() {
        return credits;
    }

    public Difficulty getDiff() {
        return diff;
    }

    public void setDiff(Difficulty diff) {
        this.diff = diff;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getFighterPoints() {
        return fighterPoints;
    }

    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    public int getTraderPoints() {
        return traderPoints;
    }

    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    public int getEngineerPoints() {
        return engineerPoints;
    }

    public void setEngineerPoints(int engineerPoints) {
        this.engineerPoints = engineerPoints;
    }

    public String getMyShip() {
        return myShip;
    }

    public void setMyShip(String myShip) {
        this.myShip = myShip;
    }

    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    private Planet currentPlanet;

    public int getCurrentUniverseSize() {
        return currentUniverseSize;
    }

    public void setCurrentUniverseSize(int currentUniverseSize) {
        this.currentUniverseSize = currentUniverseSize;
    }

    private int currentUniverseSize;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMyShipCargo() {
        return myShipCargo;
    }

    public void setMyShipCargo(int myShipCargo) {
        this.myShipCargo = myShipCargo;
    }

    private int myShipCargo;

    public int getMyShipHp() {
        return myShipHp;
    }

    public void setMyShipHp(int myShipHp) {
        this.myShipHp = myShipHp;
    }

    private int myShipHp;
}
