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

public class SpaceGarage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_space_garage);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void onBackPressed(View view) {
        startActivity(new Intent(this, MainMenu.class));
        Log.i("Test", "Returning to Main Menu");
    }
}
