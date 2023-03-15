package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import data.DataBaseHandler;

public class DisplayWish extends AppCompatActivity {
    private DataBaseHandler dba;
    private ArrayList<MyWish> dbWishes = new ArrayList<>();
    private WishAdapter wishAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_wish);
        refreshData();
    }
    private void refreshData() { dbWishes.clear();
        dba = new DataBaseHandler(getApplicationContext());
        ArrayList<MyWish> wishesFromDB = dba.getWishes();
        for (int i = 0; i < wishesFromDB.size(); i++) {
            String title = wishesFromDB.get(i).getTitle();
            String dateText = wishesFromDB.get(i).getDate();
            String content = wishesFromDB.get(i).getContent();
            int mid = wishesFromDB.get(i).getID();
            MyWish myWish = new MyWish();
            myWish.setTitle(title); myWish.setContent(content);
            myWish.setDate(dateText);
            myWish.setID(mid);
            dbWishes.add(myWish);
        }
        dba.close();
        wishAdapter = new WishAdapter(this,R.layout.wishrow, dbWishes);
        ListView view = findViewById(R.id.list);
        if(view != null) {
            view.setAdapter(wishAdapter);
        }
        wishAdapter.notifyDataSetChanged();
    }
    public class WishAdapter extends ArrayAdapter<MyWish> {
        Activity activity;
        int layoutResource;
        MyWish wish;
        ArrayList<MyWish> mData = new ArrayList<>();

        public WishAdapter(Activity act, int resource, ArrayList<MyWish> data) {
            super(act, resource, data);
            activity = act;
            layoutResource = resource;
            mData = data;
            notifyDataSetChanged();
            Log.d("Haku Debug: ", ":)");
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public MyWish getItem(int position) {
            return mData.get(position);
        }

        @Override
        public int getPosition(MyWish item) {
            return super.getPosition(item);
        }

        @Override
        public long
        getItemId(int position) {
            return
                    super.getItemId(position);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row = convertView;
            ViewHolder holder = null;
            if (row == null || (row.getTag()) == null) {
                LayoutInflater inflater = LayoutInflater.from(activity);
                row = inflater.inflate(layoutResource, null);
                holder = new ViewHolder();
                holder.mTitle = (Button)
                        row.findViewById(R.id.name);
                holder.mDate = (TextView) row.findViewById(R.id.dateText);
                row.setTag(holder); } else
            {
                holder = (ViewHolder) row.getTag(); } holder.myWish =
                    getItem(position);
            holder.mTitle.setText(holder.myWish.getTitle());
            holder.mDate.setText(holder.myWish.getDate());
            final ViewHolder finalHolder = holder;
            Log.d("Haku Debug: ", "view");

            holder.mTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Haku Debug: ", "click");
                    String text = finalHolder.myWish.getContent().toString();
                    String dateText = finalHolder.myWish.getDate().toString();
                    String title = finalHolder.myWish.getTitle().toString();
                    int mid = finalHolder.myWish.getID();
                    Log.v("MyId: ", String.valueOf(mid));
                    Intent i = new Intent(DisplayWish.this, WishDetailActivity.class);
                    i.putExtra("content", text);
                    i.putExtra("date", dateText);
                    i.putExtra("title", title);
                    i.putExtra("id", mid);
                    startActivity(i);
                }
            });
            return row;
        }
    }
}