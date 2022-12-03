package com.example.minsuapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minsuapplication.R;
import com.example.minsuapplication.model.Shift;

import java.util.Date;
import java.util.List;

public class DateTableAdapter extends RecyclerView.Adapter<DateTableAdapter.ViewHolder>{
    private List<Shift> shiftsDisplayData;
     OnListItemClickListener listener;


    public DateTableAdapter(List<Shift> shiftsDisplayData,  OnListItemClickListener listener) {
        notifyDataSetChanged();
        this.shiftsDisplayData = shiftsDisplayData;

        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.rv_table_layout_date, parent, false);
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


    public interface OnListItemClickListener {
        void onClick(int position);
    }

}
