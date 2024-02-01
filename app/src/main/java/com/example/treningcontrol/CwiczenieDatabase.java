package com.example.treningcontrol;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Cwiczenie.class}, version = 1, exportSchema = false)
public abstract class CwiczenieDatabase extends RoomDatabase {
    private static CwiczenieDatabase databaseInstance;
    static final ExecutorService databaseWriteExecutor = Executors.newSingleThreadExecutor();

    public abstract CwiczenieDAO cwiczenieDAO();

    private static final RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            databaseWriteExecutor.execute(() -> {
                CwiczenieDAO dao = databaseInstance.cwiczenieDAO();


                Cwiczenie cw1 = new Cwiczenie("Wyciskanie na lawce", 64);
                dao.insert(cw1);
                Cwiczenie cw2 = new Cwiczenie("Wyciskanie żołnierskie (OHP)", 32);
                dao.insert(cw2);
                Cwiczenie cw3 = new Cwiczenie("Uginanie ramion z hantlami", 16);
                dao.insert(cw3);
                Cwiczenie cw4 = new Cwiczenie("Pompki na poręczach (dipy)", 8);
                dao.insert(cw4);
                Cwiczenie cw5 = new Cwiczenie("Hollow body", 4);
                dao.insert(cw5);
                Cwiczenie cw6 = new Cwiczenie("Deska (Plank)", 4);
                dao.insert(cw6);
                Cwiczenie cw7 = new Cwiczenie("Przyciąganie kolan w zwisie", 4);
                dao.insert(cw7);
                Cwiczenie cw8 = new Cwiczenie("Skłony rosyjskie", 4);
                dao.insert(cw8);
                Cwiczenie cw9 = new Cwiczenie("Przysiady ze sztangą", 1);
                dao.insert(cw9);
                Cwiczenie cw10 = new Cwiczenie("Martwy ciąg", 2);
                dao.insert(cw10);
                Cwiczenie cw11 = new Cwiczenie("Hip thrust", 1);
                dao.insert(cw11);
                Cwiczenie cw12 = new Cwiczenie("Przysiad bułgarski", 1);
                dao.insert(cw12);
            });
        }
    };

    static CwiczenieDatabase getDatabase(final Context context)
    {
        if (databaseInstance == null) {
            synchronized (CwiczenieDatabase.class) {
                if (databaseInstance == null) {
                    databaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                                    CwiczenieDatabase.class, "cwiczenie_database")
                            .addCallback(sRoomDatabaseCallback) // Dodajemy callback tutaj
                            .build();
                }
            }
        }
        return databaseInstance;
    }
}
