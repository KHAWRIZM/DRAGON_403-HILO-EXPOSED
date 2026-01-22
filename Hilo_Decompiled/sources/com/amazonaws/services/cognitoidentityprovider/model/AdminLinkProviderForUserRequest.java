package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminLinkProviderForUserRequest extends AmazonWebServiceRequest implements Serializable {
    private ProviderUserIdentifierType destinationUser;
    private ProviderUserIdentifierType sourceUser;
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
        if (obj == null || !(obj instanceof AdminLinkProviderForUserRequest)) {
            return false;
        }
        AdminLinkProviderForUserRequest adminLinkProviderForUserRequest = (AdminLinkProviderForUserRequest) obj;
        if (adminLinkProviderForUserRequest.getUserPoolId() == null) {
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
        if (adminLinkProviderForUserRequest.getUserPoolId() != null && !adminLinkProviderForUserRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (adminLinkProviderForUserRequest.getDestinationUser() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getDestinationUser() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (adminLinkProviderForUserRequest.getDestinationUser() != null && !adminLinkProviderForUserRequest.getDestinationUser().equals(getDestinationUser())) {
            return false;
        }
        if (adminLinkProviderForUserRequest.getSourceUser() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getSourceUser() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (adminLinkProviderForUserRequest.getSourceUser() == null || adminLinkProviderForUserRequest.getSourceUser().equals(getSourceUser())) {
            return true;
        }
        return false;
    }

    public ProviderUserIdentifierType getDestinationUser() {
        return this.destinationUser;
    }

    public ProviderUserIdentifierType getSourceUser() {
        return this.sourceUser;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getDestinationUser() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getDestinationUser().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getSourceUser() != null) {
            i10 = getSourceUser().hashCode();
        }
        return i12 + i10;
    }

    public void setDestinationUser(ProviderUserIdentifierType providerUserIdentifierType) {
        this.destinationUser = providerUserIdentifierType;
    }

    public void setSourceUser(ProviderUserIdentifierType providerUserIdentifierType) {
        this.sourceUser = providerUserIdentifierType;
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
        if (getDestinationUser() != null) {
            sb.append("DestinationUser: " + getDestinationUser() + ",");
        }
        if (getSourceUser() != null) {
            sb.append("SourceUser: " + getSourceUser());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminLinkProviderForUserRequest withDestinationUser(ProviderUserIdentifierType providerUserIdentifierType) {
        this.destinationUser = providerUserIdentifierType;
        return this;
    }

    public AdminLinkProviderForUserRequest withSourceUser(ProviderUserIdentifierType providerUserIdentifierType) {
        this.sourceUser = providerUserIdentifierType;
        return this;
    }

    public AdminLinkProviderForUserRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
