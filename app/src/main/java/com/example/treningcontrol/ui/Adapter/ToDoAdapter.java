package com.example.treningcontrol.ui.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.treningcontrol.R;

import java.util.List;

public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder> {

    private List<String> tasks;

    public ToDoAdapter(List<String> tasks) {
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public ToDoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_list, parent, false);
        return new ToDoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ToDoViewHolder holder, int position) {
        String task = tasks.get(position);
        holder.taskTextView.setText(task);
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public void setTasks(List<String> tasks) {
        this.tasks = tasks;
        notifyDataSetChanged();
    }

    static class ToDoViewHolder extends RecyclerView.ViewHolder {
        TextView taskTextView;

        ToDoViewHolder(View itemView) {
            super(itemView);
            taskTextView = itemView.findViewById(R.id.todoCheckBox);
        }
    }
}
