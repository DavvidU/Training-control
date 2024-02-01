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
    64 - klatka
    32 - barki
    16 - biceps
    8 - triceps
    4 - brzuch
    2 - plecy
    1 - nogi
     */

    public Cwiczenie(String nazwa, int partieCiala) {
        this.nazwa = nazwa;
        this.partieCiala = partieCiala;
    }
}
