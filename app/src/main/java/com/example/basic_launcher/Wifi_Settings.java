package com.example.basic_launcher;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Wifi_Settings extends AppCompatActivity {


    private WifiManager wifi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_settings);

        Switch wifiSwitch = findViewById(R.id.wifiSwitch);
        wifi = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);


        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    wifi.setWifiEnabled(true);
                    Toast.makeText(Wifi_Settings.this, "Wifi ON", Toast.LENGTH_SHORT).show();
                }else{
                    wifi.setWifiEnabled(false);
                    Toast.makeText(Wifi_Settings.this, "Wifi OFF", Toast.LENGTH_SHORT).show();
                }
            }
        });

        if(wifi.isWifiEnabled()){
            wifiSwitch.setChecked(true);
        }else {
            wifiSwitch.setChecked(false);
        }




//        Back Button in ActionBar
        ActionBar actionBar = getSupportActionBar();
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
