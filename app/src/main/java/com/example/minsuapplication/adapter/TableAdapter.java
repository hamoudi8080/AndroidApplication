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

    public TableAdapter( List<Shift> shiftsDisplayData) {
        this.shiftsDisplayData = shiftsDisplayData;

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

//        Shift dat = shiftsDisplayData.get(position);
//        String getmydata = String.valueOf(dat.getDate());
//        holder.date_.setText(getmydata);


        Shift dat = shiftsDisplayData.get(position);
        Date getmydata =  dat.getDate();

        String string = String.valueOf(getmydata);
        String[] parts = string.split("00:");
        String part  = parts[0];


//        Calendar calendar = Calendar.getInstance();
//        calendar.setTime(getmydata);
//        String year  = String.valueOf(calendar.YEAR);
//        String month = String.valueOf(calendar.MONTH);
//        String day   = String.valueOf(calendar.DATE);



//        String YEAR =  String.valueOf(year);
//        String MONTH =  String.valueOf(month);
//        String DAY =  String.valueOf(day);
        holder.date_.setText(part );
//        holder.date_.setText(year +"/"+ month+"/" + day);




        Shift tota = shiftsDisplayData.get(position);
        String gettota = String.valueOf(tota.getTotalTime());
        holder.tot_.setText(gettota);





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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            loc = itemView.findViewById(R.id.location_data);
            date_ = itemView.findViewById(R.id.date_data);
            tot_ = itemView.findViewById(R.id.total_);

        }
    }
}
