package com.example.m5_projectsetupuserstoriesandconfiguration.model;

import android.util.Log;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Market;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player2;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.SerializableStorage;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Sets up a model that can connect to the front end views
 * and the backend repository
 */
public final class ModelSingleton implements Serializable {
    private static int currentPlayerID;

    private final Repository myRepository;

    private final Map<String, Object> interactorMap;

    private int nonStaticCurrentPlayerID;

    private static Market currentMarket;

    //could make an interactor map

    private static ModelSingleton instance = new ModelSingleton();

    /**
     * Sets a new instance of the ModelSingleton
     * @param newInstance the new instance of the model
     */
    private static void setInstance(ModelSingleton newInstance)
    {ModelSingleton.instance = newInstance;}

    /**
     * Gets the current instance of the model singleton
     * @return the current instance of the model singleton
     */
    public static ModelSingleton getInstance() {return instance;}

    /**
     * gets the current player id
     * @return the current player id
     */
    public static int getCurrentPlayerID() {return currentPlayerID;}

    /**
     * Sets the current player id
     * @param ID the new current player id
     */
    public static void setCurrentPlayerID(int ID) {
        currentPlayerID = ID;
        instance.setNonStaticCurrentPlayerID(ID);
    }

    /**
     * Sets the new nonstatic current player id
     * @param ID the new nonstatic current player id
     */
    private void setNonStaticCurrentPlayerID(int ID) {
        nonStaticCurrentPlayerID = ID;
    }

    /**
     * gets the current nonstatic current player id
     * @return the current nonstatic current player id
     */
    public int getNonStaticCurrentPlayerID() {
        return instance.nonStaticCurrentPlayerID;
    }

    /**
     * gets the current market
     * @return the current market
     */
    public static Market getCurrentMarket() {return currentMarket;}

    /**
     * sets the current market
     * @param updatedMarket the current market is set to this param
     */
    public static void setCurrentMarket(Market updatedMarket) {currentMarket = updatedMarket;}

    /**
     * updates the player similar to view models
     * @param player the player to be updated
     */
    public void updatePlayer(Player player) {
        getPlayerInteractor().getAllPlayers().set(currentPlayerID, player);
    }

    /**
     * sets the new player interactor
     * @param newPlayerInt the new player interactor to be put into the map
     */
    private void setPlayerInteractor(PlayerInteractor newPlayerInt) {
        interactorMap.put("Player", newPlayerInt);
    }


    /**
     * Makes a new model singleton instance
     */
    private ModelSingleton() {
        myRepository = new Repository();
        interactorMap = new HashMap<>();
        registerInteractors();
    }

    /**
     * Make a set of interactors to use for the application
     */
    private void registerInteractors() {
        interactorMap.put("Player", new PlayerInteractor(myRepository));
    }

    /**
     * gets the current player interactor
     * @return the current player interactor
     */
    public PlayerInteractor getPlayerInteractor() {
        return (PlayerInteractor) interactorMap.get("Player");
    }

    /**
     * used for serializable implementation
     * @return boolean if it succeeds
     */
    public void loadBinary() {
//        Log.d("LoadTest", "This line was run");
//        boolean success = true;
//        try {
//        /*
//          To read, we must use the ObjectInputStream since we want to read our model in with
//          a single read.
//         */
//            Log.d("LoadTest", "This line was run2");
//            ObjectInputStream in = new ObjectInputStream(file);
//            // assuming we saved our top level object, we read it back in with one line of code.
//            SerializableStorage storage = (SerializableStorage) in.readObject();
//            in.close();
//            file.close();
//
//            ModelSingleton.setCurrentPlayerID(storage.getCurrentID());
//            ModelSingleton.getInstance().setPlayerInteractor(storage.getPlayerInteractor());
//
//        } catch (IOException e) {
//            Log.e("UserManagementFacade", "Error reading an entry from binary file",e);
//            success = false;
//        } catch (ClassNotFoundException e) {
//            Log.e("UserManagementFacade", "Error casting a class from the binary file",e);
//            success = false;
        //}
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference();
//        myRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                // This method is called once with the initial value and again
//                // whenever data at this location is updated.
//                String value = dataSnapshot.getValue(String.class);
//                Log.d("TAG", "Value is: " + value);
//            }
//
//            @Override
//            public void onCancelled(DatabaseError error) {
//                // Failed to read value
//                Log.w("TAG", "Failed to read value.", error.toException());
//            }
//        });

    }

    /**
     * saves the current instance to fire base
     * @param file output file to save on android phone
     * @return boolean if success
     */
    public boolean saveBinary(FileOutputStream file) {

        Log.d("SINGLETON", "saveBinary");
        
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();

        Player player = getPlayerInteractor().getAllPlayers().get(0);
        Player2 player2 = new Player2(player);

        myRef.child("0").child("player1")
                .setValue(player2);

//        myRef.child("1").child("playerUniverse")
//                 .setValue(player.getCurrentUniverse().getSystems());
//        myRef.child("2").child("playerCurrentPlanet")
//                .setValue(player.getCurrentPlanet());

//myRef.child("0").child("playerUniverse").setValue(player.getCurrentUniverse());


        //        ObjectOutputStream out;
//        try {
//            /*
//               For binary, we use Serialization, so everything we write has to implement
//               the Serializable interface.  Fortunately all the collection classes and APi classes
//               that we might use are already Serializable.  You just have to make sure your
//               classes implement Serializable.
//               We have to use an ObjectOutputStream to write objects.
//               One thing to be careful of:  You cannot serialize static data.
//             */
//            // We basically can save our entire data model with one write, since this will follow
//            // all the links and pointers to save everything.  Just save the top level object.\
//            Log.d("save", file.toString());
//            out = new ObjectOutputStream(file);
//            SerializableStorage storage = new SerializableStorage(getPlayerInteractor(),
//                    ModelSingleton.getCurrentPlayerID());
//            //Player savePlayer = getPlayerInteractor().getAllPlayers().get(currentPlayerID);
//            out.writeObject(storage);
//            out.close();
//
//
//            file.close();
//            success = true;
//            /*ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
//            Repository checkRepository = (Repository) in.readObject();
//            in.close();
//            List<Player> checkList = checkRepository.getAllPlayers();
//            String checkString;
//            if (checkList.size() == 0) {
//                checkString = "Size is zero";
//            } else {
//                checkString = checkList.toString();
//                checkString = checkList.get(0).getName();
//            }
//            Log.d("SaveTest", checkString);
//
//        */} catch (IOException e) {
//            Log.d("UserManagerFacade", "Error writing an entry from binary file",e);
//            success = false;
//        }
        /*} catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        */
        return false;
    }
}
