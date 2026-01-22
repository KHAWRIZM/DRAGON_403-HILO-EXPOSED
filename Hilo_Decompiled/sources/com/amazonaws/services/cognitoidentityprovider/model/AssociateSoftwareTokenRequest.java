package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AssociateSoftwareTokenRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String session;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AssociateSoftwareTokenRequest)) {
            return false;
        }
        AssociateSoftwareTokenRequest associateSoftwareTokenRequest = (AssociateSoftwareTokenRequest) obj;
        if (associateSoftwareTokenRequest.getAccessToken() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getAccessToken() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (associateSoftwareTokenRequest.getAccessToken() != null && !associateSoftwareTokenRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if (associateSoftwareTokenRequest.getSession() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getSession() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (associateSoftwareTokenRequest.getSession() == null || associateSoftwareTokenRequest.getSession().equals(getSession())) {
            return true;
        }
        return false;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getSession() {
        return this.session;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getAccessToken() == null) {
            hashCode = 0;
        } else {
            hashCode = getAccessToken().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getSession() != null) {
            i10 = getSession().hashCode();
        }
        return i11 + i10;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getSession() != null) {
            sb.append("Session: " + getSession());
        }
        sb.append("}");
        return sb.toString();
    }

    public AssociateSoftwareTokenRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public AssociateSoftwareTokenRequest withSession(String str) {
        this.session = str;
        return this;
    }
}
