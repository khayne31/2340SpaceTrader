package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;

public class RENone extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renone);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        showButtons();
    }
    private Handler handler;

    private void showButtons() {
        handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                (findViewById(R.id.continue_button)).setVisibility(View.VISIBLE);
            }
        }, 6500);
    }

    public void onContinuePressed(View view) {
        startActivity(new Intent(this, PlanetScreen.class));
        Log.i("Test", "Continuing to new Planet");
    }

}
