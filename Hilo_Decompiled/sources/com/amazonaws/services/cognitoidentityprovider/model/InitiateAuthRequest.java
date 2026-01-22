package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class InitiateAuthRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsMetadataType analyticsMetadata;
    private String authFlow;
    private Map<String, String> authParameters;
    private String clientId;
    private Map<String, String> clientMetadata;
    private UserContextDataType userContextData;

    public InitiateAuthRequest addAuthParametersEntry(String str, String str2) {
        if (this.authParameters == null) {
            this.authParameters = new HashMap();
        }
        if (!this.authParameters.containsKey(str)) {
            this.authParameters.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public InitiateAuthRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public InitiateAuthRequest clearAuthParametersEntries() {
        this.authParameters = null;
        return this;
    }

    public InitiateAuthRequest clearClientMetadataEntries() {
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
        if (obj == null || !(obj instanceof InitiateAuthRequest)) {
            return false;
        }
        InitiateAuthRequest initiateAuthRequest = (InitiateAuthRequest) obj;
        if (initiateAuthRequest.getAuthFlow() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getAuthFlow() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (initiateAuthRequest.getAuthFlow() != null && !initiateAuthRequest.getAuthFlow().equals(getAuthFlow())) {
            return false;
        }
        if (initiateAuthRequest.getAuthParameters() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getAuthParameters() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (initiateAuthRequest.getAuthParameters() != null && !initiateAuthRequest.getAuthParameters().equals(getAuthParameters())) {
            return false;
        }
        if (initiateAuthRequest.getClientMetadata() == null) {
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
        if (initiateAuthRequest.getClientMetadata() != null && !initiateAuthRequest.getClientMetadata().equals(getClientMetadata())) {
            return false;
        }
        if (initiateAuthRequest.getClientId() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getClientId() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (initiateAuthRequest.getClientId() != null && !initiateAuthRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if (initiateAuthRequest.getAnalyticsMetadata() == null) {
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
        if (initiateAuthRequest.getAnalyticsMetadata() != null && !initiateAuthRequest.getAnalyticsMetadata().equals(getAnalyticsMetadata())) {
            return false;
        }
        if (initiateAuthRequest.getUserContextData() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getUserContextData() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (initiateAuthRequest.getUserContextData() == null || initiateAuthRequest.getUserContextData().equals(getUserContextData())) {
            return true;
        }
        return false;
    }

    public AnalyticsMetadataType getAnalyticsMetadata() {
        return this.analyticsMetadata;
    }

    public String getAuthFlow() {
        return this.authFlow;
    }

    public Map<String, String> getAuthParameters() {
        return this.authParameters;
    }

    public String getClientId() {
        return this.clientId;
    }

    public Map<String, String> getClientMetadata() {
        return this.clientMetadata;
    }

    public UserContextDataType getUserContextData() {
        return this.userContextData;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int i10 = 0;
        if (getAuthFlow() == null) {
            hashCode = 0;
        } else {
            hashCode = getAuthFlow().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getAuthParameters() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAuthParameters().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getClientMetadata() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getClientMetadata().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getClientId() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getClientId().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getAnalyticsMetadata() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getAnalyticsMetadata().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getUserContextData() != null) {
            i10 = getUserContextData().hashCode();
        }
        return i15 + i10;
    }

    public void setAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
    }

    public void setAuthFlow(String str) {
        this.authFlow = str;
    }

    public void setAuthParameters(Map<String, String> map) {
        this.authParameters = map;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
    }

    public void setUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAuthFlow() != null) {
            sb.append("AuthFlow: " + getAuthFlow() + ",");
        }
        if (getAuthParameters() != null) {
            sb.append("AuthParameters: " + getAuthParameters() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata() + ",");
        }
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getAnalyticsMetadata() != null) {
            sb.append("AnalyticsMetadata: " + getAnalyticsMetadata() + ",");
        }
        if (getUserContextData() != null) {
            sb.append("UserContextData: " + getUserContextData());
        }
        sb.append("}");
        return sb.toString();
    }

    public InitiateAuthRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
        return this;
    }

    public InitiateAuthRequest withAuthFlow(String str) {
        this.authFlow = str;
        return this;
    }

    public InitiateAuthRequest withAuthParameters(Map<String, String> map) {
        this.authParameters = map;
        return this;
    }

    public InitiateAuthRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public InitiateAuthRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public InitiateAuthRequest withUserContextData(UserContextDataType userContextDataType) {
        this.userContextData = userContextDataType;
        return this;
    }

    public void setAuthFlow(AuthFlowType authFlowType) {
        this.authFlow = authFlowType.toString();
    }

    public InitiateAuthRequest withAuthFlow(AuthFlowType authFlowType) {
        this.authFlow = authFlowType.toString();
        return this;
    }
}
