package com.example.treningcontrol.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.treningcontrol.databinding.FragmentGymBinding;

public class GymFragment extends Fragment {

    private FragmentGymBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GymViewModel gymViewModel =
                new ViewModelProvider(this).get(GymViewModel.class);

        binding = FragmentGymBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textGym;
        gymViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}