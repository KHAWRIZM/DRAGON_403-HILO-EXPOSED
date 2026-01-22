package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetDeviceRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String deviceKey;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetDeviceRequest)) {
            return false;
        }
        GetDeviceRequest getDeviceRequest = (GetDeviceRequest) obj;
        if (getDeviceRequest.getDeviceKey() == null) {
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
        if (getDeviceRequest.getDeviceKey() != null && !getDeviceRequest.getDeviceKey().equals(getDeviceKey())) {
            return false;
        }
        if (getDeviceRequest.getAccessToken() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getAccessToken() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (getDeviceRequest.getAccessToken() == null || getDeviceRequest.getAccessToken().equals(getAccessToken())) {
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

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getDeviceKey() == null) {
            hashCode = 0;
        } else {
            hashCode = getDeviceKey().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getAccessToken() != null) {
            i10 = getAccessToken().hashCode();
        }
        return i11 + i10;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
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
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetDeviceRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public GetDeviceRequest withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }
}
