package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetIdentityProviderByIdentifierResult implements Serializable {
    private IdentityProviderType identityProvider;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetIdentityProviderByIdentifierResult)) {
            return false;
        }
        GetIdentityProviderByIdentifierResult getIdentityProviderByIdentifierResult = (GetIdentityProviderByIdentifierResult) obj;
        if (getIdentityProviderByIdentifierResult.getIdentityProvider() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getIdentityProvider() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (getIdentityProviderByIdentifierResult.getIdentityProvider() == null || getIdentityProviderByIdentifierResult.getIdentityProvider().equals(getIdentityProvider())) {
            return true;
        }
        return false;
    }

    public IdentityProviderType getIdentityProvider() {
        return this.identityProvider;
    }

    public int hashCode() {
        int hashCode;
        if (getIdentityProvider() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityProvider().hashCode();
        }
        return 31 + hashCode;
    }

    public void setIdentityProvider(IdentityProviderType identityProviderType) {
        this.identityProvider = identityProviderType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIdentityProvider() != null) {
            sb.append("IdentityProvider: " + getIdentityProvider());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetIdentityProviderByIdentifierResult withIdentityProvider(IdentityProviderType identityProviderType) {
        this.identityProvider = identityProviderType;
        return this;
    }
}
