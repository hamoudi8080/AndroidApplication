package com.example.minsuapplication.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.minsuapplication.model.Shift;
import com.example.minsuapplication.repository.ShiftRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ShiftViewModel extends AndroidViewModel {



    private final ShiftRepository repository;
    private double totalTime;
    private long workedMin;

    public ShiftViewModel(@NonNull Application application) {
        super(application);
        repository = ShiftRepository.getInstance(application);

    }

    public void setWorkedMin(String m){


        String string = m;
        String[] parts = string.split("m");
        String part  = parts[0];
        workedMin = Long.valueOf(Integer.parseInt(part));
    }

    public void insertShift(Shift shift) {


        String time1 = shift.getStartTime();
        String time2 = shift.getEndTime();
        Date date1 = new Date();
        Date date2 = new Date();

        SimpleDateFormat format = new SimpleDateFormat("HH:mm");

        try {
            date1 = format.parse(time1);
            date2 = format.parse(time2);
        } catch (ParseException e) {
            e.printStackTrace();
        }



        long diff = date2.getTime() - date1.getTime();

        long diffMinutes =  diff   / (60 * 1000) % 60;


        long diffHours = diff / (60 * 60 * 1000) % 24;

        long diffDays = diff / (24 * 60 * 60 * 1000);
        //long worksubtracted = diffMinutes - workedMin;

         totalTime = Double.parseDouble(diffHours + "." + (diffMinutes));

       //  totalTime =- workedMin;

        shift.setTotalTime(totalTime);

        repository.insert(shift);
        System.out.print(diffMinutes + " days, ");
        System.out.print(diffHours + " hours, ");

    }


    public String getTotalTime() {
        return String.valueOf(totalTime);
    }




    public LiveData<List<Shift>> getDataForTABLE(){

        return repository.getDataForTABLE();
    }

}
