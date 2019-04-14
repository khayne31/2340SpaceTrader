package com.example.m5_projectsetupuserstoriesandconfiguration.entity;


/**
 * A class that denotes the difficulty a player has chosen for their game
 */
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

    /**
     * A method to return a difficulty object based on the type given
     * in the form of a string.
     * @param s The inputted string to check for difficulty type
     * @return The difficulty object based on the input
     */
    public static Difficulty getType(String s) {
        Difficulty result;
        switch (s) {
            case "BE":
                result = BE;
                break;
            case "EA":
                result = EA;
                break;
            case "NO":
                result = NO;
                break;
            case "HA":
                result = HA;
                break;
            default:
                result = IM;
                break;
        }
        return result;
    }

    /**
     * A method to return the difficulty level as a String
     * @return The level of the difficulty as a String
     */
    public String getLevel() {
        return level;
    }

    /**
     * A method to return the difficulty id as a string
     * @return The id of the difficulty as a string
     */
    public String getId() {
        return id;
    }

    /**
     * A method to convert the difficulty to a string
     * @return The string version of a difficulty, its id
     */
    public String toString() {
        return id;
    }
}
