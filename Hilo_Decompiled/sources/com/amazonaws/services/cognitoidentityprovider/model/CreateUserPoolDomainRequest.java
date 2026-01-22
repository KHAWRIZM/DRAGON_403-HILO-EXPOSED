package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CreateUserPoolDomainRequest extends AmazonWebServiceRequest implements Serializable {
    private CustomDomainConfigType customDomainConfig;
    private String domain;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateUserPoolDomainRequest)) {
            return false;
        }
        CreateUserPoolDomainRequest createUserPoolDomainRequest = (CreateUserPoolDomainRequest) obj;
        if (createUserPoolDomainRequest.getDomain() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getDomain() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (createUserPoolDomainRequest.getDomain() != null && !createUserPoolDomainRequest.getDomain().equals(getDomain())) {
            return false;
        }
        if (createUserPoolDomainRequest.getUserPoolId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getUserPoolId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (createUserPoolDomainRequest.getUserPoolId() != null && !createUserPoolDomainRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (createUserPoolDomainRequest.getCustomDomainConfig() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getCustomDomainConfig() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (createUserPoolDomainRequest.getCustomDomainConfig() == null || createUserPoolDomainRequest.getCustomDomainConfig().equals(getCustomDomainConfig())) {
            return true;
        }
        return false;
    }

    public CustomDomainConfigType getCustomDomainConfig() {
        return this.customDomainConfig;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getDomain() == null) {
            hashCode = 0;
        } else {
            hashCode = getDomain().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUserPoolId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getUserPoolId().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getCustomDomainConfig() != null) {
            i10 = getCustomDomainConfig().hashCode();
        }
        return i12 + i10;
    }

    public void setCustomDomainConfig(CustomDomainConfigType customDomainConfigType) {
        this.customDomainConfig = customDomainConfigType;
    }

    public void setDomain(String str) {
        this.domain = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getDomain() != null) {
            sb.append("Domain: " + getDomain() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getCustomDomainConfig() != null) {
            sb.append("CustomDomainConfig: " + getCustomDomainConfig());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateUserPoolDomainRequest withCustomDomainConfig(CustomDomainConfigType customDomainConfigType) {
        this.customDomainConfig = customDomainConfigType;
        return this;
    }

    public CreateUserPoolDomainRequest withDomain(String str) {
        this.domain = str;
        return this;
    }

    public CreateUserPoolDomainRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
