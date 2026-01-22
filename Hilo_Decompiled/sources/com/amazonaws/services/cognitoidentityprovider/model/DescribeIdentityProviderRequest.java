package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DescribeIdentityProviderRequest extends AmazonWebServiceRequest implements Serializable {
    private String providerName;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeIdentityProviderRequest)) {
            return false;
        }
        DescribeIdentityProviderRequest describeIdentityProviderRequest = (DescribeIdentityProviderRequest) obj;
        if (describeIdentityProviderRequest.getUserPoolId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserPoolId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (describeIdentityProviderRequest.getUserPoolId() != null && !describeIdentityProviderRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (describeIdentityProviderRequest.getProviderName() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getProviderName() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (describeIdentityProviderRequest.getProviderName() == null || describeIdentityProviderRequest.getProviderName().equals(getProviderName())) {
            return true;
        }
        return false;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getProviderName() != null) {
            i10 = getProviderName().hashCode();
        }
        return i11 + i10;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getProviderName() != null) {
            sb.append("ProviderName: " + getProviderName());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeIdentityProviderRequest withProviderName(String str) {
        this.providerName = str;
        return this;
    }

    public DescribeIdentityProviderRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
