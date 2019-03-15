package com.example.m5_projectsetupuserstoriesandconfiguration.model;

import java.util.HashMap;
import java.util.Map;

public class ModelSingleton {
    private static int currentPlayerID;

    private Repository myRepository;

    private Map<String, Object> interactorMap;

    //could make an interactor map

    private static ModelSingleton instance = new ModelSingleton();

    public static ModelSingleton getInstance() {return instance;}

    public int getCurrentPlayerID() {return currentPlayerID;}

    public static void setCurrentPlayerID(int ID) {currentPlayerID = ID;}


    //Make a new instance
    private ModelSingleton() {
        myRepository = new Repository();
        interactorMap = new HashMap<>();
        registerInteractors();
    }

    //Make a set of interactors to use for the application
    private void registerInteractors() {
        interactorMap.put("Player", new PlayerInteractor(myRepository));
    }

    public PlayerInteractor getPlayerInteractor() {
        return (PlayerInteractor) interactorMap.get("Player");
    }
}
