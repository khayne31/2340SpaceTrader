package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Market;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;

import java.io.Serializable;

/**
 * An activity that contains methods pertaining to the Market Activity
 */
public class MarketActivity extends AppCompatActivity implements Serializable {
    private Context mContext;

    private RecyclerView.Adapter mAdapter;

    private Market market;

    private Player player;


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
        // get referenced widgets
        RecyclerView recyclerView = findViewById(R.id.items_recycler_view);
        ConstraintLayout mConstraintLayout = findViewById(R.id.market_constraint_layout);
        Button mSellButton = findViewById(R.id.sell_button);

        // fix size of recycler view (less object don't make it look shorter)
        recyclerView.setHasFixedSize(true);

        // using a linear layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify adapter
        // set what data to put in adapter

        //no longer exists
        //mAdapter = new MarketAdapter(mContext, market.getItems());
        recyclerView.setAdapter(mAdapter);


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




    /**
     * An onClick method that tests the buy button
     * @param view the View of the button
     */
    public void onBuyPressed(View view) {
        Log.d("Test", "Buy Button has been pressed");
    }
    /**
     * An onClick method that tests the sell button
     * @param view the View of the button
     */
    public void onSellPressed(View view) {
        Log.d("Test", "Sell Button has been pressed");
    }

}
