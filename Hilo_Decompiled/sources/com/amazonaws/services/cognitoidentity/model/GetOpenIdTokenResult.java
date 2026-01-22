package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetOpenIdTokenResult implements Serializable {
    private String identityId;
    private String token;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetOpenIdTokenResult)) {
            return false;
        }
        GetOpenIdTokenResult getOpenIdTokenResult = (GetOpenIdTokenResult) obj;
        if (getOpenIdTokenResult.getIdentityId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getIdentityId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (getOpenIdTokenResult.getIdentityId() != null && !getOpenIdTokenResult.getIdentityId().equals(getIdentityId())) {
            return false;
        }
        if (getOpenIdTokenResult.getToken() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getToken() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (getOpenIdTokenResult.getToken() == null || getOpenIdTokenResult.getToken().equals(getToken())) {
            return true;
        }
        return false;
    }

    public String getIdentityId() {
        return this.identityId;
    }

    public String getToken() {
        return this.token;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getIdentityId() == null) {
            hashCode = 0;
        } else {
            hashCode = getIdentityId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getToken() != null) {
            i10 = getToken().hashCode();
        }
        return i11 + i10;
    }

    public void setIdentityId(String str) {
        this.identityId = str;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIdentityId() != null) {
            sb.append("IdentityId: " + getIdentityId() + ",");
        }
        if (getToken() != null) {
            sb.append("Token: " + getToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetOpenIdTokenResult withIdentityId(String str) {
        this.identityId = str;
        return this;
    }

    public GetOpenIdTokenResult withToken(String str) {
        this.token = str;
        return this;
    }
}
