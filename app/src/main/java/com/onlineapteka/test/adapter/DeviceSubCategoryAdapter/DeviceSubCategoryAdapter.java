package com.onlineapteka.test.adapter.DeviceSubCategoryAdapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onlineapteka.test.R;
import com.onlineapteka.test.model.DeviceSubcategory;

import java.util.ArrayList;
import java.util.List;

public class DeviceSubCategoryAdapter extends RecyclerView.Adapter<DeviceSubViewHolder> {

    private DeviceSubViewHolder.IOnClickListener iOnClickListener;
    private List<DeviceSubcategory> mDeviceSubcategories = new ArrayList<>();

    public DeviceSubCategoryAdapter(DeviceSubViewHolder.IOnClickListener iOnClickListener) {
        this.iOnClickListener = iOnClickListener;
    }


    public void updateList(List<DeviceSubcategory> list){
        this.mDeviceSubcategories = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DeviceSubViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_device_title,parent,false);
        return new DeviceSubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceSubViewHolder holder, int position) {
        holder.onBind(mDeviceSubcategories.get(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iOnClickListener.onClick(mDeviceSubcategories.get(position).getDeviceSubCategoryId());
                Log.d("TAG", "onClick: DeviceSubCategoryAdapter" + mDeviceSubcategories.get(position).getDeviceSubCategoryId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDeviceSubcategories.size();
    }

}
