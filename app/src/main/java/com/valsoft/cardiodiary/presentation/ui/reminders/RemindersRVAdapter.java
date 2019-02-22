package com.valsoft.cardiodiary.presentation.ui.reminders;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.valsoft.cardiodiary.R;
import com.valsoft.cardiodiary.data.local.entity.Reminding;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RemindersRVAdapter extends RecyclerView.Adapter<RemindersRVAdapter.ViewHolder> {

    private List<Reminding> mList;
    private Listener mListener;

    public RemindersRVAdapter(Listener listener) {
        mList = new ArrayList<>();
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.rv_reminding_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.setItem(mList.get(i), mListener);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setData(List<Reminding> list){
        mList = list;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView title, description, type, date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.reminding_title_tv);
            type = itemView.findViewById(R.id.reminding_type_tv);
            description = itemView.findViewById(R.id.reminding_description_tv);
            date = itemView.findViewById(R.id.reminding_date_tv);
        }

        void setItem(Reminding item, Listener listener){
            title.setText(item.getTitle());
            type.setText(item.getTypeOfReminding());
            description.setText(item.getDescription());

            if (item.getTypeOfReminding().equals("Прийом ліків") ){
                DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String firstDate = sdf.format(item.getFirstDate());
                String secondDate = sdf.format(item.getSecondaryDate());
                date.setText(firstDate+" - "+secondDate);
            }else {
                DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String simplDate = sdf.format(item.getFirstDate());
                date.setText(simplDate);
            }
            itemView.setOnClickListener(view -> {
                listener.onClicked(item.getId(), item.getTypeOfReminding());
            });
        }

    }
}
