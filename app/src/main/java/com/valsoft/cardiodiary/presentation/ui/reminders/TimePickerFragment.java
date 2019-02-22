package com.valsoft.cardiodiary.presentation.ui.reminders;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import com.valsoft.cardiodiary.R;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment {

    private TimePickerListener listener;
    private TimePicker timePicker;

    interface TimePickerListener{
        void setTime(int hour, int minute);
    }

    public void setListener(TimePickerListener listener){
        this.listener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_time_picker, null);
        timePicker = view.findViewById(R.id.dialogTimePicker);
        Calendar calendar = Calendar.getInstance();
        timePicker.setIs24HourView(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            timePicker.setHour(calendar.get(Calendar.HOUR_OF_DAY));
            timePicker.setMinute(calendar.get(Calendar.MINUTE));
        }else {
            timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));
        }
        return new AlertDialog.Builder(getContext())
                .setView(view)
                .setTitle("Вкажіть час: ")
                .setPositiveButton("Збурегти", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int hour = 0;
                        int minute = 0;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            hour = timePicker.getHour();
                        } else {
                            hour = timePicker.getCurrentHour();
                        }
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            minute = timePicker.getMinute();
                        } else {
                            minute = timePicker.getCurrentMinute();
                        }

                        listener.setTime(hour, minute);
                    }
                })
                .create()
                ;
    }

}
