package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
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

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

    }

    public void onBackPressed(View view) {
        startActivity(new Intent(this, PlanetScreen.class));
        Log.i("Test", "Returning to Planet");
    }

    public void onFuelDepotPressed(View view) {
        startActivity(new Intent(this, FuelDepot.class));
        Log.i("Test", "Going to Fuel Depot");
    }

    public void onEquipmentHangarPressed(View view) {
        startActivity(new Intent(this, EquipmentHangar.class));
        Log.i("Test", "Going to Equipment Hangar");
    }
}
