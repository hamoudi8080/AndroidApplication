package com.example.minsuapplication;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.minsuapplication.model.Shift;
import com.example.minsuapplication.viewmodel.ShiftViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class NewShiftActivity extends AppCompatActivity {
    private ShiftViewModel shiftViewModel;

    private Button startTimeButton;
    private Button endTimeButton;

    private int startMinute;
    private int startHour;

    private int endMinute;
    private int endHour;

    private DatePickerDialog datePickerDialog;

    private Button dateButton;
    private Button dateButton2;

    private int year;
    private int month;
    private String smonth;
    private int day;

    private String date;

    private String startTime;
    private String endTime;
    private Date dateObject;
    EditText addNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_shift);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("SU CALCULATION APP");

        shiftViewModel = new ViewModelProvider(this).get(ShiftViewModel.class);

        addNote = findViewById(R.id.addNoteEditText);
        FloatingActionButton floatingActionButton = findViewById(R.id.flotbutton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (date == null) {
                    Toast.makeText(NewShiftActivity.this, " nothing to be stored", Toast.LENGTH_SHORT).show();
                    finish();
                } else {

                    shiftViewModel.insertShift(new Shift(dateObject,  startTime, endTime,addNote.getText().toString() ));
                    Toast.makeText(NewShiftActivity.this, date, Toast.LENGTH_SHORT).show();

                }

            }
        });


        intitDatePicker();
        dateButton = findViewById(R.id.set_date);
        dateButton.setText(getTodaysDate());

        dateButton2 = findViewById(R.id.set_date2);
        dateButton2.setText(getTodaysDate());


        startTimeButton = findViewById(R.id.selectTime);
        endTimeButton = findViewById(R.id.selectTime2);


    }

    private String getTodaysDate() {

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);

        month = month + 1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }


    public void startTime(View view) {

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                startHour = selectedHour;
                startMinute = selectedMinute;

                startTime = String.format(Locale.getDefault(), "%02d:%02d", selectedHour, selectedMinute);
                startTimeButton.setText(String.format(Locale.getDefault(), "%02d:%02d", startHour, startMinute));
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, startHour, startMinute, true);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    public void endTime(View view) {

        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener() {

            @Override
            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                endHour = selectedHour;
                endMinute = selectedMinute;
                endTime = String.format(Locale.getDefault(), "%02d:%02d", selectedHour, selectedMinute);
                endTimeButton.setText(String.format(Locale.getDefault(), "%02d:%02d", endHour, endMinute));
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, endHour, endMinute, true);
        timePickerDialog.setTitle("Select Time");
        timePickerDialog.show();
    }

    private void intitDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                date = makeDateString(day, month, year);
                try {
                    datePicked(day, month, year);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                dateButton.setText(date);
                dateButton2.setText(date);
            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;
        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
    }


    private Date datePicked(int day, int month, int year) throws Exception {

        String date = day + "/" + month + "/" + year;
        dateObject = new SimpleDateFormat("dd/MM/yyyy", new Locale("en_US")).parse(date);


//            Date d = new Date(year , month,day, startHour,startMinute);
//            String date = day + "/" + month + "/" + year;
//            SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
//            Date mydate = formatter1.parse(date);


        return dateObject;
    }

    private String makeDateString(int day, int month, int year) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.smonth = getMonthFormat(month);
        return getMonthFormat(month) + " " + day + " " + year;
    }


    private String getMonthFormat(int month) {
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "MAY";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AUG";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OCT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DEC";

        //default should never happen
        return "JAN";
    }

    public void setDate(View view) {

        datePickerDialog.show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



}