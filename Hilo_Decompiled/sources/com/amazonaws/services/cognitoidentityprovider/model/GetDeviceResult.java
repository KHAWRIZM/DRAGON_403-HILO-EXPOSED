package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetDeviceResult implements Serializable {
    private DeviceType device;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetDeviceResult)) {
            return false;
        }
        GetDeviceResult getDeviceResult = (GetDeviceResult) obj;
        if (getDeviceResult.getDevice() == null) {
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
        if (getDeviceResult.getDevice() == null || getDeviceResult.getDevice().equals(getDevice())) {
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

    public GetDeviceResult withDevice(DeviceType deviceType) {
        this.device = deviceType;
        return this;
    }
}
