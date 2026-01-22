package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SmsMfaConfigType implements Serializable {
    private String smsAuthenticationMessage;
    private SmsConfigurationType smsConfiguration;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SmsMfaConfigType)) {
            return false;
        }
        SmsMfaConfigType smsMfaConfigType = (SmsMfaConfigType) obj;
        if (smsMfaConfigType.getSmsAuthenticationMessage() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getSmsAuthenticationMessage() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (smsMfaConfigType.getSmsAuthenticationMessage() != null && !smsMfaConfigType.getSmsAuthenticationMessage().equals(getSmsAuthenticationMessage())) {
            return false;
        }
        if (smsMfaConfigType.getSmsConfiguration() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getSmsConfiguration() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (smsMfaConfigType.getSmsConfiguration() == null || smsMfaConfigType.getSmsConfiguration().equals(getSmsConfiguration())) {
            return true;
        }
        return false;
    }

    public String getSmsAuthenticationMessage() {
        return this.smsAuthenticationMessage;
    }

    public SmsConfigurationType getSmsConfiguration() {
        return this.smsConfiguration;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getSmsAuthenticationMessage() == null) {
            hashCode = 0;
        } else {
            hashCode = getSmsAuthenticationMessage().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getSmsConfiguration() != null) {
            i10 = getSmsConfiguration().hashCode();
        }
        return i11 + i10;
    }

    public void setSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
    }

    public void setSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSmsAuthenticationMessage() != null) {
            sb.append("SmsAuthenticationMessage: " + getSmsAuthenticationMessage() + ",");
        }
        if (getSmsConfiguration() != null) {
            sb.append("SmsConfiguration: " + getSmsConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public SmsMfaConfigType withSmsAuthenticationMessage(String str) {
        this.smsAuthenticationMessage = str;
        return this;
    }

    public SmsMfaConfigType withSmsConfiguration(SmsConfigurationType smsConfigurationType) {
        this.smsConfiguration = smsConfigurationType;
        return this;
    }
}
