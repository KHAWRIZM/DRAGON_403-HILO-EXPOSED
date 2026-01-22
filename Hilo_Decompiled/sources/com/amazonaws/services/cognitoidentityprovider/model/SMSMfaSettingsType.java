package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SMSMfaSettingsType implements Serializable {
    private Boolean enabled;
    private Boolean preferredMfa;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SMSMfaSettingsType)) {
            return false;
        }
        SMSMfaSettingsType sMSMfaSettingsType = (SMSMfaSettingsType) obj;
        if (sMSMfaSettingsType.getEnabled() == null) {
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
        if (sMSMfaSettingsType.getEnabled() != null && !sMSMfaSettingsType.getEnabled().equals(getEnabled())) {
            return false;
        }
        if (sMSMfaSettingsType.getPreferredMfa() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getPreferredMfa() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (sMSMfaSettingsType.getPreferredMfa() == null || sMSMfaSettingsType.getPreferredMfa().equals(getPreferredMfa())) {
            return true;
        }
        return false;
    }

    public Boolean getEnabled() {
        return this.enabled;
    }

    public Boolean getPreferredMfa() {
        return this.preferredMfa;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getEnabled() == null) {
            hashCode = 0;
        } else {
            hashCode = getEnabled().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getPreferredMfa() != null) {
            i10 = getPreferredMfa().hashCode();
        }
        return i11 + i10;
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public Boolean isPreferredMfa() {
        return this.preferredMfa;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public void setPreferredMfa(Boolean bool) {
        this.preferredMfa = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEnabled() != null) {
            sb.append("Enabled: " + getEnabled() + ",");
        }
        if (getPreferredMfa() != null) {
            sb.append("PreferredMfa: " + getPreferredMfa());
        }
        sb.append("}");
        return sb.toString();
    }

    public SMSMfaSettingsType withEnabled(Boolean bool) {
        this.enabled = bool;
        return this;
    }

    public SMSMfaSettingsType withPreferredMfa(Boolean bool) {
        this.preferredMfa = bool;
        return this;
    }
}
