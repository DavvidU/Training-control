package com.example.treningcontrol;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class CwiczenieDatabase extends RoomDatabase {
    private static CwiczenieDatabase databaseInstance;
    static final ExecutorService databaseWriteExecutor = Executors.newSingleThreadExecutor();

    public abstract CwiczenieDAO cwiczenieDAO();

    static CwiczenieDatabase getDatabase(final Context context)
    {
        if (databaseInstance == null)
        {
            databaseInstance = Room.databaseBuilder(context.getApplicationContext(),
                    CwiczenieDatabase.class, "cwiczenie_database").build();
        }
        return databaseInstance;
    }
}
