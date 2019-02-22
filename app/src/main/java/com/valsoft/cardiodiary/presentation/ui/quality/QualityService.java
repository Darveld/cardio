package com.valsoft.cardiodiary.presentation.ui.quality;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.domain.repositories.quality.QualityRepository;
import com.valsoft.cardiodiary.presentation.MainActivity;
import com.valsoft.cardiodiary.presentation.util.NotificationHelper;

import java.util.Calendar;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import static com.valsoft.cardiodiary.presentation.ui.reminders.AlarmSettingsActivity.ALARM_TYPE_RTC;

public class QualityService extends Service{

    @Inject
    QualityRepository mRepository;
    private Disposable mDisposable;
    public static final String CHANNEL_ID = "2";
    @Override
    public void onCreate() {
        super.onCreate();
        CardioApp.getInstance().getComponentStorage().addQualityComponent();
        CardioApp.getInstance().getComponentStorage().addGetQualityComponent().inject(this);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Start Service", "true");
        mDisposable = mRepository.getItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        qualityOfLives -> {
                            Calendar calNow = Calendar.getInstance();
                            Calendar cal = Calendar.getInstance();
                            if (qualityOfLives.size()>0){
                                cal.setTime(qualityOfLives.get(0).getDate());
                                if (calNow.getTimeInMillis()>cal.getTimeInMillis()){
                                    if (calNow.get(Calendar.MONTH)>cal.get(Calendar.MONTH)&&calNow.get(Calendar.DAY_OF_MONTH)>=cal.get(Calendar.DAY_OF_MONTH)){
                                        Log.d("status quality", "true1");
                                        sendNotification();
                                    }else if (calNow.get(Calendar.MONTH)-cal.get(Calendar.MONTH)==2){
                                        Log.d("status quality", "true2");
                                        sendNotification();
                                    }else if (cal.get(Calendar.MONTH)==11 && calNow.get(Calendar.MONTH)==0 && calNow.get(Calendar.DAY_OF_MONTH)>=cal.get(Calendar.DAY_OF_MONTH)){
                                        Log.d("status quality", "true3");
                                        sendNotification();
                                    }
                                }
                            }
                        }, throwable -> {
                            Log.d("Error Request Service", throwable.getMessage());
                        });
        return super.onStartCommand(intent, flags, startId);
    }

    private void sendNotification(){
        Intent intentToRepeat = new Intent(this, MainActivity.class);
        intentToRepeat.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intentToRepeat.putExtra("type_notification", 1);
        PendingIntent pendingIntent =
                PendingIntent.getActivity(this, 0, intentToRepeat, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification repeatedNotification = buildLocalNotification(this, pendingIntent).build();

        NotificationManager notificationManager = NotificationHelper.getNotificationManager(this);

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

    private NotificationCompat.Builder buildLocalNotification(Context context, PendingIntent pendingIntent) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_heart)
                .setContentTitle("Оцінка якості життя")
                .setContentText("Дайте оцінку якості життя за місяць")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true);


        return builder;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        Log.d("Destroy Service", "true");
        mDisposable.dispose();
        CardioApp.getInstance().getComponentStorage().clearQualityComponent();
        CardioApp.getInstance().getComponentStorage().clearGetQualityComponent();
        super.onDestroy();
    }
}
