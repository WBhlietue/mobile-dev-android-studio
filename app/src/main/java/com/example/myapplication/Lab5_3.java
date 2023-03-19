
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Lab5_3 extends AppCompatActivity {
    Button btn1, btn2;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab53);
        intent = new Intent(this, MusicServices.class);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService(intent);
                Toast.makeText(getApplicationContext(), "Started", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
                Toast.makeText(getApplicationContext(), "Stoped", Toast.LENGTH_SHORT).show();
            }
        });
    }
}