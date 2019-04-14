package com.example.m5_projectsetupuserstoriesandconfiguration.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;


import java.io.FileInputStream;
import java.util.List;

public class LoadActivityViewModel extends AndroidViewModel {
    private final PlayerInteractor interactor;

    public LoadActivityViewModel(@NonNull Application application) {
        super(application);
        ModelSingleton model = ModelSingleton.getInstance();
        interactor = model.getPlayerInteractor();
    }

    public void updatePlayer(Player player ) {
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

    public String getDefaultBinaryStringName () {
        return PlayerInteractor.DEFAULT_BINARY_FILE_NAME;
    }

    public boolean loadBinary(FileInputStream file) {
        return interactor.loadBinary(file);
    }
}
