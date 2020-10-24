package com.onlineapteka.test.model;

import com.google.gson.annotations.SerializedName;

public class DeviceCategory {
    @SerializedName("id")
    private String deviceId;
    @SerializedName("title")
    private String deviveTitle;
    @SerializedName("image")
    private int deviceImage;

    public DeviceCategory() {

    }

    public DeviceCategory(String deviveTitle, int deviceImage) {
        this.deviveTitle = deviveTitle;
        this.deviceImage = deviceImage;
    }

    public DeviceCategory(String deviceId, String deviveTitle, int deviceImage) {
        this.deviceId = deviceId;
        this.deviveTitle = deviveTitle;
        this.deviceImage = deviceImage;
    }

    public DeviceCategory(int ic_medical_device, String s) {
        this.deviceImage = ic_medical_device;
        this.deviveTitle = s;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviveTitle() {
        return deviveTitle;
    }

    public void setDeviveTitle(String deviveTitle) {
        this.deviveTitle = deviveTitle;
    }

    public int getDeviceImage() {
        return deviceImage;
    }

    public void setDeviceImage(int deviceImage) {
        this.deviceImage = deviceImage;
    }
}

