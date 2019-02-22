package com.valsoft.cardiodiary.presentation.ui.quality;

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
import com.valsoft.cardiodiary.presentation.viewmodel.quality.QualityListViewModel;

public class QualityListFragment extends Fragment implements QualityRVAdapter.Listener{

    private static Fragment sFragment;
    private RecyclerView rv;
    private QualityRVAdapter mAdapter;
    private FloatingActionButton fab;
    private QualityListViewModel mViewModel;
    private boolean status;
    public static Fragment newInstance(){
        if (sFragment != null){
            return sFragment;
        }
        sFragment = new QualityListFragment();
        return sFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(QualityListViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quality_list, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Якість життя");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        status = true;
        rv = view.findViewById(R.id.rv_quality);
        fab = view.findViewById(R.id.fab);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        mAdapter = new QualityRVAdapter(this);
        rv.setAdapter(mAdapter);
        mViewModel.getLiveData().observe(this, qualityOfLives -> mAdapter.setDataSet(qualityOfLives));
        mViewModel.getCheckedLiveData().observe(this, aBoolean -> {
            fab.setEnabled(aBoolean);
            status = aBoolean;
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.setEnabled(false);
                Intent intent = new Intent(getContext(), QualityActivity.class);
                intent.putExtra("fragment_id", 0);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(long id) {
        Intent intent = new Intent(getContext(), QualityActivity.class);
        intent.putExtra("fragment_id", 1);
        intent.putExtra("id", id);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        fab.setEnabled(status);
        super.onResume();
    }
}
