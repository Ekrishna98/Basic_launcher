package com.example.basic_launcher;


import static androidx.fragment.app.FragmentManager.TAG;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

public class Wireless_And_networks extends AppCompatActivity  implements View.OnClickListener {

    AirplaneModeReceiver airplaneModeReceiver;
    View include;
    Toolbar toolbar;
    ImageView WifiIcon;
    TextView mobiledata , AirplaneMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wireless_and_networks);
        include = findViewById(R.id.MoreStatusBar);
        WifiIcon = findViewById(R.id.WifiIcon);
        WifiIcon.setVisibility(View.GONE);

        AirplaneMode = findViewById(R.id.AirplaneCheck);
        AirplaneMode.setOnClickListener(this);

        mobiledata = findViewById(R.id.MobileData);
        mobiledata.setOnClickListener(this);

        // Hide StatusBar & Navigation Bar..........
        View windowDecorView = getWindow().getDecorView();
        windowDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        toolbar = findViewById(R.id.ToolBar);
        setSupportActionBar(toolbar);
        Log.v("","ToolBar Show");
        toolbar.setTitle("Wireless & networks");
        if (toolbar != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        finish();
        return true;
    }
    //    End BackButton ActionBar.........

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.AirplaneCheck:
//                AirplaneMode();
                startActivity(new Intent(android.provider.Settings.ACTION_AIRPLANE_MODE_SETTINGS));
                break;
            case R.id.MobileData:
//                MobileData();
                startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
                break;

        }

    }

    public void AirplaneMode(){
        try{
            Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            ComponentName cn = new ComponentName("com.android.settings", "com.android.settings.AirplaneMode.AirplaneModeSettings");
            intent.setComponent(cn);
            Log.v("","AirplaneModeView");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException ignored){
            Log.v("","AirplaneModeView11");
            startActivity(new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS));
        }
    }

    private void MobileData() {
        try{
            Intent intent = new Intent(Intent.ACTION_MAIN, null);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            ComponentName cn = new ComponentName("com.android.settings", "com.android.settings.Wirelessnetworks.WirelessnetworksSettings");
            intent.setComponent(cn);
            Log.v("","MobileDataView");
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }catch (ActivityNotFoundException ignored){
            Log.v("","MobileDataView11");
            startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
        }

    }
}

