package com.example.minsuapplication.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.minsuapplication.model.Note;
import com.example.minsuapplication.model.Shift;

import java.util.List;

@Dao
public interface NoteDao {


    @Insert
    void insert(Note note);

    @Query("Select * FROM Notes_table")
    LiveData<List<Note>> getNote();


    @Query("DELETE  FROM Notes_table WHERE id = :id")
    void deleteByItemId(int id);


}
