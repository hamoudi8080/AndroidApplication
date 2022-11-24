package com.example.minsuapplication.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.minsuapplication.dao.NoteDao;
import com.example.minsuapplication.dao.ShiftDao;
import com.example.minsuapplication.model.Note;
import com.example.minsuapplication.model.Shift;
import com.example.minsuapplication.myNewDatabase.MYDatabase;
import com.example.minsuapplication.myNewDatabase.NoteDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NoteRepository {

    private static NoteRepository instance;
    private final NoteDao noteDao;
    private final ExecutorService executorService;

    private final LiveData<List<Note>> allNotes;


    private NoteRepository(Application application) {
        NoteDatabase database = NoteDatabase.getInstance(application);
        noteDao = database.noteDao();
        allNotes = noteDao.getNote();
        executorService = Executors.newFixedThreadPool(5);
    }

    public static synchronized NoteRepository getInstance(Application application) {
        if (instance == null)
            instance = new NoteRepository(application);

        return instance;
    }

    public void insert(Note note){

        executorService.execute(() -> noteDao.insert(note));
    }

    public LiveData<List<Note>> getAllNote(){

        return allNotes;
    }

    public void deleteItem(int id){
        String ida = String.valueOf(id);
        noteDao.deleteByItemId(id);
    }


}
