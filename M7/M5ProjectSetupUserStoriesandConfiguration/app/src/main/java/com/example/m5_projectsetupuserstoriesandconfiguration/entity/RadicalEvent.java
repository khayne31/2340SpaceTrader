package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.io.Serializable;

public enum RadicalEvent implements Serializable {
    DROUGHT ("Drought"),
    COLD("Cold"),
    CROPFAIL("Cropfail"),
    WAR("War"),
    BOREDOM("Boredom"),
    PLAGUE("Plague"),
    LACKOFWORKERS("LackOfWorkers");

    private final String name;

    RadicalEvent(String name) {
        this.name = name;
    }
}
