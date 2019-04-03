package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    public void onNewGamePressed(View view){
        startActivity(new Intent(this, MainActivity.class));
        Log.d("Test", "New Game has begun");
    }
    public void onLoadGamePressed(View view){
        //startActivity(new Intent(this, LoadGame.class));
        Log.d("Test", "Load Game has been Pressed");
        startActivity(new Intent(this, LoadScreen.class));
    }
    public void onSettingsPressed(View view){
        //startActivity(new Intent(this, Settings.class));
        Log.d("Test", "Settings has been pressed");
        startActivity(new Intent(this, Settings.class));
    }

}
