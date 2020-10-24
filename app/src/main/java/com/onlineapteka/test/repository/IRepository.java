package com.onlineapteka.test.repository;

import com.onlineapteka.test.model.DeviceCategory;
import com.onlineapteka.test.model.DeviceSubSecondModel;
import com.onlineapteka.test.model.DeviceSubcategory;

import java.util.List;

public interface IRepository {

    void getDeviceCategories(DeviceCategoryCallback deviceCategoryCallback);
    void getDeviceSubcategories(String deviceCategoryId, CallBack<List<DeviceSubcategory>> callBack);

    void getDeviceSubSecondCategory(String deviceSubCategoryId, CallBack<List<DeviceSubSecondModel>> callBack);

    String getWholeImagePath(String imagePath);


    interface CallBack<T>{
        void onSuccess(T t);
        void onFailure(Exception e);
    }

    interface  DeviceCategoryCallback{
        void onSuccess(List<DeviceCategory> deviceCategories);
        void onFailure(Exception e);
    }

}
