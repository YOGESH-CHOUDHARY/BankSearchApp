package com.example.banksearchapp;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public  class RetroClass {

    private static Retrofit retrofit = null;

   public static Retrofit getClient() {

       retrofit = null;


       HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
     interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
  OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).connectTimeout(180, TimeUnit.SECONDS).readTimeout(180, TimeUnit.SECONDS).writeTimeout(180, TimeUnit.SECONDS).build();


        retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://vast-shore-74260.herokuapp.com")
                .client(client)
                .build();



        return retrofit;
    }




}