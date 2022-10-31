package com.example.minsuapplication.model;

import java.text.Format;
import java.util.Date;

public class Shift {

    private String shiftStart;
    private String shiftEnd;
    private double totalPaid;

    public Shift(String shiftStart, String shiftEnd, double totalPaid) {
        this.shiftStart = shiftStart;
        this.shiftEnd = shiftEnd;
        this.totalPaid = totalPaid;
    }

    public String getShiftStart() {
        return shiftStart;
    }

    public void setShiftStart(String shiftStart) {
        this.shiftStart = shiftStart;
    }

    public String getShiftEnd() {
        return shiftEnd;
    }

    public void setShiftEnd(String shiftEnd) {
        this.shiftEnd = shiftEnd;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public void setTotalPaid(double totalPaid) {
        this.totalPaid = totalPaid;
    }
}
