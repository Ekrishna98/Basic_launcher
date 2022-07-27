package com.example.basic_launcher;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


public class Wifi_Settings extends AppCompatActivity {

    Switch wifiSwitch;
    WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_settings);
         wifiSwitch = findViewById(R.id.wifiSwitch);

         //Calling WifiCheckMethod......
         WifiCheckMethod();


//        Back Button in ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Wifi");
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true); }
    }
    @Override public boolean onSupportNavigateUp() {
        onBackPressed();
        return true; }
//    End BackButton ActionBar.........

    //  wifiCheck Method Started............
    public void WifiCheckMethod() {
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    wifiManager.setWifiEnabled(true);
                    wifiSwitch.setText("On");
                } else {
                    wifiManager.setWifiEnabled(false);
                    wifiSwitch.setText("Off");
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
        registerReceiver(wifiStateReceiver,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(wifiStateReceiver);
    }

    private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
                        WifiManager.WIFI_STATE_UNKNOWN);
                switch (wifiStateExtra){
                    case WifiManager.WIFI_STATE_ENABLED:
                        wifiSwitch.setChecked(true);
                        wifiSwitch.setText("On");
                        break;
                    case WifiManager.WIFI_STATE_DISABLED:
                        wifiSwitch.setChecked(false);
                        wifiSwitch.setText("Off");
                        break;
                }
            }
        };



   // }// WifiCheck Method End..................

}
