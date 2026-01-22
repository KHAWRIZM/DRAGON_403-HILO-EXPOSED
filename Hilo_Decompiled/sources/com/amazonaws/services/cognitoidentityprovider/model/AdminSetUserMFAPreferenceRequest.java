package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminSetUserMFAPreferenceRequest extends AmazonWebServiceRequest implements Serializable {
    private SMSMfaSettingsType sMSMfaSettings;
    private SoftwareTokenMfaSettingsType softwareTokenMfaSettings;
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
        if (obj == null || !(obj instanceof AdminSetUserMFAPreferenceRequest)) {
            return false;
        }
        AdminSetUserMFAPreferenceRequest adminSetUserMFAPreferenceRequest = (AdminSetUserMFAPreferenceRequest) obj;
        if (adminSetUserMFAPreferenceRequest.getSMSMfaSettings() == null) {
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
        if (adminSetUserMFAPreferenceRequest.getSMSMfaSettings() != null && !adminSetUserMFAPreferenceRequest.getSMSMfaSettings().equals(getSMSMfaSettings())) {
            return false;
        }
        if (adminSetUserMFAPreferenceRequest.getSoftwareTokenMfaSettings() == null) {
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
        if (adminSetUserMFAPreferenceRequest.getSoftwareTokenMfaSettings() != null && !adminSetUserMFAPreferenceRequest.getSoftwareTokenMfaSettings().equals(getSoftwareTokenMfaSettings())) {
            return false;
        }
        if (adminSetUserMFAPreferenceRequest.getUsername() == null) {
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
        if (adminSetUserMFAPreferenceRequest.getUsername() != null && !adminSetUserMFAPreferenceRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if (adminSetUserMFAPreferenceRequest.getUserPoolId() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getUserPoolId() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (adminSetUserMFAPreferenceRequest.getUserPoolId() == null || adminSetUserMFAPreferenceRequest.getUserPoolId().equals(getUserPoolId())) {
            return true;
        }
        return false;
    }

    public SMSMfaSettingsType getSMSMfaSettings() {
        return this.sMSMfaSettings;
    }

    public SoftwareTokenMfaSettingsType getSoftwareTokenMfaSettings() {
        return this.softwareTokenMfaSettings;
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
        if (getUsername() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getUsername().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getUserPoolId() != null) {
            i10 = getUserPoolId().hashCode();
        }
        return i13 + i10;
    }

    public void setSMSMfaSettings(SMSMfaSettingsType sMSMfaSettingsType) {
        this.sMSMfaSettings = sMSMfaSettingsType;
    }

    public void setSoftwareTokenMfaSettings(SoftwareTokenMfaSettingsType softwareTokenMfaSettingsType) {
        this.softwareTokenMfaSettings = softwareTokenMfaSettingsType;
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
        if (getSMSMfaSettings() != null) {
            sb.append("SMSMfaSettings: " + getSMSMfaSettings() + ",");
        }
        if (getSoftwareTokenMfaSettings() != null) {
            sb.append("SoftwareTokenMfaSettings: " + getSoftwareTokenMfaSettings() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminSetUserMFAPreferenceRequest withSMSMfaSettings(SMSMfaSettingsType sMSMfaSettingsType) {
        this.sMSMfaSettings = sMSMfaSettingsType;
        return this;
    }

    public AdminSetUserMFAPreferenceRequest withSoftwareTokenMfaSettings(SoftwareTokenMfaSettingsType softwareTokenMfaSettingsType) {
        this.softwareTokenMfaSettings = softwareTokenMfaSettingsType;
        return this;
    }

    public AdminSetUserMFAPreferenceRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminSetUserMFAPreferenceRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
