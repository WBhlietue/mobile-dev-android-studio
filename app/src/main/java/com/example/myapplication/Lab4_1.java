package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import data.DataBaseHandler;

public class Lab4_1 extends AppCompatActivity {


    private EditText title;
    private EditText content;
    private Button saveButton;
    private DataBaseHandler dba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab42);

        dba = new DataBaseHandler(this);
        title = (EditText) findViewById(R.id.titleEditText);
        content = (EditText)
                findViewById(R.id.wishEditText);
        saveButton = (Button)
                findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveToDB();
            }
        });
    }
    private void saveToDB() {
        MyWish wish = new MyWish();
        wish.setTitle(title.getText().toString().trim());
        wish.setContent(content.getText().toString().trim());
        dba.AddWish(wish);
        dba.close();
        title.setText(""); content.setText("");
        Intent i = new Intent(this, DisplayWish.class);
        startActivity(i);
    }
}