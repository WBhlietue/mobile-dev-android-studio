package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.CursorLoader;
import androidx.loader.content.Loader;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class Lab5_2 extends AppCompatActivity implements  LoaderManager.LoaderCallbacks<Cursor> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab52);
        resultView= (TextView) findViewById(R.id.res);
    }
    TextView resultView=null;
    CursorLoader cursorLoader;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
    public void onClickDisplayNames(View view) {
        getSupportLoaderManager().initLoader(1, null, this);
    }
    @Override
    public Loader<Cursor> onCreateLoader(int arg0, Bundle arg1) {
        cursorLoader= new CursorLoader(this,
                Uri.parse("content://com.example.myapplication.MyProvider/cte"), null, null, null, null);
        return cursorLoader;
    }
    @Override
    public void onLoadFinished(Loader<Cursor> arg0, Cursor cursor) {
        cursor.moveToFirst();
        StringBuilder res=new StringBuilder();
        while (!cursor.isAfterLast()) {
            int a = cursor.getColumnIndex("id");
            if( a< 0){
                a = 0;
            }
            int b = cursor.getColumnIndex("name");
            if(b < 0){
                b = 0;
            }
            res.append("\n"+cursor.getString(a)+ "-"+
                    cursor.getString(b));
            cursor.moveToNext();
        }
        resultView.setText(res);
    }
    @Override
    public void onLoaderReset(Loader<Cursor> arg0) {
// TODO Auto-generated method stub
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}