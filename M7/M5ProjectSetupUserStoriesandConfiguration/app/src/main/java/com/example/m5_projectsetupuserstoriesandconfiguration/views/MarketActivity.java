package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.content.Context;
import android.content.Intent;
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

public class MarketActivity extends AppCompatActivity implements Serializable {
    private Context mContext;

    ConstraintLayout mConstraintLayout;
    private RecyclerView recyclerView;
    private Button mSellButton;

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private Market market;

    private Player player;
    Intent intent = new Intent();


    /**
     * The start-up function for the screen
     * @param savedInstanceState
     */
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
        recyclerView = findViewById(R.id.items_recycler_view);
        mConstraintLayout = findViewById(R.id.market_constraint_layout);
        mSellButton = findViewById(R.id.sell_button);

        // fix size of recycler view (less object don't make it look shorter)
        recyclerView.setHasFixedSize(true);

        // using a linear layout manager
        layoutManager = new LinearLayoutManager(this);
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

    private static void largeLog(String tag, String content){
        if (content.length() > 4000){
            Log.v(tag, content.substring(0,4000));
            largeLog(tag, content.substring(4000));

        } else {
            Log.v(tag, content);
        }

    }

    public void onBuyPressed(View view) {
        Log.d("Test", "Buy Button has been pressed");
    }
    public void onSellPressed(View view) {
        Log.d("Test", "Sell Button has been pressed");
    }

}
