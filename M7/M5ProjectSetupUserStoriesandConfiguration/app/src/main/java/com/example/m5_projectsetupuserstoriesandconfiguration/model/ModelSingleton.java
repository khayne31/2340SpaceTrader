package com.example.m5_projectsetupuserstoriesandconfiguration.model;

import android.util.Log;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Market;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ModelSingleton implements Serializable {
    private static int currentPlayerID;

    private Repository myRepository;

    private Map<String, Object> interactorMap;

    private static Market currentMarket;

    //could make an interactor map

    private static ModelSingleton instance = new ModelSingleton();

    public static ModelSingleton getInstance() {return instance;}

    public static int getCurrentPlayerID() {return currentPlayerID;}

    public static void setCurrentPlayerID(int ID) {currentPlayerID = ID;}

    public static Market getCurrentMarket() {return currentMarket;}

    public static void setCurrentMarket(Market updatedMarket) {currentMarket = updatedMarket;}


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

    public boolean loadBinary(FileInputStream file) {
        Log.d("LoadTest", "This line was run");
        boolean success = true;
        try {
        /*
          To read, we must use the ObjectInputStream since we want to read our model in with
          a single read.
         */
            Log.d("LoadTest", "This line was run2");
            ObjectInputStream in = new ObjectInputStream(file);
            // assuming we saved our top level object, we read it back in with one line of code.
            instance = (ModelSingleton) in.readObject();
            in.close();
            file.close();
        } catch (IOException e) {
            Log.e("UserManagementFacade", "Error reading an entry from binary file",e);
            success = false;
        } catch (ClassNotFoundException e) {
            Log.e("UserManagementFacade", "Error casting a class from the binary file",e);
            success = false;
        }

        return success;

    }

    public boolean saveBinary(FileOutputStream file) {
        boolean success = true;
        ObjectOutputStream out;
        try {
            /*
               For binary, we use Serialization, so everything we write has to implement
               the Serializable interface.  Fortunately all the collection classes and APi classes
               that we might use are already Serializable.  You just have to make sure your
               classes implement Serializable.
               We have to use an ObjectOutputStream to write objects.
               One thing to be careful of:  You cannot serialize static data.
             */
            // We basically can save our entire data model with one write, since this will follow
            // all the links and pointers to save everything.  Just save the top level object.
            out = new ObjectOutputStream(file);
            out.writeObject(instance);
            out.close();
            file.close();
            /*ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            Repository checkRepository = (Repository) in.readObject();
            in.close();
            List<Player> checkList = checkRepository.getAllPlayers();
            String checkString;
            if (checkList.size() == 0) {
                checkString = "Size is zero";
            } else {
                checkString = checkList.toString();
                checkString = checkList.get(0).getName();
            }
            Log.d("SaveTest", checkString);

        */} catch (IOException e) {
            Log.d("UserManagerFacade", "Error writing an entry from binary file",e);
            success = false;
        }
        /*} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        */
        return success;
    }
}
