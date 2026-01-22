package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetSigningCertificateRequest extends AmazonWebServiceRequest implements Serializable {
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetSigningCertificateRequest)) {
            return false;
        }
        GetSigningCertificateRequest getSigningCertificateRequest = (GetSigningCertificateRequest) obj;
        if (getSigningCertificateRequest.getUserPoolId() == null) {
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
        if (getSigningCertificateRequest.getUserPoolId() == null || getSigningCertificateRequest.getUserPoolId().equals(getUserPoolId())) {
            return true;
        }
        return false;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        return 31 + hashCode;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetSigningCertificateRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
