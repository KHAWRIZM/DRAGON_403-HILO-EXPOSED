package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UpdateDeviceStatusRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String deviceKey;
    private String deviceRememberedStatus;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateDeviceStatusRequest)) {
            return false;
        }
        UpdateDeviceStatusRequest updateDeviceStatusRequest = (UpdateDeviceStatusRequest) obj;
        if (updateDeviceStatusRequest.getAccessToken() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getAccessToken() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (updateDeviceStatusRequest.getAccessToken() != null && !updateDeviceStatusRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if (updateDeviceStatusRequest.getDeviceKey() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getDeviceKey() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (updateDeviceStatusRequest.getDeviceKey() != null && !updateDeviceStatusRequest.getDeviceKey().equals(getDeviceKey())) {
            return false;
        }
        if (updateDeviceStatusRequest.getDeviceRememberedStatus() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getDeviceRememberedStatus() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (updateDeviceStatusRequest.getDeviceRememberedStatus() == null || updateDeviceStatusRequest.getDeviceRememberedStatus().equals(getDeviceRememberedStatus())) {
            return true;
        }
        return false;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public String getDeviceRememberedStatus() {
        return this.deviceRememberedStatus;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getAccessToken() == null) {
            hashCode = 0;
        } else {
            hashCode = getAccessToken().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getDeviceKey() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getDeviceKey().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getDeviceRememberedStatus() != null) {
            i10 = getDeviceRememberedStatus().hashCode();
        }
        return i12 + i10;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setDeviceKey(String str) {
        this.deviceKey = str;
    }

    public void setDeviceRememberedStatus(String str) {
        this.deviceRememberedStatus = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getDeviceKey() != null) {
            sb.append("DeviceKey: " + getDeviceKey() + ",");
        }
        if (getDeviceRememberedStatus() != null) {
            sb.append("DeviceRememberedStatus: " + getDeviceRememberedStatus());
        }
        sb.append("}");
        return sb.toString();
    }

    public UpdateDeviceStatusRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public UpdateDeviceStatusRequest withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }

    public UpdateDeviceStatusRequest withDeviceRememberedStatus(String str) {
        this.deviceRememberedStatus = str;
        return this;
    }

    public void setDeviceRememberedStatus(DeviceRememberedStatusType deviceRememberedStatusType) {
        this.deviceRememberedStatus = deviceRememberedStatusType.toString();
    }

    public UpdateDeviceStatusRequest withDeviceRememberedStatus(DeviceRememberedStatusType deviceRememberedStatusType) {
        this.deviceRememberedStatus = deviceRememberedStatusType.toString();
        return this;
    }
}
