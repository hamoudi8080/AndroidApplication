package com.example.minsuapplication;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.minsuapplication.dao.NoteDao;
import com.example.minsuapplication.dao.ShiftDao;
import com.example.minsuapplication.model.Note;
import com.example.minsuapplication.repository.NoteRepository;
import com.example.minsuapplication.viewmodel.NoteViewModel;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NotesAdapterVH> {

    private List<Note> noteList;

    private Context context;
    TextView textView ;
    OnListItemClickListener listener;
    public NotesAdapter(OnListItemClickListener listener){
        this.listener = listener;
    }
    public void setData(List<Note> noteList ){
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
        int x = position;
        Note notes = noteList.get(position);
        String mynotes = notes.getDescription();
        holder.notes.setText(mynotes);

//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }

    class NotesAdapterVH extends RecyclerView.ViewHolder{

        TextView notes;
        TextView timeOutput;
        private NotesAdapter adapter;
        NotesAdapterVH(@NonNull View itemView ) {
            super(itemView);

            notes = itemView.findViewById(R.id.notes_row);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(getAdapterPosition());
                }
            });



        }
    }
    public interface OnListItemClickListener{
        void onClick(int position);
    }

}
