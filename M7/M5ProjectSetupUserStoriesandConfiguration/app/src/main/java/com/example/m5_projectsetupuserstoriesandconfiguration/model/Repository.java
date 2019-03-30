package com.example.m5_projectsetupuserstoriesandconfiguration.model;

import android.util.Log;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Repository {

    private static int next_id = 1;

    private static int getNextUniqueID() {return next_id++;}

    private static HashMap<Integer, Player> allPlayers;


    /**
     * Make a new Repository object
     */
    public Repository() {
        allPlayers = new HashMap<>();

    }


    /**
     * Return all the Users in the system
     */
    public List<Player> getAllPlayers() {return (List) allPlayers.values();}

    /**add a new user to the system
     *
     * @param player the user to add
     */

    public void addPlayer(Player player) {
        player.setId(Repository.getNextUniqueID());
        allPlayers.put(player.getId(), player);
        Log.d("Test", "A new player was added to the database!");

    }

    public void updatePlayer(Player p) {
        for (Player player: allPlayers.values()) {
            if (player.getId() == p.getId()) {
                player.setPilotPoints(p.getPilotPoints());
                player.setEngineerPoints(p.getEngineerPoints());
                player.setFighterPoints(p.getFighterPoints());
                player.setTraderPoints(p.getTraderPoints());
                player.setCredits(p.getCredits());
                return;
            }
        }
        Log.d("APP", "Player not found with id = " + p.getId());
    }

    public Player loadPlayer(int id) {
        Player p = allPlayers.get(id);
        return p;
    }
}
