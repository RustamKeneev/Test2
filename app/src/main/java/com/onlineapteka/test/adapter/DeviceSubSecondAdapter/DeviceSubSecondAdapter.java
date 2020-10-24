package com.onlineapteka.test.adapter.DeviceSubSecondAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onlineapteka.test.OnItemClickListener;
import com.onlineapteka.test.R;
import com.onlineapteka.test.model.DeviceSubSecondModel;

import java.util.ArrayList;
import java.util.List;

public class DeviceSubSecondAdapter extends RecyclerView.Adapter<DeviceSubSecondViewHolder> {

    private DeviceSubSecondViewHolder.IOnClickListener iOnClickListener;
    private List<DeviceSubSecondModel> deviceSubSecondModels = new ArrayList<>();

        public DeviceSubSecondAdapter(DeviceSubSecondViewHolder.IOnClickListener iOnClickListener) {
        this.iOnClickListener = iOnClickListener;
    }

    public void updateList(List<DeviceSubSecondModel> list){
        this.deviceSubSecondModels = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DeviceSubSecondViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sub_category,parent,false);
        return new DeviceSubSecondViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceSubSecondViewHolder holder, int position) {
        holder.onBind(deviceSubSecondModels.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClickListener.onClick(deviceSubSecondModels.get(position).getDeviceSubSecondCategoryId());
                Log.d("TAG", "onClick: " + position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return deviceSubSecondModels.size();
    }

}
