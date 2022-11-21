package com.example.minsuapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minsuapplication.model.Note;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesAdapterVH> {

    private List<Note> noteList;

    private Context context;

    public NotesAdapter(){

    }
    public void setData(List<Note> noteList){
        this.noteList = noteList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotesAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    context = parent.getContext();
    return new NotesAdapter.NotesAdapterVH( LayoutInflater.from(context).inflate(R.layout.row_notes,null));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapterVH holder, int position) {
        Note notes = noteList.get(position);
        String mynotes = notes.getDescription();
        holder.notes.setText(mynotes);
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    class NotesAdapterVH extends RecyclerView.ViewHolder{

        TextView notes;
        TextView timeOutput;

        NotesAdapterVH(@NonNull View itemView ) {
            super(itemView);

            notes = itemView.findViewById(R.id.notes_row);


        }
    }

}
