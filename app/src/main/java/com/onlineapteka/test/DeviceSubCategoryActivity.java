package com.onlineapteka.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.onlineapteka.test.adapter.DeviceSubCategoryAdapter.DeviceSubCategoryAdapter;
import com.onlineapteka.test.adapter.DeviceSubCategoryAdapter.DeviceSubViewHolder;
import com.onlineapteka.test.model.DeviceSubcategory;

import java.util.ArrayList;
import java.util.List;

public class DeviceSubCategoryActivity extends AppCompatActivity implements DeviceSubViewHolder.IOnClickListener {
    private DeviceSubCategoryAdapter mDeviceSubCategoryAdapter;
    private RecyclerView mRecyclerView;
    private DeviceViewModel mDeviceViewModel;
    private ArrayList<DeviceSubcategory> mDeviceSubcategories;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_sub_category);
        Intent intent = getIntent();
        String id = intent.getStringExtra("subId");
        initViews();
        initViewModels();
        Log.d("TAG", "subId: " + id);
        mDeviceViewModel.getSubCategoriesDevice(id);
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.activity_device_sub_category);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mDeviceSubCategoryAdapter = new DeviceSubCategoryAdapter(this::onClick);
        mRecyclerView.setAdapter(mDeviceSubCategoryAdapter);

    }
    private void initViewModels() {
        mDeviceViewModel = ViewModelProviders.of(this).get(DeviceViewModel.class);
        mDeviceViewModel.subCategoriesLiveData.observe(this, new Observer<List<DeviceSubcategory>>() {
            @Override
            public void onChanged(List<DeviceSubcategory> deviceSubcategories) {
                Log.d("TAG", "onChanged: " + deviceSubcategories.size());
                mDeviceSubCategoryAdapter.updateList(deviceSubcategories);
                mDeviceSubcategories = new ArrayList<>();
                mDeviceSubcategories.addAll(mDeviceSubcategories);
            }
        });

    }

    @Override
    public void onClick(String subSecondId) {
        Intent intent = new Intent(this,DeviceSubSecondActivity.class);
        intent.putExtra("subSecondId", subSecondId);
        Log.d("TAG", "DeviceSubCategoryActivity: " + subSecondId);

        startActivity(intent);
    }
}