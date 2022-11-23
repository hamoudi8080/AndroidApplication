package com.example.minsuapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.minsuapplication.adapter.TableAdapter;
import com.example.minsuapplication.model.Shift;

import com.example.minsuapplication.viewmodel.ShiftViewModel;

import java.util.ArrayList;
import java.util.List;

public class DataDisplayActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    TableAdapter shiftAdapter;
     ShiftViewModel shiftViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.display_data_viewer);

        recyclerView = findViewById(R.id.table_recycleView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        shiftViewModel = new ViewModelProvider(this).get(ShiftViewModel.class);


        shiftViewModel.getDataForTABLE().observe(this, new Observer<List<Shift>>() {
            @Override
            public void onChanged(List<Shift> myShifts) {
                if (myShifts.size() > 0){
                    shiftAdapter = new TableAdapter(myShifts);
                    recyclerView.setAdapter(shiftAdapter);
                }
            }
        });

//                shiftAdapter = new TableAdapter(list);
//        recyclerView.setAdapter(shiftAdapter);






//        ArrayList<ShiftDumymodel> list = new ArrayList<ShiftDumymodel>() ;
//        list.add(new ShiftDumymodel("cop","20-02-2022","2.5"));
//        list.add(new ShiftDumymodel("cop","20-02-2022","2.5"));
//        list.add(new ShiftDumymodel("cop","20-02-2022","2.5"));
//        list.add(new ShiftDumymodel("cop","20-02-2022","2.5"));
//
//        list.add(new ShiftDumymodel("cop","20-02-2022","2.5"));
//
//        shiftAdapter = new TableAdapter(list);
//        recyclerView.setAdapter(shiftAdapter);




    }
}