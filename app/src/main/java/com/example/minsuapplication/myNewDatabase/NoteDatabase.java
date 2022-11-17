package com.example.minsuapplication.myNewDatabase;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import com.example.minsuapplication.dao.NoteDao;

import com.example.minsuapplication.model.Note;

@Database(entities = {Note.class}, version = 1)

public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase INSTANCE;

    public abstract NoteDao noteDao();


    public static synchronized NoteDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            NoteDatabase.class, "myNoteDataBase")

                    .build();
        }
        return INSTANCE;
    }
}
