package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Lab2_6 extends AppCompatActivity {
    boolean meterStart = false;
    String date = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        date = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab26);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        CalendarView calendar= findViewById(R.id.lab26Calendar);
        Chronometer meter = findViewById(R.id.lab26Time);
        TimePicker picker = findViewById(R.id.lab26TimeSelect);
        RadioGroup group = findViewById(R.id.lab26radioGroup);
        RadioButton rd1= findViewById(R.id.lab26Rad1);
        RadioButton rd2= findViewById(R.id.lab26Rad2);
        calendar.setVisibility(View.INVISIBLE);
        picker.setVisibility(View.INVISIBLE);
        Button btn1 = findViewById(R.id.lab26Btn1);
        Button btn2 = findViewById(R.id.lab26Btn2);
        TextView text = findViewById(R.id.lab26Text);
        btn1.setText("Start");
        btn1.setBackgroundColor(Color.BLUE);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(meterStart){
                    meter.stop();
                    btn1.setText("Start");
                    btn1.setBackgroundColor(Color.BLUE);
                    meterStart = false;
                }else{
                    meter.setBase(SystemClock.elapsedRealtime());
                    meter.start();
                    btn1.setText("Stop");
                    btn1.setBackgroundColor(Color.RED);
                    meterStart=true;
                }
            }
        });
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if(rd1.isChecked()){
                    calendar.setVisibility(View.VISIBLE);
                    picker.setVisibility(View.INVISIBLE);
                }else if(rd2.isChecked()){
                    calendar.setVisibility(View.INVISIBLE);
                    picker.setVisibility(View.VISIBLE);
                }
            }
        });
        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                date = i + "/" + ((i1 + 1) < 10 ? "0":"") + (i1+1) + "/" +  (i2 < 10 ? "0":"") + i2;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rd1.isChecked()){
                    text.setText(date) ;
                }else if(rd2.isChecked()){
                    text.setText(picker.getCurrentHour() + ":" + (picker.getCurrentMinute() < 10 ? "0":"")+ picker.getCurrentMinute());
                }
            }
        });
    }
}