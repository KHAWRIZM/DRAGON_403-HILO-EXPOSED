package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UsernameConfigurationType implements Serializable {
    private Boolean caseSensitive;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UsernameConfigurationType)) {
            return false;
        }
        UsernameConfigurationType usernameConfigurationType = (UsernameConfigurationType) obj;
        if (usernameConfigurationType.getCaseSensitive() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getCaseSensitive() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (usernameConfigurationType.getCaseSensitive() == null || usernameConfigurationType.getCaseSensitive().equals(getCaseSensitive())) {
            return true;
        }
        return false;
    }

    public Boolean getCaseSensitive() {
        return this.caseSensitive;
    }

    public int hashCode() {
        int hashCode;
        if (getCaseSensitive() == null) {
            hashCode = 0;
        } else {
            hashCode = getCaseSensitive().hashCode();
        }
        return 31 + hashCode;
    }

    public Boolean isCaseSensitive() {
        return this.caseSensitive;
    }

    public void setCaseSensitive(Boolean bool) {
        this.caseSensitive = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCaseSensitive() != null) {
            sb.append("CaseSensitive: " + getCaseSensitive());
        }
        sb.append("}");
        return sb.toString();
    }

    public UsernameConfigurationType withCaseSensitive(Boolean bool) {
        this.caseSensitive = bool;
        return this;
    }
}
