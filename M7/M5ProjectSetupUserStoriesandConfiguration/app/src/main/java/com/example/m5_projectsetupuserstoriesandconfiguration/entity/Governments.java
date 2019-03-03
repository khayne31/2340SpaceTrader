package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

public enum Governments {
    Dem("Dem", "Democracy"),
    Ari("Ari", "Aristocracy"),
    Oli("Oli", "Oligarchy"),
    Aut("Aut", "Autocracy"),
    Theo("Theo", "Theocracy"),
    Dict("Dict", "Dictatorship"),
    Reb("Reb", "Republic");


    private final String id;
    private final String governemnt;

    @Override
    public String toString() {
        return " -Governments{" +
                "governemnt='" + governemnt + '\'' +
                '}';
    }

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
