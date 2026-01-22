package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetIdentityProviderByIdentifierRequest extends AmazonWebServiceRequest implements Serializable {
    private String idpIdentifier;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdentityProviderByIdentifierRequest)) {
            return false;
        }
        GetIdentityProviderByIdentifierRequest getIdentityProviderByIdentifierRequest = (GetIdentityProviderByIdentifierRequest) obj;
        if (getIdentityProviderByIdentifierRequest.getUserPoolId() == null) {
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
        if (getIdentityProviderByIdentifierRequest.getUserPoolId() != null && !getIdentityProviderByIdentifierRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (getIdentityProviderByIdentifierRequest.getIdpIdentifier() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getIdpIdentifier() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (getIdentityProviderByIdentifierRequest.getIdpIdentifier() == null || getIdentityProviderByIdentifierRequest.getIdpIdentifier().equals(getIdpIdentifier())) {
            return true;
        }
        return false;
    }

    public String getIdpIdentifier() {
        return this.idpIdentifier;
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
        if (getIdpIdentifier() != null) {
            i10 = getIdpIdentifier().hashCode();
        }
        return i11 + i10;
    }

    public void setIdpIdentifier(String str) {
        this.idpIdentifier = str;
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
        if (getIdpIdentifier() != null) {
            sb.append("IdpIdentifier: " + getIdpIdentifier());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetIdentityProviderByIdentifierRequest withIdpIdentifier(String str) {
        this.idpIdentifier = str;
        return this;
    }

    public GetIdentityProviderByIdentifierRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
