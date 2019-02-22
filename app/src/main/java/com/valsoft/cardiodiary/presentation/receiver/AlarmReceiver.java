package com.valsoft.cardiodiary.presentation.receiver;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.presentation.MainActivity;
import com.valsoft.cardiodiary.presentation.util.NotificationHelper;

import static com.valsoft.cardiodiary.presentation.ui.reminders.AlarmSettingsActivity.ALARM_TYPE_RTC;

public class AlarmReceiver extends BroadcastReceiver {

    public static final String CHANNEL_ID = "1";

    @Override
    public void onReceive(Context context, Intent intent) {

        Intent intentToRepeat = new Intent(context, MainActivity.class);
        intentToRepeat.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(context, ALARM_TYPE_RTC, intentToRepeat, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification repeatedNotification = buildLocalNotification(context, pendingIntent).build();

        NotificationManager notificationManager = NotificationHelper.getNotificationManager(context);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, "My channel",
                    NotificationManager.IMPORTANCE_HIGH);
            channel.setDescription("My channel description");
            channel.enableLights(true);
            channel.setLightColor(Color.RED);
            channel.enableVibration(true);
            notificationManager.createNotificationChannel(channel);
        }
        notificationManager.notify(ALARM_TYPE_RTC, repeatedNotification);
    }
    public NotificationCompat.Builder buildLocalNotification(Context context, PendingIntent pendingIntent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                        .setContentIntent(pendingIntent)
                        .setSmallIcon(R.mipmap.ic_heart)
                        .setContentTitle("Cardio Diary")
                        .setContentText("Ваші обов'язки на день")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setDefaults(NotificationCompat.DEFAULT_ALL)
                        .setAutoCancel(true);


        return builder;
    }
}
