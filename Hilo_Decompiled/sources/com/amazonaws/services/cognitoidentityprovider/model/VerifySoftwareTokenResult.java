package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class VerifySoftwareTokenResult implements Serializable {
    private String session;
    private String status;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof VerifySoftwareTokenResult)) {
            return false;
        }
        VerifySoftwareTokenResult verifySoftwareTokenResult = (VerifySoftwareTokenResult) obj;
        if (verifySoftwareTokenResult.getStatus() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getStatus() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (verifySoftwareTokenResult.getStatus() != null && !verifySoftwareTokenResult.getStatus().equals(getStatus())) {
            return false;
        }
        if (verifySoftwareTokenResult.getSession() == null) {
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
        if (verifySoftwareTokenResult.getSession() == null || verifySoftwareTokenResult.getSession().equals(getSession())) {
            return true;
        }
        return false;
    }

    public String getSession() {
        return this.session;
    }

    public String getStatus() {
        return this.status;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getStatus() == null) {
            hashCode = 0;
        } else {
            hashCode = getStatus().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getSession() != null) {
            i10 = getSession().hashCode();
        }
        return i11 + i10;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getStatus() != null) {
            sb.append("Status: " + getStatus() + ",");
        }
        if (getSession() != null) {
            sb.append("Session: " + getSession());
        }
        sb.append("}");
        return sb.toString();
    }

    public VerifySoftwareTokenResult withSession(String str) {
        this.session = str;
        return this;
    }

    public VerifySoftwareTokenResult withStatus(String str) {
        this.status = str;
        return this;
    }

    public void setStatus(VerifySoftwareTokenResponseType verifySoftwareTokenResponseType) {
        this.status = verifySoftwareTokenResponseType.toString();
    }

    public VerifySoftwareTokenResult withStatus(VerifySoftwareTokenResponseType verifySoftwareTokenResponseType) {
        this.status = verifySoftwareTokenResponseType.toString();
        return this;
    }
}
