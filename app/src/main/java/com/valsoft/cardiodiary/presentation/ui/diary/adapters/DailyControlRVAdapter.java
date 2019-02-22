package com.valsoft.cardiodiary.presentation.ui.diary.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.DailyIndexes;
import com.valsoft.cardiodiary.presentation.OnClickListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DailyControlRVAdapter extends RecyclerView.Adapter<DailyControlRVAdapter.ViewHolder>{

    private List<DailyIndexes> mIndexesList;
    private OnClickListener mListener;
    public DailyControlRVAdapter(OnClickListener listener) {
        mIndexesList = new ArrayList<>();
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_daily_control_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setData(mIndexesList.get(i), mListener);
    }

    @Override
    public int getItemCount() {
        return mIndexesList.size();
    }

    public void setData(List<DailyIndexes> list){
        mIndexesList = list;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private TextView date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.daily_control_date);
        }

        public void setData(DailyIndexes item, OnClickListener listener){
            DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String mDate = sdf.format(item.getDate());
            date.setText(mDate);
            itemView.setOnClickListener(view ->{
                listener.onClick(item.getId());
            });
        }
    }

}

