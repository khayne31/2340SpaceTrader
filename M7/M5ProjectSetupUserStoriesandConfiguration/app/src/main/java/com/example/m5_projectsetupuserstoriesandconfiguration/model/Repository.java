package com.example.m5_projectsetupuserstoriesandconfiguration.model;

import android.util.Log;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Repository implements Serializable {

    private static int next_id = 0;

    private static int getNextUniqueID() {return next_id++;}

    private static List<Player> allPlayers;

    public static transient HashMap<String, Player> playerMap;


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
        allPlayers.add(player.getId(), player);
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
        Player p = allPlayers.get(id);
        return p;
    }

    void regenList() {
        if (playerMap != null)
            playerMap.clear();
        else
            playerMap = new HashMap<>();
        for (Player p : allPlayers) {
            playerMap.put(p.getName(), p);
        }
    }

    void loadFromText(BufferedReader reader) {
        System.out.println("Loading Text File");
        playerMap.clear();
        allPlayers.clear();
        try {
            String countStr = reader.readLine();
            assert countStr != null;
            int count = Integer.parseInt(countStr);

            //then read in each user to model
            for (int i = 0; i < count; ++i) {
                String line = reader.readLine();
                Player s = Player.parseEntry(line);
                allPlayers.add(s);
                playerMap.put(s.getName(), s);
            }
            //be sure and close the file
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done loading text file with " + allPlayers.size() + " students");

    }

    void saveAsText(PrintWriter writer) {
        System.out.println("Manager saving: " + allPlayers.size() + " students" );
        writer.println(allPlayers.size());
        for(Player p : allPlayers) {
            p.saveAsText(writer);
        }
    }

}
