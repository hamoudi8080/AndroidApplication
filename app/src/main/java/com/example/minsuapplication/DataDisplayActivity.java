package com.example.minsuapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import com.example.minsuapplication.adapter.TableAdapter;
import com.example.minsuapplication.model.Note;
import com.example.minsuapplication.model.Shift;

import com.example.minsuapplication.viewmodel.ShiftViewModel;

import java.util.ArrayList;
import java.util.List;

public class DataDisplayActivity extends AppCompatActivity implements TableAdapter.OnListItemClickListener{
    RecyclerView recyclerView;
    TableAdapter shiftAdapter;
    ShiftViewModel shiftViewModel;
    private List<Shift> shiftList;
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

                    shiftList = myShifts;
                    shiftAdapter = new TableAdapter(myShifts, DataDisplayActivity.this);
                    recyclerView.setAdapter(shiftAdapter);
                }
            }
        });





    }

    @Override
    public void onClick(int position) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Delete Confirmation");
        alert.setMessage("Are you sure you want to delete this item?");
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {


            public void onClick(DialogInterface dialog, int which) {
                // continue with delete

                int id = shiftList.get(position).getId();

                shiftViewModel.deleteItem(id);

                Toast.makeText(DataDisplayActivity.this, "The it has been deleted", Toast.LENGTH_SHORT).show();

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