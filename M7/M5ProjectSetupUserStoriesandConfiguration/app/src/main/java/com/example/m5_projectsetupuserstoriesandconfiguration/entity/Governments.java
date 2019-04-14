package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

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
        String id = govId;
        government = gov;

    }


}


