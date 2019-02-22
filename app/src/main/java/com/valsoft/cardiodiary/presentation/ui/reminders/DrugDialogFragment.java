package com.valsoft.cardiodiary.presentation.ui.reminders;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;

public class DrugDialogFragment extends DialogFragment {

    private TextInputEditText drugName, dosage, time, conditions;
    private DrugListener mListener;
    private MedicalDrug mMedicalDrug;
    public void setListener(DrugListener listener){
        mListener = listener;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_dialog_drug, null);
        drugName = view.findViewById(R.id.drugName);
        dosage = view.findViewById(R.id.drugDosage);
        time = view.findViewById(R.id.time);
        conditions = view.findViewById(R.id.conditions);
        return new AlertDialog.Builder(getContext())
                .setView(view)
                .setTitle("Заповнить поля: ")
                .setPositiveButton("Зберегти", (dialogInterface,i) ->{
                   mMedicalDrug = new MedicalDrug();
                   mMedicalDrug.setName(drugName.getText().toString());
                   mMedicalDrug.setDosage(dosage.getText().toString());
                   mMedicalDrug.setTimeUsage(time.getText().toString());
                   mMedicalDrug.setSpecialCondition(conditions.getText().toString());
                   mListener.setDrug(mMedicalDrug);
                }).create();
    }

    public interface DrugListener{
        void setDrug(MedicalDrug drug);
    }
}
