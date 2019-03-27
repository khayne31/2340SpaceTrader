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
import android.widget.Toast;


import com.example.m5_projectsetupuserstoriesandconfiguration.R;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Difficulty;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Market;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Planet;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
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
    private TextView creditsLabel;
    private TextView priceLabel;
    private Integer currentCargoInventory;
    private Integer currentMarketInventory;
    private Integer currentPrice;
    private Integer currentCredits;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buyVM = ViewModelProviders.of(this).get(MarketBuyScreenViewModel.class);
        player = buyVM.getPlayer(ModelSingleton.getInstance().getCurrentPlayerID());
        currentPlanet = player.getCurrentPlanet();
        market = currentPlanet.getMarket();

        itemSpinner = findViewById(R.id.good_select);
        ArrayAdapter<GoodType> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, GoodType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter(adapter);

        itemSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                currentGood = (GoodType) parent.getItemAtPosition(pos);
                currentCredits = player.getCredits();
                currentPrice = market.getTradeGoodPrice(currentGood);
                currentCargoInventory = new Integer(player.getMyShip().getGoodList().get(currentGood));
                if (currentCargoInventory == null) {
                    currentCargoInventory = 0;
                }

                currentMarketInventory = new Integer(market.getTradeGoodQuantity(currentGood));
                if (currentMarketInventory == null) {
                    currentMarketInventory = 0;
                }

                cargoInventory = findViewById(R.id.cargo_inventory);
                marketInventory = findViewById(R.id.market_inventory);
                numBuyLabel = findViewById(R.id.buy_label);
                numSellLabel = findViewById(R.id.sell_label);
                creditsLabel = findViewById(R.id.credits_label);
                priceLabel = findViewById(R.id.price_label);


                cargoInventory.setText("" + currentCargoInventory.toString());
                marketInventory.setText("" + currentMarketInventory);
                creditsLabel.setText ("" + currentCredits);
                priceLabel.setText("" + currentPrice);
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
        String toastString = market.tradeBuy(player, currentGood, numToBuy);
        Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show();
        buyVM.updatePlayer(player);
        currentCredits = player.getCredits();
        creditsLabel.setText("" + currentCredits);


        numToBuy = 0;
        numToSell = 0;
        numBuyLabel.setText("" + numToBuy);
        numSellLabel.setText("" + numToSell);



        currentCargoInventory = new Integer(player.getMyShip().getGoodList().get(currentGood));
        if (currentCargoInventory == null) {
            currentCargoInventory = 0;
        }
        currentMarketInventory = new Integer(market.getTradeGoodQuantity(currentGood));
        if (currentMarketInventory == null) {
            currentMarketInventory = 0;
        }

        cargoInventory.setText("" + currentCargoInventory.toString());
        marketInventory.setText("" + currentMarketInventory);
    }
    public void onSellPressed(View view) {
        Log.d("Test", "Sell Button has been pressed");
        String toastString = market.tradeSell(player, currentGood, numToSell);
        Log.d("Test", "tradeSell was executed");
        Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show();

        buyVM.updatePlayer(player);
        currentCredits = player.getCredits();
        creditsLabel.setText("" + currentCredits);
        numToBuy = 0;
        numToSell = 0;
        numBuyLabel.setText("" + numToBuy);
        numSellLabel.setText("" + numToSell);


        currentCargoInventory = new Integer(player.getMyShip().getGoodList().get(currentGood));
        if (currentCargoInventory == null) {
            currentCargoInventory = 0;
        }
        currentMarketInventory = new Integer(market.getTradeGoodQuantity(currentGood));
        if (currentMarketInventory == null) {
            currentMarketInventory = 0;
        }
        cargoInventory.setText("" + currentCargoInventory.toString());
        marketInventory.setText("" + currentMarketInventory);

    }
    public void onBuyPlus(View view) {
        Log.d("Test", "Sell Button has been pressed");

        if (currentMarketInventory > numToBuy) {
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
