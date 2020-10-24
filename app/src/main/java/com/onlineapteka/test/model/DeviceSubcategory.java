package com.onlineapteka.test.model;

import com.google.gson.annotations.SerializedName;

public class DeviceSubcategory {
    @SerializedName("category")
    private String deviceSubCategory;

    @SerializedName("title")
    private String deviceSubCategoryTitle;

    @SerializedName("id")
    private String deviceSubCategoryId;


    public DeviceSubcategory() {

    }

    public String getDeviceSubCategory() {
        return deviceSubCategory;
    }

    public void setDeviceSubCategory(String deviceSubCategory) {
        this.deviceSubCategory = deviceSubCategory;
    }

    public String getDeviceSubCategoryTitle() {
        return deviceSubCategoryTitle;
    }

    public void setDeviceSubCategoryTitle(String deviceSubCategoryTitle) {
        this.deviceSubCategoryTitle = deviceSubCategoryTitle;
    }

    public String getDeviceSubCategoryId() {
        return deviceSubCategoryId;
    }

    public void setDeviceSubCategoryId(String deviceSubCategoryId) {
        this.deviceSubCategoryId = deviceSubCategoryId;
    }

    public DeviceSubcategory(String deviceSubCategory, String deviceSubCategoryTitle, String deviceSubCategoryId) {
        this.deviceSubCategory = deviceSubCategory;
        this.deviceSubCategoryTitle = deviceSubCategoryTitle;
        this.deviceSubCategoryId = deviceSubCategoryId;
    }
}
