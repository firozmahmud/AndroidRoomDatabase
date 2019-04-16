package com.maxproit.androidroomdatabase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface NoteDao {

    @Insert
    public void insert(Note note);
}
