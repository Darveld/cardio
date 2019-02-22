package com.valsoft.cardiodiary.presentation.ui.diary.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.Symptoms;
import com.valsoft.cardiodiary.presentation.OnClickListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class SymptomRVAdapter extends RecyclerView.Adapter<SymptomRVAdapter.SymptomViewHolder> {

    private List<Symptoms> mSymptoms;
    private OnClickListener mListener;

    public SymptomRVAdapter(OnClickListener listener){
        mSymptoms = new ArrayList<>();
        mListener = listener;
    }

    @NonNull
    @Override
    public SymptomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_symptom_item, viewGroup, false);
        return new SymptomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SymptomViewHolder symptomViewHolder, int i) {
        symptomViewHolder.setData(mSymptoms.get(i), mListener);
    }

    @Override
    public int getItemCount() {
        return mSymptoms.size();
    }

    public void setSymptoms(List<Symptoms> list){
        mSymptoms = list;
        notifyDataSetChanged();
    }

    class SymptomViewHolder extends RecyclerView.ViewHolder{
        private TextView date;

        public SymptomViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.symptoms_date);
        }

        public void setData(Symptoms item, OnClickListener listener){
            DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String mDate = sdf.format(item.getDate());
            date.setText(mDate);
            itemView.setOnClickListener(view -> {
                mListener.onClick(item.getId());
            });
        }
    }
}
