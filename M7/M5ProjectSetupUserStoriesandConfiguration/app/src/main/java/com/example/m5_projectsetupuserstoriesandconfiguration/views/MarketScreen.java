package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
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
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Market;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Planet;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.ModelSingleton;
import com.example.m5_projectsetupuserstoriesandconfiguration.view_model.MarketBuyScreenViewModel;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.GoodType;
/**
 * An activity that contains methods pertaining to the MarketScreen
 */
public class MarketScreen extends AppCompatActivity {


    private MarketBuyScreenViewModel buyVM;
    private Player player;
    private Market market;
    private TextView cargoInventory;
    private TextView marketInventory;
    private int numToBuy;
    private int numToSell;
    private GoodType currentGood;
    private TextView numBuyLabel;
    private TextView numSellLabel;
    private TextView creditsLabel;
    private TextView priceLabel;
    private TextView currentTotalCargoLabel;
    private Integer currentCargoInventory;
    private Integer currentTotalCargo;
    private Integer currentMarketInventory;
    private Integer currentPrice;
    private Integer currentCredits;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_market_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        buyVM = ViewModelProviders.of(this).get(MarketBuyScreenViewModel.class);
        player = buyVM.getPlayer(ModelSingleton.getCurrentPlayerID());
        Planet currentPlanet = player.getCurrentPlanet();
        market = currentPlanet.getMarket();

        TextView maxCargoLabel = findViewById(R.id.MaxCargo_label);
        currentTotalCargoLabel = findViewById(R.id.CurrentTotalCargo_label);
        currentTotalCargo = Integer.valueOf(player.getMyShip().getCurrCargoSize());
        if(currentTotalCargo == null) {
            currentTotalCargo = 0;
        }
        currentTotalCargoLabel.setText("" + currentTotalCargo.toString());

        Log.d("onCreate", "screen init");
        maxCargoLabel.setText(Integer.toString(player.getMyShip().getType().getMaxCargo()));

        Spinner itemSpinner = findViewById(R.id.good_select);
        ArrayAdapter<GoodType> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, GoodType.values());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itemSpinner.setAdapter(adapter);

        itemSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {
                currentGood = (GoodType) parent.getItemAtPosition(pos);
                currentCredits = player.getCredits();
                currentPrice = market.getTradeGoodPrice(currentGood);
                currentCargoInventory = Integer.valueOf(
                        player.getMyShip().getGoodList().get(currentGood));
                if (currentCargoInventory == null) {
                    currentCargoInventory = 0;
                }

                currentMarketInventory = Integer.valueOf(market.getTradeGoodQuantity(currentGood));
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

    }

    /**
     * An onClick method that buys the items selected
     * @param view the View of the button
     */
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

        // TODO: update values for view labels
        currentCargoInventory = Integer.valueOf(player.getMyShip().getGoodList().get(currentGood));
        // #item_in_cargo
        if (currentCargoInventory == null) {
            currentCargoInventory = 0;
        } Log.d("BuyPressed", "currCargoInv is " + currentCargoInventory + ".");
        currentMarketInventory = Integer.valueOf(market.getTradeGoodQuantity(currentGood));
        // #item_rem_in_market
        if (currentMarketInventory == null) {
            currentMarketInventory = 0;
        } Log.d("BuyPressed", "currMarInv is " + currentMarketInventory + ".");
        currentTotalCargo = Integer.valueOf(player.getMyShip().getCurrCargoSize());
        // #updated_total_item_count
        if (currentTotalCargo == null) {
            Log.d("BuyPressed", "currTotCargo is null");
            currentTotalCargo = 0;
        }
        Log.d("BuyPressed", "currTotCargo is " + currentTotalCargo + ".");

        // TODO: update labels
        cargoInventory.setText("" + currentCargoInventory.toString());
        marketInventory.setText("" + currentMarketInventory.toString());
        currentTotalCargoLabel.setText("" + currentTotalCargo.toString());
    }

    /**
     * An onClick method that sells the items selected
     * @param view the View of the button
     */
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

        // TODO: update values for view labels
        currentCargoInventory = Integer.valueOf(player.getMyShip().getGoodList().get(currentGood));
        if (currentCargoInventory == null) {
            currentCargoInventory = 0;
        } Log.d("BuyPressed", "currCargoInv is " + currentCargoInventory + ".");
        currentMarketInventory = Integer.valueOf(market.getTradeGoodQuantity(currentGood));
        if (currentMarketInventory == null) {
            currentMarketInventory = 0;
        } Log.d("BuyPressed", "currMarInv is " + currentMarketInventory + ".");
        currentTotalCargo = Integer.valueOf(player.getMyShip().getCurrCargoSize());
        // #updated_total_item_count
        if (currentTotalCargo == null) {
            Log.d("BuyPressed", "currTotCargo is null");
            currentTotalCargo = 0;
        } Log.d("BuyPressed", "currTotCargo is " + currentTotalCargo + ".");

        // TODO: update labels
        cargoInventory.setText("" + currentCargoInventory.toString());
        marketInventory.setText("" + currentMarketInventory);
        currentTotalCargoLabel.setText("" + currentTotalCargo);
    }

    /**
     * An onClick method that adds the number of items to be bought
     * @param view the View of the button
     */
    public void onBuyPlus(View view) {
        Log.d("Test", "Sell Button has been pressed");

        if (currentMarketInventory > numToBuy) {
            numToBuy++;
            numBuyLabel.setText("" + numToBuy);
        }
    }

    /**
     * An onClick method that subtracts the number of items to be bought
     * @param view the View of the button
     */
    public void onBuyMinus(View view) {
        Log.d("Test", "Sell Button has been pressed");

        if (numToBuy > 0) {
            numToBuy--;
            numBuyLabel.setText("" + numToBuy);
        }
    }

    /**
     * An onClick method that adds the number of items to be sold
     * @param view the View of the button
     */
    public void onSellPlus(View view) {
        Log.d("Test", "Sell Button has been pressed");

        if (currentCargoInventory > numToSell) {
            numToSell++;
            numSellLabel.setText("" + numToSell);
        }
    }

    /**
     * An onClick method that subtracts the number of items to be sold
     * @param view the View of the button
     */
    public void onSellMinus(View view) {
        Log.d("Test", "Sell Button has been pressed");

        if (numToSell > 0) {
            numToSell--;
            numSellLabel.setText("" + numToSell);
        }
    }

    /**
     * An onClick method that returns the player to the previous screen
     * @param view the View of the button
     */
    public void onBackPressed(View view){
        Log.d("Test", "Back Button has been pressed");
        startActivity(new Intent(this, PlanetScreen.class));
    }
}
