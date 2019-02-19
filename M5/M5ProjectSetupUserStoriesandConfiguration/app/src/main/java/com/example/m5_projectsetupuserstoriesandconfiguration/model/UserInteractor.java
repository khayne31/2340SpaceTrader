package com.example.m5_projectsetupuserstoriesandconfiguration.model;

import android.util.Log;

import java.util.List;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.User;

/**
 * Provides the operations associated with the User entity
 * Relates the Model and the UI
 *
 */
public class UserInteractor extends Interactor {

    public UserInteractor(Repository repo) {super(repo);}

    public List<User> getAllUsers() {return getRepository().getAllUsers();}

    public void addUser (User u) { getRepository().addUser(u);}


}
