package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;


import com.example.m5_projectsetupuserstoriesandconfiguration.R;

/**
 * An activity that contains methods pertaining to the Main Menu, the opening activity
 */
public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    /**
     * An onClick method that moves to the player create
     * @param view the View of the button
     */
    public void onNewGamePressed(View view){
        startActivity(new Intent(this, MainActivity.class));
        Log.d("Test", "New Game has begun");
    }
    /**
     * An onClick method that moves to the load screen
     * @param view the View of the button
     */
    public void onLoadGamePressed(View view){
        //startActivity(new Intent(this, LoadGame.class));
        Log.d("Test", "Load Game has been Pressed");
        startActivity(new Intent(this, LoadScreen.class));
    }
    /**
     * An onClick method that takes you to the settings activity
     * @param view the View of the button
     */
    public void onSettingsPressed(View view){
        //startActivity(new Intent(this, Settings.class));
        Log.d("Test", "Settings has been pressed");
        startActivity(new Intent(this, Settings.class));
    }

}
