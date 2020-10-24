package com.onlineapteka.test.adapter.DeviceSubSecondAdapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.onlineapteka.test.App.App;
import com.onlineapteka.test.R;
import com.onlineapteka.test.model.DeviceSubSecondModel;

import com.squareup.picasso.Picasso;

public class DeviceSubSecondViewHolder extends RecyclerView.ViewHolder {

    ImageView sub_category_second_image;
    TextView sub_category_second_title;
    TextView sub_category_second_sub_title;
    TextView sub_category_second_description;

    public DeviceSubSecondViewHolder(@NonNull View itemView) {
        super(itemView);
        sub_category_second_image = itemView.findViewById(R.id.sub_category_second_image);
        sub_category_second_title = itemView.findViewById(R.id.sub_category_second_title);
        sub_category_second_sub_title = itemView.findViewById(R.id.sub_category_second_sub_title);
        sub_category_second_description = itemView.findViewById(R.id.sub_category_second_description);
    }
    public interface IOnClickListener{
        void onClick(String position);
    }

    public void onBind(DeviceSubSecondModel deviceSubSecondModel){
        Picasso.get().load(App.repository.getWholeImagePath(deviceSubSecondModel.getDeviceSubSecondCategoryImage())).into(sub_category_second_image);
        sub_category_second_title.setText(deviceSubSecondModel.getDeviceSubSecondCategoryTitle());
        sub_category_second_sub_title.setText(deviceSubSecondModel.getDeviceSubSecondCategorySubTitle());
        sub_category_second_description.setText(deviceSubSecondModel.getDeviceSubSecondCategoryDescription());
    }
}
