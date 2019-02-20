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
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Difficulty;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    private EditText nameField;
    private TextView fighterptslabel;
    private TextView engineerptslabel;
    private TextView pilotptslabel;
    private TextView traderptslabel;
    private int fighterpts = 0;
    private int traderpts = 0;
    private int pilotpts = 0;
    private int engineerpts = 0;
    private Spinner difSpinner;
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

        engineerptslabel = findViewById(R.id.engineer_pts);
        traderptslabel = findViewById(R.id.trader_pts);
        pilotptslabel = findViewById(R.id.pilot_pts);
        fighterptslabel = findViewById(R.id.fighter_pts);
<<<<<<< HEAD
        nameField = findViewById(R.id.name_input);
=======

        nameField = findViewById(R.id.name_input);


>>>>>>> a683f64cbf80b60001b7477a2c200c66bd13fc79

        /*ArrayAdapter<Difficulty> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Arrays.asList(Difficulty.values()));
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
<<<<<<< HEAD
        difSpinner.setAdapter(adapter2); */
=======
        difSpinner.setAdapter(adapter2);
>>>>>>> a683f64cbf80b60001b7477a2c200c66bd13fc79

    }


    
    public void onSavePressed(View view){
        Log.d("Test", "Save Button has been pressed");
        Log.d("Test", nameField.getText().toString());
        //finish();
    }

    public void onPilotAddPressed(View view){
        Log.d("Test", "Pilot Add Button has been pressed");
        pilotpts = ( pilotpts + engineerpts + fighterpts + traderpts < 16 ? pilotpts + 1: pilotpts);
        pilotptslabel.setText(pilotpts +"");
        //finish();
    }

    public void onPilotSubtractPressed(View view){
        Log.d("Test", "Pilot Subtract Button has been pressed");
        pilotpts = ( pilotpts == 0 ? pilotpts: pilotpts - 1);
        pilotptslabel.setText(pilotpts+"");
        //finish();
    }

    public void onEngineerAddPressed(View view){
        Log.d("Test", "Engineer Add Button has been pressed");
        engineerpts = ( pilotpts + engineerpts + fighterpts + traderpts < 16 ? engineerpts + 1: engineerpts);
        engineerptslabel.setText(engineerpts+ "");
        //finish();
    }

    public void onEngineerSubtractPressed(View view){
        Log.d("Test", "Engineer Subtract Button has been pressed");
        engineerpts = ( engineerpts == 0 ? engineerpts: engineerpts - 1);
        engineerptslabel.setText(engineerpts +"");
        //finish();
    }

    public void onTraderAddPressed(View view){
        Log.d("Test", "Trader Add Button has been pressed");
        traderpts = ( pilotpts + engineerpts + fighterpts + traderpts < 16 ? traderpts + 1: traderpts);;
        traderptslabel.setText(traderpts +"");
        //finish();
    }
    public void onTraderSubtractPressed(View view){
        Log.d("Test", "Trader Subtract Button has been pressed");
        traderpts = ( traderpts == 0 ? traderpts: traderpts - 1);
        traderptslabel.setText(traderpts +"");
        //finish();
    }
    public void onFighterAddPressed(View view){
        Log.d("Test", "Fighter Add Button has been pressed");
        fighterpts = ( pilotpts + engineerpts + fighterpts + traderpts < 16 ? fighterpts + 1: fighterpts);
        fighterptslabel.setText(fighterpts +"");
        //finish();
    }
    public void onFighterSubtractPressed(View view){
        Log.d("Test", "Fighter Subtract Button has been pressed");
        fighterpts = ( fighterpts == 0 ? fighterpts: fighterpts - 1);
        fighterptslabel.setText(fighterpts+"");
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
