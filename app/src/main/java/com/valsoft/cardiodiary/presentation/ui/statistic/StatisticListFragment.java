package com.valsoft.cardiodiary.presentation.ui.statistic;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.presentation.MainActivity;
import com.valsoft.cardiodiary.presentation.viewmodel.statistic.StatisticListViewModel;

public class StatisticListFragment extends Fragment implements StatisticRVAdapter.Listener{

    private static Fragment sFragment;
//    private LineChart lineChart;
//    private List<Entry> entries;
//    private LineDataSet dataSet;
//    private LineData lineData;
    private RecyclerView rv;
    private StatisticRVAdapter rvAdapter;
    private StatisticListViewModel mViewModel;
    public static Fragment newInstance(){
        if (sFragment != null){
            return sFragment;
        }
        sFragment = new StatisticListFragment();
        return sFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(StatisticListViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_statistic_list, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Статистика");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv = view.findViewById(R.id.rv_statistic);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAdapter = new StatisticRVAdapter(this);
        rv.setAdapter(rvAdapter);
        mViewModel.getLiveData().observe(this, list -> rvAdapter.setDataSet(list));

    }

    @Override
    public void onClick(long id) {
        Intent intent = new Intent(getContext(), StatisticContainerActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}
