package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Planet;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.RandomEvent;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Ship;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.view_model.MarketBuyScreenViewModel;

/**
 * An activity that contains methods pertaining to the MarketScreen
 */
public class Navigation extends AppCompatActivity {

    private Spinner planetSpinner;
    private MarketBuyScreenViewModel buyVM;
    private Player player;
    private Ship playerShip;
    private Planet currentPlanet;
    private Planet destinationPlanet;
    private TextView planetNameLabel;
    private TextView currentFuelLabel;
    private TextView requiredFuelLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        buyVM = ViewModelProviders.of(this).get(MarketBuyScreenViewModel.class);
        player = buyVM.getPlayer(ModelSingleton.getInstance().getCurrentPlayerID());
        playerShip = player.getMyShip();
        currentPlanet = player.getCurrentPlanet();
        planetNameLabel = findViewById(R.id.planet_title);
        currentFuelLabel = findViewById(R.id.fuel_label);
        requiredFuelLabel = findViewById(R.id.required_fuel_label);


        planetNameLabel.setText(currentPlanet.getName());
        currentFuelLabel.setText(Integer.toString(playerShip.getFuel()));




        planetSpinner = findViewById(R.id.planet_select);
        ArrayAdapter<Planet> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, player.visitablePlanets());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        planetSpinner.setAdapter(adapter);

        planetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                destinationPlanet = (Planet) parent.getItemAtPosition(pos);
                requiredFuelLabel.setText(
                        Integer.toString(player.getFuelRequired(destinationPlanet)));
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

    }

    /**
     * An onClick method that returns the player to the previous screen
     * @param view the View of the button
     */
    public void onBackPressed(View view){
        Log.d("Test", "Back Button has been pressed");
        startActivity(new Intent(this, PlanetScreen.class));
    }

    /**
     * An onClick method that moves the planet the player is currently on to the one selected
     * @param view the View of the button
     */
    public void onTravelPressed(View view){
        Log.d("Test", "Travel Button has been pressed");
        RandomEvent.events newEvent = player.travelToPlanet(destinationPlanet);
        buyVM.updatePlayer(player);
        Toast.makeText(this, newEvent.getEventDescription(), Toast.LENGTH_LONG).show();
        //startActivity(new Intent(this, PlanetScreen.class));
        //String event = newEvent.getEventName();
        switch (newEvent.getEventName()){
            case "Wormhole":
                startActivity(new Intent(this, RENone.class));
                break;
            case "Bad Navigation":
                startActivity(new Intent(this, RENone.class));
                break;
            case "Asteroid Field":
                startActivity(new Intent(this, RENone.class));
                break;
            case "Space Pirates":
                startActivity(new Intent(this, RENone.class));
                break;
            case "Crew Death":
                startActivity(new Intent(this, RENone.class));
                break;
            case "Travellers":
                startActivity(new Intent(this, RENone.class));
                break;
            case "Ship Upgrade":
                startActivity(new Intent(this, RENone.class));
                break;
            case "Alien Abduction":
                startActivity(new Intent(this, RENone.class));
                break;
            case "Enemy Attack":
                startActivity(new Intent(this, RENone.class));
                break;
            case "Space Tariffs":
                startActivity(new Intent(this, RENone.class));
                break;
            case "Big Space Monster":
                startActivity(new Intent(this, RENone.class));
                break;
            case "Small Space Monster":
                startActivity(new Intent(this, RENone.class));
                break;
            case "Fuel Leak":
                startActivity(new Intent(this, RENone.class));
                break;
            case "Nothing Happened":
                startActivity(new Intent(this, RENone.class));
                break;
            case "Star Gate":
                startActivity(new Intent(this, RENone.class));
                break;
        }
    }

}
