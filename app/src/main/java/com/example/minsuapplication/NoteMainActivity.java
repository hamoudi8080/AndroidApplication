package com.example.minsuapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.minsuapplication.adapter.NotesAdapter;
import com.example.minsuapplication.model.Note;
import com.example.minsuapplication.viewmodel.NoteViewModel;

import java.util.List;

public class NoteMainActivity extends AppCompatActivity implements NotesAdapter.OnListItemClickListener {

    NoteViewModel noteViewModel;
    NotesAdapter notesAdapter;
    RecyclerView recyclerView;
    Button btnNewNote;
    Button deleteITM;
    private List<Note> noteList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_note_main_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("CREATE A NOTE");
        btnNewNote = findViewById(R.id.btnNewNote);
//        deleteITM = findViewById(R.id.deleteItemBtn);
        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        notesAdapter = new NotesAdapter(this);
        recyclerView = findViewById(R.id.recycleView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        noteViewModel.getNote().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(List<Note> notes) {

//                if (notes.size() > 0) {
                    noteList = notes;
                    notesAdapter.setData(notes);
                    notesAdapter.notifyDataSetChanged();
                    recyclerView.setAdapter(notesAdapter);
//                }
            }
        });
        btnNewNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addNotes(NoteMainActivity.this);

            }
        });


    }


    public void addNotes(Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final View view1 = getLayoutInflater().inflate(R.layout.row_add_notes, null);

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


            }
        });
        builder.setView(view1);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }


    @Override
    public void onClick(int position) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Delete Confirmation");
        alert.setMessage("Are you sure you want to delete this item?");
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {


            public void onClick(DialogInterface dialog, int which) {
                // continue with delete


                int id = noteList.get(position).getId();

                noteViewModel.deleteItem(id);

                Toast.makeText(NoteMainActivity.this, "The it has been deleted", Toast.LENGTH_SHORT).show();

            }
        });
        alert.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                // close dialog
                dialog.cancel();
            }
        });
        alert.show();

    }
}