package com.example.basic_launcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;


import android.Manifest;
import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;
import java.lang.reflect.Method;

public class HomeLancher extends AppCompatActivity implements View.OnClickListener{
    public TextView etdate , TvSettings;
    public TextView txtCurrentTime;
    private ActionBar actionBar;
    private ImageFilterView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.imageFilterView);
        TvSettings = findViewById(R.id.tvSetting);

        iv.setOnClickListener(this);
        TvSettings.setOnClickListener(this);


        // Calling NavigationBottons
        BottomNavigationViewMethod();


        // Hide StatusBar & Navigation Bar..........
        View windowDecorView = getWindow().getDecorView();
        windowDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

//        Thread myThread = null;
//
//        Runnable runnable = new CountDownRunner();
//        myThread= new Thread(runnable);
//        myThread.start();
//
//    }
//
//    public void doWork() {
//        runOnUiThread(new Runnable() {
//            public void run() {
//                try{
//                    TextView txtCurrentTime= (TextView)findViewById(R.id.DtClock);
//                    Date dt = new Date();
//                    int hours = dt.getHours();
//                    int minutes = dt.getMinutes();
//                    int seconds = dt.getSeconds();
//                    String curTime = hours + ":" + minutes + ":" + seconds;
//                    txtCurrentTime.setText(curTime);
//                }catch (Exception e) {}
//            }
//        });
//    }

//    class CountDownRunner implements Runnable{
//        // @Override
//        public void run() {
//            while (!Thread.currentThread().isInterrupted()) {
//                try {
//                    doWork();
//                    Thread.sleep(1000);
//                } catch(InterruptedException e) {
//                    Thread.currentThread().interrupt();
//                } catch(Exception e) {
//                }
//            }
//        }
//       (   or another way display current time & date
//       etdate = findViewById(R.id.TvTime);
//
//        Calendar c = Calendar.getInstance();
//        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm ", Locale.getDefault());
//        String  dateTime = sdf.format(c.getTime());
//        etdate.setText(dateTime);)

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.imageFilterView:
                startActivity(new Intent(HomeLancher.this,Settings_List.class));
                break;
            case R.id.tvSetting:
                startActivity(new Intent(HomeLancher.this,Settings_List.class));
                break;
        }

    }

    // BottomNavigationView Press buttom check
    public void BottomNavigationViewMethod(){
        BottomNavigationView btn = findViewById(R.id.BtnNavi_View);
        btn.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_menu:
                        Toast.makeText(HomeLancher.this, "home click", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.backBtn:
                        final AlertDialog.Builder alert = new AlertDialog.Builder(HomeLancher.this);
                        View mview = getLayoutInflater().inflate(R.layout.alertbox,null);

                        EditText enterpass = mview.findViewById(R.id.AlertPassword);
                        Button cancel = mview.findViewById(R.id.Alert_Cancel);
                        Button ok = mview.findViewById(R.id.Alert_ok);
                        alert.setView(mview);
                        final AlertDialog alertDialog = alert.create();
                        alertDialog.setCanceledOnTouchOutside(false);

                        cancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                alertDialog.dismiss();
                                alertDialog.cancel();
                            }
                        });
                        ok.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                String Password = "12345";
                                String PassCheck = enterpass.getText().toString();

                                if (PassCheck.matches(Password)) {
//                                    startActivity(new Intent(HomeLancher.this, HomeLancher.class));
                                    finish();
                                    System.exit(0);
                                } else {
                                    Toast.makeText(HomeLancher.this, "Enter Wrong Password..", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        alertDialog.show();
                        // Toast.makeText(MainActivity.this, "back click", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }


}


