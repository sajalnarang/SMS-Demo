package com.example.sajalnarang.smsdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button enableButton;
    AlarmManager alarmManager;
    PendingIntent alarmIntent;
    public static String[] menu;
    public static List<String> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, AlarmReceiver.class);
        alarmIntent = alarmIntent.getBroadcast(this, 0, intent, 0);

        menu = new String[7];
        menu[0] = "Sunday's menu";
        menu[1] = "Monday's menu";
        menu[2] = "Tuesday's menu";
        menu[3] = "Wednesday's menu";
        menu[4] = "Thursday's menu";
        menu[5] = "Friday's menu";
        menu[6] = "Saturday's menu";

        numbers = new ArrayList<String>();
        numbers.add("+917043207800");
        numbers.add("+918828291032");
        numbers.add("+919819960546");
        enableButton = (Button) findViewById(R.id.enable_btn);
        enableButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                calendar.set(Calendar.HOUR_OF_DAY, 7);
                calendar.set(Calendar.MINUTE, 0);
                calendar.set(Calendar.SECOND, 0);

                alarmManager = (AlarmManager) MainActivity.this.getSystemService(MainActivity.this.ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);
                Toast.makeText(MainActivity.this, "Enabled", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
    