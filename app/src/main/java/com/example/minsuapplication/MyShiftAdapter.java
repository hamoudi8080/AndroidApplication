package com.example.minsuapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.example.minsuapplication.model.Note;
import com.example.minsuapplication.model.Shift;
import com.example.minsuapplication.viewmodel.ShiftViewModel;

import java.util.ArrayList;
import java.util.List;



public class MyShiftAdapter extends RecyclerView.Adapter<MyShiftAdapter.MyViewHolder>{

    Context context;

//    private ShiftViewModel shiftViewModel ;

    private  List<Shift> shifts;

    private OnClickListener onClickListener;

    public MyShiftAdapter(ArrayList<Shift> shifts) {
        this.shifts = shifts;

    }
    public void setOnClickListener(OnClickListener listener) {
        this.onClickListener = listener;
    }

    @NonNull

    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.note_page, parent, false);
        return new MyViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Shift notes = shifts.get(position);
        String myNote= notes.getNote();
        String s = "heeoo";
        holder.DescriptionOutput.setText(s);

    }

    @Override
    public int getItemCount() {
        return shifts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView DescriptionOutput;
        TextView timeOutput;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            DescriptionOutput = itemView.findViewById(R.id.tv_name);

//            timeOutput = itemView.findViewById(R.id.timeoutput);

            itemView.setOnClickListener(v -> {
                onClickListener.onClick(shifts.get(getBindingAdapterPosition()));
            });
        }
    }

    public interface OnClickListener {
        void onClick(Shift note);
    }
}
