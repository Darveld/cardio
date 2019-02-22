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
import android.support.v4.app.ActivityCompat;
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
import android.widget.ImageView;
import android.widget.Toast;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;
import com.valsoft.cardiodiary.presentation.ui.MedicalDrugsRVAdapter;
import com.valsoft.cardiodiary.presentation.ui.medical_card.adapters.MedicalRecordAttachmentsAdapter;
import com.valsoft.cardiodiary.presentation.ui.reminders.DrugDialogFragment;
import com.valsoft.cardiodiary.presentation.viewmodel.medicalcard.MedicalRecordFormViewModel;

import java.util.ArrayList;
import java.util.List;

import static android.app.Activity.RESULT_OK;

public class MedicalRecordFormFragment extends Fragment implements Listener, DrugDialogFragment.DrugListener{

    public static final int GET_ATTACHMENT_ACTIVITY = 1;
    private static final String DIALOG_DRUG = "dialogDrug";
    private List<Uri> imagesUri;
    private TextInputEditText title, advice, plannedInspections, plannedVisits;
    private ImageButton imgBtnAddDrug, imgbtnAttachImages;
    private Button btnSave;
    private RecyclerView rvDrugs, rvImages;
    private MedicalDrugsRVAdapter mDrugsRVAdapter;
    private MedicalRecordAttachmentsAdapter attachmentsAdapter;
    private FragmentManager fm;
    private MedicalRecordFormViewModel mViewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(MedicalRecordFormViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medical_record_form, container, false);
        ((MedicalRecordActivity)getActivity()).getSupportActionBar().setTitle("Запис");
        ((MedicalRecordActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title = view.findViewById(R.id.title);
        advice = view.findViewById(R.id.advice);
        plannedInspections = view.findViewById(R.id.plannedInspection);
        plannedVisits = view.findViewById(R.id.plannedVisits);
        imgBtnAddDrug = view.findViewById(R.id.imgBtnAddDrug);
        imgbtnAttachImages = view.findViewById(R.id.imgBtnAttachImages);
        rvDrugs = view.findViewById(R.id.drugsRv);
        rvImages = view.findViewById(R.id.imagesRv);
        btnSave = view.findViewById(R.id.btn_save);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fm = getChildFragmentManager();
        imagesUri = new ArrayList<>();
        attachmentsAdapter = new MedicalRecordAttachmentsAdapter(this);
        mDrugsRVAdapter = new MedicalDrugsRVAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rvDrugs.setLayoutManager(new LinearLayoutManager(getContext()));
        rvDrugs.setAdapter(mDrugsRVAdapter);
        rvImages.setLayoutManager(layoutManager);
        rvImages.setAdapter(attachmentsAdapter);
        mViewModel.getLiveData().observe(this, aBoolean -> {
            if (aBoolean){
                getActivity().finish();
            }else {
                Toast.makeText(getContext(), "Помилка!", Toast.LENGTH_SHORT).show();
            }
        });
        imgbtnAttachImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ContextCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    Intent photoPickerIntent = new Intent();
                    photoPickerIntent.setType("image/*");
                    photoPickerIntent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
                    photoPickerIntent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                    startActivityForResult(photoPickerIntent, GET_ATTACHMENT_ACTIVITY);
                } else {
                    requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, GET_ATTACHMENT_ACTIVITY);
                }
            }
        });
        imgBtnAddDrug.setOnClickListener(view1 -> {
            DrugDialogFragment drugDialogFragment = new DrugDialogFragment();
            drugDialogFragment.setListener(this);
            drugDialogFragment.show(fm, DIALOG_DRUG);
        });
        btnSave.setOnClickListener(view1 -> {
            mViewModel.createRecord(title.getText().toString(), advice.getText().toString(),
                    plannedInspections.getText().toString(), plannedVisits.getText().toString(), mDrugsRVAdapter.getDrugList(), attachmentsAdapter.getDataset());
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
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case GET_ATTACHMENT_ACTIVITY:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(
                            new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, GET_ATTACHMENT_ACTIVITY);
                }
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case GET_ATTACHMENT_ACTIVITY:
                if (resultCode == RESULT_OK) {
                    if(data.getData()!=null){//single image
                        Uri mImageUri=data.getData();
                        imagesUri.add(mImageUri);
                        attachmentsAdapter.addAttachment(mImageUri);

                    } else {// multiple images
                        if (data.getClipData() != null) {
                            ClipData mClipData = data.getClipData();
                            ArrayList<Uri> mArrayUri = new ArrayList<Uri>();
                            for (int i = 0; i < mClipData.getItemCount(); i++) {
                                ClipData.Item item = mClipData.getItemAt(i);
                                Uri mImageUri = item.getUri();
                                imagesUri.add(mImageUri);
                                attachmentsAdapter.addAttachment(mImageUri);
                            }
                        }
                    }
                }
                break;
        }
    }

    @Override
    public void onClickImage(Uri uri) {
        ImageViewFragment imageViewFragment = new ImageViewFragment();
        imageViewFragment.setImageUri(uri);
        imageViewFragment.show(fm,"ViewImage");
    }

    @Override
    public void setDrug(MedicalDrug drug) {
        mDrugsRVAdapter.setItem(drug);
    }
}
