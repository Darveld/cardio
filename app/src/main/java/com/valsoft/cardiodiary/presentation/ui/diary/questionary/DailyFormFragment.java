package com.valsoft.cardiodiary.presentation.ui.diary.questionary;

import android.arch.lifecycle.ViewModelProviders;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.valsoft.cardiodiary.CardioApp;
import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.databinding.FragmentDailyFormBinding;
import com.valsoft.cardiodiary.presentation.ui.statistic.StatisticContainerActivity;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.questionary.DailyFormViewModel;

import java.util.Calendar;

public class DailyFormFragment extends Fragment {

    private DailyFormViewModel mViewModel;
    private FragmentDailyFormBinding mBinding;
    private SharedPreferences sPref;
    private Calendar mCalendar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DailyFormViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_form, container, false);
        ((QuestionaryActivity)getActivity()).getSupportActionBar().setTitle("Відчуття");
        ((QuestionaryActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_daily_form, container, false);
        mBinding.setViewModel(mViewModel);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sPref = CardioApp.getInstance().getPref();
        mCalendar = Calendar.getInstance();
        mViewModel.getLiveData().observe(this, aBoolean -> {
            if (aBoolean){
                SharedPreferences.Editor editor = sPref.edit();
                editor.putInt("daily control", mCalendar.get(Calendar.DAY_OF_MONTH));
                editor.commit();
                getActivity().finish();
            }else {
                Toast.makeText(getContext(), "Помилка збереження!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.d("Back button pressed ", "true");
                getActivity().onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
