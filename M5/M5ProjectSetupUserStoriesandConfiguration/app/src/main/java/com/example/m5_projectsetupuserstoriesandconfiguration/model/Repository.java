package com.example.m5_projectsetupuserstoriesandconfiguration.model;

import android.util.Log;

import com.example.m5_projectsetupuserstoriesandconfiguration.entity.User;

import java.util.ArrayList;
import java.util.List;


public class Repository {

    private static int next_id = 1;

    private static int getNextUniqueID() {return next_id++;}

    private List<User> allUsers;


    /**
     * Make a new Repository object
     */
    public Repository() {
        allUsers = new ArrayList<>();

    }


    /**
     * Return all the Users in the system
     */
    public List<User> getAllUsers() {return allUsers;}

    /**add a new user to the system
     *
     * @param user the user to add
     */

    public void addUser(User user) {
        user.setId(Repository.getNextUniqueID());
        allUsers.add(user);

    }
}
