package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

/**
 * A class to help load information from a previous app state via firebase
 */
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

    /**
     * gets the pilot points of the player
     * @return the pilot points of the player
     */
    public int getPilotPoints() {
        return pilotPoints;
    }

    /**
     * sets the pilot points of the player
     * @param pilotPoints the new pilot points of the player
     */
    public void setPilotPoints(int pilotPoints) {
        this.pilotPoints = pilotPoints;
    }

    /**
     * gets the credits of the player
     * @return the credits of the player
     */
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

    /**
     * sets the credits of the player
     * @param credits the new credits of the player
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * gets the fighter points of the player
     * @return fighter points of the player
     */
    public int getFighterPoints() {
        return fighterPoints;
    }

    /**
     * sets the fighter points of the player
     * @param fighterPoints new fighter points of the player
     */
    public void setFighterPoints(int fighterPoints) {
        this.fighterPoints = fighterPoints;
    }

    /**
     * gets the trader points of the player
     * @return trader points of the player
     */
    public int getTraderPoints() {
        return traderPoints;
    }

    /**
     * sets trader points of the player
     * @param traderPoints new trader points of the player
     */
    public void setTraderPoints(int traderPoints) {
        this.traderPoints = traderPoints;
    }

    /**
     * gets the engineering points of the player
     * @return engineering points of the player
     */
    public int getEngineerPoints() {
        return engineerPoints;
    }

    /**
     * sets engineering points of the player
     * @param engineerPoints new engineering points of the player
     */
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
