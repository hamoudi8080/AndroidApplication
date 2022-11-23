package com.example.minsuapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.minsuapplication.model.Note;
import com.example.minsuapplication.viewmodel.NoteViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class NoteMainActivity extends AppCompatActivity {

    NoteViewModel noteViewModel;
    NotesAdapter notesAdapter;
    RecyclerView recyclerView;
    Button btnNewNote;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_note_main_page);
        btnNewNote = findViewById(R.id.btnNewNote);

        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        notesAdapter = new NotesAdapter();
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        noteViewModel.getNote().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {
                if (notes.size() > 0){
                    notesAdapter.setData(notes);
                    recyclerView.setAdapter(notesAdapter);
                }
            }
        });
        btnNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNotes(NoteMainActivity.this);

            }
        });




    }

//    public void deleteItem(){
//       int id = notesAdapter.getposintion();
//        int x = 1;
//        noteViewModel.deleteItem(x);
//    }
    public void addNotes(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
       final View view1 = getLayoutInflater().inflate(R.layout.row_add_notes,null);

        Button addNotes = view1.findViewById(R.id.btnAddNotes);
        addNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edNotes = view1.findViewById(R.id.edNotes);
                Note notes = new Note();
                notes.setDescription(edNotes.getText().toString());

                noteViewModel.insertNote(notes);

                Toast.makeText(NoteMainActivity.this, "YOU HAVE ADDED A NOTE", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(NoteMainActivity.this, NoteMainActivity.class);
                startActivity(intent);
                finish();
//                View parentLayout = findViewById(android.R.id.content);
//                Snackbar.make(parentLayout, "YOU HAVE ADDED A NOTE", Snackbar.LENGTH_LONG)
//                        .setAction("SAVED", new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//
//
//                            }
//                        })
//                        .setActionTextColor(getResources().getColor(android.R.color.holo_red_light ))
//                        .show();


            }
        });
        builder.setView(view1);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}