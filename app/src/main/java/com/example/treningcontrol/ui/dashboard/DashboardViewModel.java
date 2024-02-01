package com.example.treningcontrol.ui.dashboard;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardViewModel extends ViewModel {

    private final MutableLiveData<List<String>> tasks;

    public DashboardViewModel() {
        tasks = new MutableLiveData<>(new ArrayList<>());
    }

    public LiveData<List<String>> getTasks() {
        return tasks;
    }

    public void addTask(String taskText) {
        List<String> currentTasks = tasks.getValue();
        if (currentTasks == null) {
            currentTasks = new ArrayList<>();
        }
        currentTasks.add(taskText);
        tasks.setValue(currentTasks);
    }

}