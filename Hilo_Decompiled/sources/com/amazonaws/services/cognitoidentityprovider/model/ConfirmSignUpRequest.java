package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ConfirmSignUpRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsMetadataType analyticsMetadata;
    private String clientId;
    private Map<String, String> clientMetadata;
    private String confirmationCode;
    private Boolean forceAliasCreation;
    private String secretHash;
    private UserContextDataType userContextData;
    private String username;

    public ConfirmSignUpRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public ConfirmSignUpRequest clearClientMetadataEntries() {
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
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConfirmSignUpRequest)) {
            return false;
        }
        ConfirmSignUpRequest confirmSignUpRequest = (ConfirmSignUpRequest) obj;
        if (confirmSignUpRequest.getClientId() == null) {
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
        if (confirmSignUpRequest.getClientId() != null && !confirmSignUpRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if (confirmSignUpRequest.getSecretHash() == null) {
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
        if (confirmSignUpRequest.getSecretHash() != null && !confirmSignUpRequest.getSecretHash().equals(getSecretHash())) {
            return false;
        }
        if (confirmSignUpRequest.getUsername() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getUsername() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (confirmSignUpRequest.getUsername() != null && !confirmSignUpRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if (confirmSignUpRequest.getConfirmationCode() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getConfirmationCode() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (confirmSignUpRequest.getConfirmationCode() != null && !confirmSignUpRequest.getConfirmationCode().equals(getConfirmationCode())) {
            return false;
        }
        if (confirmSignUpRequest.getForceAliasCreation() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getForceAliasCreation() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (confirmSignUpRequest.getForceAliasCreation() != null && !confirmSignUpRequest.getForceAliasCreation().equals(getForceAliasCreation())) {
            return false;
        }
        if (confirmSignUpRequest.getAnalyticsMetadata() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getAnalyticsMetadata() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (confirmSignUpRequest.getAnalyticsMetadata() != null && !confirmSignUpRequest.getAnalyticsMetadata().equals(getAnalyticsMetadata())) {
            return false;
        }
        if (confirmSignUpRequest.getUserContextData() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getUserContextData() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (confirmSignUpRequest.getUserContextData() != null && !confirmSignUpRequest.getUserContextData().equals(getUserContextData())) {
            return false;
        }
        if (confirmSignUpRequest.getClientMetadata() == null) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (getClientMetadata() == null) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z24 ^ z25) {
            return false;
        }
        if (confirmSignUpRequest.getClientMetadata() == null || confirmSignUpRequest.getClientMetadata().equals(getClientMetadata())) {
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

    public String getConfirmationCode() {
        return this.confirmationCode;
    }

    public Boolean getForceAliasCreation() {
        return this.forceAliasCreation;
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
        int hashCode6;
        int hashCode7;
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
        if (getUsername() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getUsername().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getConfirmationCode() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getConfirmationCode().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getForceAliasCreation() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getForceAliasCreation().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getAnalyticsMetadata() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getAnalyticsMetadata().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getUserContextData() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getUserContextData().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getClientMetadata() != null) {
            i10 = getClientMetadata().hashCode();
        }
        return i17 + i10;
    }

    public Boolean isForceAliasCreation() {
        return this.forceAliasCreation;
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

    public void setConfirmationCode(String str) {
        this.confirmationCode = str;
    }

    public void setForceAliasCreation(Boolean bool) {
        this.forceAliasCreation = bool;
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
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getConfirmationCode() != null) {
            sb.append("ConfirmationCode: " + getConfirmationCode() + ",");
        }
        if (getForceAliasCreation() != null) {
            sb.append("ForceAliasCreation: " + getForceAliasCreation() + ",");
        }
        if (getAnalyticsMetadata() != null) {
            sb.append("AnalyticsMetadata: " + getAnalyticsMetadata() + ",");
        }
        if (getUserContextData() != null) {
            sb.append("UserContextData: " + getUserContextData() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public ConfirmSignUpRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
        return this;
    }

    public ConfirmSignUpRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public ConfirmSignUpRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public ConfirmSignUpRequest withConfirmationCode(String str) {
        this.confirmationCode = str;
        return this;
    }

    public ConfirmSignUpRequest withForceAliasCreation(Boolean bool) {
        this.forceAliasCreation = bool;
        return this;
    }

    public ConfirmSignUpRequest withSecretHash(String str) {
        this.secretHash = str;
        return this;
    }

    public ConfirmSignUpRequest withUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
        return this;
    }

    public ConfirmSignUpRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
