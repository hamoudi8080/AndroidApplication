package com.example.minsuapplication.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.example.minsuapplication.DataDisplayActivity;
import com.example.minsuapplication.NewShiftActivity;
import com.example.minsuapplication.NoteMainActivity;
import com.example.minsuapplication.R;
import com.example.minsuapplication.fragments.AboutFragment;
import com.example.minsuapplication.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class FragmentMainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment();
    AboutFragment aboutFragment = new AboutFragment();

    private Button newShiftButton;
    private Button view_shiftsBtn;
    private Button viewNotes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_main);

        bottomNavigationView  = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,homeFragment).commit();
                        return true;
                    case R.id.about:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container,aboutFragment).commit();
                        return true;

                }

                return false;
            }
        });


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