package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DescribeResourceServerRequest extends AmazonWebServiceRequest implements Serializable {
    private String identifier;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeResourceServerRequest)) {
            return false;
        }
        DescribeResourceServerRequest describeResourceServerRequest = (DescribeResourceServerRequest) obj;
        if (describeResourceServerRequest.getUserPoolId() == null) {
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
        if (describeResourceServerRequest.getUserPoolId() != null && !describeResourceServerRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (describeResourceServerRequest.getIdentifier() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getIdentifier() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (describeResourceServerRequest.getIdentifier() == null || describeResourceServerRequest.getIdentifier().equals(getIdentifier())) {
            return true;
        }
        return false;
    }

    public String getIdentifier() {
        return this.identifier;
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
        if (getIdentifier() != null) {
            i10 = getIdentifier().hashCode();
        }
        return i11 + i10;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
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
        if (getIdentifier() != null) {
            sb.append("Identifier: " + getIdentifier());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeResourceServerRequest withIdentifier(String str) {
        this.identifier = str;
        return this;
    }

    public DescribeResourceServerRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
