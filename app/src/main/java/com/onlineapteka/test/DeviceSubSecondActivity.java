package com.onlineapteka.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.onlineapteka.test.adapter.DeviceSubSecondAdapter.DeviceSubSecondAdapter;
import com.onlineapteka.test.adapter.DeviceSubSecondAdapter.DeviceSubSecondViewHolder;
import com.onlineapteka.test.model.DeviceSubSecondModel;

import java.util.ArrayList;
import java.util.List;

public class DeviceSubSecondActivity extends AppCompatActivity implements DeviceSubSecondViewHolder.IOnClickListener {

    private RecyclerView mRecyclerView;
    private DeviceSubSecondViewModel deviceSubSecondViewModel;
    private DeviceSubSecondAdapter deviceSubSecondAdapter;
    private ArrayList<DeviceSubSecondModel> deviceViewModels;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_sub_second);
        Intent intent = getIntent();
        String subSecondId = intent.getStringExtra("subSecondId");
        Log.d("TAG", "subSecondId: " + subSecondId);

        initViews();
        initViewModels();
        deviceSubSecondViewModel.getSubCategoriesDevice(subSecondId);

    }

    private void initViewModels() {
        deviceSubSecondViewModel = ViewModelProviders.of(this).get(DeviceSubSecondViewModel.class);
        deviceSubSecondViewModel.subSecondCategoriesLiveData.observe(this, new Observer<List<DeviceSubSecondModel>>() {
            @Override
            public void onChanged(List<DeviceSubSecondModel> deviceSubSecondModels) {
                deviceSubSecondAdapter.updateList(deviceSubSecondModels);
                deviceViewModels = new ArrayList<>();
                deviceViewModels.addAll(deviceViewModels);
                Log.d("TAG", "onChanged: deviceSubSecondModels "+ deviceSubSecondModels.size());
            }
        });

    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.device_sub_category_recycler);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        deviceSubSecondAdapter = new DeviceSubSecondAdapter(this);
        mRecyclerView.setAdapter(deviceSubSecondAdapter);
    }

    @Override
    public void onClick(String position) {

    }
}