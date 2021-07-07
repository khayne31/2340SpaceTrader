package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Market;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.view_model.PostPlayerScreenViewModel;

/**
 * An activity that contains methods pertaining to the Post player screen
 */
public class PostPlayerScreen extends AppCompatActivity {


    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("DebugScreen", "inside PostPlayerScreen");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_player_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
        int pPoints;
        int ePoints;
        int tPoints;
        int fPoints;
        int credits;
        String name;
        TextView pPtsLabel;
        TextView ePtsLabel;
        TextView tPtsLabel;
        TextView fPtsLabel;
        TextView creditsLabel;
        TextView nameLabel;
        ePtsLabel = findViewById(R.id.engineer_final_pts);
        pPtsLabel = findViewById(R.id.pilot_final_pts);
        tPtsLabel = findViewById(R.id.trader_final_pts);
        fPtsLabel = findViewById(R.id.fighter_final_pts);
        creditsLabel = findViewById(R.id.credits);
        nameLabel = findViewById(R.id.player_label);

        PostPlayerScreenViewModel postVM = ViewModelProviders.of(this).get(PostPlayerScreenViewModel.class);
        player = postVM.getPlayer(ModelSingleton.getCurrentPlayerID());
        pPoints = player.getPilotPoints();
        ePoints = player.getEngineerPoints();
        tPoints = player.getTraderPoints();
        fPoints = player.getFighterPoints();
        credits = player.getCredits();
        name = player.getName();

        pPtsLabel.setText("" + pPoints);
        ePtsLabel.setText("" + ePoints);
        tPtsLabel.setText("" + tPoints);
        fPtsLabel.setText("" + fPoints);
        creditsLabel.setText("" + credits);
        nameLabel.setText("Welcome " + name + "!");

    }

    /**
     * An onClick method that takes you to the screen where the game officially begins.
     * @param view the View of the button
     */
    public void onStartGamePressed(View view){
        Log.d("Test", "Game has Started!");

        ModelSingleton.setCurrentMarket(new Market(player.getCurrentPlanet()));
        startActivity(new Intent(this, PlanetScreen.class));
    }
}
