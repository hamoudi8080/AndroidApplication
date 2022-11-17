//package com.example.minsuapplication;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//
//import androidx.lifecycle.LiveData;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.minsuapplication.model.Shift;
//
//import java.util.ArrayList;
//
//
//public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{
//
//    Context context;
//    ArrayList<Shift> notes;
//    private OnClickListener onClickListener;
//
//    public MyAdapter(LiveData<ArrayList<Shift>> notes) {
//        this.notes = notes;
//    }
//    public void setOnClickListener(OnClickListener listener) {
//        this.onClickListener = listener;
//    }
//
//    @NonNull
//
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
//        View view = inflater.inflate(R.layout.note_page, parent, false);
//        return new MyViewHolder(view);
//
//
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        holder.DescriptionOutput.setText(notes.get(position).getNote());
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return notes.size();
//    }
//
//      class MyViewHolder extends RecyclerView.ViewHolder{
//
//        TextView DescriptionOutput;
//        TextView timeOutput;
//
//         MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            DescriptionOutput = itemView.findViewById(R.id.tv_name);
//
////            timeOutput = itemView.findViewById(R.id.timeoutput);
//
//            itemView.setOnClickListener(v -> {
//                onClickListener.onClick(notes.get(getBindingAdapterPosition()));
//            });
//        }
//    }
//
//    public interface OnClickListener {
//        void onClick(Shift note);
//    }
//}
