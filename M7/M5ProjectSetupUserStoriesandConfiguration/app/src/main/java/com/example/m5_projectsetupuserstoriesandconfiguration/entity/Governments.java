package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

/**
 * An enum that stores the different types of governments a system can have
 */
public enum Governments {
    Dem("Dem", "Democracy", 0),
    Ari("Ari", "Aristocracy", 100),
    Oli("Oli", "Oligarchy", 200),
    Aut("Aut", "Autocracy", 150),
    Theo("Theo", "Theocracy", 0),
    Dict("Dict", "Dictatorship", 300),
    Reb("Reb", "Republic", 350);


    private final String government;
    private final String id;
    private final int tax;

    @Override
    public String toString() {
        return " -Governments{" +
                "government='" + government + '\'' +
                '}';
    }

    Governments(String govId, String gov, int tx) {
        government = gov;
        id = govId;
        tax = tx;

    }

    public String getGovernment() {
        return government;
    }

    public int getTax() {
        return tax;
    }
}


