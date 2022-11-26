package com.example.minsuapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;


import com.example.minsuapplication.fragments.FragmentMainActivity;

public class MainActivity extends AppCompatActivity {

    private Button newShiftButton;
    private Button view_shiftsBtn;
    private Button viewNotes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("SU CALCULATION APP");


        newShiftButton = findViewById(R.id.new_shiftButton);

        newShiftButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, NewShiftActivity.class);
            startActivity(intent);
        });

        viewNotes = findViewById(R.id.viewMyNotes);

        viewNotes.setOnClickListener(view -> {
            Intent intent = new Intent(this, NoteMainActivity.class);
            startActivity(intent);
        });

        view_shiftsBtn = findViewById(R.id.view_shifts);

        view_shiftsBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, DataDisplayActivity.class);
            startActivity(intent);
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


}