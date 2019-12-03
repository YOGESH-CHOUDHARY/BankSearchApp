package com.example.banksearchapp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener , AdapterView.OnItemSelectedListener{

    List<BankModel> bankModels;
    private RelativeLayout mProgressBar;
    private RecyclerView recyclerView;
    public BankFilterRecyclerAdapter bankFilterRecyclerAdapter;
    private SearchView searchView;
    Spinner spinner;
    String[] cityArray = {"MUMBAI", "CHENNAI", "BANGALORE"};

    private  RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView=findViewById(R.id.searchview);
        searchView.setOnQueryTextListener(this);
        mProgressBar=findViewById(R.id.rl_progress_bar);
        spinner=findViewById(R.id.spinner);
        recyclerView=findViewById(R.id.recyclerview);
        ArrayAdapter idAdapter = new ArrayAdapter(
                this, R.layout.spinner_layout, cityArray);


        spinner.setAdapter(idAdapter);

        spinner.setOnItemSelectedListener(this);
        mProgressBar.setVisibility(View.GONE);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(MainActivity.this);



        callService(spinner.getSelectedItem().toString());
    }

    private void callService(final String spinner) {

        try

        {
            mProgressBar.setVisibility(View.VISIBLE);
            RetroInterface apiInterface = RetroClass.getClient
                    ().create(RetroInterface.class);



             Call<List<BankModel>> call = apiInterface.getData(spinner);

            call.enqueue(new Callback<List<BankModel>>() {


                @Override
                public void onResponse(@NonNull Call<List<BankModel>> call, @NonNull retrofit2.Response<List<BankModel>> response) {

                    if (response.isSuccessful()) {
                        try {
                            Log.e("hii", "onResponse: " );


                            List<BankModel> responseBody = (List<BankModel>) response.body();

                            bankModels=responseBody;
                            recyclerView.setLayoutManager(layoutManager);
                            recyclerView.setItemAnimator(new DefaultItemAnimator());
                            bankFilterRecyclerAdapter = new BankFilterRecyclerAdapter(responseBody, MainActivity.this,mProgressBar);
                            recyclerView.setAdapter(bankFilterRecyclerAdapter);
                                        mProgressBar.setVisibility(View.GONE);



                                } catch (Exception e) {

                                    e.printStackTrace();
                                    mProgressBar.setVisibility(View.GONE);
                                    }


                            } else {
                        Log.e("hiid", "onResponse: ");
                        mProgressBar.setVisibility(View.GONE);

                    }

                        }


                @Override
                public void onFailure(Call<List<BankModel>> call, Throwable t) {
                    t.printStackTrace();


                    mProgressBar.setVisibility(View.GONE);

                }
            });
        } catch (Exception e) {
            e.printStackTrace();

            mProgressBar.setVisibility(View.GONE);


        }

    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {

        if(bankFilterRecyclerAdapter!=null) {
            final List<BankModel> filteredModelList = filter(bankModels, newText);

            bankFilterRecyclerAdapter.setFilter(filteredModelList);
            return true;
        }
        return true;
    }



    private List<BankModel> filter(List<BankModel> models, String query) {
        query = query.toLowerCase();
        final List<BankModel> filteredModelList = new ArrayList<>();
        for (BankModel model : models) {

            String bankID="", ifsc="",branch="",address="",city="",district="",state="",bankname="";

            if(model.getBankId()!=null) {

                bankID = String.valueOf(model.getBankId());
            }
            if(model.getIfsc()!=null) {
                ifsc = model.getIfsc().toLowerCase();
            }
            if(model.getBranch()!=null) {

                branch = model.getBranch().toLowerCase();
            }
            if(model.getAddress()!=null) {
                address = model.getAddress().toLowerCase();
            }
            if(model.getCity()!=null) {

                city = model.getCity().toLowerCase();
            }
            if(model.getDistrict()!=null) {
                district = model.getDistrict().toLowerCase();
            }
            if(model.getState()!=null) {

                state = model.getState().toLowerCase();
            }
            if(model.getBankName()!=null) {
                bankname = model.getBankName().toLowerCase();
            }


            if (bankID.contains(query)||ifsc.contains(query)||branch.contains(query)||address.contains(query)||city.contains(query)||district.contains(query)||state.contains(query)||bankname.contains(query)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        callService(adapterView.getItemAtPosition(i).toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
