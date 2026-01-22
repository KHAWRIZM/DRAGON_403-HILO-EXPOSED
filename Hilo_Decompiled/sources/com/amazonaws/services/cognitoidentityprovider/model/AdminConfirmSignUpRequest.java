package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminConfirmSignUpRequest extends AmazonWebServiceRequest implements Serializable {
    private Map<String, String> clientMetadata;
    private String userPoolId;
    private String username;

    public AdminConfirmSignUpRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public AdminConfirmSignUpRequest clearClientMetadataEntries() {
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
        if (obj == null || !(obj instanceof AdminConfirmSignUpRequest)) {
            return false;
        }
        AdminConfirmSignUpRequest adminConfirmSignUpRequest = (AdminConfirmSignUpRequest) obj;
        if (adminConfirmSignUpRequest.getUserPoolId() == null) {
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
        if (adminConfirmSignUpRequest.getUserPoolId() != null && !adminConfirmSignUpRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (adminConfirmSignUpRequest.getUsername() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getUsername() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (adminConfirmSignUpRequest.getUsername() != null && !adminConfirmSignUpRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if (adminConfirmSignUpRequest.getClientMetadata() == null) {
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
        if (adminConfirmSignUpRequest.getClientMetadata() == null || adminConfirmSignUpRequest.getClientMetadata().equals(getClientMetadata())) {
            return true;
        }
        return false;
    }

    public Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getUsername() {
        return this.username;
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
        if (getUsername() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getUsername().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getClientMetadata() != null) {
            i10 = getClientMetadata().hashCode();
        }
        return i12 + i10;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminConfirmSignUpRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public AdminConfirmSignUpRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminConfirmSignUpRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
