package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Difficulty;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.User;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    private EditText nameField;
    private TextView fighterptslabel;
    private TextView engineerptslabel;
    private TextView pilotptslabel;
    private TextView traderptslabel;
    private TextView pointcountLabel;
    private int fighterpts = 0;
    private int traderpts = 0;
    private int pilotpts = 0;
    private int engineerpts = 0;
    private int pointcount = 16;
    private String name;
    private Spinner difSpinner;
    private Difficulty diff;


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


        engineerptslabel = findViewById(R.id.engineer_pts);
        traderptslabel = findViewById(R.id.trader_pts);
        pilotptslabel = findViewById(R.id.pilot_pts);
        fighterptslabel = findViewById(R.id.fighter_pts);
        difSpinner = findViewById(R.id.diff_select);
        nameField = findViewById(R.id.name_input);
        pointcountLabel = findViewById(R.id.point_count); //display how many points you have left at the top of the screen


        ArrayAdapter<Difficulty> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, Difficulty.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        difSpinner.setAdapter(adapter);


    }
    //** ADD AND SUBTRACT POINTS BUTTONS **//
    public void onPilotAddPressed(View view){
        Log.d("Test", "Pilot Add Button has been pressed");
        //pilotpts = ( pilotpts + engineerpts + fighterpts + traderpts < 16 ? pilotpts + 1: pilotpts);
        if (pilotpts + engineerpts + fighterpts + traderpts < 16) {
            pilotpts++;
            pointcount--;
        }
        pilotptslabel.setText(pilotpts +"");
        pointcountLabel.setText(pointcount + "");
        //finish();
    }

    public void onPilotSubtractPressed(View view){
        Log.d("Test", "Pilot Subtract Button has been pressed");
        //pilotpts = ( pilotpts == 0 ? pilotpts: pilotpts - 1);
        if (pilotpts > 0) {
            pilotpts--;
            pointcount++;
        }
        pilotptslabel.setText(pilotpts+"");
        pointcountLabel.setText(pointcount + "");
        //finish();
    }

    public void onEngineerAddPressed(View view){
        Log.d("Test", "Engineer Add Button has been pressed");
        //engineerpts = ( pilotpts + engineerpts + fighterpts + traderpts < 16 ? engineerpts + 1: engineerpts);
        if (pilotpts + engineerpts + fighterpts + traderpts < 16) {
            engineerpts++;
            pointcount--;
        }
        engineerptslabel.setText(engineerpts+ "");
        pointcountLabel.setText(pointcount + "");
        //finish();
    }

    public void onEngineerSubtractPressed(View view){
        Log.d("Test", "Engineer Subtract Button has been pressed");
        //engineerpts = ( engineerpts == 0 ? engineerpts: engineerpts - 1);
        if (engineerpts > 0) {
            engineerpts--;
            pointcount++;
        }
        engineerptslabel.setText(engineerpts +"");
        pointcountLabel.setText(pointcount + "");
        //finish();
    }

    public void onTraderAddPressed(View view){
        Log.d("Test", "Trader Add Button has been pressed");
        //traderpts = ( pilotpts + engineerpts + fighterpts + traderpts < 16 ? traderpts + 1: traderpts);
        if (pilotpts + engineerpts + fighterpts + traderpts < 16) {
            traderpts++;
            pointcount--;
        }
        traderptslabel.setText(traderpts +"");
        pointcountLabel.setText(pointcount + "");
        //finish();
    }
    public void onTraderSubtractPressed(View view){
        Log.d("Test", "Trader Subtract Button has been pressed");
        //traderpts = ( traderpts == 0 ? traderpts: traderpts - 1);
        if (traderpts > 0){
            traderpts--;
            pointcount++;
        }
        traderptslabel.setText(traderpts +"");
        pointcountLabel.setText(pointcount+ "");
        //finish();
    }
    public void onFighterAddPressed(View view){
        Log.d("Test", "Fighter Add Button has been pressed");
        //fighterpts = ( pilotpts + engineerpts + fighterpts + traderpts < 16 ? fighterpts + 1: fighterpts);
        if (pilotpts + engineerpts + fighterpts + traderpts < 16) {
            fighterpts++;
            pointcount--;
        }
        fighterptslabel.setText(fighterpts +"");
        pointcountLabel.setText(pointcount+"");
        //finish();
    }
    public void onFighterSubtractPressed(View view){
        Log.d("Test", "Fighter Subtract Button has been pressed");
        //fighterpts = ( fighterpts == 0 ? fighterpts: fighterpts - 1);
        if (fighterpts > 0) {
            fighterpts--;
            pointcount++;
        }
        fighterptslabel.setText(fighterpts+"");
        pointcountLabel.setText(pointcount+"");
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

    public void onCreatePlayerPressed(View view){
        Log.d("Test", "Create Player Button has been pressed");
        /*
        if (name.equals("")) {     //FIX THIS ITS NOT DISPLAYING IF THERES NO INPUT
            Toast.makeText(this, "You did not enter a name", Toast.LENGTH_SHORT).show();
        }
        */
        if (fighterpts + pilotpts + engineerpts + traderpts == 16) {
            User newUser = new User(name, fighterpts, traderpts, engineerpts, pilotpts, diff);
            Log.d("Test", "New player successfully created!");
            Toast.makeText(this, "New Player Created", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(this, "You did not use all of your points", Toast.LENGTH_SHORT).show();
        }
        //finish();
    }
}
