package com.example.minsuapplication.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.util.Date;


@Entity(tableName = "Shift")
public class Shift {



    @PrimaryKey(autoGenerate = true)
    private int id;
    @TypeConverters({DateTypeConverter.class})
    private Date date;
    private String startTime;
    private String endTime;
    private double hourlyPay;
    private double totalTime;
    private String note;




    //constraint set / motionlayout


    public Shift(Date date, String startTime, String endTime, String note) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getHourlyPay() {
        return hourlyPay;
    }

    public void setHourlyPay(double hourlyPay) {
        this.hourlyPay = hourlyPay;
    }

    public double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(double totalTime) {
        this.totalTime = totalTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
