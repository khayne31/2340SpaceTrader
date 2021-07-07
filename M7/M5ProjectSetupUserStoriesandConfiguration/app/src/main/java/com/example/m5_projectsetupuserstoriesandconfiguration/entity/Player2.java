package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

/**
 * A class to store the Player info for firebase (unsure if this is still used or not)
 */
public class Player2 {

    private String name;
    private int pilotPoints;
    private int engineerPoints;
    private int traderPoints;
    private int fighterPoints;
    private int credits;
    private final int id;
    private final Difficulty diff;
    private final String myShip;

    /**
     * Constructor for player2
     * @param p The player that will be used to create a player2
     */
    public Player2(Player p) {
        name = p.getName();
        id = p.getId();
        fighterPoints = p.getFighterPoints();
        traderPoints = p.getTraderPoints();
        engineerPoints = p.getEngineerPoints();
        engineerPoints = p.getPilotPoints();
        diff = p.getDiff();
        credits = p.getCredits();
        Planet currentPlanet = p.getCurrentPlanet();
        int currentUniverseSize = p.getCurrentUniverse().getSizeOfUniverse();
        myShip = p.getMyShip().getType().name();
        int myShipCargo = p.getMyShip().getCurrCargoSize();
        int myShipHp = p.getMyShip().getHp();

    }
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
     * gets the credits of the player
     * @return the credits of the player
     */
    public int getCredits() {
        return credits;
    }

    /**
     * sets the credits of the player
     * @param credits the new credits of the player
     */
    public void setCredits(int credits) {
        this.credits = credits;
    }

    /**
     * gets the pilot points of the player
     * @return the pilot points of the player
     */
    public int getPilotPoints() {return pilotPoints;}

    /**
     * sets the pilot points of the player
     * @param pilotPoints the new pilot points of the player
     */
    public void setPilotPoints(int pilotPoints) {this.pilotPoints = pilotPoints;}

    /**
     * gets the engineering points of the player
     * @return engineering points of the player
     */
    public int getEngineerPoints() {return engineerPoints;}

    /**
     * sets engineering points of the player
     * @param engineerPoints new engineering points of the player
     */
    public void setEngineerPoints(int engineerPoints) {this.engineerPoints = engineerPoints; }

    /**
     * gets the trader points of the player
     * @return trader points of the player
     */
    public int getTraderPoints() {return traderPoints;}

    /**
     * sets trader points of the player
     * @param traderPoints new trader points of the player
     */
    public void setTraderPoints(int traderPoints) {this.traderPoints = traderPoints;}

    /**
     * gets the fighter points of the player
     * @return fighter points of the player
     */
    public int getFighterPoints() {return fighterPoints;}

    /**
     * sets the fighter points of the player
     * @param fighterPoints new fighter points of the player
     */
    public void setFighterPoints(int fighterPoints) {this.fighterPoints = fighterPoints;}
    /**
     * gets the id of the player
     * @return id of the player
     */
    public int getId() {return id;}

    /**
     * gets the ship of the player
     * @return the ship of the player
     */
    public String getMyShip() { return myShip; }
    /**
     * gets the difficulty of the player
     * @return the difficulty level of the player
     */
    public Difficulty getDiff() {
        return diff;
    }

}
