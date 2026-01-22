package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminGetDeviceRequest extends AmazonWebServiceRequest implements Serializable {
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
        if (obj == null || !(obj instanceof AdminGetDeviceRequest)) {
            return false;
        }
        AdminGetDeviceRequest adminGetDeviceRequest = (AdminGetDeviceRequest) obj;
        if (adminGetDeviceRequest.getDeviceKey() == null) {
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
        if (adminGetDeviceRequest.getDeviceKey() != null && !adminGetDeviceRequest.getDeviceKey().equals(getDeviceKey())) {
            return false;
        }
        if (adminGetDeviceRequest.getUserPoolId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getUserPoolId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (adminGetDeviceRequest.getUserPoolId() != null && !adminGetDeviceRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (adminGetDeviceRequest.getUsername() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getUsername() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (adminGetDeviceRequest.getUsername() == null || adminGetDeviceRequest.getUsername().equals(getUsername())) {
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
        if (getDeviceKey() == null) {
            hashCode = 0;
        } else {
            hashCode = getDeviceKey().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUserPoolId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getUserPoolId().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getUsername() != null) {
            i10 = getUsername().hashCode();
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
        if (getDeviceKey() != null) {
            sb.append("DeviceKey: " + getDeviceKey() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminGetDeviceRequest withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }

    public AdminGetDeviceRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminGetDeviceRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
