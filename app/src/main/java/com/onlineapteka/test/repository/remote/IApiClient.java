package com.onlineapteka.test.repository.remote;

import com.onlineapteka.test.model.DeviceSubSecondModel;
import com.onlineapteka.test.model.DeviceSubcategory;
import com.onlineapteka.test.repository.IRepository;

import java.util.List;

public interface IApiClient {
    void getDeviceCategories(IRepository.DeviceCategoryCallback deviceCategoryCallback);
    void getDeviceSubcategories(String deviceCategoryId, IRepository.CallBack<List<DeviceSubcategory>> callBack);
    void getDeviceSubSecondcategories(String deviceCategoryId, IRepository.CallBack<List<DeviceSubSecondModel>> callBack);

    String getBASE_URL();
}
