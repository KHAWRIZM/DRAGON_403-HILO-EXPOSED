package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class VerifyUserAttributeRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String attributeName;
    private String code;

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
        if (obj == null || !(obj instanceof VerifyUserAttributeRequest)) {
            return false;
        }
        VerifyUserAttributeRequest verifyUserAttributeRequest = (VerifyUserAttributeRequest) obj;
        if (verifyUserAttributeRequest.getAccessToken() == null) {
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
        if (verifyUserAttributeRequest.getAccessToken() != null && !verifyUserAttributeRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if (verifyUserAttributeRequest.getAttributeName() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getAttributeName() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (verifyUserAttributeRequest.getAttributeName() != null && !verifyUserAttributeRequest.getAttributeName().equals(getAttributeName())) {
            return false;
        }
        if (verifyUserAttributeRequest.getCode() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getCode() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (verifyUserAttributeRequest.getCode() == null || verifyUserAttributeRequest.getCode().equals(getCode())) {
            return true;
        }
        return false;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public String getCode() {
        return this.code;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getAccessToken() == null) {
            hashCode = 0;
        } else {
            hashCode = getAccessToken().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getAttributeName() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAttributeName().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getCode() != null) {
            i10 = getCode().hashCode();
        }
        return i12 + i10;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getAttributeName() != null) {
            sb.append("AttributeName: " + getAttributeName() + ",");
        }
        if (getCode() != null) {
            sb.append("Code: " + getCode());
        }
        sb.append("}");
        return sb.toString();
    }

    public VerifyUserAttributeRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public VerifyUserAttributeRequest withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public VerifyUserAttributeRequest withCode(String str) {
        this.code = str;
        return this;
    }
}
