package com.onlineapteka.test;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.onlineapteka.test.App.App;
import com.onlineapteka.test.model.DeviceSubcategory;
import com.onlineapteka.test.repository.IRepository;

import java.util.List;

public class DeviceViewModel extends ViewModel {
        public MutableLiveData<List<DeviceSubcategory>> subCategoriesLiveData = new MutableLiveData<>();

        public void getSubCategoriesDevice(final String categoryId){
            App.repository.getDeviceSubcategories(categoryId, new IRepository.CallBack<List<DeviceSubcategory>>() {
                @Override
                public void onSuccess(List<DeviceSubcategory> deviceSubcategories) {
                    subCategoriesLiveData.setValue(deviceSubcategories);
                }

                @Override
                public void onFailure(Exception e) {
                    Log.d("TAG", "subId:");
                }
            });
        }
}
