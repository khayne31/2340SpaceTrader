package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Planet;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.view_model.PlanetScreenViewModel;
import com.example.m5_projectsetupuserstoriesandconfiguration.view_model.SaveActivityViewModel;
import java.io.FileOutputStream;

public class PlanetScreen extends AppCompatActivity {
    private String planetName;
    private Player player;
    private PlanetScreenViewModel planetVM;
    private Planet currentPlanet;
    private TextView planetNameLabel;
    private SaveActivityViewModel saveVM;
    public static final String ARG_ITEM_ID = "item_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_planet_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        planetVM = ViewModelProviders.of(this).get(PlanetScreenViewModel.class);
        player = planetVM.getPlayer(ModelSingleton.getInstance().getCurrentPlayerID());
        //cannot get the player when loading
        currentPlanet = player.getCurrentPlanet();
        planetNameLabel = findViewById(R.id.planet_title);
        planetName = currentPlanet.getName();
        planetNameLabel.setText(planetName);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }
    public void onSpaceGaragePressed(View view){
        Log.d("Test", "Space Garage Button has been pressed");
        startActivity(new Intent(this, SpaceGarage.class));
    }
    public void onMarketPressed(View view){
        Log.d("Test", "Market Button has been pressed");
        startActivity(new Intent(this, MarketScreen.class));
    }
    public void onTravelPressed(View view){
        Log.d("Test", "Travel Button has been pressed");
        startActivity(new Intent(this, Navigation.class));
    }
    public void onMainMenuPressed(View view){
        Log.d("Test", "Main Menu Button has been pressed");
        startActivity(new Intent(this, MainMenu.class));
    }

    public void onSavePressed(View view) {//CANNOT HAVE A BOOLEAN AS A BUTTON METHOD
        String fileName;
        FileOutputStream out;
        fileName =  planetVM.getDefaultBinaryStringName();
        try {
            out = openFileOutput(fileName, Context.MODE_PRIVATE);
            Log.d("save", fileName);
        } catch (Exception e) {
            Log.d("save", "failed");
            out = null;
        }


        Boolean returnableBool = planetVM.saveBinary(out);
        if (returnableBool) {
            Toast.makeText(this, "Player was saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Player was not saved", Toast.LENGTH_SHORT).show();

        }
        //return returnableBool;
    }
}
