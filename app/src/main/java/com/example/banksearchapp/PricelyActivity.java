package com.example.banksearchapp;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class PricelyActivity extends AppCompatActivity {

    private List<PricelyModel> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private PricelyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pricely_smiley);

        recyclerView = (RecyclerView) findViewById(R.id.rv);

        mAdapter = new PricelyAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        preparePricelyData();


    }

    private void preparePricelyData() {
        PricelyModel pricelyModel = new PricelyModel(R.drawable.image_1,"Mad Max: Fury Road", "Action & Adventure", "2015");
        movieList.add(pricelyModel);

        pricelyModel = new PricelyModel(R.drawable.image_2,"Inside Out", "Animation, Kids & Family", "2015");
        movieList.add(pricelyModel);

        pricelyModel = new PricelyModel(R.drawable.image_3,"Star Wars: Episode VII - The Force Awakens", "Action", "2015");
        movieList.add(pricelyModel);

        pricelyModel = new PricelyModel(R.drawable.image_4,"Shaun the Sheep", "Animation", "2015");
        movieList.add(pricelyModel);

        pricelyModel = new PricelyModel(R.drawable.image_1,"The Martian", "Science Fiction & Fantasy", "2015");
        movieList.add(pricelyModel);

        pricelyModel = new PricelyModel(R.drawable.image_2,"Mission: Impossible Rogue Nation", "Action", "2015");
        movieList.add(pricelyModel);

        mAdapter.notifyDataSetChanged();
    }
}
