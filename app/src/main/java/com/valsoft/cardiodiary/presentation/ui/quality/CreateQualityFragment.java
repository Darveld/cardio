package com.valsoft.cardiodiary.presentation.ui.quality;

import android.arch.lifecycle.ViewModelProviders;
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

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.databinding.FragmentQualityFormBinding;
import com.valsoft.cardiodiary.presentation.viewmodel.quality.QualityCreateViewModel;

public class CreateQualityFragment extends Fragment {

    private QualityCreateViewModel mViewModel;
    private FragmentQualityFormBinding mBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(QualityCreateViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quality_form, container, false);
        ((QualityActivity)getActivity()).getSupportActionBar().setTitle("Оцінка якості");
        ((QualityActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_quality_form, container, false);
        mBinding.setViewModel(mViewModel);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.getLiveDataStatus().observe(this, aBoolean -> {
            if (aBoolean){
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
