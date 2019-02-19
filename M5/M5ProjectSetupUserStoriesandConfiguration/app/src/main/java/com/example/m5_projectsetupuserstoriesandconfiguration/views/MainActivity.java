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
<<<<<<< HEAD
import android.widget.TextView;
=======
import android.widget.Spinner;
>>>>>>> 7aec2675a547053f2edc0237f788576a986d615a

import com.example.m5_projectsetupuserstoriesandconfiguration.R;

public class MainActivity extends AppCompatActivity {


    private EditText nameField;
<<<<<<< HEAD
    private TextView fighterptslabel;
    private TextView engineerptslabel;
    private TextView pilotptslabel;
    private TextView traderptslabel;
    private int fighterpts = 0;
    private int traderpts = 0;
    private int pilotpts = 0;
    private int engineerpts = 0;
=======
    private Spinner spinner;
>>>>>>> 7aec2675a547053f2edc0237f788576a986d615a
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
<<<<<<< HEAD
        engineerptslabel = findViewById(R.id.engineer_pts);
        traderptslabel = findViewById(R.id.engineer_pts);
        pilotptslabel = findViewById(R.id.pilot_pts);
        fighterptslabel = findViewById(R.id.fighter_pts);
=======
        Button plusPilot = findViewById(R.id.button_pilot_add);
        Button minusPilot = findViewById(R.id.button_pilot_rm);
        Button plusEngin = findViewById(R.id.button_engineer_add);
        Button minusEngin = findViewById(R.id.button_engineer_rm);
        Button plusFighter = findViewById(R.id.button_fighter_add);
        Button minusFighter = findViewById(R.id.button_fighter_rm);
        Button plusTrader = findViewById(R.id.button_trader_add);
        Button minusTrader = findViewById(R.id.button_trader_rm);
>>>>>>> 7aec2675a547053f2edc0237f788576a986d615a
        nameField = findViewById(R.id.name_input);
    }

    public void onFightPtsAddPressed(View view){
        fighterpts++;
        fighterptslabel.setText(fighterpts + "");
    }
    public void onFightPtsMinusPressed(View view){
        fighterpts--;
        fighterptslabel.setText(fighterpts+"");
    }
    public void onEngineerPtsMinusPressed(View view){
        engineerpts--;
        engineerptslabel.setText(engineerpts+"");
    }

    public void onEngineerPtsAddPressed(View view){
        engineerpts++;
        engineerptslabel.setText(engineerpts+"");
    }

    
    public void onSavePressed(View view){
        Log.d("Test", "Button has been pressed");
        Log.d("Test", nameField.getText().toString());
        fighterptslabel.setText("2");
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
