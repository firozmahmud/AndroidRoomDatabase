package com.maxproit.androidroomdatabase;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private NoteViewModel noteViewModel;
    private EditText noteEt;
    private Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);


        initViews();

        initListeners();

    }

    private void initViews() {
        noteEt = findViewById(R.id.noteEt);
        saveBtn = findViewById(R.id.saveBtn);
    }

    private void initListeners() {
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!TextUtils.isEmpty(noteEt.getText())) {

                    noteViewModel.insert(new Note(noteEt.getText().toString().trim()));
                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Enter note", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
