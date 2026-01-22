package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetSigningCertificateResult implements Serializable {
    private String certificate;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetSigningCertificateResult)) {
            return false;
        }
        GetSigningCertificateResult getSigningCertificateResult = (GetSigningCertificateResult) obj;
        if (getSigningCertificateResult.getCertificate() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getCertificate() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (getSigningCertificateResult.getCertificate() == null || getSigningCertificateResult.getCertificate().equals(getCertificate())) {
            return true;
        }
        return false;
    }

    public String getCertificate() {
        return this.certificate;
    }

    public int hashCode() {
        int hashCode;
        if (getCertificate() == null) {
            hashCode = 0;
        } else {
            hashCode = getCertificate().hashCode();
        }
        return 31 + hashCode;
    }

    public void setCertificate(String str) {
        this.certificate = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCertificate() != null) {
            sb.append("Certificate: " + getCertificate());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetSigningCertificateResult withCertificate(String str) {
        this.certificate = str;
        return this;
    }
}
