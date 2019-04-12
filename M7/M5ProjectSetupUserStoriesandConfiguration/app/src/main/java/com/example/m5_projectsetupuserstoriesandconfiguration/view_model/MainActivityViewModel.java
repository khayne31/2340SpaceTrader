package com.example.m5_projectsetupuserstoriesandconfiguration.view_model;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;

public class MainActivityViewModel extends AndroidViewModel {
    private final PlayerInteractor interactor;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        interactor = ModelSingleton.getInstance().getPlayerInteractor();
    }

    public void updatePlayer(Player player ) {
        interactor.updatePlayer(player);
    }


    public void addPlayer (Player player) {interactor.addPlayer(player);}
}
