package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

public enum Governments {
    Dem("Dem", "Democracy"),
    Ari("Ari", "Arisocracy"),
    Oli("Oli", "Oligarchy"),
    Aut("Aut", "Autocracy"),
    Theo("Theo", "Theocracy"),
    Dict("Dict", "Dictatorship"),
    Reb("Reb", "Republic");


    private final String id;
    private final String governemnt;

    Governments(String govId, String gov ){
        id = govId;
        governemnt = gov;

    }

    public String getId() {
        return id;
    }

    public String getGovernemnt() {
        return governemnt;
    }
}
