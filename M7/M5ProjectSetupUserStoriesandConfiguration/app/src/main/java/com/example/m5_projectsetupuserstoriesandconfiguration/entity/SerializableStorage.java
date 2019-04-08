package com.example.m5_projectsetupuserstoriesandconfiguration.entity;

import android.graphics.ColorSpace;

import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;

import java.io.Serializable;

public class SerializableStorage implements Serializable {

    private ModelSingleton instance;
    private int currentID;

    public SerializableStorage(ModelSingleton toSave, int currentID) {
        instance = toSave;
        this.currentID = currentID;
    }

    public int getCurrentID() {
        return currentID;
    }

    public ModelSingleton getInstance() {
        return instance;
    }

}
