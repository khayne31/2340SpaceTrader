package com.example.m5_projectsetupuserstoriesandconfiguration.views;

import android.content.Context;
import android.graphics.Color;
import android.graphics.EmbossMaskFilter;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.m5_projectsetupuserstoriesandconfiguration.R;

import java.util.List;

/**
 * An activity that contains the recycler view for the market screen
 */
public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.MViewHolder> {
    private final List<String> mItemData;
    private List<String> mPriceData;
    private final Context mContext;

    public static class MViewHolder extends RecyclerView.ViewHolder {
        // currently set up if each data item is just a string
        public final TextView textViewA;
        public final TextView textViewB;
        public final LinearLayout mLinearLayout;
        public MViewHolder(View v) {
            super(v);
            textViewA = v.findViewById(R.id.item_name);
            textViewB = v.findViewById(R.id.item_price);
            mLinearLayout = v.findViewById(R.id.items_linear);
        }
    }

    // constructor --> depends on the dataset
    public MarketAdapter(Context context, List<String> myItemDataset) {
        mItemData = myItemDataset;
        mContext = context;
    }

    public MarketAdapter.MViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(mContext)
                .inflate(R.layout.item_view, parent, false);
        // customize stuff here
        MViewHolder vh = new MViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MViewHolder holder, final int position) {
        // setup text of item in position x to match the one from items list
        holder.textViewA.setText(mItemData.get(position)); // need getter
        holder.textViewB.setText(mPriceData.get(position)); // need getter

        // set TextView background
        holder.textViewA.setBackgroundColor(Color.BLACK);
        holder.textViewB.setBackgroundColor(Color.BLACK);

        // set TextView text color
        holder.textViewA.setTextColor(Color.WHITE);
        holder.textViewB.setTextColor(Color.WHITE);

        // set a gradient background for layout
        holder.mLinearLayout.setBackgroundColor(Color.BLACK);
        // to set a background image use .setBackground

        // emboss TextView text??
        applyEmbossMaskFilter(holder.textViewA);
        applyEmbossMaskFilter(holder.textViewB);

        // listener for TextView?? --> both item and price are clickable
        // and refer to the same item
        holder.textViewA.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String item = mItemData.get(position);
               Toast.makeText(mContext, item, Toast.LENGTH_SHORT).show();
           }
        });
        holder.textViewB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String price = mPriceData.get(position);
                Toast.makeText(mContext, price, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItemData.size();
    }

    protected void applyEmbossMaskFilter(TextView tv){
        EmbossMaskFilter embossFilter = new EmbossMaskFilter(
                new float[]{1f, 5f, 1f}, // direction of the light source
                0.8f, // ambient light between 0 to 1
                8, // specular highlights
                7f // blur before applying lighting
        );
        tv.setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        tv.getPaint().setMaskFilter(embossFilter);
    }
}
