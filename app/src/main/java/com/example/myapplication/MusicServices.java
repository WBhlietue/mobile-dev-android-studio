package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MusicServices extends Service {
    MediaPlayer mP1;
    @Override
    public void onCreate() {
        super.onCreate();
    }
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(), "Started Command",
                Toast.LENGTH_SHORT).show();
        mP1 = MediaPlayer.create(this, R.raw.m1);
        mP1.setLooping(true); mP1.start();
        return super.onStartCommand(intent, flags, startId);
    }
    @Override
    public void onDestroy() {
        super.onDestroy(); mP1.stop();
    }
}
