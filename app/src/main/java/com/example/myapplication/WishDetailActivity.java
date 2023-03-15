package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

import data.DataBaseHandler;

public class WishDetailActivity extends AppCompatActivity {
    private TextView title, date, content;
    private Button deleteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wishdetail);
        title = (TextView) findViewById(R.id.detailsTitle);
        date =
                (TextView) findViewById(R.id.detailsDateText);
        content =
                (TextView) findViewById(R.id.detailsTextView);
        deleteButton =
                (Button) findViewById(R.id.deleteButton);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            title.setText(extras.getString("title"));
            date.setText("Created: " + extras.getString("date"));
            content.setText(" \" " + extras.getString("content") + " \" ");
            final int id =
                    extras.getInt("id");
            deleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DataBaseHandler dba = new DataBaseHandler(getApplicationContext());
                    dba.DeleteWish(id);
                    Toast.makeText(getApplicationContext(), "Wish Deleted!",
                            Toast.LENGTH_LONG).show();
                    startActivity(new Intent(WishDetailActivity.this, DisplayWish.class));
                    WishDetailActivity.this.finish();
                }
            });
        }
    }
}