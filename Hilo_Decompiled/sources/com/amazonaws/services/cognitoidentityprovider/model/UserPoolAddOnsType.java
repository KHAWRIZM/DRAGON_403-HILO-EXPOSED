package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UserPoolAddOnsType implements Serializable {
    private String advancedSecurityMode;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserPoolAddOnsType)) {
            return false;
        }
        UserPoolAddOnsType userPoolAddOnsType = (UserPoolAddOnsType) obj;
        if (userPoolAddOnsType.getAdvancedSecurityMode() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getAdvancedSecurityMode() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (userPoolAddOnsType.getAdvancedSecurityMode() == null || userPoolAddOnsType.getAdvancedSecurityMode().equals(getAdvancedSecurityMode())) {
            return true;
        }
        return false;
    }

    public String getAdvancedSecurityMode() {
        return this.advancedSecurityMode;
    }

    public int hashCode() {
        int hashCode;
        if (getAdvancedSecurityMode() == null) {
            hashCode = 0;
        } else {
            hashCode = getAdvancedSecurityMode().hashCode();
        }
        return 31 + hashCode;
    }

    public void setAdvancedSecurityMode(String str) {
        this.advancedSecurityMode = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAdvancedSecurityMode() != null) {
            sb.append("AdvancedSecurityMode: " + getAdvancedSecurityMode());
        }
        sb.append("}");
        return sb.toString();
    }

    public UserPoolAddOnsType withAdvancedSecurityMode(String str) {
        this.advancedSecurityMode = str;
        return this;
    }

    public void setAdvancedSecurityMode(AdvancedSecurityModeType advancedSecurityModeType) {
        this.advancedSecurityMode = advancedSecurityModeType.toString();
    }

    public UserPoolAddOnsType withAdvancedSecurityMode(AdvancedSecurityModeType advancedSecurityModeType) {
        this.advancedSecurityMode = advancedSecurityModeType.toString();
        return this;
    }
}
