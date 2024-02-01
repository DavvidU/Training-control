package com.example.treningcontrol;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CwiczenieDAO {
    @Query("SELECT * FROM Cwiczenie")
    LiveData<List<Cwiczenie>> pobierzWszystkie();

    @Query("SELECT * FROM Cwiczenie WHERE partieCiala & :rzadanePartie = :rzadanePartie")
    List<Cwiczenie> pobierzWgPartii(int rzadanePartie);

    @Delete
    void usun(Cwiczenie cwiczenie);

    @Insert
    void wstaw(Cwiczenie cwiczenie);
}
