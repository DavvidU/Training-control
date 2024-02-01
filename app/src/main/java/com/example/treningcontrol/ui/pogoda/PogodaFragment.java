package com.example.treningcontrol.ui.pogoda;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.treningcontrol.R;
import com.example.treningcontrol.databinding.FragmentPogodaBinding;
import com.example.treningcontrol.ui.pogoda.PogodaViewModel;
public class PogodaFragment extends Fragment {

    private FragmentPogodaBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PogodaViewModel pogodaViewModel =
                new ViewModelProvider(this).get(PogodaViewModel.class);

        binding = FragmentPogodaBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textPogoda;
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}