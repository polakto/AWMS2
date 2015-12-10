package com.support.android.designlibdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import data.Cheeses;
import data.DataLayer;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private ArrayList mDataset;
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public String mCommodityName;
        public View mTextView;
        public Context mojContext;
        public ViewHolder(View v, Context myContext, String commodityName) {
            super(v);
            mTextView = v;
            mojContext = myContext;
            mCommodityName = commodityName;




        }
    }



    // Provide a suitable constructor (depends on the kind of dataset)
    /*
    public MyAdapter(String[] myDataset) {

        mDataset = myDataset;
    }
    */

    public MyAdapter(ArrayList myDataset, Context myContext) {
        mContext = myContext;
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card, parent, false);

        //TextView pomocnik = (TextView) v.findViewById(R.id.info_text);
        //pomocnik.setText("Goliasious");

        ViewHolder vh = new ViewHolder(v, mContext, "DEMO COMMODITY NAME");
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        //holder.mTextView.setText(mDataset[position]);

        HashMap item = (HashMap) mDataset.get(position);

        final String myCommodityName2 = item.get("name").toString();

        View pomocnik = holder.itemView;
        TextView pomocnik2 = (TextView) pomocnik.findViewById(R.id.info_text);
        pomocnik2.setText(item.get("name").toString());

        View pomocnikus = holder.itemView;
        TextView pomocnikus2 = (TextView) pomocnikus.findViewById(R.id.info_text2);

        NumberFormat formatter = new DecimalFormat("###,###,###.##");

        double theNumber = (double) item.get("quantity");


        pomocnikus2.setText(formatter.format(theNumber).toString() + " " + item.get("uom").toString());
        View pomocnikPic = holder.itemView;
        ImageView pomocnikPic2 = (ImageView) pomocnikPic.findViewById(R.id.commodity_picture);


        int resourceId = mContext.getResources().getIdentifier(item.get("picture").toString(), "drawable", mContext.getPackageName());
        pomocnikPic2.setBackgroundResource(resourceId);


        holder.mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = v.getContext();
                Intent intent = new Intent(context, CommodityDetailActivity.class);
                intent.putExtra(CommodityDetailActivity.EXTRA_NAME, myCommodityName2);

                context.startActivity(intent);
            }
        });





    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return (int)mDataset.size();
    }
}