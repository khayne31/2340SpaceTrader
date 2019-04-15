package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

/**
 * An enum that stores the different types of governments a system can have
 */
public enum Governments {
    Dem("Dem", "Democracy"),
    Ari("Ari", "Aristocracy"),
    Oli("Oli", "Oligarchy"),
    Aut("Aut", "Autocracy"),
    Theo("Theo", "Theocracy"),
    Dict("Dict", "Dictatorship"),
    Reb("Reb", "Republic");


    private final String government;

    @Override
    public String toString() {
        return " -Governments{" +
                "government='" + government + '\'' +
                '}';
    }

    Governments(String govId, String gov) {
        government = gov;

    }


}


