package com.valsoft.cardiodiary.presentation.ui;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.MedicalDrug;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MedicalDrugsRVAdapter extends RecyclerView.Adapter<MedicalDrugsRVAdapter.ViewHolder> {

    private List<MedicalDrug> mDrugList;

    public MedicalDrugsRVAdapter() {
        mDrugList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_drug_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setData(mDrugList.get(i));
    }

    @Override
    public int getItemCount() {
        return mDrugList.size();
    }

    public void setDrugList(List<MedicalDrug> list){
        mDrugList = list;
        notifyDataSetChanged();
    }

    public void setItem(MedicalDrug drug){
        mDrugList.add(drug);
        notifyDataSetChanged();
    }

    public List<MedicalDrug> getDrugList() {
        return mDrugList;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView title, doze, admissionTime, conditions;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.drug_title);
            doze = itemView.findViewById(R.id.doze);
            admissionTime = itemView.findViewById(R.id.admission_time);
            conditions = itemView.findViewById(R.id.conditions);
        }

        void setData(MedicalDrug item){
            title.setText(item.getName());
            doze.setText(item.getDosage());
            admissionTime.setText(item.getTimeUsage());
            conditions.setText(item.getSpecialCondition());
        }
    }
}
