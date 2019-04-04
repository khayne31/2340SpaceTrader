package com.example.m5_projectsetupuserstoriesandconfiguration.model;

import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.List;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;

/**
 * Provides the operations associated with the User entity
 * Relates the Model and the UI
 *
 */
public class PlayerInteractor extends Interactor {

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


    public boolean loadBinary(File file) {
        boolean success = true;
        try {
        /*
          To read, we must use the ObjectInputStream since we want to read our model in with
          a single read.
         */
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
            // assuming we saved our top level object, we read it back in with one line of code.
            theRepository = (Repository) in.readObject();
            theRepository.regenList();
            in.close();
        } catch (IOException e) {
            Log.e("UserManagementFacade", "Error reading an entry from binary file",e);
            success = false;
        } catch (ClassNotFoundException e) {
            Log.e("UserManagementFacade", "Error casting a class from the binary file",e);
            success = false;
        }

        return success;
    }

    public boolean saveBinary(File file) {
        boolean success = true;
        try {
            /*
               For binary, we use Serialization, so everything we write has to implement
               the Serializable interface.  Fortunately all the collection classes and APi classes
               that we might use are already Serializable.  You just have to make sure your
               classes implement Serializable.

               We have to use an ObjectOutputStream to write objects.

               One thing to be careful of:  You cannot serialize static data.
             */


            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
            // We basically can save our entire data model with one write, since this will follow
            // all the links and pointers to save everything.  Just save the top level object.
            out.writeObject(theRepository);
            out.close();

        } catch (IOException e) {
            Log.e("UserManagerFacade", "Error writing an entry from binary file",e);
            success = false;
        }
        return success;
    }


    public boolean loadText(File file) {
        try {
            //make an input object for reading
            BufferedReader reader = new BufferedReader(new FileReader(file));
            theRepository.loadFromText(reader);

        } catch (FileNotFoundException e) {
            Log.e("ModelSingleton", "Failed to open text file for loading!");
            return false;
        }

        return true;
    }

    public boolean saveText(File file) {
        System.out.println("Saving as a text file");
        try {
            PrintWriter pw = new PrintWriter(file);
            theRepository.saveAsText(pw);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Log.d("UserManagerFacade", "Error opening the text file for save!");
            return false;
        }

        return true;
    }


}
