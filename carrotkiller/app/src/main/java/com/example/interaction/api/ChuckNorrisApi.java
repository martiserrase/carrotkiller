package com.example.interaction.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ChuckNorrisApi {

    @GET("jokes/random")
    Call<ChuckNorris> getChuckNorris();

}