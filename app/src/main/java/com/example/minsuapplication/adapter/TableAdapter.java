package com.example.minsuapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minsuapplication.DataDisplayActivity;
import com.example.minsuapplication.R;
import com.example.minsuapplication.model.Note;
import com.example.minsuapplication.model.Shift;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {


    private List<Shift> shiftsDisplayData;
    OnListItemClickListener listener;


    public TableAdapter(List<Shift> shiftsDisplayData, OnListItemClickListener listener) {
        this.shiftsDisplayData = shiftsDisplayData;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_table_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Shift loca = shiftsDisplayData.get(position);
        String getmyLocation = loca.getMyLocation();
        holder.loc.setText(getmyLocation);


        Shift dat = shiftsDisplayData.get(position);
        Date getmydata = dat.getDate();

        String string = String.valueOf(getmydata);
        String[] parts = string.split("00:");
        String part = parts[0];


        holder.date_.setText(part);


        Shift tota = shiftsDisplayData.get(position);
        String gettota = String.valueOf(tota.getTotalTime());
        holder.tot_.setText(gettota);


        Shift s_time = shiftsDisplayData.get(position);
        String getstarttime = String.valueOf(s_time.getStartTime());
        holder.sTime.setText(getstarttime);



        Shift e_time = shiftsDisplayData.get(position);
        String getendtime = String.valueOf(e_time.getEndTime());
        holder.eTime.setText(getendtime);

//        holder.loc.setText(shiftsDisplayData.get(position).getMyLocation());
//
//        holder.date_.setText(  shiftsDisplayData.get(position).getStartTime());
//       holder.tot_.setText(shiftsDisplayData.get(position).getEndTime());

    }

    @Override
    public int getItemCount() {
        return shiftsDisplayData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView loc;
        TextView date_;
        TextView tot_;

        TextView sTime;
        TextView eTime;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            loc = itemView.findViewById(R.id.location_data);
            date_ = itemView.findViewById(R.id.date_data);
            tot_ = itemView.findViewById(R.id.total_);

            sTime = itemView.findViewById(R.id.start_time);
            eTime = itemView.findViewById(R.id.end_time);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    listener.onClick(getAdapterPosition());
                }
            });

        }
    }

    public interface OnListItemClickListener {
        void onClick(int position);
    }
}
