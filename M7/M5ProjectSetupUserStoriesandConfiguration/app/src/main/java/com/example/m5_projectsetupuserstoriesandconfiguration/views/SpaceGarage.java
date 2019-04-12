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
 * An activity that contains methods pertaining to the Space Garage
 */
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

    /**
     * An onClick method that takes you back to the previous screen
     * @param view the View of the button
     */
    public void onBackPressed(View view) {
        startActivity(new Intent(this, PlanetScreen.class));
        Log.i("Test", "Returning to Planet");
    }

    /**
     * An onClick method that takes the player to the fuel depot
     * @param view the View of the button
     */
    public void onFuelDepotPressed(View view) {
        startActivity(new Intent(this, FuelDepot.class));
        Log.i("Test", "Going to Fuel Depot");
    }

    /**
     * An onClick method that takes the player to the equipment hangar
     * @param view the View of the button
     */
    public void onEquipmentHangarPressed(View view) {
        startActivity(new Intent(this, EquipmentHangar.class));
        Log.i("Test", "Going to Equipment Hangar");
    }
}
