package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.*;

import java.util.concurrent.TimeUnit;

public class Lab4_3 extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    public TextView songName, duration;
    private double timeElapsed = 0, finalTime = 0; private
    int forwardTime = 2000, backwardTime = 2000; private
    Handler durationHandler = new Handler(); private
    SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab43);
        RadioButton btn1 = findViewById(R.id.radioButton3);
        RadioButton btn2 = findViewById(R.id.radioButton2);
        RadioButton btn3 = findViewById(R.id.radioButton);
        btn1.isChecked();
        btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    pause(null);
                    initializeViews(R.raw.m1, "music1");
                }
            }
        });
        btn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    pause(null);
                    initializeViews(R.raw.m2, "music2");
                }
            }
        });
        btn3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    pause(null);
                    initializeViews(R.raw.m3, "music3");
                }
            }
        });


        initializeViews(R.raw.m1, "music1");
    }
    public void initializeViews(int res, String name){
        songName = (TextView) findViewById(R.id.songName);
        mediaPlayer = MediaPlayer.create(this, res);
        finalTime = mediaPlayer.getDuration();
        duration = (TextView) findViewById(R.id.songDuration);
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        songName.setText(name+".mp3");
        seekbar.setMax((int) finalTime);
        seekbar.setClickable(false);
    }
    public void play(View view) {
        mediaPlayer.start();
        timeElapsed = mediaPlayer.getCurrentPosition();
        seekbar.setProgress((int) timeElapsed);
        durationHandler.postDelayed(updateSeekBarTime, 100);
    }
    private Runnable updateSeekBarTime = new Runnable() {
        public void run() {
            timeElapsed = mediaPlayer.getCurrentPosition();
            seekbar.setProgress((int) timeElapsed);
            double timeRemaining = finalTime - timeElapsed;
            duration.setText(String.format("%d min, %d sec", TimeUnit.MILLISECONDS.toMinutes((long)
                    timeRemaining), TimeUnit.MILLISECONDS.toSeconds((long) timeRemaining) -
                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining))));
            durationHandler.postDelayed(this, 100);
        }
    };
    public void pause(View view) {
        mediaPlayer.pause();
    }
    public void forward(View view) {
        if ((timeElapsed + forwardTime)<= finalTime) {
            timeElapsed = timeElapsed - backwardTime;
            mediaPlayer.seekTo((int) timeElapsed);
        }
    }
}