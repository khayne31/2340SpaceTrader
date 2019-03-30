package com.example.m5_projectsetupuserstoriesandconfiguration.entity;


public class Game {

    private Player player;
    private Market market;


    public Game(Player newPlayer) {
        player = newPlayer;
        market = new Market(player.getCurrentPlanet());
    }

}
