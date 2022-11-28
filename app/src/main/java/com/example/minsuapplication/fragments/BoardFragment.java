package com.example.minsuapplication.fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.minsuapplication.R;
import com.example.minsuapplication.adapter.NotesAdapter;
import com.example.minsuapplication.adapter.TableAdapter;
import com.example.minsuapplication.model.Shift;
import com.example.minsuapplication.viewmodel.ShiftViewModel;

import java.util.List;

public class BoardFragment extends Fragment implements TableAdapter.OnListItemClickListener{



    RecyclerView recyclerView;
    TableAdapter shiftAdapter;
    ShiftViewModel shiftViewModel;
    private List<Shift> shiftList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        recyclerView = view.findViewById(R.id.table_recycleView);
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        shiftViewModel = new ViewModelProvider(this).get(ShiftViewModel.class);


        shiftViewModel.getDataForTABLE().observe(getActivity(), new Observer<List<Shift>>() {
            @Override
            public void onChanged(List<Shift> myShifts) {
                if (myShifts.size() > 0){

                    shiftList = myShifts;
                    shiftAdapter = new TableAdapter(myShifts, BoardFragment.this);
                    recyclerView.setAdapter(shiftAdapter);
                }
            }
        });


        return view;


    }

    @Override
    public void onClick(int position) {

        AlertDialog.Builder alert = new AlertDialog.Builder(getContext());

        alert.setTitle("Delete Confirmation");
        alert.setMessage("Are you sure you want to delete this item?");
        alert.setPositiveButton("yes", new DialogInterface.OnClickListener() {


            public void onClick(DialogInterface dialog, int which) {
                // continue with delete

                int id = shiftList.get(position).getId();

                shiftViewModel.deleteItem(id);


                Toast.makeText(getContext(), "The it has been deleted", Toast.LENGTH_SHORT).show();

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