package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class Lab5_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab51);
    }
    public void onClickAddName(View view) {
        ContentValues values = new ContentValues();
        values.put(MyProvider.name, ((EditText) findViewById(R.id.txtName))
                .getText().toString());
        Uri uri = getContentResolver().insert(MyProvider.CONTENT_URI, values);
        Toast.makeText(getBaseContext(), "New record inserted", Toast.LENGTH_LONG)
                .show();
    }
}

