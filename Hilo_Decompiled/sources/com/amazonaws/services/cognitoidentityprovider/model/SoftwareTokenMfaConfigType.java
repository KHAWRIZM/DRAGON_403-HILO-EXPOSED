package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SoftwareTokenMfaConfigType implements Serializable {
    private Boolean enabled;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SoftwareTokenMfaConfigType)) {
            return false;
        }
        SoftwareTokenMfaConfigType softwareTokenMfaConfigType = (SoftwareTokenMfaConfigType) obj;
        if (softwareTokenMfaConfigType.getEnabled() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getEnabled() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (softwareTokenMfaConfigType.getEnabled() == null || softwareTokenMfaConfigType.getEnabled().equals(getEnabled())) {
            return true;
        }
        return false;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public int hashCode() {
        int hashCode;
        if (getEnabled() == null) {
            hashCode = 0;
        } else {
            hashCode = getEnabled().hashCode();
        }
        return 31 + hashCode;
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEnabled() != null) {
            sb.append("Enabled: " + getEnabled());
        }
        sb.append("}");
        return sb.toString();
    }

    public SoftwareTokenMfaConfigType withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }
}
