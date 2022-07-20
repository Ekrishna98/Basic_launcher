package com.example.basic_launcher;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;


public class Wifi_Settings extends AppCompatActivity {

    Switch wifiSwitch;
    WifiManager wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_settings);

         wifiSwitch = findViewById(R.id.wifiSwitch);
        wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);



        if(wifi.isWifiEnabled()){
            wifiSwitch.setText("Off");
        }else if(!wifi.isWifiEnabled()){
            wifiSwitch.setText("On");
        }

        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(wifi.isWifiEnabled()){
                    wifi.setWifiEnabled(false);
                    wifiSwitch.setText("Off");

                }else if(!wifi.isWifiEnabled()){
                    wifi.setWifiEnabled(true);
                    wifiSwitch.setText("On");

                }
            }
        });

//        wifiSwitch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if(wifi.isWifiEnabled()){
//                    wifiSwitch.setText("Turn Wifi on");
//                    wifi.setWifiEnabled(false);
//                }else if(!wifi.isWifiEnabled()){
//                    wifiSwitch.setText("Turn Wifi Off");
//                    wifi.setWifiEnabled(true);
//                }
//            }
//        });

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







    }
