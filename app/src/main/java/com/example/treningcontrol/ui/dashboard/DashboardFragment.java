package com.example.treningcontrol.ui.dashboard;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.treningcontrol.R;
import com.example.treningcontrol.databinding.FragmentDashboardBinding;
import com.example.treningcontrol.ui.Adapter.ToDoAdapter;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;
    private DashboardViewModel dashboardViewModel;
    private ToDoAdapter toDoAdapter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        toDoAdapter = new ToDoAdapter(new ArrayList<>());

        binding.tasksRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.tasksRecyclerView.setAdapter(toDoAdapter);

        binding.fab.setOnClickListener(view -> showAddTaskDialog());

        dashboardViewModel.getTasks().observe(getViewLifecycleOwner(), tasks -> toDoAdapter.setTasks(tasks));

        return root;
    }

    private void showAddTaskDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Dodaj nowe zadanie");

        final EditText inputField = new EditText(getContext());
        builder.setView(inputField);

        builder.setPositiveButton("Dodaj", (dialogInterface, i) -> {
            String taskText = inputField.getText().toString();
            if (!taskText.isEmpty()) {
                dashboardViewModel.addTask(taskText);
            }
        });

        builder.setNegativeButton("Anuluj", (dialog, which) -> dialog.dismiss());

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}