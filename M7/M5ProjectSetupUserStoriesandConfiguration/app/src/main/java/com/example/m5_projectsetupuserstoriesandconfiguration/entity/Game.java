package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

/**
 * A class that stores a player as well as the current market, is deprecated
 */
public class Game {

    private Player player;
    private Market market;

    /**
     * A constructor that generates a new game based on an inputted player
     * @param newPlayer The new player to create a game for
     */
    public Game(Player newPlayer) {
        player = newPlayer;
        market = new Market(player.getCurrentPlanet());
    }

}
