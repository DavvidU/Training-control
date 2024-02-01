package com.example.treningcontrol;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Cwiczenie {
    @PrimaryKey(autoGenerate = true)
    public int id;

    public String nazwa;
    public int partieCiala;
    /*
    10^6 - klatka
    10^5 - barki
    10^4 - biceps
    10^3 - triceps
    10^2 - brzuch
    10^1 - plecy
    10^0 - nogi
     */
}
