package com.example.basic_launcher;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

public class Bluetooth_Settings extends AppCompatActivity {

    public static final int BLUETOOTH_REQ_CODE = 1;
    Switch BluetoothSwitch;
    BluetoothManager bluetoothManager;
    BluetoothAdapter bluetoothAdapter;
    View include;
    Toolbar toolbar;
    ImageView WifiIcon;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth_settings);
        BluetoothSwitch = findViewById(R.id.BluetoothSwitch);
        include=findViewById(R.id.BluetoothStatusBar);
        WifiIcon = findViewById(R.id.WifiIcon);
        WifiIcon.setVisibility(View.GONE);
        // Hide StatusBar & Navigation Bar..........
        View windowDecorView = getWindow().getDecorView();
        windowDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        // Bluetooth method Calling
        BluetoothMethod();

        toolbar = findViewById(R.id.ToolBar);
        setSupportActionBar(toolbar);
        Log.v("","ToolBar Show");
        toolbar.setTitle("Bluetooth");
        if (toolbar != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    //    End BackButton ActionBar.........
    
    @RequiresApi(api = Build.VERSION_CODES.M)
    public void BluetoothMethod() {
        bluetoothManager = (BluetoothManager) getApplicationContext().getSystemService(BluetoothManager.class);
        BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();
        if (bluetoothAdapter == null) {
            // Device doesn't support Bluetooth
            Toast.makeText(this, "This Device not support Bluetooth", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "This Device support Bluetooth", Toast.LENGTH_SHORT).show();
        }
    }
}