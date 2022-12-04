package com.example.minsuapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.minsuapplication.fragments.BoardFragment;
import com.example.minsuapplication.fragments.OnlyDateFragment;

public class MainActivityFragment extends AppCompatActivity {


    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_fragment);
//        toolbar = findViewById(R.id.mytoolbar);
//        getSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("VIEW SHIFTS");
        Button borad = findViewById(R.id.board_btn);
        borad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, BoardFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });


        Button onlyDatebtn = findViewById(R.id.onlyDate_btn);
        onlyDatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainerView, OnlyDateFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });


    }

//    private void getSupportActionBar(Toolbar toolbar) {
//
//        toolbar.setTitle("ViewShifts");
//
//    }
}