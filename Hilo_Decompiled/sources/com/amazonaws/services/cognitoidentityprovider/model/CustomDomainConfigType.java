package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CustomDomainConfigType implements Serializable {
    private String certificateArn;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CustomDomainConfigType)) {
            return false;
        }
        CustomDomainConfigType customDomainConfigType = (CustomDomainConfigType) obj;
        if (customDomainConfigType.getCertificateArn() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getCertificateArn() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (customDomainConfigType.getCertificateArn() == null || customDomainConfigType.getCertificateArn().equals(getCertificateArn())) {
            return true;
        }
        return false;
    }

    public String getCertificateArn() {
        return this.certificateArn;
    }

    public int hashCode() {
        int hashCode;
        if (getCertificateArn() == null) {
            hashCode = 0;
        } else {
            hashCode = getCertificateArn().hashCode();
        }
        return 31 + hashCode;
    }

    public void setCertificateArn(String str) {
        this.certificateArn = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCertificateArn() != null) {
            sb.append("CertificateArn: " + getCertificateArn());
        }
        sb.append("}");
        return sb.toString();
    }

    public CustomDomainConfigType withCertificateArn(String str) {
        this.certificateArn = str;
        return this;
    }
}
