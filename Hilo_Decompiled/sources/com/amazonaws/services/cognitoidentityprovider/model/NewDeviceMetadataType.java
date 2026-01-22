package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class NewDeviceMetadataType implements Serializable {
    private String deviceGroupKey;
    private String deviceKey;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NewDeviceMetadataType)) {
            return false;
        }
        NewDeviceMetadataType newDeviceMetadataType = (NewDeviceMetadataType) obj;
        if (newDeviceMetadataType.getDeviceKey() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getDeviceKey() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (newDeviceMetadataType.getDeviceKey() != null && !newDeviceMetadataType.getDeviceKey().equals(getDeviceKey())) {
            return false;
        }
        if (newDeviceMetadataType.getDeviceGroupKey() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getDeviceGroupKey() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (newDeviceMetadataType.getDeviceGroupKey() == null || newDeviceMetadataType.getDeviceGroupKey().equals(getDeviceGroupKey())) {
            return true;
        }
        return false;
    }

    public String getDeviceGroupKey() {
        return this.deviceGroupKey;
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getDeviceKey() == null) {
            hashCode = 0;
        } else {
            hashCode = getDeviceKey().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getDeviceGroupKey() != null) {
            i10 = getDeviceGroupKey().hashCode();
        }
        return i11 + i10;
    }

    public void setDeviceGroupKey(String str) {
        this.deviceGroupKey = str;
    }

    public void setDeviceKey(String str) {
        this.deviceKey = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDeviceKey() != null) {
            sb.append("DeviceKey: " + getDeviceKey() + ",");
        }
        if (getDeviceGroupKey() != null) {
            sb.append("DeviceGroupKey: " + getDeviceGroupKey());
        }
        sb.append("}");
        return sb.toString();
    }

    public NewDeviceMetadataType withDeviceGroupKey(String str) {
        this.deviceGroupKey = str;
        return this;
    }

    public NewDeviceMetadataType withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }
}
