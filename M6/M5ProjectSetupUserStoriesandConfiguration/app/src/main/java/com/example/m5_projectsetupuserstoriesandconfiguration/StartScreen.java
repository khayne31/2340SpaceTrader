package com.example.m5_projectsetupuserstoriesandconfiguration;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.m5_projectsetupuserstoriesandconfiguration.views.MainActivity;
import com.example.m5_projectsetupuserstoriesandconfiguration.views.PostPlayerScreen;

public class StartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("DebugScreen", "inside StartScreen");
        setContentView(R.layout.activity_start_screen);
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
    }

    public void onStartPressed(View view){
        startActivity(new Intent(this, MainActivity.class));
        Log.d("Test", "Start Button has been pressed");
    }



}
