package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

public enum Resources {
    NO(0, "NOSPECIALRESOURCES"), // cargoSize not given (on wiki) supposed to be "few"
    MINRCH(1, "MINARALRICH"),
    MINPR(2, "MINERALPOOER"),
    DSRT(3, "DESSERT"),
    LOW(4, "LOTSOFWATER"),
    RS(5, "RICHSOIL"),
    PS(6, "POORSOIL"),
    RF(7, "RICHSOIL"),
    LLN(8, "LIFELESSNESS"), // cargoSize not given (on wiki) supposed to be "few"
    WSHRM(9, "WEIRDMUSHROOMS"),
    LOH(10, "LOTSOFHERBS"),
    ART(11, "ARTISTIC"),
    WAR(12, "WARLIKE"),
    RCHF(13, "RICHFAUNA");

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
