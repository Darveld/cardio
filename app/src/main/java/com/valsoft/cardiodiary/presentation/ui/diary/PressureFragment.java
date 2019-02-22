package com.valsoft.cardiodiary.presentation.ui.diary;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.presentation.MainActivity;
import com.valsoft.cardiodiary.presentation.ui.diary.adapters.PressureRVAdapter;
import com.valsoft.cardiodiary.presentation.ui.diary.questionary.QuestionaryActivity;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.PressureViewModel;

public class PressureFragment extends Fragment {
    public static final int PRESSURE_FORM = 2;
    private FloatingActionButton fab;
    private RecyclerView mRecyclerView;
    private PressureRVAdapter rvAdapter;
    private PressureViewModel mViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(PressureViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pressure, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.rv_pressure);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAdapter = new PressureRVAdapter();
        mRecyclerView.setAdapter(rvAdapter);
        fab = view.findViewById(R.id.fab);

        mViewModel.getLiveData().observe(this, list ->{
            rvAdapter.setPressureList(list);
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), QuestionaryActivity.class);
                intent.putExtra(MainActivity.FRAGMENT_ID, PRESSURE_FORM);
                startActivity(intent);
            }
        });
    }
}
