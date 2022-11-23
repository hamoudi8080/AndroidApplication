package com.example.minsuapplication.myNewDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.minsuapplication.dao.ShiftDao;
import com.example.minsuapplication.model.DateTypeConverter;
import com.example.minsuapplication.model.Shift;

@Database(entities = {Shift.class}, version = 4)
@TypeConverters({DateTypeConverter.class})
public abstract class MYDatabase extends RoomDatabase {

    private static MYDatabase INSTANCE;

    public abstract ShiftDao shiftDao();


    public static synchronized MYDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MYDatabase.class, "myOriginaldatabase")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            try {
                database.execSQL("ALTER TABLE Shift rename to shift_table "
                );


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

}
