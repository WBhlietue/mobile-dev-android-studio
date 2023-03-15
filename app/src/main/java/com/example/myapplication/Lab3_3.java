package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Lab3_3 extends AppCompatActivity {

    GridView lay;
    View btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab33);
        final GridView gv = (GridView) findViewById(R.id.gridView1);
        lay = gv;
        btn   =findViewById(R.id.lab33btn);

        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
        registerForContextMenu(btn);
    }
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo
            menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater mInflater = getMenuInflater();
        if (v == btn) {
            menu.setHeaderTitle("Changing the background color");
            mInflater.inflate(R.menu.menu2, menu);
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_red:
                lay.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_green:
                lay.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.menu_blue:
                lay.setBackgroundColor(Color.BLUE);
                return true;
        }
        return false;
    }

        public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater mInflater = getMenuInflater();
        mInflater.inflate(R.menu.menu2, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        switch (item.getItemId()) {
            case R.id.menu_red:
                lay.setBackgroundColor(Color.RED);
                return true;
            case R.id.menu_green:
                lay.setBackgroundColor(Color.GREEN);
                return true;
            case R.id.menu_blue:
                lay.setBackgroundColor(Color.BLUE);
                return true;
        }
        return false;
    }

    public class MyGridAdapter extends BaseAdapter {
        Context context;

        Drawable[] posterID ={};
        public MyGridAdapter(Context c) {
            context = c;
            List<Drawable> l = new ArrayList<>();
            for(int i = 1; i <= 43; i++){
                int res = getResources().getIdentifier("@drawable/country" + i, null, context.getPackageName());
                l.add(getResources().getDrawable(res));
            }
            posterID = new Drawable[l.size()];
            for(int i = 0; i < l.size(); i++){
                posterID[i] = l.get(i);
            }
            Log.d("Haku: ", posterID.length+"");
        }
        @Override
        public int getCount() {
            return posterID.length;
        }
        @Override
        public Object getItem(int arg0) {
            return null;
        }
        @Override
        public long getItemId(int arg0) {
            return 0;
        }
        public View getView(int position, View arg1, ViewGroup arg2) {
            final ImageView imView = new ImageView(context);
            imView.setLayoutParams(new GridView.LayoutParams(100,
                    150));
            imView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imView.setPadding(5, 5, 5, 5);
            Log.d("Haku: ", posterID.length+"");
            imView.setImageDrawable(posterID[position]);
            final int pos = position;
            imView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    View dialogView = (View)
                            View.inflate(Lab3_3.this, R.layout.dialog, null);
                    AlertDialog.Builder dbl = new
                            AlertDialog.Builder(Lab3_3.this);
                    ImageView ivPoster = (ImageView)
                            dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageDrawable(posterID[pos]);
//                    ivPoster.setScaleX(10);
//                    ivPoster.setScaleY(10);
                    dbl.setTitle("Томруулсан зураг");
//                    dbl.setIcon(R.drawable.country2);
                    dbl.setView(dialogView);
                    dbl.setNegativeButton("Хаах", null);
                    dbl.show();
                }
            });
            return imView;
        }
    }
}