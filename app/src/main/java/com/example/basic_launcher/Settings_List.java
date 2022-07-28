package com.example.basic_launcher;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

public class Settings_List extends AppCompatActivity implements View.OnClickListener {

    TextView Wifi, Bluetooth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_list);
        Wifi = findViewById(R.id.TvWifi);
        Bluetooth =findViewById(R.id.TvBluetooth);

        Wifi.setOnClickListener(this);
        Bluetooth.setOnClickListener(this);

        // Hide StatusBar & Navigation Bar..........
        View windowDecorView = getWindow().getDecorView();
        windowDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


//        Back Button in ActionBar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Settings");
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
//            actionBar.setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override public boolean onSupportNavigateUp() {
        onBackPressed();
        return true; }
    //    End BackButton ActionBar.........


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.TvWifi:
                startActivity(new Intent(Settings_List.this,Wifi_Settings.class));
                break;
            case R.id.TvBluetooth:
                startActivity(new Intent(Settings_List.this,Bluetooth_Settings.class));
                break;
        }
    }
}