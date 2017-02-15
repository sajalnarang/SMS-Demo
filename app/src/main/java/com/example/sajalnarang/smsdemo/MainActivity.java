package com.example.sajalnarang.smsdemo;

import android.Manifest;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_SEND_SMS = 1;
    public static List<String> numbers;
    public static int mId = 0;
    public Button reloadMenuButton;
    public Button reloadNumbersButton;
    Button enableButton;
    AlarmManager alarmManager;
    PendingIntent alarmIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        while (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.SEND_SMS}, MY_PERMISSIONS_SEND_SMS);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(this, AlarmService.class);
        alarmIntent = PendingIntent.getService(this, 0, intent, 0);

        numbers = new ArrayList<>();
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

                alarmManager = (AlarmManager) MainActivity.this.getSystemService(MainActivity.ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);
                Toast.makeText(MainActivity.this, "Enabled", Toast.LENGTH_SHORT).show();
            }
        });
        reloadMenuButton = (Button) findViewById(R.id.reload_menu_btn);
        reloadMenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitInterface retrofitInterface = ServiceGenerator.createService(RetrofitInterface.class);
                retrofitInterface.getMenu().enqueue(new Callback<GsonModels.MenuResponse>() {
                    @Override
                    public void onResponse(Call<GsonModels.MenuResponse> call, Response<GsonModels.MenuResponse> response) {
                        if (response.isSuccessful()) {
                            Data.setMenuResponse(response.body());
                            Log.d("Menu", "onResponse: success");
                        } else {
                            Log.d("Menu", "onResponse: failure " + response.code() + " " + response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<GsonModels.MenuResponse> call, Throwable t) {
                        Log.d("Menu", "onFailure");
                    }
                });
            }
        });
        reloadNumbersButton = (Button) findViewById(R.id.reload_numbers_btn);
        reloadNumbersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RetrofitInterface retrofitInterface = ServiceGenerator.createService(RetrofitInterface.class);
                retrofitInterface.getNumbers().enqueue(new Callback<GsonModels.PhoneResponse>() {
                    @Override
                    public void onResponse(Call<GsonModels.PhoneResponse> call, Response<GsonModels.PhoneResponse> response) {
                        if (response.isSuccessful()) {
                            Data.setPhoneResponse(response.body());
                            Log.d("Phone", "onResponse: success");
                        } else {
                            Log.d("Phone", "onResponse: failure " + response.code() + " " + response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<GsonModels.PhoneResponse> call, Throwable t) {
                        Log.d("Phone", "onFailure");
                    }
                });
            }
        });
    }
}
    