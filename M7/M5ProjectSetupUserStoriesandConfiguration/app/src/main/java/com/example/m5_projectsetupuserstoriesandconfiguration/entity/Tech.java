package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import java.io.Serializable;

public enum Tech implements Serializable {
    PRE(0, "PRE"),
    AGR(1, "AGR"),
    MID(2, "MID"),
    REN(3, "REN"),
    EAR(4, "EAR"),
    IND(5, "IND"),
    POS(6, "POS"),
    HIT(7, "HIT");

    private final int lvl;
    private final String government;


    Tech(int techLvl, String techName){
        lvl = techLvl;
        government = techName;
    }

    @Override
    public String toString() {
        return " -Tech{" +
                "tech lvl=" + lvl +
                ", government='" + government + '\'' +
                '}';
    }

    public int getLvl() {
        return lvl;
    }
}
