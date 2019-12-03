package com.example.banksearchapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;



public class BankFilterRecyclerAdapter  extends RecyclerView.Adapter<BankFilterRecyclerAdapter.MyViewHolder>  {

    List<BankModel> bankModels;
    Activity activity;
    RelativeLayout mProgressBar;
    public  BankFilterRecyclerAdapter(List<BankModel> bankModels, Activity activity, RelativeLayout mProgressBar){
       this.bankModels=bankModels;
       this.activity=activity;
       this.mProgressBar=mProgressBar;
    }

    public void setFilter(List<BankModel> filteredModelList) {

        bankModels = new ArrayList<>();
        bankModels.addAll(filteredModelList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull BankFilterRecyclerAdapter.MyViewHolder myViewHolder, int i) {

        myViewHolder.ifsc.setText(bankModels.get(i).getIfsc());
        myViewHolder.bankname.setText(bankModels.get(i).getBankName());
        myViewHolder.branch.setText(bankModels.get(i).getBranch());

    }

    @Override
    public int getItemCount() {
        return bankModels.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView bankname,branch,ifsc;
        public MyViewHolder(View itemView) {

            super(itemView);
            bankname=(TextView)itemView.findViewById(R.id.bank_name);
            branch=(TextView)itemView.findViewById(R.id.branch);
            ifsc=(TextView)itemView.findViewById(R.id.ifsc);


        }
    }
}
