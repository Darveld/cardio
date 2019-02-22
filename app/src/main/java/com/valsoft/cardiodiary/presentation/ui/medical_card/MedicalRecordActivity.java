package com.valsoft.cardiodiary.presentation.ui.medical_card;

import android.Manifest;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.presentation.ui.medical_card.adapters.MedicalRecordAttachmentsAdapter;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordActivity extends AppCompatActivity {
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
                MedicalRecordFormFragment fragment1 = new MedicalRecordFormFragment();
                fm.beginTransaction().add(R.id.medical_record_container, fragment1)
                        .commit();
                break;
            case 1:
                MedicalRecordDetailFragment fragment2 = new MedicalRecordDetailFragment();
                fragment2.setArguments(intent.getLongExtra("record_id", 0));
                fm.beginTransaction().add(R.id.medical_record_container, fragment2)
                        .commit();
                break;
        }
    }

}
