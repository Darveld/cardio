package com.valsoft.cardiodiary.presentation.ui.statistic;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.valsoft.cardiodiary.R;

public class StatisticContainerActivity extends AppCompatActivity {

    private FragmentManager fm;
    private Intent intent;
    private StatisticFragment mFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistic_form);
        intent = getIntent();
        fm = getSupportFragmentManager();
        mFragment = new StatisticFragment();
        mFragment.setArguments(intent.getLongExtra("id", 0));
        fm.beginTransaction()
                .add(R.id.statistic_container, mFragment)
                .commit();
    }
}
