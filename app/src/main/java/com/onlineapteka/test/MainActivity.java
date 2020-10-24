package com.onlineapteka.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.onlineapteka.test.adapter.DeviceCategoryAdapter.DeviceAdapter;
import com.onlineapteka.test.adapter.DeviceCategoryAdapter.DeviceViewHolder;
import com.onlineapteka.test.model.DeviceCategory;
import com.onlineapteka.test.model.DeviceSubcategory;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DeviceViewHolder.IOnClickListener {

    private DeviceAdapter mDeviceAdapter;
    private ArrayList<DeviceCategory> mDeviceCategories;
    private RecyclerView mRecyclerView;
    private GridLayoutManager gridLayoutManager;
    private DeviceViewModel mDeviceViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initViewModels();
    }

    private void initViews() {
        mRecyclerView = findViewById(R.id.device_category_recycler);

        mDeviceCategories = new ArrayList<>();
        mDeviceCategories.add(new DeviceCategory("7","id7 -> Изделия используемые " +
                "для введения лекарственных средств и растворов в ткани и полости тела",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("16","id16 -> Перевязочные средства",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("18","id18 -> Шовный материал",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("34","id34 -> Анестезиологические и респираторные медицинские изделия",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("35","id35 -> Вспомогательные и общебольничные медицинские изделия",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("36","id36 -> Гастроэнтерологические медицинские изделия",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("37","id37 -> Медицинские изделия для акушерства и гинекологии",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("38","id38 -> Медицинские изделия для диагностики in vitro",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("39","id39 -> Медицинские изделия для манипуляций/восстановления тканей/органов человека",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("40","id40 -> Медицинские изделия для оториноларингологии",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("41","id41 -> Медицинские изделия для пластической хирургии и косметологии",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("42","id42 -> Неврологические медицинские изделия",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("43","id43 -> Ортопедические медицинские изделия",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("44","id44 -> Офтальмологические медицинские изделия",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("45","id45 -> Радиологические медицинские изделия",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("46","id46 -> Реабилитационные и адаптированные для инвалидов медицинские изделия",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("47","id47 -> Сердечно-сосудистые медицинские изделия",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("48","id48 -> Стоматологические медицинские изделия",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("49","id49 -> Урологические медицинские изделия",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("50","id50 -> Физиотерапевтические медицинские изделия",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("51","id51 -> Хирургические инструменты/системы и сопутствующие медицинские изделия",R.drawable.ic_baseline));
        mDeviceCategories.add(new DeviceCategory("52","id52 -> Эндоскопические медицинские изделия",R.drawable.ic_baseline));


        mDeviceAdapter = new DeviceAdapter(this);
        gridLayoutManager = new GridLayoutManager(this,1,GridLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mDeviceAdapter);
        mDeviceAdapter.updateList(mDeviceCategories);
    }

    private void initViewModels() {
        mDeviceViewModel = ViewModelProviders.of(this).get(DeviceViewModel.class);
        mDeviceViewModel.subCategoriesLiveData.observe(this, new Observer<List<DeviceSubcategory>>() {
            @Override
            public void onChanged(List<DeviceSubcategory> deviceSubcategories) {

            }
        });

    }

    @Override
    public void onClick(String subId) {
        Intent intent = new Intent(this, DeviceSubCategoryActivity.class);
        intent.putExtra("subId", subId);
        Log.d("TAG", "Main onClick: " + subId);

        startActivity(intent);
    }
}