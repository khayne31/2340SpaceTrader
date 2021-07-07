package com.example.m5_projectsetupuserstoriesandconfiguration.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;


import java.util.List;

/**
 * A viewmodel that links the LoadScreen to the backend for loading a previous game
 */
class LoadActivityViewModel extends AndroidViewModel {
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

    /**
     * A method to add a player to the interactor
     * @param player The player to be added
     */
    public void addPlayer (Player player) {interactor.addPlayer(player);}

    /**
     * A method that retrieves a Player based on the inputted ID
     * @param iD The iD of the Player that needs to be retrieved
     * @return The Player requested
     */
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

    /**
     * A method that gets all the players from the interactor
     * @return A list object containing Player objects
     */
    public List<Player> getAllPlayers () {
        return interactor.getAllPlayers();

    }

    /**
     * A method that loads the binary file to implement serialization (deprecated)
     */
    public void loadBinary() {
        interactor.loadBinary();
    }
}
