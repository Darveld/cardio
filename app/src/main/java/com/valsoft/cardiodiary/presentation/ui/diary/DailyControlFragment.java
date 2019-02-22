package com.valsoft.cardiodiary.presentation.ui.diary;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.presentation.MainActivity;
import com.valsoft.cardiodiary.presentation.OnClickListener;
import com.valsoft.cardiodiary.presentation.ui.diary.adapters.DailyControlRVAdapter;
import com.valsoft.cardiodiary.presentation.ui.diary.questionary.QuestionaryActivity;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.DailyControlViewModel;

import java.util.Calendar;

public class DailyControlFragment extends Fragment implements OnClickListener {

    public static final int DAILY_FORM = 1;
    private FloatingActionButton fab;
    private DailyControlViewModel mViewModel;
    private RecyclerView rv;
    private DailyControlRVAdapter rvAdapter;
    private SharedPreferences sPref;
    private Calendar mCalendar;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DailyControlViewModel.class);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_control, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sPref = CardioApp.getInstance().getPref();
        mCalendar = Calendar.getInstance();
        fab = view.findViewById(R.id.fab);
        rv = view.findViewById(R.id.rv_daily);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAdapter = new DailyControlRVAdapter(this);
        rv.setAdapter(rvAdapter);
        mViewModel.getLiveData().observe(this, list ->{
            rvAdapter.setData(list);
        });
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int day = sPref.getInt("daily control", 0);
                if (day == mCalendar.get(Calendar.DAY_OF_MONTH)){
                    Toast.makeText(getContext(), "Ви вже заповнювали сьогодні дану форму!", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(getContext(), QuestionaryActivity.class);
                    intent.putExtra(MainActivity.FRAGMENT_ID, DAILY_FORM);
                    startActivity(intent);
                }

            }
        });
    }

    @Override
    public void onClick(long id) {
        Intent intent = new Intent(getContext(), DetailContainerActivity.class);
        intent.putExtra("fragment_id", 1);
        intent.putExtra("daily_control_id", id);
        startActivity(intent);
    }
}
