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

import com.example.m5_projectsetupuserstoriesandconfiguration.R;

public class REAlien extends AppCompatActivity {

    private static final int DELAY = 6500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realien);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        showButtons();
    }
    /**
     * An method that shows the button after a slight delay (when the animation ends)
     */
    private void showButtons() {
        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                (findViewById(R.id.continue_button)).setVisibility(View.VISIBLE);
            }
        }, DELAY);
    }

    /**
     * An onClick method that continues to the next screen on the new planet
     * @param view the View of the button
     */
    public void onContinuePressed(View view) {
        startActivity(new Intent(this, PlanetScreen.class));
        Log.i("Test", "Continuing to new Planet");
    }

}
