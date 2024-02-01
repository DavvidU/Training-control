package com.example.treningcontrol;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class CwiczenieViewModel extends AndroidViewModel {
    private final CwiczenieRepository cwiczenieRepository;
    private final LiveData<List<Cwiczenie>> cwiczenia;

    public CwiczenieViewModel(@NonNull Application application)
    {
        super(application);
        cwiczenieRepository = new CwiczenieRepository(application);
        cwiczenia = cwiczenieRepository.pobierzWszystkieCwiczenia();
    }

    LiveData<List<Cwiczenie>> pobierzWszystkieCwiczenia() { return cwiczenia; }

    List<Cwiczenie> pobierzCwiczeniaWgPartii(int rzadanePartie)
    { return cwiczenieRepository.pobierzCwiczeniaWgPartii(rzadanePartie); }

    void usun(Cwiczenie cwiczenie) { cwiczenieRepository.usun(cwiczenie); }

    void wstaw(Cwiczenie cwiczenie) { cwiczenieRepository.wstaw(cwiczenie); }
}
