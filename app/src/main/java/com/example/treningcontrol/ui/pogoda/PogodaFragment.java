package com.example.treningcontrol.ui.pogoda;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.treningcontrol.R;
import com.example.treningcontrol.databinding.FragmentPogodaBinding;
import com.example.treningcontrol.ui.pogoda.PogodaViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PogodaFragment extends Fragment {

    private FragmentPogodaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PogodaViewModel pogodaViewModel =
                new ViewModelProvider(this).get(PogodaViewModel.class);

        binding = FragmentPogodaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        double latitude = 37.4226711;
        double longitude = -122.0849872;

        PogodaAPI api = PogodaViewModel.getAPI();
        Call<PogodaWynik> call = api.getCurrentWeatherData(latitude, longitude, PogodaViewModel.API_KEY, "metric", "pl");

        call.enqueue(new Callback<PogodaWynik>() {
            @Override
            public void onResponse(Call<PogodaWynik> call, Response<PogodaWynik> response) {
                if (response.isSuccessful()) {
                    PogodaWynik weatherResult = response.body();
                    String weatherDetails = "Temperatura: " + weatherResult.main.temp + "°C\n" +
                            "Pogoda: " + weatherResult.weather.get(0).description + "\n" +
                            "Wilgotnosc: " + weatherResult.main.humidity + "%\n" +
                            "Predkosc wiatru: " + weatherResult.wind.speed + "m/s";
                    ((TextView) root.findViewById(R.id.text_pogoda)).setText(weatherDetails);
                }
            }

            @Override
            public void onFailure(Call<PogodaWynik> call, Throwable t) {
                Log.d("API Call Failed", t.getMessage());
                ((TextView) root.findViewById(R.id.text_pogoda)).setText("Failed to load weather data");
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}