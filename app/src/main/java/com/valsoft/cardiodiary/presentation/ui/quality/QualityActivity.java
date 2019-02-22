package com.valsoft.cardiodiary.presentation.ui.quality;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.valsoft.cardiodiary.R;

public class QualityActivity extends AppCompatActivity {
    private FragmentManager fm;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_record);
        fm = getSupportFragmentManager();
        intent = getIntent();
        loadFragment(intent.getIntExtra("fragment_id", 0));
    }

    private void loadFragment(int id){
        switch (id){
            case 0:
                CreateQualityFragment fragment1 = new CreateQualityFragment();
                fm.beginTransaction().add(R.id.medical_record_container, fragment1)
                        .commit();
                break;
            case 1:
                QualityFragment fragment2 = new QualityFragment();
                fragment2.setArguments(intent.getLongExtra("id", 0));
                fm.beginTransaction().add(R.id.medical_record_container, fragment2)
                        .commit();
                break;
        }
    }

}
