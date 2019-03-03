package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

public enum Resources {
    NO(0, "NOSPECIALRESOURCES"), // cargoSize not given (on wiki) supposed to be "few"
    MINRCH(1, "MINARALRICH"),
    MINPR(2, "MINERALPOOER"),
    DSRT(3, "DESSER"),
    LOW(4, "LOTSOFWATER"),
    RS(5, "RICHSOIL"),
    PS(6, "POORSOIL"),
    RF(7, "RICHSOIL"),
    LLN(0, "LIFELESSNESS"), // cargoSize not given (on wiki) supposed to be "few"
    WSHRM(1, "WEIRDMUSHROOMS"),
    LOH(2, "LOTSOFHERBS"),
    ART(3, "ARTISTIC"),
    WAR(4, "WARLIKE");

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
