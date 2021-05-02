package com.example.lab_assignment3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

public class NoteEditorActivity extends AppCompatActivity {
    int nodeId;
    public String da;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_editor);
        EditText editText=(EditText) findViewById(R.id.editTextTextMultiLine);
        Intent intent=getIntent();
        nodeId=intent.getIntExtra("nodeId",-1);
        if(nodeId!=-1){
            editText.setText(MainActivity.notes.get(nodeId));
        }
        else
        {
            Date Time= Calendar.getInstance().getTime();
            da=Time.toString();
            intent.putExtra("date",da);
            MainActivity.notes.add("");
            nodeId=MainActivity.notes.size() -1;
            MainActivity.arrayAdapter.notifyDataSetChanged();
        }
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                MainActivity.notes.set(nodeId,String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}