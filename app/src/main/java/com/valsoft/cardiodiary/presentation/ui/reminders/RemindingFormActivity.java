package com.valsoft.cardiodiary.presentation.ui.reminders;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.valsoft.cardiodiary.R;

public class RemindingFormActivity extends AppCompatActivity {

    private FragmentManager fm;
    private Intent mIntent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminding);
        fm = getSupportFragmentManager();
        mIntent = getIntent();
        createForm(mIntent.getIntExtra("fragment_id", 1));
    }

    private void createForm(int id){
        switch (id){
            case 0:
                RemindingFormFragment fragment1 = new RemindingFormFragment();
                fragment1.setArguments(mIntent.getLongExtra("id", 0), mIntent.getStringExtra("type"));
                fm.beginTransaction()
                        .add(R.id.reminding_container, fragment1)
                        .commit();
                break;
            case 1:
                fm.beginTransaction()
                        .add(R.id.reminding_container, new RemindingCreationFormFragment())
                        .commit();
                break;
        }
    }
}
