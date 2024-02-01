package com.example.treningcontrol.ui.pogoda;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PogodaViewModel extends ViewModel {
    private static Retrofit retrofit;
    private static final String BASE_URL = "http://api.openweathermap.org/";
    private static final String API_KEY = "6c98378630f60f6b53ff91ba3e9ccd3d";


    public PogodaViewModel() {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static void loadWeatherData(double latitude, double longitude, Callback<PogodaWynik> callback) {
        PogodaAPI api = retrofit.create(PogodaAPI.class);
        Call<PogodaWynik> call = api.getCurrentWeatherData(latitude, longitude, API_KEY);
        call.enqueue(callback);
    }
}