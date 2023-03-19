
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Lab5_4 extends AppCompatActivity {

    ImageView im1;
    TextView et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab54);
        im1 =(ImageView) findViewById(R.id.ivBattery);
        et1 =(TextView) findViewById(R.id.edtBattery);
    }
    BroadcastReceiver br = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(intent.ACTION_BATTERY_CHANGED)) { int
                    remain = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
                et1.append("Current charge:" + remain + "%\n");
                if (remain >= 90)
                    im1.setImageResource(R.drawable.bat100);
                else if (remain >= 70)
                    im1.setImageResource(R.drawable.bat80);
                else if (remain >= 50)
                    im1.setImageResource(R.drawable.bat60);
                else if (remain >= 30)
                    im1.setImageResource(R.drawable.bat40);
                else if (remain >= 10)
                    im1.setImageResource(R.drawable.bat20);
                int plug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
                switch (plug) {
                    case
                            0:
                        et1.append("Connection: No Plugged\n");
                        break;
                    case BatteryManager.BATTERY_PLUGGED_AC:
                        et1.append("Connection: Adapted Plugged\n"); break;
                    case BatteryManager.BATTERY_PLUGGED_USB:
                        et1.append("Connection: USB Plugged\n");
                        break;
                }
                int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, 0);
                switch (status) {
                    case BatteryManager.BATTERY_STATUS_CHARGING:
                        Toast.makeText(getApplicationContext(), "Battery Status: Charging",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case BatteryManager.BATTERY_STATUS_DISCHARGING:
                        Toast.makeText(getApplicationContext(), "Battery Status: Dis Charging",
                                Toast.LENGTH_SHORT).show();
                        break;
                    case BatteryManager.BATTERY_STATUS_FULL:
                        Toast.makeText(getApplicationContext(), "Battery Status: Full Charging", Toast.LENGTH_SHORT).show(); break;
                    case BatteryManager.BATTERY_STATUS_NOT_CHARGING:
                        Toast.makeText(getApplicationContext(), "Battery Status: Not  Charging", Toast.LENGTH_SHORT).show(); break; default:
                                Toast.makeText(getApplicationContext(), "Battery Status: Unknown", Toast.LENGTH_SHORT).show(); break;
                }
            }
        }
    };
    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(br);
    }
    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter iFilter = new IntentFilter();

        iFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(br, iFilter); }
}