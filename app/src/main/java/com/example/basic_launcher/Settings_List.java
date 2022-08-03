package com.example.basic_launcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Settings_List extends AppCompatActivity implements View.OnClickListener {

    TextView Wifi,  bluetooth , MoreOption;
    View include;
    Toolbar toolbar , toolbar1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_list);
        include = findViewById(R.id.StatusBarSettingList);
        include.setVisibility(View.GONE);

        Wifi = findViewById(R.id.TvWifi);
        Wifi.setOnClickListener(this);

        bluetooth = findViewById(R.id.tvBluetooth);
        bluetooth.setOnClickListener(this);

        MoreOption = findViewById(R.id.tvMore);
        MoreOption.setOnClickListener(this);

        // Hide StatusBar & Navigation Bar..........
        View windowDecorView = getWindow().getDecorView();
        windowDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        toolbar1 = findViewById(R.id.ToolBar1);
        setSupportActionBar(toolbar1);
        toolbar1.setTitle("Settings");
        Log.v("", "ToolBar Show setting");
        if (toolbar1 != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
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