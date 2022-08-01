package com.example.basic_launcher;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Settings_List extends AppCompatActivity implements View.OnClickListener {

    TextView Wifi,  bluetooth , MoreOption;
    View include;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_list);
//        include = findViewById(R.id.StatusBarSettingList);

        Wifi = findViewById(R.id.TvWifi);
        Wifi.setOnClickListener(this);

        bluetooth= findViewById(R.id.tvBluetooth);
        bluetooth.setOnClickListener(this);

        MoreOption = findViewById(R.id.tvMore);
        MoreOption.setOnClickListener(this);

        // Hide StatusBar & Navigation Bar..........
        View windowDecorView = getWindow().getDecorView();
        windowDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN  | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

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
        finish();
        return true; }
    //    End BackButton ActionBar.........


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.TvWifi:
                startActivity(new Intent(Settings_List.this,Wifi_Settings.class));
                break;
            case R.id.tvBluetooth:
                startActivity(new Intent(Settings_List.this, Bluetooth_Settings.class));
                break;
            case R.id.tvMore:
                startActivity(new Intent(Settings_List.this, Wireless_And_networks.class));
        }
    }
}