package com.example.m5_projectsetupuserstoriesandconfiguration.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;

import java.util.List;

/**
 * Aids in attaching the view to the model for the MarketBuy
 * Screen
 */
public class MarketBuyScreenViewModel extends AndroidViewModel {
    private final PlayerInteractor interactor;

    /**
     * Constructor for the MarketBuyScreenViewModel
     * @param application the current applicaiton. so the game app
     */
    public MarketBuyScreenViewModel(@NonNull Application application) {
        super(application);
        interactor = ModelSingleton.getInstance().getPlayerInteractor();
    }

    /**
     * Changes the player in the view
     * @param player the instance of the current user of the game
     */
    public void updatePlayer(Player player ) {
        interactor.updatePlayer(player);
    }

    /**
     * adds a player to the repository
     * @param player the instance of the current user of the game
     */
    public void addPlayer (Player player) {interactor.addPlayer(player);}

    /**
     * returns a player from the repo based on the id passed in
     * @param iD the id of the player passed in
     * @return Player object based on id
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
}