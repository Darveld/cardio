package com.valsoft.cardiodiary.presentation.ui.medical_card;

import android.Manifest;
import android.arch.lifecycle.ViewModelProviders;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.presentation.ui.MedicalDrugsRVAdapter;
import com.valsoft.cardiodiary.presentation.ui.medical_card.adapters.MedicalRecordAttachmentsAdapter;
import com.valsoft.cardiodiary.presentation.ui.reminders.DrugDialogFragment;
import com.valsoft.cardiodiary.presentation.viewmodel.medicalcard.MedicalRecordDetailViewModel;
import com.valsoft.cardiodiary.presentation.viewmodel.medicalcard.MedicalRecordFormViewModel;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class MedicalRecordDetailFragment extends Fragment implements Listener{

    private TextView title, advice, plannedInspections, plannedVisits;
    private RecyclerView rvDrugs, rvImages;
    private MedicalDrugsRVAdapter mDrugsRVAdapter;
    private MedicalRecordAttachmentsAdapter attachmentsAdapter;
    private FragmentManager fm;
    private MedicalRecordDetailViewModel mViewModel;
    private List<Uri> mUriList;
    public void setArguments(long id){
        Bundle args = new Bundle();
        args.putLong("id", id);
        this.setArguments(args);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MedicalRecordDetailViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medical_record_detail, container, false);
        ((MedicalRecordActivity)getActivity()).getSupportActionBar().setTitle("Деталі");
        ((MedicalRecordActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title = view.findViewById(R.id.title);
        advice = view.findViewById(R.id.advice);
        plannedInspections = view.findViewById(R.id.plannedInspection);
        plannedVisits = view.findViewById(R.id.plannedVisits);
        rvDrugs = view.findViewById(R.id.drugsRv);
        rvImages = view.findViewById(R.id.imagesRv);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        long id = getArguments().getLong("id");
        fm = getChildFragmentManager();
        mUriList = new ArrayList<>();
        attachmentsAdapter = new MedicalRecordAttachmentsAdapter(this);
        mDrugsRVAdapter = new MedicalDrugsRVAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvDrugs.setLayoutManager(new LinearLayoutManager(getContext()));
        rvDrugs.setAdapter(mDrugsRVAdapter);
        rvImages.setLayoutManager(layoutManager);
        rvImages.setAdapter(attachmentsAdapter);
        mViewModel.getData(id);
        mViewModel.getDrugLiveData().observe(this, list -> {
            mDrugsRVAdapter.setDrugList(list);
        });
        mViewModel.getRecordLiveData().observe(this, item ->{
            for (String uri: item.getImages()) {
                Log.d("Uri ", uri);
                mUriList.add(Uri.parse(uri));
            }
            attachmentsAdapter.setDataset(mUriList);
            title.setText(item.getTitle());
            advice.setText(item.getMedicalNotes());
            plannedInspections.setText(item.getPlannedInspection());
            plannedVisits.setText(item.getPlannedVisits());
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
    public void onClickImage(Uri uri) {
        ImageViewFragment imageViewFragment = new ImageViewFragment();
        imageViewFragment.setImageUri(uri);
        imageViewFragment.show(fm,"ViewImage");
    }

}
