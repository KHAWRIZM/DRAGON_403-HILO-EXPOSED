package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SetUserPoolMfaConfigRequest extends AmazonWebServiceRequest implements Serializable {
    private String mfaConfiguration;
    private SmsMfaConfigType smsMfaConfiguration;
    private SoftwareTokenMfaConfigType softwareTokenMfaConfiguration;
    private String userPoolId;

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
        if (obj == null || !(obj instanceof SetUserPoolMfaConfigRequest)) {
            return false;
        }
        SetUserPoolMfaConfigRequest setUserPoolMfaConfigRequest = (SetUserPoolMfaConfigRequest) obj;
        if (setUserPoolMfaConfigRequest.getUserPoolId() == null) {
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
        if (setUserPoolMfaConfigRequest.getUserPoolId() != null && !setUserPoolMfaConfigRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (setUserPoolMfaConfigRequest.getSmsMfaConfiguration() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getSmsMfaConfiguration() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (setUserPoolMfaConfigRequest.getSmsMfaConfiguration() != null && !setUserPoolMfaConfigRequest.getSmsMfaConfiguration().equals(getSmsMfaConfiguration())) {
            return false;
        }
        if (setUserPoolMfaConfigRequest.getSoftwareTokenMfaConfiguration() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getSoftwareTokenMfaConfiguration() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (setUserPoolMfaConfigRequest.getSoftwareTokenMfaConfiguration() != null && !setUserPoolMfaConfigRequest.getSoftwareTokenMfaConfiguration().equals(getSoftwareTokenMfaConfiguration())) {
            return false;
        }
        if (setUserPoolMfaConfigRequest.getMfaConfiguration() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getMfaConfiguration() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (setUserPoolMfaConfigRequest.getMfaConfiguration() == null || setUserPoolMfaConfigRequest.getMfaConfiguration().equals(getMfaConfiguration())) {
            return true;
        }
        return false;
    }

    public String getMfaConfiguration() {
        return this.mfaConfiguration;
    }

    public SmsMfaConfigType getSmsMfaConfiguration() {
        return this.smsMfaConfiguration;
    }

    public SoftwareTokenMfaConfigType getSoftwareTokenMfaConfiguration() {
        return this.softwareTokenMfaConfiguration;
    }

    public String getUserPoolId() {
        return this.userPoolId;
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
        if (getSmsMfaConfiguration() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSmsMfaConfiguration().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getSoftwareTokenMfaConfiguration() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getSoftwareTokenMfaConfiguration().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getMfaConfiguration() != null) {
            i10 = getMfaConfiguration().hashCode();
        }
        return i13 + i10;
    }

    public void setMfaConfiguration(String str) {
        this.mfaConfiguration = str;
    }

    public void setSmsMfaConfiguration(SmsMfaConfigType smsMfaConfigType) {
        this.smsMfaConfiguration = smsMfaConfigType;
    }

    public void setSoftwareTokenMfaConfiguration(SoftwareTokenMfaConfigType softwareTokenMfaConfigType) {
        this.softwareTokenMfaConfiguration = softwareTokenMfaConfigType;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getSmsMfaConfiguration() != null) {
            sb.append("SmsMfaConfiguration: " + getSmsMfaConfiguration() + ",");
        }
        if (getSoftwareTokenMfaConfiguration() != null) {
            sb.append("SoftwareTokenMfaConfiguration: " + getSoftwareTokenMfaConfiguration() + ",");
        }
        if (getMfaConfiguration() != null) {
            sb.append("MfaConfiguration: " + getMfaConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public SetUserPoolMfaConfigRequest withMfaConfiguration(String str) {
        this.mfaConfiguration = str;
        return this;
    }

    public SetUserPoolMfaConfigRequest withSmsMfaConfiguration(SmsMfaConfigType smsMfaConfigType) {
        this.smsMfaConfiguration = smsMfaConfigType;
        return this;
    }

    public SetUserPoolMfaConfigRequest withSoftwareTokenMfaConfiguration(SoftwareTokenMfaConfigType softwareTokenMfaConfigType) {
        this.softwareTokenMfaConfiguration = softwareTokenMfaConfigType;
        return this;
    }

    public SetUserPoolMfaConfigRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public void setMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
    }

    public SetUserPoolMfaConfigRequest withMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
        return this;
    }
}
