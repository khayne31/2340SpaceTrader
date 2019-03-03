package com.example.m5_projectsetupuserstoriesandconfiguration.model;

import android.util.Log;

import java.util.List;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;

/**
 * Provides the operations associated with the User entity
 * Relates the Model and the UI
 *
 */
public class PlayerInteractor extends Interactor {

    public PlayerInteractor(Repository repo) {super(repo);}

    public List<Player> getAllPlayers() {return getRepository().getAllPlayers();}

    public void addUser (Player p) { getRepository().addPlayer(p);}


}
