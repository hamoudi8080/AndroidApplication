package com.example.minsuapplication.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.minsuapplication.dao.ShiftDao;


import com.example.minsuapplication.model.Shift;
import com.example.minsuapplication.myNewDatabase.MYDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShiftRepository {
    private static ShiftRepository instance;
    private final ShiftDao shiftDao;
    private final ExecutorService executorService;

    //private final LiveData<List<something>> getalldata;

    private ShiftRepository(Application application) {
        MYDatabase database = MYDatabase.getInstance(application);
        shiftDao = database.shiftDao();
        //allNotes = noteDao.getAllNotes();
        executorService = Executors.newFixedThreadPool(2);
    }

    public static synchronized ShiftRepository getInstance(Application application) {
        if (instance == null)
            instance = new ShiftRepository(application);

        return instance;
    }

    public void insert(Shift shift){

        executorService.execute(() -> shiftDao.insert(shift));
    }
}
