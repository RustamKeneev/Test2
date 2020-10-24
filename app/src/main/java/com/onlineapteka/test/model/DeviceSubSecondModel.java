package com.onlineapteka.test.model;

import com.google.gson.annotations.SerializedName;

public class DeviceSubSecondModel {
    @SerializedName("id")
    private String deviceSubSecondCategoryId;

    @SerializedName("title")
    private String deviceSubSecondCategoryTitle;

    @SerializedName("sub_title")
    private String deviceSubSecondCategorySubTitle;

    @SerializedName("image")
    private String deviceSubSecondCategoryImage;

    @SerializedName("description")
    private String deviceSubSecondCategoryDescription;

    public DeviceSubSecondModel() {

    }

    public DeviceSubSecondModel(String deviceSubSecondCategoryId, String deviceSubSecondCategoryTitle,
                                String deviceSubSecondCategorySubTitle, String deviceSubSecondCategoryImage,
                                String deviceSubSecondCategoryDescription) {
        this.deviceSubSecondCategoryId = deviceSubSecondCategoryId;
        this.deviceSubSecondCategoryTitle = deviceSubSecondCategoryTitle;
        this.deviceSubSecondCategorySubTitle = deviceSubSecondCategorySubTitle;
        this.deviceSubSecondCategoryImage = deviceSubSecondCategoryImage;
        this.deviceSubSecondCategoryDescription = deviceSubSecondCategoryDescription;
    }

    public String getDeviceSubSecondCategoryId() {
        return deviceSubSecondCategoryId;
    }

    public void setDeviceSubSecondCategoryId(String deviceSubSecondCategoryId) {
        this.deviceSubSecondCategoryId = deviceSubSecondCategoryId;
    }

    public String getDeviceSubSecondCategoryTitle() {
        return deviceSubSecondCategoryTitle;
    }

    public void setDeviceSubSecondCategoryTitle(String deviceSubSecondCategoryTitle) {
        this.deviceSubSecondCategoryTitle = deviceSubSecondCategoryTitle;
    }

    public String getDeviceSubSecondCategorySubTitle() {
        return deviceSubSecondCategorySubTitle;
    }

    public void setDeviceSubSecondCategorySubTitle(String deviceSubSecondCategorySubTitle) {
        this.deviceSubSecondCategorySubTitle = deviceSubSecondCategorySubTitle;
    }

    public String getDeviceSubSecondCategoryImage() {
        return deviceSubSecondCategoryImage;
    }

    public void setDeviceSubSecondCategoryImage(String deviceSubSecondCategoryImage) {
        this.deviceSubSecondCategoryImage = deviceSubSecondCategoryImage;
    }

    public String getDeviceSubSecondCategoryDescription() {
        return deviceSubSecondCategoryDescription;
    }

    public void setDeviceSubSecondCategoryDescription(String deviceSubSecondCategoryDescription) {
        this.deviceSubSecondCategoryDescription = deviceSubSecondCategoryDescription;
    }
}
