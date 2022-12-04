package com.example.interaction.api;

import retrofit2.Call;
import retrofit2.http.GET;

// Code with the API call in the StatisticsActivity.java

public interface ChuckNorrisApi {

    @GET("jokes/random")
    Call<ChuckNorris> getChuckNorris();

}