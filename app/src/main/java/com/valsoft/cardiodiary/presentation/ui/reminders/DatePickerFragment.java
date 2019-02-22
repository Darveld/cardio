package com.valsoft.cardiodiary.presentation.ui.reminders;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import com.valsoft.cardiodiary.R;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatePickerFragment extends DialogFragment {

    private DatePickerListener listener;
    private DatePicker datePicker;

    interface DatePickerListener extends Serializable{
        void setDate(Date date);
        void setStartDate(Date date);
        void setEndDate(Date date);
    }

    public void setArguments(int dateType, DatePickerListener listener, Date date){
        Bundle args = new Bundle();
        args.putInt("date_type", dateType);
        args.putSerializable("date", date);
        args.putSerializable("listener", listener);
        this.setArguments(args);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        Date date = (Date) getArguments().getSerializable("date");
        calendar.setTime(date);
        listener = (DatePickerListener) getArguments().getSerializable("listener");
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_date_picker, null);
        datePicker = view.findViewById(R.id.dialogDatePicker);
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), null);
        return new AlertDialog.Builder(getContext())
                .setView(view)
                .setTitle("Виберіть дату: ")
                .setPositiveButton("Зберегти", (dialogInterface, i) -> {
                    switch (getArguments().getInt("date_type")){
                        case 0:
                            listener.setStartDate(getDate());
                            break;
                        case 1:
                            listener.setEndDate(getDate());
                            break;
                        case 2:
                            listener.setDate(getDate());
                            break;
                    }
                })
                .create();
    }

    private Date getDate(){
        int year = datePicker.getYear();
        int month = datePicker.getMonth();
        int day = datePicker.getDayOfMonth();
        return new GregorianCalendar(year, month, day).getTime();
    }

}
