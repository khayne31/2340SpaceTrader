package com.example.m5_projectsetupuserstoriesandconfiguration.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;

/**
 * A viewmodel to transfer data from the UI to the interactor
 */
public class MainActivityViewModel extends AndroidViewModel {
    private final PlayerInteractor interactor;

    /**
     * The constructor method for MainActivityViewModel
     * @param application The current application
     */
    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        interactor = ModelSingleton.getInstance().getPlayerInteractor();
    }

    /**
     * A method to update the backend with a new player
     * @param player The updated player to send to the database
     */
    public void updatePlayer(Player player ) {
        interactor.updatePlayer(player);
    }

    /**
     * A method to add a player to the interactor
     * @param player The player to be added
     */
    public void addPlayer (Player player) {interactor.addPlayer(player);}
}
