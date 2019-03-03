package com.example.m5_projectsetupuserstoriesandconfiguration.view_model;

import android.arch.lifecycle.ViewModel;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;

public class MainActivityViewModel extends ViewModel {
    private PlayerInteractor interactor;


    public void updatePlayer(Player player ) {interactor.updatePlayer(player);}

    public void addPlayer (Player player) {interactor.addPlayer(player);}
}
