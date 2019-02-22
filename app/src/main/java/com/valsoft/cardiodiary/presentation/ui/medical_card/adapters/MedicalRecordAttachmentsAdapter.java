package com.valsoft.cardiodiary.presentation.ui.medical_card.adapters;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.presentation.OnClickListener;
import com.valsoft.cardiodiary.presentation.ui.diary.questionary.DatePickerFragment;
import com.valsoft.cardiodiary.presentation.ui.diary.questionary.PressureFormFragment;
import com.valsoft.cardiodiary.presentation.ui.medical_card.ImageViewFragment;
import com.valsoft.cardiodiary.presentation.ui.medical_card.Listener;

import java.util.ArrayList;
import java.util.List;

public class MedicalRecordAttachmentsAdapter extends RecyclerView.Adapter<MedicalRecordAttachmentsAdapter.ViewHolder>  {
    private List<Uri> dataset;
    private Listener mListener;
    public MedicalRecordAttachmentsAdapter(Listener listener) {
        mListener = listener;
        dataset = new ArrayList<>();
    }



    @NonNull
    @Override
    public  ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        ConstraintLayout itemLayout = (ConstraintLayout) LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_record_attachment, viewGroup, false);
        return new  ViewHolder(itemLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull  ViewHolder viewHolder, int i) {
        viewHolder.setItem(dataset.get(i), mListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void setDataset(List<Uri> dataset) {
        this.dataset = dataset;
        notifyDataSetChanged();
    }

    public void addAttachment(Uri uri){
        dataset.add(uri);
        notifyItemInserted(dataset.size()-1);
    }

    public List<Uri> getDataset() {
        return dataset;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView recordAttachmentIV;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            recordAttachmentIV = itemView.findViewById(R.id.recordAttachmentIV);
        }

        void setItem(Uri uri, Listener listener){
            Picasso.get().load(uri).into(recordAttachmentIV);
            itemView.setOnClickListener(view -> {
                listener.onClickImage(uri);
            });
        }
    }
}
