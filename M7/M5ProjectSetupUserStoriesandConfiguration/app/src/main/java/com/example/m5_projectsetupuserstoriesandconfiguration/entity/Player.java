package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

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



    public Player(String name, int fPoints, int tPoints, int ePoints, int pPoints, Difficulty difficulty, Universe uni) {
        this.name = name;
        credits = 1000;
        fighterPoints = fPoints;
        traderPoints = tPoints;
        engineerPoints = ePoints;
        pilotPoints = pPoints;
        this.diff = difficulty;
        myShip = new Ship(Ship.makeGnat(), 200, 0);
        currentUniverse = uni;
        //law of demeter violation
        currentSystem = uni.getSystems().get(new Random().nextInt(uni.getSystems().size()));
        //law of demeter violation
        currentPlanet = currentSystem.getPlanets().get(new Random().nextInt(currentSystem.getPlanets().size()));
        currentPlanet.playerLandedOn();
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

    public void setId(int id) {this.id = id;}

    public Planet getCurrentPlanet() {
        return currentPlanet;
    }

    public void setCurrentPlanet(Planet currentPlanet) {
        this.currentPlanet = currentPlanet;
    }

    public void subtractCredits(int x){
        credits = (credits - x) > 0 ? credits - x : 0;
    }

    public void losePoints(int x){
        int[] pointArray = {engineerPoints, fighterPoints, pilotPoints, traderPoints};
        int max = engineerPoints;
        int index = 0;
        int i;
        for(i = 1; i < 4; i++){
            if(pointArray[i] > max){
                max = pointArray[i];
                index = i;
                break;
            }
        }
        switch(index){
            case 1:
                fighterPoints -= x;
            case 2:
                pilotPoints -= x;
            case 3:
                traderPoints -= x;
            default:
                engineerPoints -= x;
        }
    }

    public void gainPoints(int x){
        int[] pointArray = {engineerPoints, fighterPoints, pilotPoints, traderPoints};
        int min = engineerPoints;
        int index = 0;
        int i;
        for(i = 1; i < 4; i++){
            if(pointArray[i] < min){
                min = pointArray[i];
                index = i;
                break;
            }
        }
        switch(index){
            case 1:
                fighterPoints += x;
            case 2:
                pilotPoints += x;
            case 3:
                traderPoints += x;
            default:
                engineerPoints += x;
        }
    }

    //why isn't this used
    public SolarSystem getCurrentSystem() {
        return currentSystem;
    }

    public void setCurrentSystem(SolarSystem currentSystem) {
        this.currentSystem = currentSystem;
    }

    public ArrayList<Planet> visitablePlanets(){
        ArrayList<int[]> viableCoords = new ArrayList<>();
        ArrayList<Planet> planetsAbleToVisit = new ArrayList<>();
        //viableCoords.add(currentSystem.getCoords());

        for(int i = 0; i < currentUniverse.getSizeOfUniverse(); i++){
            for(int j = 0; j < currentUniverse.getSizeOfUniverse(); j++){
                if(i >= (currentSystem.getCoords()[0] - myShip.getRange()) &&
                        i <= (currentSystem.getCoords()[0] + myShip.getRange()) &&
                        j >= (currentSystem.getCoords()[1] - myShip.getRange()) &&
                        j <= (currentSystem.getCoords()[1] + myShip.getRange())) {
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
        int maxRadius  = (int) Math.floor(myShip.getType().getRange() / (currentUniverse.getSizeOfUniverse() + 0.0));

        double percentageFuelUsed = (maxRadius - distance) / maxRadius;
        myShip.setFuel((int)(myShip.getFuel() * percentageFuelUsed));
        myShip.setRange((int)(myShip.getFuel()/myShip.getType().getMaxfuel()) * myShip.getRange());
        currentPlanet = p;
        currentSystem = p.getHomesystem();
    }*/

    public RandomEvent.events travelToPlanet(Planet p){
        SolarSystem hs = p.getHomesystem();
        int[] sysCoords = hs.getCoords();
        int dx = Math.abs(currentPlanet.getCoords()[0] - sysCoords[0]);
        int dy = Math.abs(currentPlanet.getCoords()[1] - sysCoords[1]);
        double maxRadius = 2 *  Math.pow(myShip.getRange(),2);
        double actualRadius = Math.pow(dx, 2) + Math.pow(dy,2);

        double remainingFuel = (maxRadius - actualRadius) / (maxRadius != 0.0 ? maxRadius: 1);
        myShip.setFuel((int)(myShip.getFuel() * remainingFuel));
        myShip.setRange((myShip.getFuel()/myShip.getType().getMaxfuel()) * myShip.getRange());
        currentPlanet = p;
        currentSystem = p.getHomesystem();
        p.playerLandedOn();
        return Math.random() < 0 ? RandomEvent.events.Nothing : new RandomEvent().generateRandomEvent(this);
    }

    public int getFuelRequired(Planet p) {
        SolarSystem hs = p.getHomesystem();
        int[] sysCoords = hs.getCoords();
        int dx = Math.abs(currentPlanet.getCoords()[0] - sysCoords[0]);
        int dy = Math.abs(currentPlanet.getCoords()[1] - sysCoords[1]);
        double maxRadius = 2 *  Math.pow(myShip.getRange(),2);
        double actualRadius = Math.pow(dx, 2) + Math.pow(dy,2);

        double remainingFuel = (maxRadius - actualRadius) / maxRadius;

        //return (int)(myShip.getFuel() - (myShip.getFuel() * remainingFuel));
        return  dx + dy * 5;

    }


    public Universe getCurrentUniverse() {
        return currentUniverse;
    }

        //deprecated
    public static Player parseEntry(String line) {
        assert line != null;
        String[] tokens = line.split("\t");
        assert tokens.length == 5;
        Universe replacementUniverse = new Universe(10);
        Player s = new Player(tokens[0], Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]),
                Integer.valueOf(tokens[3]), Integer.valueOf(tokens[4]),
                Difficulty.getType(tokens[5]), replacementUniverse);

        return s;
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


}
