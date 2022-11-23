package com.example.minsuapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.minsuapplication.model.Note;
import com.example.minsuapplication.model.Shift;
import com.example.minsuapplication.repository.NoteRepository;
import com.example.minsuapplication.repository.ShiftRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {


    private final NoteRepository repository;
    LiveData<List<Note>> noteList;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        repository = NoteRepository.getInstance(application);
    }



    public void insertNote(Note note) {
        repository.insert(note);

    }

    public LiveData<List<Note>> getNote(){

        return repository.getAllNote();
    }

    public void deleteItem(int id){
        repository.deleteItem(id);
    }

}