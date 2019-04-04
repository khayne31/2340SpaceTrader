package com.example.m5_projectsetupuserstoriesandconfiguration.entity;


import java.io.Serializable;

public enum  Difficulty implements Serializable {
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

    public static Difficulty getType(String s) {
        Difficulty result;
        if (s.equals("BE")) {
            result = BE;
        } else if (s.equals("EA")) {
            result = EA;
        } else if (s.equals("NO")) {
            result = NO;
        } else if (s.equals("HA")) {
            result = HA;
        } else {
            result = IM;
        }
        return result;
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
