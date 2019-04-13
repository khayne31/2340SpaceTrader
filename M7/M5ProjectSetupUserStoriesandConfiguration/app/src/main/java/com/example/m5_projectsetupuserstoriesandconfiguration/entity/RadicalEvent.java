package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

public enum RadicalEvent {
    DROUGHT ("Drought"),
    COLD("Cold"),
    CROPFAIL("Cropfail"),
    WAR("War"),
    BOREDOM("Boredom"),
    PLAGUE("Plague"),
    LACKOFWORKERS("LackOfWorkers");

    private final String name;

    /**
     * the constructor for the radical event enum
     * @param name the name of the radical event
     */
    RadicalEvent(String name) {
        this.name = name;
    }
}
