package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminGetDeviceResult implements Serializable {
    private DeviceType device;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminGetDeviceResult)) {
            return false;
        }
        AdminGetDeviceResult adminGetDeviceResult = (AdminGetDeviceResult) obj;
        if (adminGetDeviceResult.getDevice() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getDevice() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (adminGetDeviceResult.getDevice() == null || adminGetDeviceResult.getDevice().equals(getDevice())) {
            return true;
        }
        return false;
    }

    public DeviceType getDevice() {
        return this.device;
    }

    public int hashCode() {
        int hashCode;
        if (getDevice() == null) {
            hashCode = 0;
        } else {
            hashCode = getDevice().hashCode();
        }
        return 31 + hashCode;
    }

    public void setDevice(DeviceType deviceType) {
        this.device = deviceType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDevice() != null) {
            sb.append("Device: " + getDevice());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminGetDeviceResult withDevice(DeviceType deviceType) {
        this.device = deviceType;
        return this;
    }
}
