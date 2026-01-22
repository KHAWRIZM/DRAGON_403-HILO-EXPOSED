package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DeleteUserPoolDomainRequest extends AmazonWebServiceRequest implements Serializable {
    private String domain;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteUserPoolDomainRequest)) {
            return false;
        }
        DeleteUserPoolDomainRequest deleteUserPoolDomainRequest = (DeleteUserPoolDomainRequest) obj;
        if (deleteUserPoolDomainRequest.getDomain() == null) {
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
        if (deleteUserPoolDomainRequest.getDomain() != null && !deleteUserPoolDomainRequest.getDomain().equals(getDomain())) {
            return false;
        }
        if (deleteUserPoolDomainRequest.getUserPoolId() == null) {
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
        if (deleteUserPoolDomainRequest.getUserPoolId() == null || deleteUserPoolDomainRequest.getUserPoolId().equals(getUserPoolId())) {
            return true;
        }
        return false;
    }

    public String getDomain() {
        return this.domain;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getDomain() == null) {
            hashCode = 0;
        } else {
            hashCode = getDomain().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUserPoolId() != null) {
            i10 = getUserPoolId().hashCode();
        }
        return i11 + i10;
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
            sb.append("UserPoolId: " + getUserPoolId());
        }
        sb.append("}");
        return sb.toString();
    }

    public DeleteUserPoolDomainRequest withDomain(String str) {
        this.domain = str;
        return this;
    }

    public DeleteUserPoolDomainRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
