package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;

import java.io.Serializable;
import java.util.Random;
/**
 * the planet class
 */
public class Planet implements Serializable {
    private int[] coords;
    private final String name;
    private final Tech t_lvl;
    private final RadicalEvent event;
    private  Resources resources;
    private Market market;
    private final SolarSystem homesystem;

    /**
     * The constructor which initializes a splanet with coordinates, a planet name and a home SolarSystem
     * @param coordinates an array representing its position in the SolarSystem
     * @param planetName A string representing the name of the Planet
     * @param system A instance of the SolarSystem class representing the home system of the planet
     */
    private Planet(int[] coordinates, String planetName, SolarSystem system){
        if(coordinates.length >= 2){
            coords = coordinates;
        } else{
            coords[1] = 0;
            coords[0] = 0;
        }
        name = planetName;
        t_lvl = Tech.values()[new Random().nextInt(Tech.values().length)];
        event = RadicalEvent.values()[new Random().nextInt(RadicalEvent.values().length)];
        resources = Resources.values()[new Random().nextInt(Resources.values().length)];
        market = new Market(this);
        homesystem = system;

    }

    /**
     * A constructor for the planet class
     * @param coordinates The new coordinates of the planet
     * @param planetName The new name for the planet
     * @param system The planet's home system
     * @param res The planet's specific resources
     */
    public Planet(int[] coordinates, String planetName, SolarSystem system, Resources res){
        this(coordinates, planetName, system);
        resources = res;

    }

    /**
     * A planet constructor for testing the market class
     * @param planetName the name to be given to the planet
     * @param res the resource classification of the planet
     * @param tech The Tech level of the new planet
     */
    public Planet(String planetName, Resources res, Tech tech) {
        name = planetName;
        t_lvl = tech;
        event = RadicalEvent.values()[new Random().nextInt(RadicalEvent.values().length)];
        resources = res;
        market = new Market(this);
        homesystem = new SolarSystem("DummySystem");
    }



    /**
     * a getter function for the coords variable
     * @return  returns an array of ints representing the coords of the planet
     */
    public int[] getCoords() {
        return coords;
    }

    /**
     * toString functions
     * @return  returns the name of the planet
     */
    @Override
    public String toString() {
        /*" -Planet{" +
                "coords=" + Arrays.toString(coords) +
                ", name='" + name + '\'' +
                "Radical_Event = " + event + '\'' +
                '}';*/
        return name;
    }

    /**
     * getter for the name variable
     * @return  returns the name of the planet
     */
    public String getName() {
        return name;
    }

    /**
     * getter for the event variable
     * @return  returns the event on the planet
     */
    public RadicalEvent getEvent() {
        return event;
    }


    /**
     * getter for the level of the planet's tech
     * @return  returns the tech level of the of the planet
     */
    public int getT_lvl() {
        return t_lvl.getLvl();
    }

    /**
     * creates a new market on this planet
     */
    public String playerLandedOn(Player p){
        market = new Market(this);
        Governments gov = homesystem.getGov();
        if(p.getCredits() >= gov.getTax())
            p.subtractCredits(gov.getTax());
        switch (gov){
            case Theo:
                if(Math.random() < .5){
                    p.getMyShip().upgradeShip();
                    p.gainPoints(1);
                    return "Theocracy: The people have blessed you. You get a ship upgrade and gain a crew member credits!";
                }
                else{
                    p.losePoints(1);
                    return "Theocracy: A sacrifice is required. Lose one crew  member!";
                }
            case Ari:
                if(p.getCredits() > 700){
                    p.gainPoints(1);
                    return "Aristocracy: You have " + p.getCredits() + " credits, the leaders consider you worthy, " +
                            "gain one crew member";
                } else if (p.getCredits() > 400){
                    p.subtractCredits(100);
                    return "Aristocracy: You have " + p.getCredits() + " credits, as you are not poor the council will allow" +
                            "safe passage with an additional tax of 100 credits";
                } else{
                    p.setMyShip(new Ship(Ship.shipType.FL, p.getMyShip().getHp(), Ship.shipType.FL.getMaxfuel()));
                    return "Aristocracy: You have " + p.getCredits() + " credits. The council despises poor worthless beings " +
                            "like you. You are forced sell you ship to the lowest tier if you want to continue. " +
                            "PATHETIC!";
                }
            case Aut:
                int sum = p.getEngineerPoints() + p.getPilotPoints() + p.getFighterPoints() + p.getTraderPoints();
                p.losePoints(sum);
                return "Autocracy: Lose you entire crew. Your lucky to be alive scum!";
            case Dict:
                double rnd =  Math.random();
                p.setMyShip(new Ship(Ship.shipType.FL, p.getMyShip().getHp(), Ship.shipType.FL.getMaxfuel()));
                if(p.getMyShip().getHp() <= p.getMyShip().getMaxhp() * rnd){
                    return "Dictatorship: You ship is below " + (int)(rnd*100) + "percent hp. You are weak!" +
                            " Relinquish you ship and crew. You deserve to fly rubble.";
                } else{
                    p.gainPoints(1);
                    return "Dictatorship: You ship is above " + (int)(rnd*100) + "percent hp. You are strong!" +
                            " Gain a crew member.";
                }
            case Oli:
                if(Math.random() < 1/3){
                    p.addCredits(gov.getTax());
                    return "Oligarchy: The leaders turn out to be pacifists. Proceed unharmed with you tax returned";
                } else if(Math.random() < 2/3){
                    p.setFighterPoints(new Random().nextInt(p.getMax_pts()));
                    p.setEngineerPoints(new Random().nextInt(p.getMax_pts()) - p.getFighterPoints());
                    p.setPilotPoints(new Random().nextInt(p.getMax_pts()) - p.getFighterPoints() - p.getEngineerPoints());
                    p.setTraderPoints( p.getMax_pts()- p.getFighterPoints() - p.getEngineerPoints() - p.getPilotPoints());
                    return "Oligarchy: The crew members have been abducted by the leaders for research. " +
                            "Don't worry you get new ones.";
                } else{
                    p.getMyShip().upgradeShip();
                    p.getMyShip().upgradeShip();
                    p.getMyShip().upgradeShip();
                    return "Oligarchy: Such gracious memebers have recognized you potential and have upgraded you ship!";
                }
            case Dem:
                if(Math.random() < .5){
                    return "Democracy: There was a vote... your allowed to pass safely";
                } else{
                    p.losePoints(3);
                    return "There was a vote amoung the people. The people want a gladitor show. RIP three of your crew";
                }
            case Reb:
                p.subtractCredits((int)(gov.getTax() * .5));
                return "There was a vote amoung the people who decided to let you pass...but it didn't matter. " +
                        "The representatives want more tax!";
            default:
                return "Safe passage";
        }


        }


    /**
     * getter for the market variable
     * @return  returns the market of the planet
     */
    public Market getMarket() {return market;}


    /**
     * getter for the homesystem variable
     * @return  returns the homesystem of the planet
     */
    public SolarSystem getHomesystem() {
        return homesystem;
    }

    public Resources getResources() {
        return resources;
    }
}
