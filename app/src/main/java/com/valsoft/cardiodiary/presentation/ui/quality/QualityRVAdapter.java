package com.valsoft.cardiodiary.presentation.ui.quality;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.QualityOfLife;
import com.valsoft.cardiodiary.data.local.entity.Statistic;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class QualityRVAdapter extends RecyclerView.Adapter<QualityRVAdapter.ViewHolder> {

    private List<QualityOfLife> dataSet;
    private Listener mListener;

    public QualityRVAdapter(Listener listener){
        dataSet = new ArrayList<>();
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_quality_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(dataSet.get(i), mListener);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void setDataSet(List<QualityOfLife> list){
        dataSet = list;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView monthTextView, yearTextView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            monthTextView = itemView.findViewById(R.id.month);
            yearTextView = itemView.findViewById(R.id.year);
        }

        void bind(QualityOfLife quality, Listener listener){
            Calendar cal = Calendar.getInstance();
            cal.setTime(quality.getDate());
            yearTextView.setText(String.valueOf(cal.get(Calendar.YEAR)));
            String[] monthNames = { "Січень", "Лютий", "Березень", "Квітень", "Травень", "Червень", "Липень", "Серпень", "Вересень", "Жвтень", "Листопад", "Грудень" };
            String month = monthNames[cal.get(Calendar.MONTH)];
            monthTextView.setText(month);
            itemView.setOnClickListener(view -> mListener.onClick(quality.getId()));
        }
    }

    public interface Listener{
        void onClick(long id);
    }
}

