package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SetUserMFAPreferenceRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private SMSMfaSettingsType sMSMfaSettings;
    private SoftwareTokenMfaSettingsType softwareTokenMfaSettings;

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
        if (obj == null || !(obj instanceof SetUserMFAPreferenceRequest)) {
            return false;
        }
        SetUserMFAPreferenceRequest setUserMFAPreferenceRequest = (SetUserMFAPreferenceRequest) obj;
        if (setUserMFAPreferenceRequest.getSMSMfaSettings() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getSMSMfaSettings() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (setUserMFAPreferenceRequest.getSMSMfaSettings() != null && !setUserMFAPreferenceRequest.getSMSMfaSettings().equals(getSMSMfaSettings())) {
            return false;
        }
        if (setUserMFAPreferenceRequest.getSoftwareTokenMfaSettings() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getSoftwareTokenMfaSettings() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (setUserMFAPreferenceRequest.getSoftwareTokenMfaSettings() != null && !setUserMFAPreferenceRequest.getSoftwareTokenMfaSettings().equals(getSoftwareTokenMfaSettings())) {
            return false;
        }
        if (setUserMFAPreferenceRequest.getAccessToken() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getAccessToken() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (setUserMFAPreferenceRequest.getAccessToken() == null || setUserMFAPreferenceRequest.getAccessToken().equals(getAccessToken())) {
            return true;
        }
        return false;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public SMSMfaSettingsType getSMSMfaSettings() {
        return this.sMSMfaSettings;
    }

    public SoftwareTokenMfaSettingsType getSoftwareTokenMfaSettings() {
        return this.softwareTokenMfaSettings;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getSMSMfaSettings() == null) {
            hashCode = 0;
        } else {
            hashCode = getSMSMfaSettings().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getSoftwareTokenMfaSettings() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSoftwareTokenMfaSettings().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getAccessToken() != null) {
            i10 = getAccessToken().hashCode();
        }
        return i12 + i10;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setSMSMfaSettings(SMSMfaSettingsType sMSMfaSettingsType) {
        this.sMSMfaSettings = sMSMfaSettingsType;
    }

    public void setSoftwareTokenMfaSettings(SoftwareTokenMfaSettingsType softwareTokenMfaSettingsType) {
        this.softwareTokenMfaSettings = softwareTokenMfaSettingsType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSMSMfaSettings() != null) {
            sb.append("SMSMfaSettings: " + getSMSMfaSettings() + ",");
        }
        if (getSoftwareTokenMfaSettings() != null) {
            sb.append("SoftwareTokenMfaSettings: " + getSoftwareTokenMfaSettings() + ",");
        }
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public SetUserMFAPreferenceRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public SetUserMFAPreferenceRequest withSMSMfaSettings(SMSMfaSettingsType sMSMfaSettingsType) {
        this.sMSMfaSettings = sMSMfaSettingsType;
        return this;
    }

    public SetUserMFAPreferenceRequest withSoftwareTokenMfaSettings(SoftwareTokenMfaSettingsType softwareTokenMfaSettingsType) {
        this.softwareTokenMfaSettings = softwareTokenMfaSettingsType;
        return this;
    }
}
