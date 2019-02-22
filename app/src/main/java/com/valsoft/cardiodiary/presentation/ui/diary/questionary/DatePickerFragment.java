package com.valsoft.cardiodiary.presentation.ui.diary.questionary;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import com.valsoft.cardiodiary.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DatePickerFragment extends DialogFragment {

    private DatePickerListener listener;
    private DatePicker datePicker;
    interface DatePickerListener{
        void setDate(Date date);
    }

    public void setListener(DatePickerListener listener){
        this.listener = listener;
    }


    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        Calendar calendar = Calendar.getInstance();
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_date_picker, null);
        datePicker = view.findViewById(R.id.dialogDatePicker);
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), null);
        return new AlertDialog.Builder(getContext())
                .setView(view)
                .setTitle("Виберіть дату: ")
                .setPositiveButton("Зберегти", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        int year = datePicker.getYear();
                        int month = datePicker.getMonth();
                        int day = datePicker.getDayOfMonth();
                        Date dateOfCreation = new GregorianCalendar(year, month, day).getTime();
                        listener.setDate(dateOfCreation);
                    }
                })
                .create();
    }
}
