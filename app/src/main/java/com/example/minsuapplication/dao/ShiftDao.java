package com.example.minsuapplication.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

import com.example.minsuapplication.model.Shift;

@Dao
public interface ShiftDao {

    @Insert
    void insert(Shift shift);

    @Delete
    void delete(Shift shift);


//
//    @Query("DELETE FROM note_table")
//    void deleteAllNotes();
//
//    @Query("SELECT * FROM note_table ORDER BY priority DESC")
//    LiveData<List<Note>> getAllNotes();



}
