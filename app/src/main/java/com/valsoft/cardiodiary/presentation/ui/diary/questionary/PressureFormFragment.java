package com.valsoft.cardiodiary.presentation.ui.diary.questionary;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.questionary.PressureFormViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class PressureFormFragment extends Fragment implements DatePickerFragment.DatePickerListener, TimePickerFragment.TimePickerListener{

    private Button saveBtn;
    private TextInputEditText dateEdText, timeEdText, systolicEdText, diastolicEdText, frequencyEdText;
    private FragmentManager fm;
    private Calendar calendar;
    public static final String DIALOG_DATE = "dialogDate";
    public static final String DIALOG_TIME = "dialogTime";
    private PressureFormViewModel model;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(this).get(PressureFormViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pressure_form, container, false);
        ((QuestionaryActivity)getActivity()).getSupportActionBar().setTitle("Контроль АТ");
        ((QuestionaryActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dateEdText = view.findViewById(R.id.date_ed_text);
        timeEdText = view.findViewById(R.id.time_ed_text);
        saveBtn = view.findViewById(R.id.btn_save);
        systolicEdText = view.findViewById(R.id.systolic_ed_text);
        diastolicEdText = view.findViewById(R.id.diastolic_ed_text);
        frequencyEdText = view.findViewById(R.id.frequency_ed_text);
        fm = getActivity().getSupportFragmentManager();
        calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String today = sdf.format(date);
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String currentTime = timeFormat.format(date);
        timeEdText.setText(currentTime);
        dateEdText.setText(today);
        timeEdText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerFragment timePickerFragment = new TimePickerFragment();
                timePickerFragment.setListener(PressureFormFragment.this);
                timePickerFragment.show(fm, DIALOG_TIME);
            }
        });
        dateEdText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerFragment datePickerFragment = new DatePickerFragment();
                datePickerFragment.setListener(PressureFormFragment.this);
                datePickerFragment.show(fm, DIALOG_DATE);
            }
        });
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (diastolicEdText.getText().length()>= 2 && systolicEdText.getText().length() >= 2 && frequencyEdText.getText().length()>=2 ) {
                    model.saveData(Integer.parseInt(diastolicEdText.getText().toString()),
                            Integer.parseInt(systolicEdText.getText().toString()),
                            Integer.parseInt(frequencyEdText.getText().toString()), calendar.getTime());
                }else {
                    Toast.makeText(getContext(), "fields are empty", Toast.LENGTH_SHORT).show();
                }
            }
        });

        model.getLiveData().observe(this, aBoolean -> {
            if (aBoolean){
                getActivity().finish();
            }else {
                Toast.makeText(getContext(), "Проблема збереження!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.d("Back button pressed ", "true");
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void setDate(Date date) {
        Calendar currentCal = Calendar.getInstance();
        currentCal.setTime(date);
        calendar.set(currentCal.get(Calendar.YEAR), currentCal.get(Calendar.MONTH), currentCal.get(Calendar.DAY_OF_MONTH));
        DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String today = sdf.format(calendar.getTime());
        dateEdText.setText(today);
    }

    @Override
    public void setTime(int hour, int minute) {
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), hour, minute);
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String currentTime = timeFormat.format(calendar.getTime());
        timeEdText.setText(currentTime);
    }
}
