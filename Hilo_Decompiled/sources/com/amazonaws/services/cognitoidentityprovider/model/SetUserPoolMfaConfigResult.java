package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SetUserPoolMfaConfigResult implements Serializable {
    private String mfaConfiguration;
    private SmsMfaConfigType smsMfaConfiguration;
    private SoftwareTokenMfaConfigType softwareTokenMfaConfiguration;

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
        if (obj == null || !(obj instanceof SetUserPoolMfaConfigResult)) {
            return false;
        }
        SetUserPoolMfaConfigResult setUserPoolMfaConfigResult = (SetUserPoolMfaConfigResult) obj;
        if (setUserPoolMfaConfigResult.getSmsMfaConfiguration() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getSmsMfaConfiguration() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (setUserPoolMfaConfigResult.getSmsMfaConfiguration() != null && !setUserPoolMfaConfigResult.getSmsMfaConfiguration().equals(getSmsMfaConfiguration())) {
            return false;
        }
        if (setUserPoolMfaConfigResult.getSoftwareTokenMfaConfiguration() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getSoftwareTokenMfaConfiguration() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (setUserPoolMfaConfigResult.getSoftwareTokenMfaConfiguration() != null && !setUserPoolMfaConfigResult.getSoftwareTokenMfaConfiguration().equals(getSoftwareTokenMfaConfiguration())) {
            return false;
        }
        if (setUserPoolMfaConfigResult.getMfaConfiguration() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getMfaConfiguration() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (setUserPoolMfaConfigResult.getMfaConfiguration() == null || setUserPoolMfaConfigResult.getMfaConfiguration().equals(getMfaConfiguration())) {
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

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getSmsMfaConfiguration() == null) {
            hashCode = 0;
        } else {
            hashCode = getSmsMfaConfiguration().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getSoftwareTokenMfaConfiguration() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSoftwareTokenMfaConfiguration().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getMfaConfiguration() != null) {
            i10 = getMfaConfiguration().hashCode();
        }
        return i12 + i10;
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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
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

    public SetUserPoolMfaConfigResult withMfaConfiguration(String str) {
        this.mfaConfiguration = str;
        return this;
    }

    public SetUserPoolMfaConfigResult withSmsMfaConfiguration(SmsMfaConfigType smsMfaConfigType) {
        this.smsMfaConfiguration = smsMfaConfigType;
        return this;
    }

    public SetUserPoolMfaConfigResult withSoftwareTokenMfaConfiguration(SoftwareTokenMfaConfigType softwareTokenMfaConfigType) {
        this.softwareTokenMfaConfiguration = softwareTokenMfaConfigType;
        return this;
    }

    public void setMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
    }

    public SetUserPoolMfaConfigResult withMfaConfiguration(UserPoolMfaType userPoolMfaType) {
        this.mfaConfiguration = userPoolMfaType.toString();
        return this;
    }
}
