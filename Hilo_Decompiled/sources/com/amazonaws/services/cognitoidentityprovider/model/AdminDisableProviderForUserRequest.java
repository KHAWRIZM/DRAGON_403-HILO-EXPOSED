package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminDisableProviderForUserRequest extends AmazonWebServiceRequest implements Serializable {
    private ProviderUserIdentifierType user;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminDisableProviderForUserRequest)) {
            return false;
        }
        AdminDisableProviderForUserRequest adminDisableProviderForUserRequest = (AdminDisableProviderForUserRequest) obj;
        if (adminDisableProviderForUserRequest.getUserPoolId() == null) {
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
        if (adminDisableProviderForUserRequest.getUserPoolId() != null && !adminDisableProviderForUserRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (adminDisableProviderForUserRequest.getUser() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getUser() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (adminDisableProviderForUserRequest.getUser() == null || adminDisableProviderForUserRequest.getUser().equals(getUser())) {
            return true;
        }
        return false;
    }

    public ProviderUserIdentifierType getUser() {
        return this.user;
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
        if (getUser() != null) {
            i10 = getUser().hashCode();
        }
        return i11 + i10;
    }

    public void setUser(ProviderUserIdentifierType providerUserIdentifierType) {
        this.user = providerUserIdentifierType;
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
        if (getUser() != null) {
            sb.append("User: " + getUser());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminDisableProviderForUserRequest withUser(ProviderUserIdentifierType providerUserIdentifierType) {
        this.user = providerUserIdentifierType;
        return this;
    }

    public AdminDisableProviderForUserRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
