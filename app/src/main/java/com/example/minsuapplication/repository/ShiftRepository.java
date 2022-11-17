package com.example.minsuapplication.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.minsuapplication.dao.ShiftDao;


import com.example.minsuapplication.model.Shift;
import com.example.minsuapplication.myNewDatabase.MYDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShiftRepository {
    private static ShiftRepository instance;
    private final ShiftDao shiftDao;
    private final ExecutorService executorService;

    private final LiveData<List<Shift>> allNotes;
 

    private ShiftRepository(Application application) {
        MYDatabase database = MYDatabase.getInstance(application);
        shiftDao = database.shiftDao();
        allNotes = shiftDao.getNote();
        executorService = Executors.newFixedThreadPool(5);
    }

    public static synchronized ShiftRepository getInstance(Application application) {
        if (instance == null)
            instance = new ShiftRepository(application);

        return instance;
    }

    public void insert(Shift shift){

        executorService.execute(() -> shiftDao.insert(shift));
    }

    public LiveData<List<Shift>> getNote(){

       return allNotes;
    }
}
