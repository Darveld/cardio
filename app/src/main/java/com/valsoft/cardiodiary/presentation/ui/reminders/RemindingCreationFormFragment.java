package com.valsoft.cardiodiary.presentation.ui.reminders;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.databinding.FragmentRemindingCreationBinding;
import com.valsoft.cardiodiary.presentation.ui.MedicalDrugsRVAdapter;
import com.valsoft.cardiodiary.presentation.viewmodel.reminders.RemindingCreateViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class RemindingCreationFormFragment extends Fragment implements View.OnClickListener,
        DatePickerFragment.DatePickerListener, TimePickerFragment.TimePickerListener, DrugDialogFragment.DrugListener {

    private RemindingCreateViewModel mViewModel;
    private FragmentRemindingCreationBinding mBinding;
    private FragmentManager fm;
    private Calendar calStart, calEnd ;
    private DatePickerFragment dialogFragment;
    private static final String DIALOG_DATE = "dialogDate";
    private static final String DIALOG_DATE_START = "dialogDateStart";
    private static final String DIALOG_DATE_END = "dialogDateEnd";
    private static final String DIALOG_TIME = "dialogTime";
    private static final String DIALOG_DRUG = "dialogDrug";
    private RecyclerView rv;
    private MedicalDrugsRVAdapter rvAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RemindingCreateViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_reminding_creation, container, false);
        ((RemindingFormActivity)getActivity()).getSupportActionBar().setTitle("Нагадування");
        ((RemindingFormActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mBinding.setViewModel(mViewModel);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fm = getActivity().getSupportFragmentManager();
        calStart = Calendar.getInstance();
        Date date = calStart.getTime();
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(date);
        calEnd = Calendar.getInstance();
        calEnd.add(Calendar.DATE, 1);
        String nextDay = sdf.format(calEnd.getTime());
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String currentTime = timeFormat.format(date);
        mViewModel.setStartDate(calStart.getTime());
        mViewModel.setEndDate(calEnd.getTime());
        mBinding.startDateEdText.setText(today);
        mBinding.endDateEdText.setText(nextDay);
        mBinding.dateEdText.setText(today);
        mBinding.timeEdText.setText(currentTime);
        mBinding.startDateEdText.setOnClickListener(this);
        mBinding.endDateEdText.setOnClickListener(this);
        mBinding.dateEdText.setOnClickListener(this);
        mBinding.timeEdText.setOnClickListener(this);
        mBinding.btnSave.setOnClickListener(this);
        mBinding.imgBtnAddDrug.setOnClickListener(this);
        mBinding.btnSave.setOnClickListener(this);
        rv = mBinding.drugsRv;
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAdapter = new MedicalDrugsRVAdapter();
        rv.setAdapter(rvAdapter);
        mViewModel.getLiveData().observe(this, boolean1 ->{
            if (boolean1){
                getActivity().finish();
            }else {
                mBinding.btnSave.setEnabled(true);
                Toast.makeText(getContext(), "Помилка!", Toast.LENGTH_SHORT).show();
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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start_date_ed_text:
                dialogFragment = new DatePickerFragment();
                dialogFragment.setArguments(0, this, calStart.getTime());
                dialogFragment.show(fm, DIALOG_DATE_START);

                break;
            case R.id.end_date_ed_text:
                dialogFragment = new DatePickerFragment();
                dialogFragment.setArguments(1, this, calEnd.getTime());
                dialogFragment.show(fm, DIALOG_DATE_END);
                break;
            case R.id.date_ed_text:
                dialogFragment = new DatePickerFragment();
                dialogFragment.setArguments(2, this, calStart.getTime());
                dialogFragment.show(fm, DIALOG_DATE);
                break;
            case R.id.time_ed_text:
                TimePickerFragment timePickerFragment = new TimePickerFragment();
                timePickerFragment.setListener(this);
                timePickerFragment.show(fm, DIALOG_TIME);
                break;
            case R.id.imgBtnAddDrug:
                DrugDialogFragment drugDialogFragment = new DrugDialogFragment();
                drugDialogFragment.setListener(this);
                drugDialogFragment.show(fm, DIALOG_DRUG);
                break;
            case R.id.btn_save:
                mBinding.btnSave.setEnabled(false);
                mViewModel.saveData(rvAdapter.getDrugList());
                break;

        }
    }

    @Override
    public void setDate(Date date) {
        dialogFragment.onDestroy();
        Calendar currentCal = Calendar.getInstance();
        currentCal.setTime(date);
        calStart.set(currentCal.get(Calendar.YEAR), currentCal.get(Calendar.MONTH), currentCal.get(Calendar.DAY_OF_MONTH));
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(calStart.getTime());
        mViewModel.setStartDate(calStart.getTime());
        mBinding.dateEdText.setText(today);
    }

    @Override
    public void setStartDate(Date date) {
        dialogFragment.onDestroy();
        calStart.setTime(date);
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String today = sdf.format(calStart.getTime());
        mViewModel.setStartDate(calStart.getTime());
        mBinding.startDateEdText.setText(today);
    }

    @Override
    public void setEndDate(Date date) {
        dialogFragment.onDestroy();
        calEnd.setTime(date);
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String endDay = sdf.format(calEnd.getTime());
        mViewModel.setEndDate(calEnd.getTime());
        mBinding.endDateEdText.setText(endDay);
    }

    @Override
    public void setTime(int hour, int minute) {
        calStart.set(calStart.get(Calendar.YEAR), calStart.get(Calendar.MONTH), calStart.get(Calendar.DAY_OF_MONTH), hour, minute);
        DateFormat timeFormat = new SimpleDateFormat("HH:mm");
        String currentTime = timeFormat.format(calStart.getTime());
        mViewModel.setStartDate(calStart.getTime());
        mBinding.timeEdText.setText(currentTime);
    }

    @Override
    public void setDrug(MedicalDrug drug) {
        rvAdapter.setItem(drug);
    }
}
