package com.onlineapteka.test.adapter.DeviceCategoryAdapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onlineapteka.test.R;
import com.onlineapteka.test.model.DeviceCategory;
import com.squareup.picasso.Picasso;

public class DeviceViewHolder extends RecyclerView.ViewHolder {

    ImageView device_item_image;
    TextView device_item_title;

    public DeviceViewHolder(@NonNull View itemView) {
        super(itemView);
        device_item_image = itemView.findViewById(R.id.device_item_image);
        device_item_title = itemView.findViewById(R.id.device_item_title);
    }
    public interface IOnClickListener{
        void onClick(String position);
    }

    public void onBind(DeviceCategory deviceCategory){
        Picasso.get().load(deviceCategory.getDeviceImage());
        device_item_title.setText(deviceCategory.getDeviveTitle());
    }
}
