package com.example.m5_projectsetupuserstoriesandconfiguration.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;


import java.io.FileInputStream;
import java.util.List;

/**
 * A viewmodel that links the LoadScreen to the backend for loading a previous game
 */
public class LoadActivityViewModel extends AndroidViewModel {
    private final PlayerInteractor interactor;

    /**
     * a constructor method for the LoadActivityViewModel
     * @param application the current application
     */
    public LoadActivityViewModel(@NonNull Application application) {
        super(application);
        ModelSingleton model = ModelSingleton.getInstance();
        interactor = model.getPlayerInteractor();
    }

    /**
     * A method to update the backend with a new player
     * @param player The updated player to send to the database
     */
    public void updatePlayer(Player player) {
        interactor.updatePlayer(player);
    }


    public void addPlayer (Player player) {interactor.addPlayer(player);}

    public Player getPlayer (int iD) {
        List<Player> playerList = interactor.getAllPlayers();
        Player returnPlayer = null;
        for (Player player : playerList) {
            if (iD == player.getId()) {
                returnPlayer = player;
            }
        }
        //if (returnPlayer == null) {
        //  throw new Exception("no player was found with that ID");
        //}

        return returnPlayer;
    }

    public List<Player> getAllPlayers () {
        return interactor.getAllPlayers();

    }


    public void loadBinary() {
        interactor.loadBinary();
    }
}
