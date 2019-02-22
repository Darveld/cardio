package com.valsoft.cardiodiary.presentation.ui.diary.questionary;

import android.arch.lifecycle.Observer;
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
import android.widget.Button;
import android.widget.Toast;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.databinding.FragmentSymptomFormBinding;
import com.valsoft.cardiodiary.presentation.viewmodel.diary.questionary.SymptomFormViewModel;

public class SymptomFormFragment extends Fragment {

    private Button mNextBtn;
    private SymptomFormViewModel mViewModel;
    private FragmentSymptomFormBinding mBinding;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(SymptomFormViewModel.class);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_symptom_form, container, false);
        ((QuestionaryActivity)getActivity()).getSupportActionBar().setTitle("Симптоми");
        ((QuestionaryActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mBinding.setViewModel(mViewModel);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNextBtn = view.findViewById(R.id.btn_save);
        mViewModel.getStatusLiveData().observe(this, aBoolean ->{
            if (aBoolean){
                getActivity().finish();
            }else {
                Toast.makeText(getContext(), "Помилка при заповненні форми!", Toast.LENGTH_SHORT).show();
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
