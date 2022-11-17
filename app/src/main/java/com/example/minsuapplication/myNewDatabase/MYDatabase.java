package com.example.minsuapplication.myNewDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.minsuapplication.dao.ShiftDao;
import com.example.minsuapplication.model.Shift;

@Database(entities = {Shift.class}, version = 1)

public abstract class MYDatabase extends RoomDatabase {

    private static MYDatabase INSTANCE;

    public abstract ShiftDao shiftDao();


    public static synchronized MYDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MYDatabase.class, "myOriginaldatabase")

                    .build();
        }
        return INSTANCE;
    }


}
