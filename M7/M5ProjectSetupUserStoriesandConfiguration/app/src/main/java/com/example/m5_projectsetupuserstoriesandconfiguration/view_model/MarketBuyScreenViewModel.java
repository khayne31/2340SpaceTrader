package com.example.m5_projectsetupuserstoriesandconfiguration.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;

import java.util.ArrayList;
import java.util.List;


public class MarketBuyScreenViewModel extends AndroidViewModel {
    private PlayerInteractor interactor;

    public MarketBuyScreenViewModel(@NonNull Application application) {
        super(application);
        interactor = ModelSingleton.getInstance().getPlayerInteractor();
    }

    public void updatePlayer(Player player ) {
        interactor.updatePlayer(player);
    }


    public void addPlayer (Player player) {interactor.addPlayer(player);}

    public Player getPlayer (int index) {
        List<Player> playerList = interactor.getAllPlayers();
        try {
            return playerList.get(index);
        } catch (Exception e){
            throw new IndexOutOfBoundsException("Can't get a player from that index");
        }

    }
}