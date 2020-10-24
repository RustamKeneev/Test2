package com.onlineapteka.test.repository;

import com.onlineapteka.test.model.DeviceSubSecondModel;
import com.onlineapteka.test.model.DeviceSubcategory;
import com.onlineapteka.test.repository.remote.IApiClient;

import java.util.List;

public class Repository implements IRepository {
    private IApiClient apiClient;

    public Repository(IApiClient apiClient) {
        this.apiClient = apiClient;
    }

    @Override
    public void getDeviceCategories(DeviceCategoryCallback deviceCategoryCallback) {
        apiClient.getDeviceCategories(deviceCategoryCallback);
    }

    @Override
    public void getDeviceSubcategories(String deviceCategoryId, CallBack<List<DeviceSubcategory>> callBack) {
        apiClient.getDeviceSubcategories(deviceCategoryId,callBack);
    }

    @Override
    public void getDeviceSubSecondCategory(String deviceSubCategoryId, CallBack<List<DeviceSubSecondModel>> callBack) {
        apiClient.getDeviceSubSecondcategories(deviceSubCategoryId, callBack);
    }

    @Override
    public String getWholeImagePath(String imagePath) {
        return apiClient.getBASE_URL() + imagePath;
    }

}
