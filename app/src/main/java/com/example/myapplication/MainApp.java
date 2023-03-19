package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

public class MainApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main2);
        Intent lab1_1 = new Intent(this, Lab1_1.class);
        Intent lab1_2 = new Intent(this, Lab1_2.class);
        Intent lab2_1 = new Intent(this, Lab2_1.class);
        Intent lab2_2 = new Intent(this, Lab2_2.class);
        Intent lab2_5 = new Intent(this, Lab2_5.class);
        Intent lab2_6 = new Intent(this, Lab2_6.class);
        Intent lab3_1 = new Intent(this, Lab3_1.class);
        Intent lab3_2 = new Intent(this, Lab3_2.class);
        Intent lab3_3 = new Intent(this, Lab3_3.class);
        Intent lab4_1 = new Intent(this, Lab4_1.class);
        Intent lab4_2 = new Intent(this, Lab4_2.class);
        Intent lab4_3 = new Intent(this, Lab4_3.class);
        Intent lab5_1 = new Intent(this, Lab5_1.class);
        Intent lab5_2 = new Intent(this, Lab5_2.class);
        Intent lab5_3 = new Intent(this, Lab5_3.class);
        Intent lab5_4 = new Intent(this, Lab5_4.class);
        Intent lab6_1 = new Intent(this, Lab6_1.class);
        Intent lab6_2 = new Intent(this, Lab6_2.class);

        findViewById(R.id.lab1_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab1_1);
            }
        });
        findViewById(R.id.lab1_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab1_2);
            }
        });
        findViewById(R.id.lab2_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab2_1);
            }
        });
        findViewById(R.id.lab2_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab2_2);
            }
        });
        findViewById(R.id.lab2_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab2_5);
            }
        });
        findViewById(R.id.lab2_6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab2_6);
            }
        });
        findViewById(R.id.lab3_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab3_1);
            }
        });
        findViewById(R.id.lab3_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab3_2);
            }
        });
        findViewById(R.id.lab3_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab3_3);
            }
        });
        findViewById(R.id.lab4_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab4_1);
            }
        });
        findViewById(R.id.lab4_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab4_2);
            }
        });
        findViewById(R.id.lab4_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab4_3);
            }
        });
        findViewById(R.id.lab5_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab5_1);
            }
        });
        findViewById(R.id.lab5_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab5_2);
            }
        });
        findViewById(R.id.lab5_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab5_3);
            }
        });
        findViewById(R.id.lab5_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab5_4);
            }
        });
        findViewById(R.id.lab6_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab6_1);
            }
        });
        findViewById(R.id.lab6_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(lab6_2);
            }
        });

    }
}