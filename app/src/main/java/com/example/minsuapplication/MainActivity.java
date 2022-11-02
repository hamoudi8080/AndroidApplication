package com.example.minsuapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private Button newShiftButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        newShiftButton = findViewById(R.id.new_shiftButton);

        newShiftButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, NewShiftActivity.class);
            startActivity(intent);
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main_menu, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//
//    public void startTime(View view) {
//
//        TimePickerDialog.OnTimeSetListener onTimeSetListener= new TimePickerDialog.OnTimeSetListener(){
//
//            @Override
//            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
//                hour = selectedHour;
//                minute = selectedMinute;
//                startTimeButton.setText(String.format(Locale.getDefault(),"%02d:%02d", hour, minute));
//            }
//        };
//        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);
//        timePickerDialog.setTitle("Select Time");
//        timePickerDialog.show();
//    }




//
//
//    Button startTimeButton;
//    Button endTimeButton;
//    int hour, minute;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.new_shift);
//
//        startTimeButton = findViewById(R.id.selectTime);
//        endTimeButton = findViewById(R.id.selectTime2);
//    }
//
//
//
//    public void startTime(View view) {
//
//        TimePickerDialog.OnTimeSetListener onTimeSetListener = new TimePickerDialog.OnTimeSetListener(){
//
//            @Override
//            public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
//                hour = selectedHour;
//                minute = selectedMinute;
//                startTimeButton.setText(String.format(Locale.getDefault(),"%02d:%02d", hour, minute));
//            }
//        };
//        TimePickerDialog timePickerDialog = new TimePickerDialog(this, onTimeSetListener, hour, minute, true);
//        timePickerDialog.setTitle("Select Time");
//        timePickerDialog.show();
//    }
}