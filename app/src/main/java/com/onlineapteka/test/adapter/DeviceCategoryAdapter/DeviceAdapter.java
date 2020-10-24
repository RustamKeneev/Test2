package com.onlineapteka.test.adapter.DeviceCategoryAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onlineapteka.test.R;
import com.onlineapteka.test.model.DeviceCategory;

import java.util.ArrayList;
import java.util.List;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceViewHolder> {

    private DeviceViewHolder.IOnClickListener iOnClickListener;
    private List<DeviceCategory> mDeviceCategories = new ArrayList<>();



    public DeviceAdapter(DeviceViewHolder.IOnClickListener iOnClickListener) {
        this.iOnClickListener = iOnClickListener;
    }

    public void updateList(List<DeviceCategory> list){
        this.mDeviceCategories = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_device,parent,false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder holder, final int position) {
        holder.onBind(mDeviceCategories.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClickListener.onClick(mDeviceCategories.get(position).getDeviceId());
                Log.d("TAG", "onClick: " + mDeviceCategories.get(position).getDeviceId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDeviceCategories.size();
    }

    private void setData(DeviceCategory deviceCategory){
        mDeviceCategories.clear();
        mDeviceCategories.add(deviceCategory);
        notifyDataSetChanged();
    }
}
