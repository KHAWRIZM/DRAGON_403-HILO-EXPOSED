package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminUpdateDeviceStatusRequest extends AmazonWebServiceRequest implements Serializable {
    private String deviceKey;
    private String deviceRememberedStatus;
    private String userPoolId;
    private String username;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminUpdateDeviceStatusRequest)) {
            return false;
        }
        AdminUpdateDeviceStatusRequest adminUpdateDeviceStatusRequest = (AdminUpdateDeviceStatusRequest) obj;
        if (adminUpdateDeviceStatusRequest.getUserPoolId() == null) {
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
        if (adminUpdateDeviceStatusRequest.getUserPoolId() != null && !adminUpdateDeviceStatusRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (adminUpdateDeviceStatusRequest.getUsername() == null) {
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
        if (adminUpdateDeviceStatusRequest.getUsername() != null && !adminUpdateDeviceStatusRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if (adminUpdateDeviceStatusRequest.getDeviceKey() == null) {
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
        if (adminUpdateDeviceStatusRequest.getDeviceKey() != null && !adminUpdateDeviceStatusRequest.getDeviceKey().equals(getDeviceKey())) {
            return false;
        }
        if (adminUpdateDeviceStatusRequest.getDeviceRememberedStatus() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getDeviceRememberedStatus() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (adminUpdateDeviceStatusRequest.getDeviceRememberedStatus() == null || adminUpdateDeviceStatusRequest.getDeviceRememberedStatus().equals(getDeviceRememberedStatus())) {
            return true;
        }
        return false;
    }

    public String getDeviceKey() {
        return this.deviceKey;
    }

    public String getDeviceRememberedStatus() {
        return this.deviceRememberedStatus;
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
        int hashCode3;
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
        if (getDeviceKey() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getDeviceKey().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getDeviceRememberedStatus() != null) {
            i10 = getDeviceRememberedStatus().hashCode();
        }
        return i13 + i10;
    }

    public void setDeviceKey(String str) {
        this.deviceKey = str;
    }

    public void setDeviceRememberedStatus(String str) {
        this.deviceRememberedStatus = str;
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
            sb.append("DeviceKey: " + getDeviceKey() + ",");
        }
        if (getDeviceRememberedStatus() != null) {
            sb.append("DeviceRememberedStatus: " + getDeviceRememberedStatus());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminUpdateDeviceStatusRequest withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }

    public AdminUpdateDeviceStatusRequest withDeviceRememberedStatus(String str) {
        this.deviceRememberedStatus = str;
        return this;
    }

    public AdminUpdateDeviceStatusRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminUpdateDeviceStatusRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public void setDeviceRememberedStatus(DeviceRememberedStatusType deviceRememberedStatusType) {
        this.deviceRememberedStatus = deviceRememberedStatusType.toString();
    }

    public AdminUpdateDeviceStatusRequest withDeviceRememberedStatus(DeviceRememberedStatusType deviceRememberedStatusType) {
        this.deviceRememberedStatus = deviceRememberedStatusType.toString();
        return this;
    }
}
