package com.valsoft.cardiodiary.presentation.ui.reminders;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.presentation.ui.MedicalDrugsRVAdapter;
import com.valsoft.cardiodiary.presentation.viewmodel.reminders.RemindingFormViewModel;


import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class RemindingFormFragment extends Fragment {

    private RemindingFormViewModel mViewModel;
    private RecyclerView rv;
    private TextView title, date, type, description;
    private MedicalDrugsRVAdapter rvAdapter;

    public void setArguments(long id, String type){
        Bundle args = new Bundle();
        args.putLong("id", id);
        args.putString("type", type);
        this.setArguments(args);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(RemindingFormViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_reminding_form, container, false);
        ((RemindingFormActivity)getActivity()).getSupportActionBar().setTitle("Деталі");
        ((RemindingFormActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title = view.findViewById(R.id.reminding_title_tv);
        date = view.findViewById(R.id.reminding_date_tv);
        type = view.findViewById(R.id.reminding_type_tv);
        description = view.findViewById(R.id.reminding_description_tv);
        rv = view.findViewById(R.id.drugs_rv);
        Bundle args = getArguments();
        mViewModel.getReminding(args.getLong("id", 0), args.getString("type"));
        mViewModel.getRemindingLiveData().observe(this, reminding -> {
            title.setText(reminding.getTitle());
            type.setText(reminding.getTypeOfReminding());
            description.setText(reminding.getDescription());
            if (reminding.getSecondaryDate() != null){
                DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String firstDate = sdf.format(reminding.getFirstDate());
                String secondDate = sdf.format(reminding.getSecondaryDate());
                date.setText(firstDate+"-"+secondDate);
            }else {
                DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String simplDate = sdf.format(reminding.getFirstDate());
                date.setText(simplDate);
            }
        });
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rvAdapter = new MedicalDrugsRVAdapter();
        rv.setAdapter(rvAdapter);
        mViewModel.getDrugsLiveData().observe(this, list -> rvAdapter.setDrugList(list));
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
