package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 * The main class of the game that stores a user's related info,
 * such as ship, credits, etc., as well as their unique universe
 */
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
    private Planet currentPlanet;
    private SolarSystem currentSystem;
    private Universe currentUniverse;
    private static  final int INITAL_HP = 200;


    /**
     * Constructor for player
     * @param name the players name
     * @param fPoints fighter points
     * @param tPoints trader points
     * @param ePoints engineer points
     * @param pPoints pilot points
     * @param difficulty the difficulty level
     * @param uni the players universe
     */
    public Player(String name, int fPoints, int tPoints, int ePoints, int pPoints,
                  Difficulty difficulty, Universe uni) {
        this.name = name;
        credits = 1000;
        fighterPoints = fPoints;
        traderPoints = tPoints;
        engineerPoints = ePoints;
        pilotPoints = pPoints;
        this.diff = difficulty;
        int hp = INITAL_HP;
        myShip = new Ship(Ship.shipType.GN, hp, 0);
        currentUniverse = uni;
        //law of demeter violation
        currentSystem = uni.getSystems().get(new Random().nextInt(uni.getSystems().size()));
        //law of demeter violation
        currentPlanet = currentSystem.getPlanets().get(new Random().nextInt(
                currentSystem.getPlanets().size()));
        currentPlanet.playerLandedOn();
    }

    /**
     * A constructor for player that is used for testing the market class
     * @param name the players name
     * @param fPoints fighter points
     * @param tPoints trader points
     * @param ePoints engineer points
     * @param pPoints pilot points
     * @param difficulty the difficulty level
     */
    public Player(String name, int fPoints, int tPoints, int ePoints, int pPoints,
                  Difficulty difficulty) {
        this.name = name;
        credits = 1000;
        fighterPoints = fPoints;
        traderPoints = tPoints;
        engineerPoints = ePoints;
        pilotPoints = pPoints;
        this.diff = difficulty;
        int hp = INITAL_HP;
        myShip = new Ship(Ship.shipType.GN, hp, 0);
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
    public Ship getMyShip() { return myShip; }

    /**
     * sets the id of the player
     * @param id the new id of the player
     */
    public void setId(int id) {this.id = id;}

    /**
     * gets the current planet of the player
     * @return current planet of the player
     */
    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    /**
     * sets current planet of the player
     * @param currentPlanet new current planet of the player
     */
    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    /**
     * subtracts an amount of credits from the player
     * @param x an amount of credits
     */
    public void subtractCredits(int x){
        credits = ((credits - x) > 0) ? (credits - x) : 0;
    }

    /**
     * subtracts points from one of the 4 categories of points from the player
     * @param x an amount to subtract
     */
    public void losePoints(int x){
        int[] pointArray = {engineerPoints, fighterPoints, pilotPoints, traderPoints};
        int max = engineerPoints;
        int index = 0;
        int i;
        for(i = 1; i < 4; i++){
            if(pointArray[i] > max){
                index = i;
                break;
            }
        }
        switch(index){
            case 1:
                if (fighterPoints <= 0) {
                    fighterPoints = 0;
                    return;
                }
                fighterPoints -= x;
                break;
            case 2:
                if (pilotPoints <= 0) {
                    pilotPoints = 0;
                    return;
                }
                pilotPoints -= x;
                break;
            case 3:
                if (traderPoints <= 0) {
                    traderPoints = 0;
                    return;
                }
                traderPoints -= x;
                break;
            default:
                if (engineerPoints <= 0) {
                    engineerPoints = 0;
                    return;
                }
                engineerPoints -= x;
        }
    }

    /**
     * adds points to one of the 4 categories of points from the player
     * @param x the amount of points
     */
    public void gainPoints(int x){
        int[] pointArray = {engineerPoints, fighterPoints, pilotPoints, traderPoints};
        int min = engineerPoints;
        int index = 0;
        int i;
        for(i = 1; i < 4; i++){
            if(pointArray[i] < min){
                index = i;
                break;
            }
        }
        switch(index){
            case 1:
                fighterPoints += x;
                break;
            case 2:
                pilotPoints += x;
                break;
            case 3:
                traderPoints += x;
                break;
            default:
                engineerPoints += x;
        }
    }


    //why isn't this used
    /*
     * gets the current solar system
     * @return the current solar system

    public SolarSystem getCurrentSystem() {
        return currentSystem;
    }
    */

    /**
     * sets current solar system
     * @param currentSystem new current solar system
     */
    public void setCurrentSystem(SolarSystem currentSystem) {
        this.currentSystem = currentSystem;
    }

    /**
     * gets the list of planets the player can travel to based on the amount
     * of fuel in the ship
     * @return the list of visitable planets
     */
    public ArrayList<Planet> visitablePlanets(){
        Collection<int[]> viableCoords = new ArrayList<>();
        ArrayList<Planet> planetsAbleToVisit = new ArrayList<>();
        //viableCoords.add(currentSystem.getCoords());

        for(int i = 0; i < currentUniverse.getSizeOfUniverse(); i++){
            for(int j = 0; j < currentUniverse.getSizeOfUniverse(); j++){
                if((i >= (currentSystem.getCoords()[0] - myShip.getRange())) &&
                        (i <= (currentSystem.getCoords()[0] + myShip.getRange())) &&
                        (j >= (currentSystem.getCoords()[1] - myShip.getRange())) &&
                        (j <= (currentSystem.getCoords()[1] + myShip.getRange()))) {
                        viableCoords.add(new int[] {i, j});
                }
            }
        }

        for(int[] coord: viableCoords){
            //why is this hardcoded
            //its not. that's how the coordinates work
            SolarSystem  s = currentUniverse.getUniverse().get(coord[0]).get(coord[1]);
            if(s != null){
                for(Planet p: s.getPlanets()){
                    if(!planetsAbleToVisit.contains(p) && !p.equals(currentPlanet)) {
                        planetsAbleToVisit.add(p);
                    }
                }
            }

        }

        return planetsAbleToVisit;

    }

    /*public void travelToPlanet(Planet p){
        SolarSystem hs = p.getHomesystem();
        int[] sysCoords = hs.getCoords();
        int distance =  (int)Math.sqrt ((Math.pow(sysCoords[0] - currentSystem.getCoords()[0], 2)
                + Math.pow(sysCoords[1] - currentSystem.getCoords()[1],2)));
        int maxRadius  = (int) Math.floor(myShip.getType().getRange() /
        (currentUniverse.getSizeOfUniverse() + 0.0));

        double percentageFuelUsed = (maxRadius - distance) / maxRadius;
        myShip.setFuel((int)(myShip.getFuel() * percentageFuelUsed));
        myShip.setRange((int)(myShip.getFuel()/myShip.getType().getMaxfuel()) * myShip.getRange());
        currentPlanet = p;
        currentSystem = p.getHomesystem();
    }*/

    /**
     * the player can travel to the planet and will encounter a random event
     * @param p the planet of interest
     * @return the random event to affect the player
     */
    public RandomEvent.events travelToPlanet(Planet p){
        SolarSystem hs = p.getHomesystem();
        int[] sysCoords = hs.getCoords();
        int dx = Math.abs(currentPlanet.getCoords()[0] - sysCoords[0]);
        int dy = Math.abs(currentPlanet.getCoords()[1] - sysCoords[1]);
        double maxRadius = 2 *  Math.pow(myShip.getRange(),2);
        double actualRadius = Math.pow(dx, 2) + Math.pow(dy,2);

        double remainingFuel = (maxRadius - actualRadius) / ((maxRadius != 0.0) ? maxRadius : 1);
        myShip.setFuel((int)(myShip.getFuel() * remainingFuel));
        myShip.setRange((myShip.getFuel()/myShip.getType().getMaxfuel()) * myShip.getRange());
        currentPlanet = p;
        currentSystem = p.getHomesystem();
        p.playerLandedOn();
        return (Math.random() < 0) ? RandomEvent.events.Nothing :
                RandomEvent.generateRandomEvent(this);
    }

    /**
     * A method that tests to see how much fuel is required to travel to a planet
     * @param p The planet to travel to
     * @return The amount of fuel required to travel there, as an int
     */
    public int getFuelRequired(Planet p) {
        SolarSystem hs = p.getHomesystem();
        int[] sysCoords = hs.getCoords();
        int dx = Math.abs(currentPlanet.getCoords()[0] - sysCoords[0]);
        int dy = Math.abs(currentPlanet.getCoords()[1] - sysCoords[1]);
        double maxRadius = 2 *  Math.pow(myShip.getRange(),2);
        double actualRadius = Math.pow(dx, 2) + Math.pow(dy,2);

        //double remainingFuel = (maxRadius - actualRadius) / maxRadius;

        //return (int)(myShip.getFuel() - (myShip.getFuel() * remainingFuel));
        return dx + (dy * 5);

    }

    /**
     * gets the current universe of the player
     * @return the current universe of the player
     */
    public Universe getCurrentUniverse() {
        return currentUniverse;
    }


    //deprecated
    /**
     * Save this class in a custom save format
     * I chose to use tab (\t) to make line splitting easy for loading
     * If your data had tabs, you would need something else as a delimiter
     *
     * @param writer the file to write this student to
     */
    public void saveAsText(PrintWriter writer) {
        System.out.println("Student saving student: " + name);
        writer.println(name + "\t" + fighterPoints + "\t" + traderPoints + "\t" +
                engineerPoints + "\t" + pilotPoints + "\t" + diff.toString() + "\t" +
                currentUniverse.toStringForSave());
    }

    /**
     * gets the difficulty of the player
     * @return the difficulty level of the player
     */
    public Difficulty getDiff() {
        return diff;
    }

    /**
     * sets the difficulty of the player
     * @param diff the desired difficulty
     */
    public void setDiff(Difficulty diff) {
        this.diff = diff;
    }

    /**
     * sets the ship that the player chooses
     * @param myShip the ship
     */
    public void setMyShip(Ship myShip) {
        this.myShip = myShip;
    }

    /**
     * sets the current universe of the player
     * @param currentUniverse the new current universe of the player
     */
    public void setCurrentUniverse(Universe currentUniverse) {
        this.currentUniverse = currentUniverse;
    }

    /**
     * A method to enable the ship to lose hp
     * @param toLose the amount of hp to lose
     */
    public void loseHP(int toLose) {
        myShip.loseHp(toLose);
    }

    /**
     * A method to enable the ship to lose fuel
     * @param toLose the amount of fuel to lose
     */
    public void loseFuel(int toLose) {
        myShip.loseFuel(toLose);
    }
}
