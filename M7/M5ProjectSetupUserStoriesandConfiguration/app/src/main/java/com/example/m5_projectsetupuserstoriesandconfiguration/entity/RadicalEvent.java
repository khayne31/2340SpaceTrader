package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

/**
 * An enum that describes RadicalEvents for planets
 */
public enum RadicalEvent {
    DROUGHT ("Drought"),
    COLD("Cold"),
    CROPFAIL("Cropfail"),
    WAR("War"),
    BOREDOM("Boredom"),
    PLAGUE("Plague"),
    LACKOFWORKERS("LackOfWorkers");

    /**
     * the constructor for the radical event enum
     * @param name the name of the radical event
     */
    RadicalEvent(String name) {
    }
}
