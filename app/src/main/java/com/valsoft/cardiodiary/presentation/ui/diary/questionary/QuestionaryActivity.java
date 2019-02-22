package com.valsoft.cardiodiary.presentation.ui.diary.questionary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.presentation.MainActivity;
import com.valsoft.cardiodiary.presentation.ui.diary.DailyControlFragment;
import com.valsoft.cardiodiary.presentation.ui.diary.PressureFragment;
import com.valsoft.cardiodiary.presentation.ui.diary.SymptomFragment;

public class QuestionaryActivity extends AppCompatActivity {

    private FragmentManager fm;
    private Intent mIntent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionary);
        fm = getSupportFragmentManager();
        mIntent = getIntent();
        loadForm(mIntent.getIntExtra(MainActivity.FRAGMENT_ID, 0));
    }

    private void loadForm(int id){
        switch (id){
            case DailyControlFragment.DAILY_FORM:
                fm.beginTransaction()
                        .add(R.id.questionary_container, new DailyFormFragment())
                        .commit();
                break;
            case PressureFragment.PRESSURE_FORM:
                fm.beginTransaction()
                        .add(R.id.questionary_container, new PressureFormFragment())
                        .commit();
                break;
            case SymptomFragment.SYMPTOM_FORM:
                fm.beginTransaction()
                        .add(R.id.questionary_container, new SymptomFormFragment())
                        .commit();
        }
    }

}
