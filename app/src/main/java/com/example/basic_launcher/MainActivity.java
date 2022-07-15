package com.example.basic_launcher;

import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
import static android.view.View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.utils.widget.ImageFilterView;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public TextView etdate;
    public TextView txtCurrentTime;
    private ActionBar actionBar;
    private ImageFilterView iv;


    // FirebaseFirestore firestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv = findViewById(R.id.imageFilterView);
        BottomNavigationView btn = findViewById(R.id.BtnNavi_View);
       // BottomNavigationView btnnavi_View = (BottomNavigationView) findViewById(R.id.BtnNavi_View);
       // btn.setBackground(null);



        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Settings_List.class));
            }
        });
















        btn.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_menu:
                        Toast.makeText(MainActivity.this, "home click", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.backBtn:
                        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                        builder.setTitle("Really Exit?")
                                .setMessage("Are you sure?..")
                                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        MainActivity.super.onBackPressed();
                                    }
                                })
                                .setNegativeButton("cancel",null);
                        AlertDialog alert = builder.create();
                        alert.show();

                       // Toast.makeText(MainActivity.this, "back click", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }

        });



















        View windowDecorView = getWindow().getDecorView();
        windowDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);


//        actionBar=getActionBar();
//        actionBar.setHomeButtonEnabled(true);



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
//
//
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


//        View v = findViewById(R.id.launcher);
//        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                                | View.SYSTEM_UI_FLAG_FULLSCREEN
//                                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

    }

}