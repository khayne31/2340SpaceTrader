package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.util.Random;

public class RandomEvent {
    private static final int HP_LOST_ASTROIDS = 25;
    private static final int NUMBER_CREDITS_LOST = 100;
    private static final int CREDITS_TO_LOSE = 2;
    private static final int CREDITS_TO_GAIN = 2;
    private enum events{
        Wormhole("Wormhole", "You have encountered a wormhole and are being transported to a random planet."),
        Astroids("Astroid Field","Your ship has encountered a astroid feild, you ship loses "+ HP_LOST_ASTROIDS +" hp."),
        Pirates("Space Pirates", "During the course of travel you encountered space pirates and had to pay " + NUMBER_CREDITS_LOST + " credits."),
        Death("Crew Death", "A member of your crew has died, lose " +  CREDITS_TO_LOSE + " skill points."),
        Travellers("Travellers", "You have come across travellers who have decided to join your crew, gain " + CREDITS_TO_GAIN + " credits."),
        Upgrade("Ship Upgrade", "You ship has been upgraded one level by the natives");

        private String eventName;
        private String eventDescription;
        events(String name, String description){
            eventName = name;
            eventDescription = description;
        }

        public String getEventDescription() {
            return eventDescription;
        }
    }

    RandomEvent(){

    }

    public events generateRandomEvent(Player p){
        events event = events.values()[new Random().nextInt(events.values().length)];
        switch(event){
            case Wormhole:
                Universe uni = p.getCurrentUniverse();
                SolarSystem randomSystem = uni.getSystems().get(new Random().nextInt(uni.getSystems().size()));
                Planet randomPlanet = randomSystem.getPlanets().get(randomSystem.getPlanets().size());
                p.setCurrentPlanet(randomPlanet);
                //TODO implement loss and gain of skill points, ship dmg, credit gain and loss, fuel gain and loss, ship upgrade, fighting
            case Astroids:
                p.getMyShip().setHp(HP_LOST_ASTROIDS);
            case Pirates:
                p.subtractCredits(NUMBER_CREDITS_LOST);
            case Death:
                p.losePoints(CREDITS_TO_LOSE);
            case Travellers:
                p.gainPoints(CREDITS_TO_GAIN);
            case Upgrade:
                p.getMyShip().upgradeShip();
        }
        return event;
    }
}
