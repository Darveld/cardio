package com.valsoft.cardiodiary.presentation.ui.quality;

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
import com.valsoft.cardiodiary.data.local.entity.QualityOfLife;
import com.valsoft.cardiodiary.presentation.viewmodel.quality.QualityCreateViewModel;
import com.valsoft.cardiodiary.presentation.viewmodel.quality.QualityViewModel;

import java.util.Calendar;

public class QualityFragment extends Fragment {

    private QualityViewModel mViewModel;
    private TextView physicalCondition, mood, leisure, sexualActivity,
            dailyActivity, socialActivity, financialPosition, accommodation, work, overallQualityOfLife, date;
    public void setArguments(long id){
        Bundle args = new Bundle();
        args.putLong("id", id);
        this.setArguments(args);
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(QualityViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quality, container, false);
        ((QualityActivity)getActivity()).getSupportActionBar().setTitle("Деталі");
        ((QualityActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        date = view.findViewById(R.id.date);
        physicalCondition = view.findViewById(R.id.physicalCondition);
        mood = view.findViewById(R.id.mood);
        leisure = view.findViewById(R.id.leisure);
        sexualActivity = view.findViewById(R.id.sexualActivity);
        dailyActivity = view.findViewById(R.id.dailyActivity);
        socialActivity = view.findViewById(R.id.socialActivity);
        financialPosition = view.findViewById(R.id.financialPosition);
        accommodation = view.findViewById(R.id.accommodation);
        work = view.findViewById(R.id.work);
        overallQualityOfLife = view.findViewById(R.id.overallQualityOfLife);
        long id = getArguments().getLong("id");
        mViewModel.getLiveData().observe(this, this::setData);
        mViewModel.getQuality(id);
    }

    private void setData(QualityOfLife qualityOfLife){
        physicalCondition.setText(String.valueOf(qualityOfLife.getPhysicalCondition()));
        mood.setText(String.valueOf(qualityOfLife.getMood()));
        leisure.setText(String.valueOf(qualityOfLife.getLeisure()));
        sexualActivity.setText(String.valueOf(qualityOfLife.getSexualActivity()));
        dailyActivity.setText(String.valueOf(qualityOfLife.getDailyActivity()));
        socialActivity.setText(String.valueOf(qualityOfLife.getSocialActivity()));
        financialPosition.setText(String.valueOf(qualityOfLife.getFinancialPosition()));
        accommodation.setText(String.valueOf(qualityOfLife.getAccommodation()));
        work.setText(String.valueOf(qualityOfLife.getWork()));
        overallQualityOfLife.setText(String.valueOf(qualityOfLife.getOverallQualityOfLife()));
        Calendar cal = Calendar.getInstance();
        cal.setTime(qualityOfLife.getDate());
        String[] monthNames = { "Січень", "Лютий", "Березень", "Квітень", "Травень", "Червень", "Липень", "Серпень", "Вересень", "Жвтень", "Листопад", "Грудень" };
        String month = monthNames[cal.get(Calendar.MONTH)];
        date.setText(month+" "+cal.get(Calendar.YEAR));
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
}
