package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetUserAttributeVerificationCodeRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String attributeName;
    private Map<String, String> clientMetadata;

    public GetUserAttributeVerificationCodeRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GetUserAttributeVerificationCodeRequest clearClientMetadataEntries() {
        this.clientMetadata = null;
        return this;
    }

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
        if (obj == null || !(obj instanceof GetUserAttributeVerificationCodeRequest)) {
            return false;
        }
        GetUserAttributeVerificationCodeRequest getUserAttributeVerificationCodeRequest = (GetUserAttributeVerificationCodeRequest) obj;
        if (getUserAttributeVerificationCodeRequest.getAccessToken() == null) {
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
        if (getUserAttributeVerificationCodeRequest.getAccessToken() != null && !getUserAttributeVerificationCodeRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if (getUserAttributeVerificationCodeRequest.getAttributeName() == null) {
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
        if (getUserAttributeVerificationCodeRequest.getAttributeName() != null && !getUserAttributeVerificationCodeRequest.getAttributeName().equals(getAttributeName())) {
            return false;
        }
        if (getUserAttributeVerificationCodeRequest.getClientMetadata() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getClientMetadata() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (getUserAttributeVerificationCodeRequest.getClientMetadata() == null || getUserAttributeVerificationCodeRequest.getClientMetadata().equals(getClientMetadata())) {
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

    public Map<String, String> getClientMetadata() {
        return this.clientMetadata;
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
        if (getClientMetadata() != null) {
            i10 = getClientMetadata().hashCode();
        }
        return i12 + i10;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setAttributeName(String str) {
        this.attributeName = str;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
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
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetUserAttributeVerificationCodeRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public GetUserAttributeVerificationCodeRequest withAttributeName(String str) {
        this.attributeName = str;
        return this;
    }

    public GetUserAttributeVerificationCodeRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }
}
