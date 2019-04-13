package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.util.Log;

import java.util.Random;

public class RandomEvent {
    private static final int HP_LOST_ASTEROIDS = 15;
    private static final int HP_LOST_ENEMY = 20;
    private static final int NUMBER_CREDITS_LOST = 100;
    private static final int CREDITS_TO_LOSE = 2;
    private static final int CREDITS_TO_GAIN = 2;
    private static final int SPACE_TAX = 50;
    private static final int BIG_SPACE_BOI = 25;
    private static final int SMOL_SPACE_BOI = 10;
    private static final int FUEL_TO_LOSE = 20;

    public enum events{
//        Wormhole("Wormhole", "You have encountered a wormhole and are being transported to a
// random planet."),
//        Lost("Bad Navigation", "Your crew went off route! You went to a different planet."),
        Asteroids("Asteroid Field","Your ship has encountered an asteroid field! Your ship loses "
        + HP_LOST_ASTEROIDS +" hp."),
        Pirates("Space Pirates", "During the course of travel you encountered space pirates and " +
                "had to pay " + NUMBER_CREDITS_LOST + " credits."),
        Death("Crew Death", "A member of your crew has died, lose " +  CREDITS_TO_LOSE + " skill " +
                "points."),
        Travellers("Travellers", "You have come across travellers who have decided to join your " +
                "crew! Gain " + CREDITS_TO_GAIN + " credits."),
        Upgrade("Ship Upgrade", "You ship has been upgraded one level by the natives."),
        Aliens("Alien Abduction", "A member of your crew was abducted by aliens; you lose " +
                CREDITS_TO_LOSE + " skill points."),
        Enemy("Enemy Attack", "An enemy ship attacked your ship! Your ship loses " + HP_LOST_ENEMY
                + " hp."),
        Tax("Space Tariffs", "Your ship crossed into a Space Tariff Zone! You paid " + SPACE_TAX +
                " credits."),
        MonsterB("Big Space Monster", "Your ship took damage from an enraged Giant Space " +
                "Monster! Your ship loses " + BIG_SPACE_BOI + " hp."),
        MonsterS("Small Space Monster", "Your ship took damage from an Small Space Monster " +
                "migration! Your ship loses " + SMOL_SPACE_BOI + " hp."),
        FuelLeak("Fuel Leak", "Your ship was leaking fuel. Your ship loses " + FUEL_TO_LOSE +
                " gallons of fuel."),
//        StarGate("Star Gate", "You have encountered a star gate, of unimaginable power and were
// transported to a random planet"),
        Nothing("Nothing Happened", "You trip was successful");

        private final String eventName;
        private final String eventDescription;

        /**
         * the constructor for the event enum
         * @param name the name of the event
         * @param description the description of the event
         */
        events(String name, String description){
            eventName = name;
            eventDescription = description;
        }

        /**
         * gets the description of the event
         * @return the description
         */
        public String getEventDescription() {
            return eventDescription;
        }

        /**
         * gets the event name
         * @return the event name
         */
        public String getEventName() { return eventName; }
    }

    RandomEvent(){

    }

    /**
     * Generates a random event based on a random num generator
     * @param p the current player
     * @return a random event
     */
    public events generateRandomEvent(Player p){
        Log.d("rng", "rng");
        events event = events.values()[new Random().nextInt(events.values().length-1)];
        Log.d("rng", event.eventDescription + "   " + events.values());
        System.out.print(events.values() + "\t" + event);
        switch(event){
//            case Wormhole:
//                Universe uni = p.getCurrentUniverse();
//                Log.d("rng", uni + "");
//                SolarSystem randomSystem = uni.getSystems().get(
// new Random().nextInt(uni.getSystems().size()));
//                Log.d("rng", randomSystem+"");
//                Planet randomPlanet = randomSystem.getPlanets().get(
// randomSystem.getPlanets().size());
//                Log.d("rng",  randomPlanet + "");
//                p.setCurrentPlanet(randomPlanet);
//
//                break;
                //TODO implement loss and gain of skill points, ship dmg, credit gain and loss,
            // fuel gain and loss, ship upgrade, fighting
//            case Lost:
//                Universe universe = p.getCurrentUniverse();
//                SolarSystem randSys = universe.getSystems().get(new Random().nextInt(
// universe.getSystems().size()));
//                Planet randPlanet = randSys.getPlanets().get(randSys.getPlanets().size());
//                p.setCurrentPlanet(randPlanet);
//                break;
//            case StarGate:
//                Universe uni1 = p.getCurrentUniverse();
//                SolarSystem randomSystem1 = uni1.getSystems().get(new Random().nextInt(
// uni1.getSystems().size()));
//                Planet randomPlanet1 = randomSystem1.getPlanets().get(
// randomSystem1.getPlanets().size());
//                p.setCurrentPlanet(randomPlanet1);
//                break;
            case Asteroids:
                p.getMyShip().loseHp(HP_LOST_ASTEROIDS);
                break;
            case Pirates:
                p.subtractCredits(NUMBER_CREDITS_LOST);
                break;
            case Death:
                p.losePoints(CREDITS_TO_LOSE);
                break;
            case Travellers:
                p.gainPoints(CREDITS_TO_GAIN);
                break;
            case Upgrade:
                //p.getMyShip().upgradeShip();
                break;
            case Aliens:
                p.losePoints(CREDITS_TO_LOSE);
                break;
            case Enemy:
                p.getMyShip().loseHp(HP_LOST_ENEMY);
                break;
            case Tax:
                p.subtractCredits(SPACE_TAX);
                break;
            case MonsterB:
                p.getMyShip().loseHp(BIG_SPACE_BOI);
                break;
            case MonsterS:
                p.getMyShip().loseHp(SMOL_SPACE_BOI);
                break;
            case FuelLeak:
                p.getMyShip().loseFuel(FUEL_TO_LOSE);
                break;
            case Nothing:
                break;
        }
        return event;
    }
}
