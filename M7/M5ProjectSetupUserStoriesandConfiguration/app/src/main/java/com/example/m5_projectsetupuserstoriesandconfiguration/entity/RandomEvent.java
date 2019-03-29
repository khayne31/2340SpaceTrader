package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.util.Random;

public class RandomEvent {
    private enum events{
        Wormhole("Wormhole", "You have encountered a wormhole and are being transported to a random planet");
        private String eventName;
        private String eventDescription;
        events(String name, String description){
            eventName = name;
            eventDescription = description;
        }


    }

    RandomEvent(){

    }

    public void generateRandomEvent(Player p){
        events event = events.values()[new Random().nextInt(events.values().length)];
        switch(event){
            case Wormhole:
                Universe uni = p.getCurrentUniverse();
                SolarSystem randomSystem = uni.getSystems().get(new Random().nextInt(uni.getSystems().size()));
                Planet randomPlanet = randomSystem.getPlanets().get(randomSystem.getPlanets().size());
                p.setCurrentPlanet(randomPlanet);
                //TODO implement loss and gain of skill points, ship dmg, credit gaina dn loss, fuel gain and loss, ship updrate, fighting
        }
    }
}
