package com.example.treningcontrol.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.treningcontrol.Cwiczenie;
import com.example.treningcontrol.R;

import java.util.ArrayList;
import java.util.List;

public class CwiczenieAdapter extends RecyclerView.Adapter<CwiczenieAdapter.CwiczenieViewHolder> {
    private List<Cwiczenie> listaCwiczen = new ArrayList<>();

    @NonNull
    @Override
    public CwiczenieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_cwiczenie, parent, false);
        return new CwiczenieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CwiczenieViewHolder holder, int position) {
        Cwiczenie cwiczenie = listaCwiczen.get(position);
        holder.bind(cwiczenie);
    }

    @Override
    public int getItemCount() {
        return listaCwiczen.size();
    }

    public void setCwiczenia(List<Cwiczenie> cwiczenia) {
        this.listaCwiczen = cwiczenia;
        notifyDataSetChanged();
    }

    class CwiczenieViewHolder extends RecyclerView.ViewHolder {
        // Znajdź widoki w item_cwiczenie.xml
        private TextView textViewNazwa;

        CwiczenieViewHolder(View itemView) {
            super(itemView);
            textViewNazwa = itemView.findViewById(R.id.textViewNazwa);
        }

        void bind(Cwiczenie cwiczenie) {
            textViewNazwa.setText(cwiczenie.nazwa);
        }
    }
}
