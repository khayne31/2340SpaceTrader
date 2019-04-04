package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;
import com.example.m5_projectsetupuserstoriesandconfiguration.entity.Player;
import com.example.m5_projectsetupuserstoriesandconfiguration.model.PlayerInteractor;
import com.example.m5_projectsetupuserstoriesandconfiguration.view_model.LoadActivityViewModel;

import java.io.File;
import java.util.List;

public class LoadScreen extends AppCompatActivity {

    private LoadActivityViewModel loadVM;
    private Player selectedPlayer;
    private Spinner playerSpinner;
    SimpleItemRecyclerViewAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_screen);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        loadVM = ViewModelProviders.of(this).get(LoadActivityViewModel.class);

        PlayerInteractor playerInteractor = PlayerInteractor.getInstance();
        //selectedPlayer = (Player) playerSpinner.getSelectedItem();
        File file;

        //create a file object in the local files section
        //file = new File(this.getFilesDir(), playerInteractor.DEFAULT_BINARY_FILE_NAME);
        //Log.d("MY APP", "Loading Binary Data");
        //playerInteractor.loadBinary(file);
        //reset adapter to new data that has come in.
        //myAdapter.updateList(playerInteractor.getAllPlayers());
        //Log.d("MY APP", "New Adaptor set");

        playerSpinner = findViewById(R.id.player_select);
        ArrayAdapter<Player> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, loadVM.getPlayers());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        playerSpinner.setAdapter(adapter);
        //playerSpinner.setAdapter(myAdapter);

//        recyclerView = (RecyclerView) findViewById(R.id.cardList);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        View recyclerView = findViewById(R.id.players_recycler_view);
        assert recyclerView != null;
        setupRecyclerView((RecyclerView) recyclerView);

    }

    private void setupRecyclerView(@NonNull RecyclerView recyclerView) {
        PlayerInteractor pi = PlayerInteractor.getInstance();

        myAdapter = new SimpleItemRecyclerViewAdapter(pi.getAllPlayers());

        recyclerView.setAdapter(myAdapter);
    }

    public void onGoBackPressed(View view) {
        startActivity(new Intent(this, MainMenu.class));
        Log.i("Test", "Returning to Main Menu");
    }

    public void onLoadGamePressed(View view) {
        PlayerInteractor playerInteractor = PlayerInteractor.getInstance();
        selectedPlayer = (Player) playerSpinner.getSelectedItem();
        File file;

        //create a file object in the local files section
        file = new File(this.getFilesDir(), playerInteractor.DEFAULT_BINARY_FILE_NAME);
        //Log.d("MY APP", "Loading Binary Data");
        playerInteractor.loadBinary(file);
        //reset adapter to new data that has come in.
        myAdapter.updateList(playerInteractor.getAllPlayers());
        //Log.d("MY APP", "New Adaptor set");
        selectedPlayer = (Player) playerSpinner.getSelectedItem();
        Intent moveActivities = new Intent(this, PlanetScreen.class);
        startActivity(moveActivities);


    }


    public class SimpleItemRecyclerViewAdapter
            extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

        private List<Player> mValues;

        public SimpleItemRecyclerViewAdapter(List<Player> items) {
            mValues = items;
        }

        public void updateList(List<Player> newdata) {
            mValues = newdata;
            notifyDataSetChanged();
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.content_load_screen, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final ViewHolder holder, int position) {
            holder.mItem = mValues.get(position);
            holder.mIdView.setText(mValues.get(position).getName());
            holder.mContentView.setText(mValues.get(position).getCurrentPlanet().getName());

            holder.mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("MY APPLICATION", holder.mItem.toString());
                    Context context = v.getContext();
                    Intent intent = new Intent(context, PlanetScreen.class);
                    intent.putExtra(PlanetScreen.ARG_ITEM_ID, holder.mItem.getName());

                    context.startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return mValues.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public final View mView;
            public final TextView mIdView;
            public final TextView mContentView;
            public Player mItem;

            public ViewHolder(View view) {
                super(view);
                mView = view;
                mIdView = (TextView) view.findViewById(R.id.load_game);
                mContentView = (TextView) view.findViewById(R.id.content);
            }

            @Override
            public String toString() {
                return super.toString() + " '" + mContentView.getText() + "'";
            }
        }
    }

}
