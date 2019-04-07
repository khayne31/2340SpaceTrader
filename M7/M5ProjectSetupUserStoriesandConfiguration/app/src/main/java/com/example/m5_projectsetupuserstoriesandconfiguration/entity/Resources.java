package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.io.Serializable;

public enum Resources implements Serializable {
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

    private final int lvl;
    private final String resource;


    Resources(int resourceLvl, String resourceName){
        lvl = resourceLvl;
        resource = resourceName;
    }

    @Override
    public String toString() {
        return " -Resources{" +
                " resource='" + resource + '\'' +
                '}';
    }
}
