//package com.example.minsuapplication;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.lifecycle.LiveData;
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProvider;
//import androidx.recyclerview.widget.DividerItemDecoration;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import android.os.Bundle;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.example.minsuapplication.model.Shift;
//import com.example.minsuapplication.viewmodel.ShiftViewModel;
//
//import java.util.ArrayList;
//import java.util.List;//
//public class NoteActivity extends AppCompatActivity {
//
//
//    private ShiftViewModel shiftViewModel ;
//
//    List<Shift> ary;
//
//    RecyclerView noteList;
////    MyAdapter myAdapter;
//
//    MyShiftAdapter myAdapter;
//    RecyclerView recyclerView;
//
//    private TextView textView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_note);
//
//        recyclerView = findViewById(R.id.rv);
//
//        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//
////        shiftViewModel.getNote().observe(this, new Observer<List<Shift>>() {
////            @Override
////            public void onChanged(List<Shift> shifts) {
////                if(shifts.)
////            }
////        });
//
//
//
//
//
//
////        shiftViewModel = new ViewModelProvider(this).get(ShiftViewModel.class);
////
////
////
////
////
////       ary = (List<Shift>) shiftViewModel.getNote();
////
////
////
////
////
////        noteList = findViewById(R.id.rv);
////        noteList.hasFixedSize();
////        noteList.setLayoutManager(new LinearLayoutManager(this));
////
////
////
//////        ArrayList<Note> notes= new ArrayList<>();
//////
//////        notes.add(new Note("Bulbasaur"));
//////        notes.add(new Note("Ivysaur" ));
//////        notes.add(new Note("Venusaur" ));
//////        notes.add(new Note("Charmander" ));
//////        notes.add(new Note("Charmeleon" ));
////
//////        myAdapter = new MyShiftAdapter((ArrayList<Shift>) ary);
//////
//////
//////        myAdapter.setOnClickListener(new MyShiftAdapter.OnClickListener() {
//////            @Override
//////            public void onClick(Shift note) {
//////                Toast.makeText(NoteActivity.this, note.getNote()), Toast.LENGTH_SHORT).show();
//////            }
//////        });
////
////        noteList.setAdapter(myAdapter);
//    }
//}