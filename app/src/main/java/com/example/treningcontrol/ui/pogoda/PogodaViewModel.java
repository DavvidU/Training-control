package com.example.treningcontrol.ui.pogoda;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PogodaViewModel extends ViewModel {
    private static Retrofit retrofit = null;
    private static final String BASE_URL = "https://api.openweathermap.org/";
    public static final String API_KEY = "6c98378630f60f6b53ff91ba3e9ccd3d";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static PogodaAPI getAPI() {
        return getRetrofitInstance().create(PogodaAPI.class);
    }
}