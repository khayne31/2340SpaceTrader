package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

/**
 * An enum that defines the kinds of resources a planet can have
 */
public enum Resources {
    NO(0, "NOSPECIALRESOURCES"),
    MINRCH(1, "MINERALRICH"),
    MINPR(2, "MINERALPOOR"),
    DSRT(3, "DESERT"),
    LOW(4, "LOTSOFWATER"),
    RS(5, "RICHSOIL"),
    PS(6, "POORSOIL"),
    RF(7, "RICHSOIL"),
    LLN(8, "LIFELESSNESS"),
    WSHRM(9, "WEIRDMUSHROOMS"),
    LOH(10, "LOTSOFHERBS"),
    ART(11, "ARTISTIC"),
    WAR(12, "WARLIKE"),
    RCHF(13, "RICHFAUNA"),
    NEVER(14, "NEVER");

    private final String resource;

    /**
     * Constructor for the resource enum
     * @param resourceLvl the level of resources on planet
     * @param resourceName the name of resource on planet
     */
    Resources(int resourceLvl, String resourceName){
        resource = resourceName;
    }

    /**
     * a string representation of the resource enum
     * @return a string representation of the resource enum
     */
    @Override
    public String toString() {
        return " -Resources{" +
                " resource='" + resource + '\'' +
                '}';
    }
}
