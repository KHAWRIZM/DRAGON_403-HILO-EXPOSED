package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SmsConfigurationType implements Serializable {
    private String externalId;
    private String snsCallerArn;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SmsConfigurationType)) {
            return false;
        }
        SmsConfigurationType smsConfigurationType = (SmsConfigurationType) obj;
        if (smsConfigurationType.getSnsCallerArn() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getSnsCallerArn() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (smsConfigurationType.getSnsCallerArn() != null && !smsConfigurationType.getSnsCallerArn().equals(getSnsCallerArn())) {
            return false;
        }
        if (smsConfigurationType.getExternalId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getExternalId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (smsConfigurationType.getExternalId() == null || smsConfigurationType.getExternalId().equals(getExternalId())) {
            return true;
        }
        return false;
    }

    public String getExternalId() {
        return this.externalId;
    }

    public String getSnsCallerArn() {
        return this.snsCallerArn;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getSnsCallerArn() == null) {
            hashCode = 0;
        } else {
            hashCode = getSnsCallerArn().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getExternalId() != null) {
            i10 = getExternalId().hashCode();
        }
        return i11 + i10;
    }

    public void setExternalId(String str) {
        this.externalId = str;
    }

    public void setSnsCallerArn(String str) {
        this.snsCallerArn = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSnsCallerArn() != null) {
            sb.append("SnsCallerArn: " + getSnsCallerArn() + ",");
        }
        if (getExternalId() != null) {
            sb.append("ExternalId: " + getExternalId());
        }
        sb.append("}");
        return sb.toString();
    }

    public SmsConfigurationType withExternalId(String str) {
        this.externalId = str;
        return this;
    }

    public SmsConfigurationType withSnsCallerArn(String str) {
        this.snsCallerArn = str;
        return this;
    }
}
