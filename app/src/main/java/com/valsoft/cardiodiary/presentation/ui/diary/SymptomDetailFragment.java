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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.Symptoms;
import com.valsoft.cardiodiary.presentation.ui.diary.questionary.QuestionaryActivity;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.SymptomDetailViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class SymptomDetailFragment extends Fragment{

    private SymptomDetailViewModel mViewModel;
    private TextView pain, localizationTV, irradiationTV, intensityTV, durationTV, conditionsTV,
            frequencyInterruptionTV, frequencyPalpitationTV,
            durationHeadacheTV, characterOfDyspneaTV, conditionsOfDyspneaTV,
            frequencyDizzinessTV, systolicDizziness, diastolicDizziness,
            frequencyLossOfConsciousnessTV, systolicLossOfConsciousness, diastolicLossOfConsciousness,
            edemaTV, date;
    private LinearLayout heartPainLayout, heartInterruption, palpitation, headache, dyspnea,
            dizziness, lossOfConsciousness, edema;
    public void setArguments(long id){
        Bundle args = new Bundle();
        args.putLong("symptom_id", id);
        this.setArguments(args);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SymptomDetailViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_symptom_detail, container, false);
        ((DetailContainerActivity)getActivity()).getSupportActionBar().setTitle("Деталі");
        ((DetailContainerActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pain = view.findViewById(R.id.pain);
        localizationTV = view.findViewById(R.id.localization_text_view);
        irradiationTV = view.findViewById(R.id.irradiation_text_view);
        intensityTV = view.findViewById(R.id.intensity_text_view);
        durationTV = view.findViewById(R.id.duration_text_view);
        conditionsTV = view.findViewById(R.id.conditions_text_view);
        frequencyInterruptionTV = view.findViewById(R.id.frequency_interruption_text_view);
        frequencyPalpitationTV = view.findViewById(R.id.frequency_palpitation_text_view);
        edemaTV = view.findViewById(R.id.edema_text_view);
        durationHeadacheTV = view.findViewById(R.id.duration_headache_text_view);
        characterOfDyspneaTV = view.findViewById(R.id.character_of_dyspnea_text_view);
        conditionsOfDyspneaTV = view.findViewById(R.id.conditions_of_dyspnea_text_view);
        frequencyDizzinessTV  = view.findViewById(R.id.frequency_dizziness_text_view);
        systolicDizziness = view.findViewById(R.id.systolic_dizziness);
        diastolicDizziness = view.findViewById(R.id.diastolic_dizziness);
        frequencyLossOfConsciousnessTV = view.findViewById(R.id.frequency_lossOfConsciousness_tv);
        systolicLossOfConsciousness = view.findViewById(R.id.systolic_lossOfConsciousness);
        diastolicLossOfConsciousness = view.findViewById(R.id.diastolic_lossOfConsciousness);
        heartPainLayout = view.findViewById(R.id.heart_pain_layout);
        heartInterruption = view.findViewById(R.id.heart_interruption);
        palpitation = view.findViewById(R.id.palpitation);
        headache = view.findViewById(R.id.headache);
        dyspnea = view.findViewById(R.id.dyspnea);
        dizziness = view.findViewById(R.id.dizziness);
        lossOfConsciousness = view.findViewById(R.id.lossOfConsciousness);
        edema = view.findViewById(R.id.edema);
        date = view.findViewById(R.id.date);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        long id = getArguments().getLong("symptom_id");
        mViewModel.getLiveData().observe(this, this::setData);
        mViewModel.getSymptoms(id);
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

    private void setData(Symptoms symptoms){
        if (symptoms.getNatureOfHeartPain()!= null||
                symptoms.getLocalization()!= null||
                symptoms.getIrradiation()!= null||
                symptoms.getHeartPainIntensity()!=0||
                symptoms.getHeartPainDuration()!=0||
                symptoms.getHeartPainCondition()!= null){
            heartPainLayout.setVisibility(View.VISIBLE);
            if (symptoms.getNatureOfHeartPain()!= null) pain.setText(symptoms.getNatureOfHeartPain());
            if (symptoms.getLocalization()!= null) localizationTV.setText(symptoms.getLocalization());
            if (symptoms.getIrradiation()!= null) irradiationTV.setText(symptoms.getIrradiation());
            intensityTV.setText(String.valueOf(symptoms.getHeartPainIntensity()));
            if (symptoms.getHeartPainDuration() == 5){
                durationTV.setText(getString(R.string.about_five));
            }else if (symptoms.getHeartPainDuration() == 10){
                durationTV.setText(getString(R.string.from_five));
            }else if (symptoms.getHeartPainDuration() == 30){
                durationTV.setText(getString(R.string.more_thirty));
            }
            if (symptoms.getHeartPainCondition()!= null) conditionsTV.setText(symptoms.getConditionOfDyspnea());
        }
        if (symptoms.isHeartInterruptions()){
            heartInterruption.setVisibility(View.VISIBLE);
            frequencyInterruptionTV.setText(String.valueOf(symptoms.getHeartInterruptionFrequency()));
        }
        if (symptoms.isPalpitation()){
            palpitation.setVisibility(View.VISIBLE);
            frequencyPalpitationTV.setText(String.valueOf(symptoms.getPalpitationFrequency()));
        }
        if (symptoms.isHeadache()){
            headache.setVisibility(View.VISIBLE);
            durationHeadacheTV.setText(String.valueOf(symptoms.getHeadacheDuration()));
        }
        if (symptoms.getDyspnea()!=null||symptoms.getConditionOfDyspnea() !=null){
            dyspnea.setVisibility(View.VISIBLE);
            if (symptoms.getDyspnea()!=null) characterOfDyspneaTV.setText(symptoms.getDyspnea());
            if (symptoms.getConditionOfDyspnea() !=null) conditionsOfDyspneaTV.setText(symptoms.getConditionOfDyspnea());
        }
        if (symptoms.isDizziness()){
            dizziness.setVisibility(View.VISIBLE);
            frequencyDizzinessTV.setText(String.valueOf(symptoms.getDizzinesFrequency()));
            systolicDizziness.setText(String.valueOf(symptoms.getDizzinesSystolic()));
            diastolicDizziness.setText(String.valueOf(symptoms.getDizzinesDiastolic()));
        }
        if (symptoms.isLossOfConsciousness()){
            lossOfConsciousness.setVisibility(View.VISIBLE);
            frequencyLossOfConsciousnessTV.setText(String.valueOf(symptoms.getConsciousnessFrequency()));
            systolicLossOfConsciousness.setText(String.valueOf(symptoms.getConsciousnessSystolic()));
            diastolicLossOfConsciousness.setText(String.valueOf(symptoms.getConsciousnessDiastolic()));
        }
        if (symptoms.getEdema() != null){
            edema.setVisibility(View.VISIBLE);
            edemaTV.setText(symptoms.getEdema());
        }
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String date = sdf.format(symptoms.getDate());
        this.date.setText(date);
    }
}
