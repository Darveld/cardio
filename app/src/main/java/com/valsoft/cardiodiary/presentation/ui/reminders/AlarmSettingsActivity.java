package com.valsoft.cardiodiary.presentation.ui.reminders;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.presentation.receiver.AlarmReceiver;
import com.valsoft.cardiodiary.presentation.util.NotificationHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AlarmSettingsActivity extends AppCompatActivity implements TimePickerFragment.TimePickerListener{

    private Switch mSwitch;
    private TextInputEditText time;
    private String hours, minutes;
    public static final String DIALOG_TIME = "dialogTime";
    private Context mContext;
    public static int ALARM_TYPE_RTC = 100;
    private FragmentManager fm;
    boolean checked;
    private SharedPreferences sPref;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_settings);
        mSwitch = findViewById(R.id.switchAlarm);
        time = findViewById(R.id.timeEdText);
        mContext = getApplicationContext();
        fm = getSupportFragmentManager();
        Intent intent = new Intent(this, AlarmReceiver.class);
        checked = (PendingIntent.getBroadcast(this, ALARM_TYPE_RTC, intent, PendingIntent.FLAG_NO_CREATE)!= null);
        Log.d("Alarm created", String.valueOf(checked));
        mSwitch.setChecked(checked);
        sPref = CardioApp.getInstance().getPref();
        Calendar calendar = Calendar.getInstance();
        if (sPref.getInt("hour", 0) == 0){
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 9, 0);
            hours = String.valueOf(9);
            minutes = String.valueOf(0);
            DateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String currentTime = timeFormat.format(calendar.getTime());
            time.setText(currentTime);
        }else {
            calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), sPref.getInt("hour",0), sPref.getInt("minute", 0));
            hours = String.valueOf(sPref.getInt("hour",0));
            minutes = String.valueOf(sPref.getInt("minute", 0));
            DateFormat timeFormat = new SimpleDateFormat("HH:mm");
            String currentTime = timeFormat.format(calendar.getTime());
            time.setText(currentTime);
        }
        getSupportActionBar().setTitle("Налаштування");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com.valsoft.cardiodiary.presentation.ui.diary.questionary.TimePickerFragment timePickerFragment = new com.valsoft.cardiodiary.presentation.ui.diary.questionary.TimePickerFragment();
                timePickerFragment.setListener(AlarmSettingsActivity.this::setTime);
                timePickerFragment.show(fm, DIALOG_TIME);
            }
        });
        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    Log.d("Alarm", hours+minutes);
                    NotificationHelper.scheduleRepeatingRTCNotification(mContext, hours, minutes);
                } else {
                    NotificationHelper.cancelAlarmRTC();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setTime(int hour, int minute) {
        if (sPref == null){
            sPref = CardioApp.getInstance().getPref();
        }
        SharedPreferences.Editor editor = sPref.edit();
        editor.putInt("hour", hour);
        editor.putInt("minute", minute);
        editor.commit();
        hours = String.valueOf(hour);
        minutes = String.valueOf(minute);
        Calendar calendar = Calendar.getInstance();
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), hour, minute);
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String currentTime = timeFormat.format(calendar.getTime());
        time.setText(currentTime);
        if (checked)NotificationHelper.scheduleRepeatingRTCNotification(mContext, hours, minutes);
    }
}
