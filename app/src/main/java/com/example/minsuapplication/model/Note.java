package com.example.minsuapplication.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "Notes_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;



    @ColumnInfo(name = "description")
    private String description;

    @Ignore
    public Note(String description) {
        this.description = description;
    }
    public Note( ) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
