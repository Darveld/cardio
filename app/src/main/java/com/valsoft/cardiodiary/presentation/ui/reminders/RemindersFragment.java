package com.valsoft.cardiodiary.presentation.ui.reminders;

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
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.Reminding;
import com.valsoft.cardiodiary.presentation.MainActivity;
import com.valsoft.cardiodiary.presentation.util.NotificationHelper;
import com.valsoft.cardiodiary.presentation.viewmodel.reminders.RemindersViewModel;


public class RemindersFragment extends Fragment implements Listener{

    private static Fragment sFragment;
    private RecyclerView rv;
    private FloatingActionButton fab;
    private RemindersRVAdapter rvAdapter;
    private RemindersViewModel mViewModel;

    @Override
    public void onClicked(long id, String type) {
        Intent intent = new Intent(getContext(), RemindingFormActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("type", type);
        intent.putExtra("fragment_id", 0);
        startActivity(intent);
    }


    public static Fragment newInstance(){
        if (sFragment != null){
            return sFragment;
        }
        sFragment = new RemindersFragment();
        return sFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RemindersViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reminders, container, false);
        ((MainActivity)getActivity()).getSupportActionBar().setTitle("Нагадування");
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        NotificationHelper.scheduleRepeatingRTCNotification(getContext(), "09", "00");
        fab = view.findViewById(R.id.fab);
        rv = view.findViewById(R.id.remindersRV);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAdapter = new RemindersRVAdapter(this);
        rv.setAdapter(rvAdapter);
        mViewModel.getLiveData().observe(this, list -> rvAdapter.setData(list));

        fab.setOnClickListener(view1 -> {
            Intent intent = new Intent(getContext(), RemindingFormActivity.class);
            intent.putExtra("fragment_id", 1);
            startActivity(intent);
        });

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.reminding, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_settings:
                Intent intent = new Intent(getContext(), AlarmSettingsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}

interface Listener{
    void onClicked(long id, String type);
}