package com.example.minsuapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.minsuapplication.model.Note;
import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

public class NoteActivity extends AppCompatActivity {



    RecyclerView noteList;
    MyAdapter myAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        noteList = findViewById(R.id.rv);
        noteList.hasFixedSize();
        noteList.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Note> notes= new ArrayList<>();

        notes.add(new Note("Bulbasaur"));
        notes.add(new Note("Ivysaur" ));
        notes.add(new Note("Venusaur" ));
        notes.add(new Note("Charmander" ));
        notes.add(new Note("Charmeleon" ));

        myAdapter = new MyAdapter(notes);

        myAdapter.setOnClickListener(note -> {
            Toast.makeText(this, note.getDescription(), Toast.LENGTH_SHORT).show();
        });

        noteList.setAdapter(myAdapter);
    }
}