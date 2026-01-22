package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminForgetDeviceRequest extends AmazonWebServiceRequest implements Serializable {
    private String deviceKey;
    private String userPoolId;
    private String username;

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
        if (obj == null || !(obj instanceof AdminForgetDeviceRequest)) {
            return false;
        }
        AdminForgetDeviceRequest adminForgetDeviceRequest = (AdminForgetDeviceRequest) obj;
        if (adminForgetDeviceRequest.getUserPoolId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserPoolId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (adminForgetDeviceRequest.getUserPoolId() != null && !adminForgetDeviceRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (adminForgetDeviceRequest.getUsername() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getUsername() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (adminForgetDeviceRequest.getUsername() != null && !adminForgetDeviceRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if (adminForgetDeviceRequest.getDeviceKey() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getDeviceKey() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (adminForgetDeviceRequest.getDeviceKey() == null || adminForgetDeviceRequest.getDeviceKey().equals(getDeviceKey())) {
            return true;
        }
        return false;
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUsername() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getUsername().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getDeviceKey() != null) {
            i10 = getDeviceKey().hashCode();
        }
        return i12 + i10;
    }

    public void setDeviceKey(String str) {
        this.deviceKey = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getDeviceKey() != null) {
            sb.append("DeviceKey: " + getDeviceKey());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminForgetDeviceRequest withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }

    public AdminForgetDeviceRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminForgetDeviceRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
