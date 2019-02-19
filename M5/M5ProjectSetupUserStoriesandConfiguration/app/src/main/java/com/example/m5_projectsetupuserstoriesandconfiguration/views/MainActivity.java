package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;

public class MainActivity extends AppCompatActivity {


    private EditText nameField;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

        Button button = findViewById(R.id.button_name);
        Button plusPilot = findViewById(R.id.button_pilot_add);
        Button minusPilot = findViewById(R.id.button_pilot_rm);
        Button plusEngin = findViewById(R.id.button_engineer_add);
        Button minusEngin = findViewById(R.id.button_engineer_rm);
        Button plusFighter = findViewById(R.id.button_fighter_add);
        Button minusFighter = findViewById(R.id.button_fighter_rm);
        Button plusTrader = findViewById(R.id.button_trader_add);
        Button minusTrader = findViewById(R.id.button_trader_rm);
        nameField = findViewById(R.id.name_input);
    }


    public void onSavePressed(View view){
        Log.d("Test", "Save Button has been pressed");
        Log.d("Test", nameField.getText().toString());
        //finish();
    }

    public void onPilotAddPressed(View view){
        Log.d("Test", "Pilot Add Button has been pressed");
        //finish();
    }

    public void onPilotSubtractPressed(View view){
        Log.d("Test", "Pilot Subtract Button has been pressed");
        //finish();
    }

    public void onEngineerAddPressed(View view){
        Log.d("Test", "Engineer Add Button has been pressed");
        //finish();
    }

    public void onEngineerSubtractPressed(View view){
        Log.d("Test", "Engineer Subtract Button has been pressed");
        //finish();
    }

    public void onTraderAddPressed(View view){
        Log.d("Test", "Trader Add Button has been pressed");
        //finish();
    }
    public void onTraderSubtractPressed(View view){
        Log.d("Test", "Trader Subtract Button has been pressed");
        //finish();
    }
    public void onFighterAddPressed(View view){
        Log.d("Test", "Fighter Add Button has been pressed");
        //finish();
    }
    public void onFighterSubtractPressed(View view){
        Log.d("Test", "Fighter Subtract Button has been pressed");
        //finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
