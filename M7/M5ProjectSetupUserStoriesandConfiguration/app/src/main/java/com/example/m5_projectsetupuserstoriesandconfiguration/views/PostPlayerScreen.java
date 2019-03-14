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
import android.widget.TextView;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.view_model.MainActivityViewModel;
import com.example.m5_projectsetupuserstoriesandconfiguration.view_model.PostPlayerScreenViewModel;

import java.io.Serializable;

public class PostPlayerScreen extends AppCompatActivity implements Serializable {

    //Player player = (Player) getIntent().getSerializableExtra("Player");
    private int pPoints;
    private int ePoints;
    private int tPoints;
    private int fPoints;
    private int credits;
    private TextView pPtsLabel;
    private TextView ePtsLabel;
    private TextView tPtsLabel;
    private TextView fPtsLabel;
    private TextView creditsLabel;
    private PostPlayerScreenViewModel postVM;
    private Player player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("DebugScreen", "inside PostPlayerScreen");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_player_screen);
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

        ePtsLabel = findViewById(R.id.engineer_final_pts);
        pPtsLabel = findViewById(R.id.pilot_final_pts);
        tPtsLabel = findViewById(R.id.trader_final_pts);
        fPtsLabel = findViewById(R.id.fighter_final_pts);
        creditsLabel = findViewById(R.id.credits_label);

        postVM = ViewModelProviders.of(this).get(PostPlayerScreenViewModel.class);
        player = postVM.getPlayer(0);
        pPoints = player.getPilotPoints();
        ePoints = player.getEngineerPoints();
        tPoints = player.getTraderPoints();
        fPoints = player.getFighterPoints();
        credits = player.getCredits();

        pPtsLabel.setText("" + pPoints);
        ePtsLabel.setText("" + ePoints);
        tPtsLabel.setText(""+tPoints);
        fPtsLabel.setText(""+fPoints);
        creditsLabel.setText(""+credits);

    }

    public void onStartGamePressed(View view){
        Log.d("Test", "Game has Started!");
        startActivity(new Intent(this, PlanetScreen.class));
    }
}
