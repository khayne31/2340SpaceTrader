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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


import com.example.m5_projectsetupuserstoriesandconfiguration.R;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Difficulty;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Market;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Planet;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.view_model.MarketBuyScreenViewModel;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.GoodType;

public class MarketScreen extends AppCompatActivity {


    private MarketBuyScreenViewModel buyVM;
    private Player player;
    private Market market;
    private Planet currentPlanet;
    private Spinner itemSpinner;
    private TextView cargoInventory;
    private TextView marketInventory;
    private int numToBuy;
    private int numToSell;
    private GoodType currentGood;
    private TextView numBuyLabel;
    private TextView numSellLabel;
    private Integer currentCargoInventory;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buyVM = ViewModelProviders.of(this).get(MarketBuyScreenViewModel.class);
        player = buyVM.getPlayer(0);
        currentPlanet = player.getCurrentPlanet();
        market = new Market(currentPlanet);

        itemSpinner = findViewById(R.id.good_select);
        ArrayAdapter<GoodType> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GoodType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter(adapter);

        itemSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                currentGood = (GoodType) parent.getItemAtPosition(pos);
                currentCargoInventory = new Integer(player.getMyShip().getGoodList().get(currentGood));
                currentCargoInventory += 5;
                if (currentCargoInventory == null) {
                    currentCargoInventory = 0;
                }
                //market = Market(currentPlanet);
                cargoInventory = findViewById(R.id.cargo_inventory);
                marketInventory = findViewById(R.id.market_inventory);
                numBuyLabel = findViewById(R.id.buy_label);
                numSellLabel = findViewById(R.id.sell_label);
                cargoInventory.setText("" + currentCargoInventory.toString());
                marketInventory.setText("");
            }

            public void onNothingSelected(AdapterView<?> arg0) {
                // TODO Auto-generated method stub

            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }



    public void onBuyPressed(View view) {
        Log.d("Test", "Buy Button has been pressed");
        //good = the type of good you are going to sell
        //num = the number of goods you are going to sell

        //player = market.tradeBuy(player, good, num);
        buyVM.updatePlayer(player);
        numToBuy = 0;
        numToSell = 0;
        numBuyLabel.setText("" + numToBuy);
        numSellLabel.setText("" + numToSell);


        Integer currentCargoInventory = new Integer(player.getMyShip().getGoodList().get(currentGood));
        if (currentCargoInventory == null) {
            currentCargoInventory = 0;
        }

        cargoInventory.setText("" + currentCargoInventory.toString());
        marketInventory.setText("");
    }
    public void onSellPressed(View view) {
        Log.d("Test", "Sell Button has been pressed");
        //good = the type of good you are going to sell
        //num = the number of goods you are going to sell


        //player = market.tradeSell(player, good, num);
        buyVM.updatePlayer(player);



        currentCargoInventory = currentCargoInventory - numToSell;
        numToBuy = 0;
        numToSell = 0;
        numBuyLabel.setText("" + numToBuy);
        numSellLabel.setText("" + numToSell);


        cargoInventory.setText("" + currentCargoInventory.toString());
        marketInventory.setText("");

    }
    public void onBuyPlus(View view) {
        Log.d("Test", "Sell Button has been pressed");

        if (currentCargoInventory > numToBuy) {
            numToBuy++;
            numBuyLabel.setText("" + numToBuy);
        }
    }

    public void onBuyMinus(View view) {
        Log.d("Test", "Sell Button has been pressed");

        if (numToBuy > 0) {
            numToBuy--;
            numBuyLabel.setText("" + numToBuy);
        }
    }

    public void onSellPlus(View view) {
        Log.d("Test", "Sell Button has been pressed");

        if (currentCargoInventory > numToSell) {
            numToSell++;
            numSellLabel.setText("" + numToSell);
        }
    }

    public void onSellMinus(View view) {
        Log.d("Test", "Sell Button has been pressed");

        if (numToSell > 0) {
            numToSell--;
            numSellLabel.setText("" + numToSell);
        }
    }
}
