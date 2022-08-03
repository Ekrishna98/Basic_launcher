package com.example.basic_launcher;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.ActivityNotFoundException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;


public class Wifi_Settings extends AppCompatActivity {

    Switch wifiSwitch;
    WifiManager wifiManager;
    ImageView WifiIcon;
    View include;
    Toolbar toolbar;

    @Override
    
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wifi_settings);
        wifiSwitch = findViewById(R.id.wifiSwitch);
        WifiIcon = findViewById(R.id.WifiIcon);
        include = findViewById(R.id.StatusBarWifiSettings);
//       WifiIcon.setVisibility(View.GONE);


        //Calling WifiCheckMethod......
        WifiCheckMethod();


        // Hide StatusBar & Navigation Bar..........
        View windowDecorView = getWindow().getDecorView();
        windowDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);



       toolbar = findViewById(R.id.ToolBar);
        setSupportActionBar(toolbar);
        Log.v("","ToolBar Show");
        toolbar.setTitle("Wi-Fi");
        if (toolbar != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
        @Override public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return true; }
//    End BackButton ActionBar.........


//    //  wifiCheck Method Started............
//    public void WifiCheckMethod() {
//        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
//
//        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    wifiManager.setWifiEnabled(true);
//                    wifiSwitch.setText("On");
//                  WifiIcon.setVisibility(View.VISIBLE);
//                } else {
//                    wifiManager.setWifiEnabled(false);
//                    wifiSwitch.setText("Off");
//                  WifiIcon.setVisibility(View.GONE);
//                }
//            }
//        });
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        IntentFilter intentFilter = new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION);
//        registerReceiver(wifiStateReceiver,intentFilter);
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        unregisterReceiver(wifiStateReceiver);
//    }
//
//    private BroadcastReceiver wifiStateReceiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                int wifiStateExtra = intent.getIntExtra(WifiManager.EXTRA_WIFI_STATE,
//                        WifiManager.WIFI_STATE_UNKNOWN);
//                switch (wifiStateExtra){
//                    case WifiManager.WIFI_STATE_ENABLED:
//                        wifiSwitch.setChecked(true);
//                        wifiSwitch.setText("On");
//                        WifiIcon.setVisibility(View.VISIBLE);
//                        break;
//                    case WifiManager.WIFI_STATE_DISABLED:
//                        wifiSwitch.setChecked(false);
//                        wifiSwitch.setText("Off");
//                    WifiIcon.setVisibility(View.GONE);
//                        break;
//                }
//            }
//        };
//


   // }// WifiCheck Method End..................





    public void WifiCheckMethod(){

        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                try{
                    Intent intent = new Intent(Intent.ACTION_MAIN, null);
                    intent.addCategory(Intent.CATEGORY_LAUNCHER);
                    ComponentName cn = new ComponentName("com.android.settings", "com.android.settings.wifi.WifiSettings");
                    intent.setComponent(cn);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }catch (ActivityNotFoundException ignored){
                    startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                }
            }
        });

    }



}
