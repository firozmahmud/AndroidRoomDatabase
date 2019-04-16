package com.maxproit.androidroomdatabase.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Notes")
public class Note {

    @PrimaryKey(autoGenerate = true)
    public int noteId;

    @ColumnInfo(name = "note")
    public String noteTxt;


    public Note(String noteTxt) {
        this.noteTxt = noteTxt;
    }


    public int getNoteId() {
        return noteId;
    }

    public String getNoteTxt() {
        return noteTxt;
    }
}
