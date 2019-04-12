package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;

import java.io.Serializable;

public class SerializableStorage implements Serializable {

    private final PlayerInteractor playerInt;
    private final int currentID;

    public SerializableStorage(PlayerInteractor newPlayerInt, int currentID) {
        playerInt = newPlayerInt;
        this.currentID = currentID;
    }

    public int getCurrentID() {
        return currentID;
    }

    public PlayerInteractor getPlayerInteractor() {
        return playerInt;
    }

}
