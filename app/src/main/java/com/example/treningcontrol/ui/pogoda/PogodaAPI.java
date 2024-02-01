package com.example.treningcontrol.ui.pogoda;

import com.example.treningcontrol.ui.pogoda.PogodaWynik;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PogodaAPI {
    @GET("data/2.5/weather")
    Call<PogodaWynik> getCurrentWeatherData(@Query("lat") double lat, @Query("lon") double lon, @Query("appid") String apiKey);
}