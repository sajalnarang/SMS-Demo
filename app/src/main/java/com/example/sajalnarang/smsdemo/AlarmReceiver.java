package com.example.sajalnarang.smsdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.telephony.SmsManager;
import android.widget.Toast;

import java.util.Calendar;

/**
 * Created by sajalnarang on 4/12/16.
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Test run", Toast.LENGTH_LONG).show();
        String message = "If you are receiving this, please call +918087088708 and inform";

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case Calendar.SUNDAY:
                message = MainActivity.menu[0];
                break;
            case Calendar.MONDAY:
                message = MainActivity.menu[1];
                break;
            case Calendar.TUESDAY:
                message = MainActivity.menu[2];
                break;
            case Calendar.WEDNESDAY:
                message = MainActivity.menu[3];
                break;
            case Calendar.THURSDAY:
                message = MainActivity.menu[4];
                break;
            case Calendar.FRIDAY:
                message = MainActivity.menu[5];
                break;
            case Calendar.SATURDAY:
                message = MainActivity.menu[6];
                break;
        }

        for (String number: MainActivity.numbers) {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(number, null, message, null, null);
        }
    }
}
