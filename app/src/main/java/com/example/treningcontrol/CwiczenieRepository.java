package com.example.treningcontrol;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;

import java.util.List;

public class CwiczenieRepository {
    private final CwiczenieDAO cwiczenieDAO;
    private final LiveData<List<Cwiczenie>> cwiczenia;

    CwiczenieRepository(Application application)
    {
        CwiczenieDatabase database = CwiczenieDatabase.getDatabase(application);
        cwiczenieDAO = database.cwiczenieDAO();
        cwiczenia = cwiczenieDAO.pobierzWszystkie();
    }

    LiveData<List<Cwiczenie>> pobierzWszystkieCwiczenia() { return cwiczenia; }

    List<Cwiczenie> pobierzCwiczeniaWgPartii(int rzadanePartie) { return cwiczenieDAO.pobierzWgPartii(rzadanePartie); }

    void usun(Cwiczenie cwiczenie)
    { CwiczenieDatabase.databaseWriteExecutor.execute(() -> cwiczenieDAO.usun(cwiczenie)); }

    void wstaw(Cwiczenie cwiczenie)
    { CwiczenieDatabase.databaseWriteExecutor.execute(() -> cwiczenieDAO.wstaw(cwiczenie)); }
}
