package com.valsoft.cardiodiary.presentation.ui.medical_card.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.MedicalRecord;
import com.valsoft.cardiodiary.presentation.OnClickListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MedicalRecordsAdapter extends RecyclerView.Adapter<MedicalRecordsAdapter.ViewHolder> {
    private List<MedicalRecord> dataset;
    private OnClickListener mListener;

    public MedicalRecordsAdapter(OnClickListener listener) {
        dataset = new ArrayList<>();
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_medical_record, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setItem(dataset.get(i), mListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void setDataset(List<MedicalRecord> list) {
        this.dataset = list;
        notifyDataSetChanged();
    }

    public List<MedicalRecord> getDataset() {
        return dataset;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title, date;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date);
        }

        void setItem(MedicalRecord item, OnClickListener listener){
            title.setText(item.getTitle());
            DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            String date = sdf.format(item.getDate());
            this.date.setText(date);
            itemView.setOnClickListener(view ->{
                listener.onClick(item.getId());
            });
        }
    }
}
