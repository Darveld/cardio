package com.valsoft.cardiodiary.presentation.ui.statistic;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.Statistic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class StatisticRVAdapter extends RecyclerView.Adapter<StatisticRVAdapter.ViewHolder> {

    private List<Statistic> dataSet;
    private Listener mListener;

    public StatisticRVAdapter(Listener listener){
        dataSet = new ArrayList<>();
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_statistic_item, viewGroup, false);
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

    public void setDataSet(List<Statistic> list){
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

        void bind(Statistic statistic, Listener listener){
            yearTextView.setText(String.valueOf(statistic.getYear()));
            Calendar cal = Calendar.getInstance();
            String[] monthNames = { "Січень", "Лютий", "Березень", "Квітень", "Травень", "Червень", "Липень", "Серпень", "Вересень", "Жвтень", "Листопад", "Грудень" };
            cal.set(Calendar.MONTH, statistic.getMonth()-1);
            String month = monthNames[cal.get(Calendar.MONTH)];
            monthTextView.setText(month);
            itemView.setOnClickListener(view -> mListener.onClick(statistic.getId()));
        }
    }

    public interface Listener{
        void onClick(long id);
    }
}

