package com.example.myapplication;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.*;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.myapplication.databinding.ActivityLab12Binding;

public class Lab1_2 extends AppCompatActivity {

    TextView text1, text2;
    CheckBox chk1;
    RadioGroup rg1;
    RadioButton rb1, rb2, rb3, rb4;
    Button bt1;
    ImageView ima1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_lab12);


        text1 = (TextView) findViewById(R.id.txt1);
        text2 = (TextView) findViewById(R.id.txt2);
        chk1 = (CheckBox) findViewById(R.id.chkAgree);
        rg1 = (RadioGroup) findViewById(R.id.rGroup);
        rb1 = (RadioButton) findViewById(R.id.rBtn1);
        rb2 = (RadioButton) findViewById(R.id.rBtn2);
        rb3 = (RadioButton) findViewById(R.id.rBtn3);
        bt1 = (Button) findViewById(R.id.btnOk);
        ima1 = (ImageView) findViewById(R.id.imgPet);
        text2.setVisibility(View.INVISIBLE);
        rg1.setVisibility(View.INVISIBLE);
        bt1.setVisibility(View.INVISIBLE);
        ima1.setVisibility(View.INVISIBLE);
        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chk1.isChecked() == true) {
                    text2.setVisibility(View.VISIBLE);
                    rg1.setVisibility(View.VISIBLE);
                    bt1.setVisibility(View.VISIBLE);
                    ima1.setVisibility(View.VISIBLE);
                } else {
                    text2.setVisibility(View.INVISIBLE);
                    rg1.setVisibility(View.INVISIBLE);
                    bt1.setVisibility(View.INVISIBLE);
                    ima1.setVisibility(View.INVISIBLE);
                }
            }
        });
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rg1.getCheckedRadioButtonId()) {
                    case R.id.rBtn1:
                        ima1.setImageResource(R.drawable.burger);
                        break;
                    case R.id.rBtn2:
                        ima1.setImageResource(R.drawable.chicken);
                        break;
                    case R.id.rBtn3:
                        ima1.setImageResource(R.drawable.icecream);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "Амьтан сонгоно уу!!!",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}