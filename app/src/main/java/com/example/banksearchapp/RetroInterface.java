package com.example.banksearchapp;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface RetroInterface {

    @Headers("Content-Type: application/json")
    @GET("/banks")
    Call<List<BankModel>> getData(@Query(value = "city", encoded = true) String param);

   /* @Headers("Content-Type: application/json")
    @POST("/109681")
    Call<ResponseBody> deviceIDN(@Body RequestBody body);*/

}
