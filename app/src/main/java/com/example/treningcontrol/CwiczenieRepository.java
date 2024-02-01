package com.example.treningcontrol;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CwiczenieRepository {
    private final CwiczenieDAO cwiczenieDAO;
    private final LiveData<List<Cwiczenie>> cwiczenia;

    public CwiczenieRepository(Application application)
    {
        CwiczenieDatabase database = CwiczenieDatabase.getDatabase(application);
        cwiczenieDAO = database.cwiczenieDAO();
        cwiczenia = cwiczenieDAO.pobierzWszystkie();
    }

    public LiveData<List<Cwiczenie>> pobierzWszystkieCwiczenia() { return cwiczenia; }

    public LiveData<List<Cwiczenie>> pobierzCwiczeniaWgPartii(int rzadanePartie) { return cwiczenieDAO.pobierzWgPartii(rzadanePartie); }

    public void usun(Cwiczenie cwiczenie)
    { CwiczenieDatabase.databaseWriteExecutor.execute(() -> cwiczenieDAO.delete(cwiczenie)); }

    public void wstaw(Cwiczenie cwiczenie)
    { CwiczenieDatabase.databaseWriteExecutor.execute(() -> cwiczenieDAO.insert(cwiczenie)); }
}
