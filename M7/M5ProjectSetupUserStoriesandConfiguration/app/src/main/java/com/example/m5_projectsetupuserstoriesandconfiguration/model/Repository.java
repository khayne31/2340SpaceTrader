package com.example.m5_projectsetupuserstoriesandconfiguration.model;

import android.util.Log;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;

import java.util.ArrayList;
import java.util.List;


public class Repository {

    private static int next_id = 1;

    private static int getNextUniqueID() {return next_id++;}

    private List<Player> allPlayers;


    /**
     * Make a new Repository object
     */
    public Repository() {
        allPlayers = new ArrayList<>();

    }


    /**
     * Return all the Users in the system
     */
    public List<Player> getAllPlayers() {return allPlayers;}

    /**add a new user to the system
     *
     * @param player the user to add
     */

    public void addPlayer(Player player) {
        player.setId(Repository.getNextUniqueID());
        allPlayers.add(player);

    }
}
