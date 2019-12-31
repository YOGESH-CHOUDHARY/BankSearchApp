package com.example.banksearchapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class PricelyAdapter extends RecyclerView.Adapter<PricelyAdapter.MyViewHolder> {

    List<PricelyModel> pricelyModels;

    public PricelyAdapter(List<PricelyModel> pricelyModels) {
        this.pricelyModels = pricelyModels;

    }


    @NonNull
    @Override
    public PricelyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.pricely_item, parent, false);
        PricelyAdapter.MyViewHolder myViewHolder = new PricelyAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PricelyAdapter.MyViewHolder myViewHolder, int i) {

//        myViewHolder.image.setImageResource(R.drawable.ic_launcher_foreground);
        myViewHolder.name.setText(pricelyModels.get(i).getSname());
        myViewHolder.timedate.setText(pricelyModels.get(i).getTimestamp());
        myViewHolder.price.setText(pricelyModels.get(i).getBestprice());

    }

    @Override
    public int getItemCount() {
        return pricelyModels.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name, timedate, price;

        public MyViewHolder(View itemView) {

            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.img);
            name = (TextView) itemView.findViewById(R.id.name);
            timedate = (TextView) itemView.findViewById(R.id.time_and_date);
            price = (TextView) itemView.findViewById(R.id.price);


        }
    }
}
