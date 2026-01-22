package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ForgotPasswordRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsMetadataType analyticsMetadata;
    private String clientId;
    private Map<String, String> clientMetadata;
    private String secretHash;
    private UserContextDataType userContextData;
    private String username;

    public ForgotPasswordRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public ForgotPasswordRequest clearClientMetadataEntries() {
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
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ForgotPasswordRequest)) {
            return false;
        }
        ForgotPasswordRequest forgotPasswordRequest = (ForgotPasswordRequest) obj;
        if (forgotPasswordRequest.getClientId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getClientId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (forgotPasswordRequest.getClientId() != null && !forgotPasswordRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if (forgotPasswordRequest.getSecretHash() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getSecretHash() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (forgotPasswordRequest.getSecretHash() != null && !forgotPasswordRequest.getSecretHash().equals(getSecretHash())) {
            return false;
        }
        if (forgotPasswordRequest.getUserContextData() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getUserContextData() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (forgotPasswordRequest.getUserContextData() != null && !forgotPasswordRequest.getUserContextData().equals(getUserContextData())) {
            return false;
        }
        if (forgotPasswordRequest.getUsername() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getUsername() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (forgotPasswordRequest.getUsername() != null && !forgotPasswordRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if (forgotPasswordRequest.getAnalyticsMetadata() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getAnalyticsMetadata() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (forgotPasswordRequest.getAnalyticsMetadata() != null && !forgotPasswordRequest.getAnalyticsMetadata().equals(getAnalyticsMetadata())) {
            return false;
        }
        if (forgotPasswordRequest.getClientMetadata() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getClientMetadata() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (forgotPasswordRequest.getClientMetadata() == null || forgotPasswordRequest.getClientMetadata().equals(getClientMetadata())) {
            return true;
        }
        return false;
    }

    public AnalyticsMetadataType getAnalyticsMetadata() {
        return this.analyticsMetadata;
    }

    public String getClientId() {
        return this.clientId;
    }

    public Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public String getSecretHash() {
        return this.secretHash;
    }

    public UserContextDataType getUserContextData() {
        return this.userContextData;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int i10 = 0;
        if (getClientId() == null) {
            hashCode = 0;
        } else {
            hashCode = getClientId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getSecretHash() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSecretHash().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getUserContextData() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getUserContextData().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getUsername() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getUsername().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getAnalyticsMetadata() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getAnalyticsMetadata().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getClientMetadata() != null) {
            i10 = getClientMetadata().hashCode();
        }
        return i15 + i10;
    }

    public void setAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
    }

    public void setSecretHash(String str) {
        this.secretHash = str;
    }

    public void setUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getSecretHash() != null) {
            sb.append("SecretHash: " + getSecretHash() + ",");
        }
        if (getUserContextData() != null) {
            sb.append("UserContextData: " + getUserContextData() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getAnalyticsMetadata() != null) {
            sb.append("AnalyticsMetadata: " + getAnalyticsMetadata() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public ForgotPasswordRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
        return this;
    }

    public ForgotPasswordRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public ForgotPasswordRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public ForgotPasswordRequest withSecretHash(String str) {
        this.secretHash = str;
        return this;
    }

    public ForgotPasswordRequest withUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
        return this;
    }

    public ForgotPasswordRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
