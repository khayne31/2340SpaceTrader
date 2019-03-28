package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.GoodType;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Planet;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.view_model.MarketBuyScreenViewModel;

public class Navigation extends AppCompatActivity {

    private Spinner planetSpinner;
    private MarketBuyScreenViewModel buyVM;
    private Player player;
    private Planet currentPlanet;
    private Planet destinationPlanet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buyVM = ViewModelProviders.of(this).get(MarketBuyScreenViewModel.class);
        player = buyVM.getPlayer(ModelSingleton.getInstance().getCurrentPlayerID());
        currentPlanet = player.getCurrentPlanet();


        planetSpinner = findViewById(R.id.planet_select);
        //Need to change this so its a list of planets
        ArrayAdapter<Planet> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, player.visitablePlanets());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        planetSpinner.setAdapter(adapter);

        planetSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                destinationPlanet = (Planet) parent.getItemAtPosition(pos);
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public void onBackPressed(View view){
        Log.d("Test", "Back Button has been pressed");
        startActivity(new Intent(this, PlanetScreen.class));
    }

    public void onTravelPressed(View view){
        Log.d("Test", "Travel Button has been pressed");
        player.setCurrentPlanet(destinationPlanet);
        buyVM.updatePlayer(player);
        startActivity(new Intent(this, PlanetScreen.class));
    }

}
