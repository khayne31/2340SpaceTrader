package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;

public class MainMenu extends AppCompatActivity {

    AnimationDrawable menuAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        /*
        ImageView menuImage = (ImageView) findViewById(R.id.main_screen);
        menuImage.setBackgroundResource(R.drawable.mainscreenanimation);
        menuAnimation = (AnimationDrawable) menuImage.getBackground();
        menuImage.setVisibility(View.VISIBLE);

        menuImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menuAnimation.start();
            }
        });
        */
    }

    public void onNewGamePressed(View view){
        startActivity(new Intent(this, MainActivity.class));
        Log.d("Test", "New Game has begun");
    }
    public void onLoadGamePressed(View view){
        //startActivity(new Intent(this, LoadGame.class));
        Log.d("Test", "Load Game has been Pressed");
    }
    public void onSettingsPressed(View view){
        //startActivity(new Intent(this, Settings.class));
        Log.d("Test", "Settings has been pressed");
    }

}
