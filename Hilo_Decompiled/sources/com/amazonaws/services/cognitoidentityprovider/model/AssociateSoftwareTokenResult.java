package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AssociateSoftwareTokenResult implements Serializable {
    private String secretCode;
    private String session;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssociateSoftwareTokenResult)) {
            return false;
        }
        AssociateSoftwareTokenResult associateSoftwareTokenResult = (AssociateSoftwareTokenResult) obj;
        if (associateSoftwareTokenResult.getSecretCode() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getSecretCode() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (associateSoftwareTokenResult.getSecretCode() != null && !associateSoftwareTokenResult.getSecretCode().equals(getSecretCode())) {
            return false;
        }
        if (associateSoftwareTokenResult.getSession() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getSession() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (associateSoftwareTokenResult.getSession() == null || associateSoftwareTokenResult.getSession().equals(getSession())) {
            return true;
        }
        return false;
    }

    public String getSecretCode() {
        return this.secretCode;
    }

    public String getSession() {
        return this.session;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getSecretCode() == null) {
            hashCode = 0;
        } else {
            hashCode = getSecretCode().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getSession() != null) {
            i10 = getSession().hashCode();
        }
        return i11 + i10;
    }

    public void setSecretCode(String str) {
        this.secretCode = str;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getSecretCode() != null) {
            sb.append("SecretCode: " + getSecretCode() + ",");
        }
        if (getSession() != null) {
            sb.append("Session: " + getSession());
        }
        sb.append("}");
        return sb.toString();
    }

    public AssociateSoftwareTokenResult withSecretCode(String str) {
        this.secretCode = str;
        return this;
    }

    public AssociateSoftwareTokenResult withSession(String str) {
        this.session = str;
        return this;
    }
}
