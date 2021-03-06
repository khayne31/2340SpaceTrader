package com.example.m5_projectsetupuserstoriesandconfiguration.model;

import android.util.Log;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



class Repository implements Serializable {

    private static int next_id;

    private static int getNextUniqueID() {
        next_id++;
        return next_id;
    }

    private static List<Player> allPlayers;

    public transient HashMap<String, Player> playerMap;


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
        Log.d("Test", "A new player was added to the database!");

    }

    public void updatePlayer(Player p) {
        for (Player player: allPlayers) {
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
        return allPlayers.get(id);
    }

}
