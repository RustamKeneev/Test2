package com.onlineapteka.test.adapter.DeviceSubCategoryAdapter;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.onlineapteka.test.R;
import com.onlineapteka.test.model.DeviceSubcategory;

public class DeviceSubViewHolder extends RecyclerView.ViewHolder {

    TextView sub_category_title;

    public DeviceSubViewHolder(@NonNull View itemView) {
        super(itemView);

        sub_category_title = itemView.findViewById(R.id.sub_category_title);
    }

    public interface IOnClickListener{
        void onClick(String position);
    }

    public void onBind(DeviceSubcategory deviceSubcategory){
        sub_category_title.setText(deviceSubcategory.getDeviceSubCategoryTitle());
    }
}
