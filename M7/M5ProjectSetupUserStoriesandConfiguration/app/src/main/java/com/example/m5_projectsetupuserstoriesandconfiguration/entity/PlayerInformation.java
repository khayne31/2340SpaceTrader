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

    /**
     * A method to get the current planet
     * @return The currentPlanet
     */
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

    /**
     * A method to get the current difficulty level of the game
     * @return The difficulty level, as a Difficulty object
     */
    public Difficulty getDiff() {
        return diff;
    }

    /**
     * A method to set the current difficulty level of the game
     * @param diff The new difficulty level to be set
     */
    public void setDiff(Difficulty diff) {
        this.diff = diff;
    }

    /**
     * A method to get the ID associated with the playerinformation
     * @return The player ID, as an int
     */
    public int getId() {
        return id;
    }

    /**
     * A method to set the ID associated with the playerinformation
     * @param id The new player id
     */
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

    /**
     * gets the ship of the player
     * @return the ship of the player
     */
    public String getMyShip() {
        return myShip;
    }

    /**
     * sets the ship that the player chooses
     * @param myShip the ship
     */
    public void setMyShip(String myShip) {
        this.myShip = myShip;
    }

    /**
     * sets current planet of the player
     * @param currentPlanet new current planet of the player
     */
    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    private Planet currentPlanet;

    /**
     * A method to get the size of the universe the player interacts with
     * @return The universe size
     */
    public int getCurrentUniverseSize() {
        return currentUniverseSize;
    }

    /**
     * A method to set the size of the universe the player interacts with
     * @param currentUniverseSize The new universe size
     */
    public void setCurrentUniverseSize(int currentUniverseSize) {
        this.currentUniverseSize = currentUniverseSize;
    }

    private int currentUniverseSize;

    /**
     * gets the name of the player
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name of the player
     * @param name the new name of the player
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * A method to get the current number of Goods a player has in their ship
     * @return The current cargo count
     */
    public int getMyShipCargo() {
        return myShipCargo;
    }

    /**
     * A method to set the current number of Goods a player has in their ship
     * @param myShipCargo The new cargo total
     */
    public void setMyShipCargo(int myShipCargo) {
        this.myShipCargo = myShipCargo;
    }

    private int myShipCargo;

    /**
     * A method to get the current ship HP
     * @return the current ship HP
     */
    public int getMyShipHp() {
        return myShipHp;
    }

    /**
     * A method to set the current ship HP
     * @param myShipHp the new HP value for the ship
     */
    public void setMyShipHp(int myShipHp) {
        this.myShipHp = myShipHp;
    }

    private int myShipHp;
}
