package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;

import java.io.Serializable;

/**
 * A class that was meant to help store information for the serialization process
 */
public class SerializableStorage implements Serializable {

    private final PlayerInteractor playerInt;
    private final int currentID;

    /**
     * The constructor method for SerializableStorage
     * @param newPlayerInt The PlayerInteractor to be stored
     * @param currentID the currentID from the model singleton to be stored
     */
    public SerializableStorage(PlayerInteractor newPlayerInt, int currentID) {
        playerInt = newPlayerInt;
        this.currentID = currentID;
    }

    /**
     * A method that gets the current ID stored in the Serializable Storage object
     * @return the currentID, an int
     */
    public int getCurrentID() {
        return currentID;
    }

    /**
     * A method that gets the player interactor stored in the Serializable Storage object
     * @return the PlayerInteractor object
     */
    public PlayerInteractor getPlayerInteractor() {
        return playerInt;
    }

}
