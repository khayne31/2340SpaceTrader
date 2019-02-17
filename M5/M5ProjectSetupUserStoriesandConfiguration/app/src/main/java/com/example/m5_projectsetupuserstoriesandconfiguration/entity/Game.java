package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

public class Game {
    private enum  difficulty {
        BE ("beginner", "BE"),
        EA ("easy", "EA"),
        NO ("normal", "NO"),
        HA ("hard", "HA"),
        IM ("impossible", "IM");

    private final String level;
    private final String id;

    difficulty (String difLevel, String difId) {
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












}
