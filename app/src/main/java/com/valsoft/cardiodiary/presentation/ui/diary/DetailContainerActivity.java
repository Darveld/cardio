package com.valsoft.cardiodiary.presentation.ui.diary;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.valsoft.cardiodiary.R;

public class DetailContainerActivity extends AppCompatActivity {

    private FragmentManager fm;
    private Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        fm = getSupportFragmentManager();
        intent = getIntent();
        loadFragment(intent.getIntExtra("fragment_id", 0));
    }

    private void loadFragment(int fragmentId){
        switch (fragmentId){
            case 0:
                SymptomDetailFragment fragment1 = new SymptomDetailFragment();
                fragment1.setArguments(intent.getLongExtra("symptom_id", 0));
                fm.beginTransaction().add(R.id.detail_container, fragment1)
                        .commit();
                break;
            case 1:
                DailyControlDetailFragment fragment2 = new DailyControlDetailFragment();
                fragment2.setArguments(intent.getLongExtra("daily_control_id", 0));
                fm.beginTransaction().add(R.id.detail_container, fragment2)
                        .commit();
                break;

        }
    }
}
