package com.example.treningcontrol.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.treningcontrol.databinding.FragmentGymBinding;

import java.io.Console;

public class GymFragment extends Fragment {

    private FragmentGymBinding binding;
    private GymViewModel gymViewModel;
    private RecyclerView recyclerView;
    private CwiczenieAdapter cwiczenieAdapter;
    private int maskaPartiiCiala = 0; // Początkowa maska

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        gymViewModel =
                new ViewModelProvider(this).get(GymViewModel.class);



        binding = FragmentGymBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Inicjalizacja RecyclerView
        recyclerView = binding.recyclerViewCwiczenia;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        cwiczenieAdapter = new CwiczenieAdapter();
        recyclerView.setAdapter(cwiczenieAdapter);

        // Obsługa zdarzeń checkboxów
        ustawCheckboxListeners();

        // Obserwowanie danych
        gymViewModel.pobierzWszystkieCwiczenia().observe(getViewLifecycleOwner(), cwiczenia -> {
            if (cwiczenia != null && !cwiczenia.isEmpty()) {
                // Logowanie pierwszego ćwiczenia
                Log.d("GymFragment", "Pierwsze ćwiczenie: " + cwiczenia.get(0).nazwa);
                cwiczenieAdapter.setCwiczenia(cwiczenia);
            } else {
                Log.d("GymFragment", "Brak ćwiczeń do wyświetlenia.");
            }
        });



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void ustawCheckboxListeners() {
        binding.checkboxNogi.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) maskaPartiiCiala |= 1;
            else maskaPartiiCiala &= ~1;
            aktualizujCwiczenia();
        });

        binding.checkboxPlecy.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) maskaPartiiCiala |= 2;
            else maskaPartiiCiala &= ~2;
            aktualizujCwiczenia();
        });

        binding.checkboxBrzuch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) maskaPartiiCiala |= 4;
            else maskaPartiiCiala &= ~4;
            aktualizujCwiczenia();
        });

        binding.checkboxTriceps.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) maskaPartiiCiala |= 8;
            else maskaPartiiCiala &= ~8;
            aktualizujCwiczenia();
        });

        binding.checkboxBiceps.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) maskaPartiiCiala |= 16;
            else maskaPartiiCiala &= ~16;
            aktualizujCwiczenia();
        });

        binding.checkboxBarki.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) maskaPartiiCiala |= 32;
            else maskaPartiiCiala &= ~32;
            aktualizujCwiczenia();
        });

        binding.checkboxKlatka.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) maskaPartiiCiala |= 64;
            else maskaPartiiCiala &= ~64;
            aktualizujCwiczenia();
        });
    }

    private void aktualizujCwiczenia() {

        gymViewModel.pobierzCwiczeniaWgPartii(maskaPartiiCiala).observe(getViewLifecycleOwner(), cwiczenia -> {
            cwiczenieAdapter.setCwiczenia(cwiczenia);
        });
    }
}