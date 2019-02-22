package com.valsoft.cardiodiary.presentation.ui.medical_card;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.presentation.MainActivity;
import com.valsoft.cardiodiary.presentation.OnClickListener;
import com.valsoft.cardiodiary.presentation.ui.medical_card.adapters.MedicalRecordsAdapter;
import com.valsoft.cardiodiary.presentation.viewmodel.medicalcard.MedicalRecordsViewModel;

public class MedicalRecordsFragment extends Fragment implements OnClickListener{

    private static Fragment sFragment;
    private MedicalRecordsAdapter medicalRecordsAdapter;
    private RecyclerView medicalRecordsRV;
    private FloatingActionButton fab;
    private FragmentManager fm;
    private MedicalRecordsViewModel mViewModel;

    public static Fragment newInstance(){
        if (sFragment != null){
            return sFragment;
        }
        sFragment = new MedicalRecordsFragment();
        return sFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MedicalRecordsViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_records, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Архів");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        medicalRecordsRV = view.findViewById(R.id.medicalrecordsRV);
        medicalRecordsRV.setLayoutManager(new LinearLayoutManager(getContext()));
        medicalRecordsAdapter = new MedicalRecordsAdapter(this);
        medicalRecordsRV.setNestedScrollingEnabled(false);
        medicalRecordsRV.setAdapter(medicalRecordsAdapter);
        mViewModel.getLiveData().observe(this, list -> {
            medicalRecordsAdapter.setDataset(list);
        });
        fm = getFragmentManager();
        fab = view.findViewById(R.id.floatingActionButtonMedicalRecords);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), MedicalRecordActivity.class);
                intent.putExtra("fragment_id", 0);
                startActivity(intent);
            }
        });

        medicalRecordsRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dy>0){
                    fab.hide();
                }
                else {
                    fab.show();
                }
            }
        });

    }

    @Override
    public void onClick(long id) {
        Intent intent = new Intent(getContext(), MedicalRecordActivity.class);
        intent.putExtra("fragment_id", 1);
        intent.putExtra("record_id", id);
        startActivity(intent);
    }
}
