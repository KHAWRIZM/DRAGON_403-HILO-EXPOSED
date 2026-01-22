package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ConfirmDeviceRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String deviceKey;
    private String deviceName;
    private DeviceSecretVerifierConfigType deviceSecretVerifierConfig;

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
        if (obj == null || !(obj instanceof ConfirmDeviceRequest)) {
            return false;
        }
        ConfirmDeviceRequest confirmDeviceRequest = (ConfirmDeviceRequest) obj;
        if (confirmDeviceRequest.getAccessToken() == null) {
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
        if (confirmDeviceRequest.getAccessToken() != null && !confirmDeviceRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if (confirmDeviceRequest.getDeviceKey() == null) {
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
        if (confirmDeviceRequest.getDeviceKey() != null && !confirmDeviceRequest.getDeviceKey().equals(getDeviceKey())) {
            return false;
        }
        if (confirmDeviceRequest.getDeviceSecretVerifierConfig() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getDeviceSecretVerifierConfig() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (confirmDeviceRequest.getDeviceSecretVerifierConfig() != null && !confirmDeviceRequest.getDeviceSecretVerifierConfig().equals(getDeviceSecretVerifierConfig())) {
            return false;
        }
        if (confirmDeviceRequest.getDeviceName() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getDeviceName() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (confirmDeviceRequest.getDeviceName() == null || confirmDeviceRequest.getDeviceName().equals(getDeviceName())) {
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

    public String getDeviceName() {
        return this.deviceName;
    }

    public DeviceSecretVerifierConfigType getDeviceSecretVerifierConfig() {
        return this.deviceSecretVerifierConfig;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
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
        if (getDeviceSecretVerifierConfig() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getDeviceSecretVerifierConfig().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getDeviceName() != null) {
            i10 = getDeviceName().hashCode();
        }
        return i13 + i10;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setDeviceKey(String str) {
        this.deviceKey = str;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setDeviceSecretVerifierConfig(DeviceSecretVerifierConfigType deviceSecretVerifierConfigType) {
        this.deviceSecretVerifierConfig = deviceSecretVerifierConfigType;
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
        if (getDeviceSecretVerifierConfig() != null) {
            sb.append("DeviceSecretVerifierConfig: " + getDeviceSecretVerifierConfig() + ",");
        }
        if (getDeviceName() != null) {
            sb.append("DeviceName: " + getDeviceName());
        }
        sb.append("}");
        return sb.toString();
    }

    public ConfirmDeviceRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public ConfirmDeviceRequest withDeviceKey(String str) {
        this.deviceKey = str;
        return this;
    }

    public ConfirmDeviceRequest withDeviceName(String str) {
        this.deviceName = str;
        return this;
    }

    public ConfirmDeviceRequest withDeviceSecretVerifierConfig(DeviceSecretVerifierConfigType deviceSecretVerifierConfigType) {
        this.deviceSecretVerifierConfig = deviceSecretVerifierConfigType;
        return this;
    }
}
