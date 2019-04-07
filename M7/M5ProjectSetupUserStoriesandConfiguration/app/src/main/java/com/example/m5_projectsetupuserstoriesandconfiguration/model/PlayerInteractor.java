package com.example.m5_projectsetupuserstoriesandconfiguration.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.Serializable;
import java.util.List;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;

/**
 * Provides the operations associated with the User entity
 * Relates the Model and the UI
 *
 */
public class PlayerInteractor extends Interactor implements Serializable {

    public PlayerInteractor(Repository repo) {super(repo);}

    public List<Player> getAllPlayers() {return getRepository().getAllPlayers();}

    public void addPlayer (Player p) {getRepository().addPlayer(p);}

    public void updatePlayer (Player p) {getRepository().updatePlayer(p);}

    private static Repository theRepository = new Repository();

    public final static String DEFAULT_JSON_FILE_NAME = "data.json";
    public final static String DEFAULT_TEXT_FILE_NAME = "data.txt";
    public final static String DEFAULT_BINARY_FILE_NAME = "data.bin";

    private static PlayerInteractor instance = new PlayerInteractor(theRepository);

    public static PlayerInteractor getInstance() { return instance; }


    public boolean loadBinary(FileInputStream file) {
        return ModelSingleton.getInstance().loadBinary(file);

    }

    public boolean saveBinary(FileOutputStream out) {
        return ModelSingleton.getInstance().saveBinary(out);
    }


}
