package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CreateUserPoolDomainResult implements Serializable {
    private String cloudFrontDomain;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateUserPoolDomainResult)) {
            return false;
        }
        CreateUserPoolDomainResult createUserPoolDomainResult = (CreateUserPoolDomainResult) obj;
        if (createUserPoolDomainResult.getCloudFrontDomain() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getCloudFrontDomain() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (createUserPoolDomainResult.getCloudFrontDomain() == null || createUserPoolDomainResult.getCloudFrontDomain().equals(getCloudFrontDomain())) {
            return true;
        }
        return false;
    }

    public String getCloudFrontDomain() {
        return this.cloudFrontDomain;
    }

    public int hashCode() {
        int hashCode;
        if (getCloudFrontDomain() == null) {
            hashCode = 0;
        } else {
            hashCode = getCloudFrontDomain().hashCode();
        }
        return 31 + hashCode;
    }

    public void setCloudFrontDomain(String str) {
        this.cloudFrontDomain = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCloudFrontDomain() != null) {
            sb.append("CloudFrontDomain: " + getCloudFrontDomain());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateUserPoolDomainResult withCloudFrontDomain(String str) {
        this.cloudFrontDomain = str;
        return this;
    }
}
