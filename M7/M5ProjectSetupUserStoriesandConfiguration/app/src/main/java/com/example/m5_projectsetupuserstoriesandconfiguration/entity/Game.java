package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

/**
 * A class that stores a player as well as the current market, is deprecated
 */
class Game {

    /**
     * A constructor that generates a new game based on an inputted player
     * @param newPlayer The new player to create a game for
     */
    public Game(Player newPlayer) {
        Market market = new Market(newPlayer.getCurrentPlanet());
    }

}
