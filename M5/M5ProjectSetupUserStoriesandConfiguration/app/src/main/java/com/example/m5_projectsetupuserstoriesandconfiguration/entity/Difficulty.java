package com.example.m5_projectsetupuserstoriesandconfiguration.entity;



public enum  Difficulty {
    BE ("beginner", "BE"),
    EA ("easy", "EA"),
    NO ("normal", "NO"),
    HA ("hard", "HA"),
    IM ("impossible", "IM");

    private final String level;
    private final String id;

    Difficulty (String difLevel, String difId) {
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
