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
import com.valsoft.cardiodiary.presentation.OnClickListener;
import com.valsoft.cardiodiary.presentation.ui.diary.adapters.SymptomRVAdapter;
import com.valsoft.cardiodiary.presentation.ui.diary.questionary.QuestionaryActivity;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.SymptomViewModel;

public class SymptomFragment extends Fragment implements OnClickListener {

    public static final int SYMPTOM_FORM = 3;
    private SymptomViewModel mViewModel;
    private FloatingActionButton fab;
    private SymptomRVAdapter rvAdapter;
    private RecyclerView rv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SymptomViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_symptom, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = view.findViewById(R.id.rv_symptoms);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAdapter = new SymptomRVAdapter(this);
        rv.setAdapter(rvAdapter);
        mViewModel.getLiveData().observe(this, list ->{
            rvAdapter.setSymptoms(list);
        });
        fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), QuestionaryActivity.class);
                intent.putExtra(MainActivity.FRAGMENT_ID, SYMPTOM_FORM);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(long id) {
        Intent intent = new Intent(getContext(), DetailContainerActivity.class);
        intent.putExtra("fragment_id",  0);
        intent.putExtra("symptom_id", id);
        startActivity(intent);
    }
}
