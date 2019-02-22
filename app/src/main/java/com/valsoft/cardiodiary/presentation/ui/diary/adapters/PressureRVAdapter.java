package com.valsoft.cardiodiary.presentation.ui.diary.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.Pressure;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PressureRVAdapter extends RecyclerView.Adapter<PressureRVAdapter.PressureViewHolder>{

    private List<Pressure> mPressureList;

    public PressureRVAdapter(){
        mPressureList = new ArrayList<>();
    }

    @NonNull
    @Override
    public PressureViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_pressure_item, viewGroup, false);
        return new PressureViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PressureViewHolder pressureViewHolder, int i) {
        pressureViewHolder.setData(mPressureList.get(i));
    }

    @Override
    public int getItemCount() {
        return mPressureList.size();
    }

    public void setPressureList(List<Pressure> pressureList){
        mPressureList = pressureList;
        notifyDataSetChanged();
    }

    class PressureViewHolder extends RecyclerView.ViewHolder{
        private TextView systolic, diastolic, frequency, date;

        public PressureViewHolder(@NonNull View itemView) {
            super(itemView);
            systolic = itemView.findViewById(R.id.systolic_text_view);
            diastolic = itemView.findViewById(R.id.diastolic_text_view);
            frequency = itemView.findViewById(R.id.frequency_text_view);
            date = itemView.findViewById(R.id.date_text_view);
        }

        public void setData(Pressure item){
            DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String mDate = sdf.format(item.getDate());
            date.setText(mDate);
            this.systolic.setText(String.valueOf(item.getSystolic()));
            this.diastolic.setText(String.valueOf(item.getDiastolic()));
            this.frequency.setText(String.valueOf(item.getFrequency()));
        }
    }
}
