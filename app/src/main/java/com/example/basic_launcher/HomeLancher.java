package com.example.basic_launcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;


import android.app.ActionBar;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeLancher extends AppCompatActivity implements View.OnClickListener {
    public TextView etdate, TvSettings;
    public TextView txtCurrentTime;
    private ActionBar actionBar;
    private ImageFilterView iv;
    ImageView WifiIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.imageFilterView);
        TvSettings = findViewById(R.id.tvSetting);
        WifiIcon = findViewById(R.id.WifiIcon);
        WifiIcon.setVisibility(View.INVISIBLE);

        iv.setOnClickListener(this);
        TvSettings.setOnClickListener(this);

        // Calling NavigationBottons
        BottomNavigationViewMethod();

        // Hide StatusBar & Navigation Bar..........
        // View windowDecorView = getWindow().getDecorView();
        // windowDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

//        Thread myThread = null;
//        Runnable runnable = new CountDownRunner();
//        myThread= new Thread(runnable);
//        myThread.start();
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
        switch (view.getId()) {
            case R.id.imageFilterView:
            case R.id.tvSetting:
                startActivity(new Intent(HomeLancher.this, Settings_List.class));
                break;
        }
    }

    // BottomNavigationView Press buttom check
    public void BottomNavigationViewMethod() {
        BottomNavigationView btn = findViewById(R.id.BtnNavi_View);
        btn.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_menu:
                        Toast.makeText(HomeLancher.this, "home click", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.backBtn:
                        ShowAlertBox();
                        break;
                }
                return true;
            }
        });
    }

    public void ShowAlertBox(){
        final Dialog d = new Dialog(HomeLancher.this, R.style.customTheme);
        d.setContentView(R.layout.custom_two_buttons_alert);
        d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        d.setCancelable(false);
        EditText enterpass = d.findViewById(R.id.AlertPassword);
        TextView AlertMeassage = d.findViewById(R.id.Alert_message_Two);
        AlertMeassage.setVisibility(View.GONE);
        Button cancel = d.findViewById(R.id.Alert_Cancel);
        Button ok = d.findViewById(R.id.Alert_ok);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("", "Hide NotificationBar");
                 if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
                    View v1 = HomeLancher.this.getWindow().getDecorView();
                    v1.setSystemUiVisibility(View.GONE);
                } else if (Build.VERSION.SDK_INT >= 19) {
                    //for new api versions.
                    View decorView = getWindow().getDecorView();
                    int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
                    decorView.setSystemUiVisibility(uiOptions);
                }
             d.dismiss();
             d.cancel();
            }
        });
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Password = "12345";
                String PassCheck = enterpass.getText().toString();

                if (PassCheck.matches(Password)) {
//              startActivity(new Intent(HomeLancher.this, HomeLancher.class));
                    finish();
                    System.exit(0);
                } else {
                    Toast.makeText(HomeLancher.this, "Enter Wrong Password..", Toast.LENGTH_SHORT).show();
                }
            }
        });
        d.show();
        // Toast.makeText(MainActivity.this, "back click", Toast.LENGTH_SHORT).show();
        }




    @Override
    public void onResume() {
        super.onResume();
        Log.v("", "On Resume");
        // Hide StatusBar & Navigation Bar..........
//    View windowDecorView = getWindow().getDecorView();
//    windowDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        if (Build.VERSION.SDK_INT > 11 && Build.VERSION.SDK_INT < 19) { // lower api
            View v = this.getWindow().getDecorView();
            v.setSystemUiVisibility(View.GONE);
        } else if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
            decorView.setSystemUiVisibility(uiOptions);
        }

    }
}


