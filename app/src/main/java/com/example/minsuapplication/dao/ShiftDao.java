package com.example.minsuapplication.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.minsuapplication.model.Shift;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface ShiftDao {

    @Insert
    void insert(Shift shift);

    @Delete
    void delete(Shift shift);

//    @Query("Select * FROM shift_table")
//    LiveData<List<Shift>> getNote();

    @Query("Select * FROM shift_table")
    LiveData<List<Shift>> getDataForTABLE();

    @Query("DELETE  FROM shift_table WHERE id = :id")
    void deleteByItemId(int id);


}
