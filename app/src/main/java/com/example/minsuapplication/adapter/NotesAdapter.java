package com.example.minsuapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minsuapplication.R;
import com.example.minsuapplication.model.Note;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesAdapterVH> {

    private List<Note> noteList;

    private Context context;
    TextView textView;
    OnListItemClickListener listener;

    public NotesAdapter(OnListItemClickListener listener) {
        this.listener = listener;
    }

    public void setData(List<Note> noteList) {
        this.noteList = noteList;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public NotesAdapterVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new NotesAdapter.NotesAdapterVH(LayoutInflater.from(context).inflate(R.layout.row_notes, null));
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapterVH holder, int position) {
        int x = position;
        Note notes = noteList.get(position);
        String mynotes = notes.getDescription();
        holder.notes.setText(mynotes);


    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    class NotesAdapterVH extends RecyclerView.ViewHolder {

        TextView notes;
        ImageView deleteButton;


        NotesAdapterVH(@NonNull View itemView) {
            super(itemView);

            notes = itemView.findViewById(R.id.notes_row);
            deleteButton = itemView.findViewById(R.id.item_delete);

//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    listener.onClick(getAdapterPosition());
//                }
//            });

            deleteButton.setOnClickListener(view -> {
                listener.onClick(getAdapterPosition());
            });


        }
    }

    public interface OnListItemClickListener {
        void onClick(int position);
    }

}
