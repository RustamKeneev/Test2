package com.onlineapteka.test;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.onlineapteka.test.App.App;
import com.onlineapteka.test.model.DeviceSubSecondModel;

import com.onlineapteka.test.repository.IRepository;

import java.util.List;

public class DeviceSubSecondViewModel extends ViewModel {
    public MutableLiveData<List<DeviceSubSecondModel>> subSecondCategoriesLiveData = new MutableLiveData<>();
    public void getSubCategoriesDevice(final String subCategoryId){
        App.repository.getDeviceSubSecondCategory(subCategoryId, new IRepository.CallBack<List<DeviceSubSecondModel>>() {
            @Override
            public void onSuccess(List<DeviceSubSecondModel> deviceSubSecondModels) {
                subSecondCategoriesLiveData.setValue(deviceSubSecondModels);
                Log.d("TAG", "onSuccess: subSecondCategoriesLiveData " + deviceSubSecondModels.size());
            }

            @Override
            public void onFailure(Exception e) {
                e.printStackTrace();
                Log.d("TAG", "onFailure: " +e);
            }
        });
    }
}
