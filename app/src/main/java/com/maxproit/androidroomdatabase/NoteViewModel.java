package com.maxproit.androidroomdatabase;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

public class NoteViewModel extends AndroidViewModel {

    private NoteDao noteDao;
    private NoteRoomDatabase noteRoomDatabase;


    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteRoomDatabase = NoteRoomDatabase.getDatabase(application);
        noteDao = noteRoomDatabase.noteDao();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        // View Model Destroyed
    }


    public void insert(Note note) {
        new InsertAsyncTask(noteDao).execute(note);
    }
}


class InsertAsyncTask extends AsyncTask<Note, Void, Void> {

    NoteDao noteDao;

    public InsertAsyncTask(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    @Override
    protected Void doInBackground(Note... notes) {

        noteDao.insert(notes[0]);
        return null;
    }
}