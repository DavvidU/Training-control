package com.example.treningcontrol.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.treningcontrol.Cwiczenie;
import com.example.treningcontrol.CwiczenieRepository;

import java.util.List;

public class GymViewModel extends AndroidViewModel {
    private final CwiczenieRepository cwiczenieRepository; // repozytorium zarzadzajace cwiczeniami
    private final LiveData<List<Cwiczenie>> cwiczenia;

    private final MutableLiveData<String> mText;

    public GymViewModel(@NonNull Application application) {
        /* Inicjalizacja repozytorium cwiczen */
        super(application);
        cwiczenieRepository = new CwiczenieRepository(application);
        cwiczenia = cwiczenieRepository.pobierzWszystkieCwiczenia();

        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    /* Metody uzywajace repozytorium cwiczen */

    LiveData<List<Cwiczenie>> pobierzWszystkieCwiczenia() { return cwiczenia; }

    List<Cwiczenie> pobierzCwiczeniaWgPartii(int rzadanePartie)
    { return cwiczenieRepository.pobierzCwiczeniaWgPartii(rzadanePartie); }

    void usun(Cwiczenie cwiczenie) { cwiczenieRepository.usun(cwiczenie); }

    void wstaw(Cwiczenie cwiczenie) { cwiczenieRepository.wstaw(cwiczenie); }
}