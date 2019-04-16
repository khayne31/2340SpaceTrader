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
import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;
import com.example.m5_projectsetupuserstoriesandconfiguration.view_model.PlanetScreenViewModel;
import java.io.FileOutputStream;

/**
 * An activity that contains methods pertaining to the Planet Screen
 */
public class PlanetScreen extends AppCompatActivity {
    private PlanetScreenViewModel planetVM;
    //public static final String ARG_ITEM_ID = "item_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_planet_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        planetVM = ViewModelProviders.of(this).get(PlanetScreenViewModel.class);
        Player player = planetVM.getPlayer(ModelSingleton.getCurrentPlayerID());
        //cannot get the player when loading
        Planet currentPlanet = player.getCurrentPlanet();
        TextView planetNameLabel = findViewById(R.id.planet_title);
        String planetName = currentPlanet.getName();
        planetNameLabel.setText(planetName);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    /**
     * An onClick method that takes the player to the space garage screen
     * @param view the View of the button
     */
    public void onSpaceGaragePressed(View view){
        Log.d("Test", "Space Garage Button has been pressed");
        startActivity(new Intent(this, SpaceGarage.class));
    }

    /**
     * An onClick method that takes the player to the market screen
     * @param view the View of the button
     */
    public void onMarketPressed(View view){
        Log.d("Test", "Market Button has been pressed");
        startActivity(new Intent(this, MarketScreen.class));
    }

    /**
     * An onClick method that takes the player to the navigation screen
     * @param view the View of the button
     */
    public void onTravelPressed(View view){
        Log.d("Test", "Travel Button has been pressed");
        startActivity(new Intent(this, Navigation.class));
    }

    /**
     * An onClick method that takes the player back to the main menu
     * @param view the View of the button
     */
    public void onMainMenuPressed(View view){
        Log.d("Test", "Main Menu Button has been pressed");
        startActivity(new Intent(this, MainMenu.class));
    }

    /**
     * An onClick method that saves the current game
     * @param view the View of the button
     */
    public void onSavePressed(View view) {//CANNOT HAVE A BOOLEAN AS A BUTTON METHOD

        boolean returnableBool = planetVM.saveBinary();
        if (returnableBool) {
            Toast.makeText(this, "Player was saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Player was not saved", Toast.LENGTH_SHORT).show();

        }
        //return returnableBool;
    }
}
