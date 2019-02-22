package com.valsoft.cardiodiary.presentation.ui.diary;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;
import com.valsoft.cardiodiary.presentation.ui.diary.questionary.QuestionaryActivity;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.DailyControlDetailViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class DailyControlDetailFragment extends Fragment{

    private DailyControlDetailViewModel mViewModel;
    private TextView wellBeing, activity, mood, anxiety, irritation, difficulties, fatigue, psychoemotionalStress, sleep, date;
    public void setArguments(long id){
        Bundle args = new Bundle();
        args.putLong("id", id);
        this.setArguments(args);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DailyControlDetailViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_detail, container, false);
        ((DetailContainerActivity)getActivity()).getSupportActionBar().setTitle("Деталі");
        ((DetailContainerActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        wellBeing = view.findViewById(R.id.well_being);
        activity = view.findViewById(R.id.activity);
        mood = view.findViewById(R.id.mood);
        anxiety = view.findViewById(R.id.anxiety);
        irritation = view.findViewById(R.id.irritation);
        difficulties = view.findViewById(R.id.difficulties);
        fatigue = view.findViewById(R.id.fatigue);
        psychoemotionalStress = view.findViewById(R.id.psychoemotional_stress);
        sleep = view.findViewById(R.id.sleep);
        date = view.findViewById(R.id.date);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        long id = getArguments().getLong("id");
        mViewModel.getLiveData().observe(this, this::setData);
        mViewModel.getDailyIndexes(id);
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

    private void setData(DailyIndexes item){
        wellBeing.setText(String.valueOf(item.getFeelings()));
        activity.setText(String.valueOf(item.getActivity()));
        mood.setText(String.valueOf(item.getMood()));
        anxiety.setText(String.valueOf(item.getAnxiety()));
        irritation.setText(String.valueOf(item.getIrritation()));
        difficulties.setText(String.valueOf(item.getConcentration()));
        fatigue.setText(String.valueOf(item.getFatigue()));
        psychoemotionalStress.setText(String.valueOf(item.getPsychoemotionalStress()));
        sleep.setText(String.valueOf(item.getSleep()));
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String date = sdf.format(item.getDate());
        this.date.setText(date);
    }
}
