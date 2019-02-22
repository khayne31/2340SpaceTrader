package com.example.m5_projectsetupuserstoriesandconfiguration.entity;



public enum  Difficulty {
    BE("BE", "Beginner"),
    EA("EA", "Easy"),
    NO("NO", "Normal"),
    HA("HA", "Hard"),
    IM("IM", "Impossible");

    private final String level;
    private final String id;

    Difficulty(String difLevel, String difId) {
        level = difLevel;
        id = difId;
    }

    public String getLevel() {
        return level;
    }

    public String getId() {
        return id;
    }

    public String toString() {
        return id;
    }
}
