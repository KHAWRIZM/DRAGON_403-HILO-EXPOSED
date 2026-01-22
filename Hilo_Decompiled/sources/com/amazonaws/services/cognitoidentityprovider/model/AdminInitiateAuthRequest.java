package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminInitiateAuthRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsMetadataType analyticsMetadata;
    private String authFlow;
    private Map<String, String> authParameters;
    private String clientId;
    private Map<String, String> clientMetadata;
    private ContextDataType contextData;
    private String userPoolId;

    public AdminInitiateAuthRequest addAuthParametersEntry(String str, String str2) {
        if (this.authParameters == null) {
            this.authParameters = new HashMap();
        }
        if (!this.authParameters.containsKey(str)) {
            this.authParameters.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public AdminInitiateAuthRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public AdminInitiateAuthRequest clearAuthParametersEntries() {
        this.authParameters = null;
        return this;
    }

    public AdminInitiateAuthRequest clearClientMetadataEntries() {
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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminInitiateAuthRequest)) {
            return false;
        }
        AdminInitiateAuthRequest adminInitiateAuthRequest = (AdminInitiateAuthRequest) obj;
        if (adminInitiateAuthRequest.getUserPoolId() == null) {
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
        if (adminInitiateAuthRequest.getUserPoolId() != null && !adminInitiateAuthRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (adminInitiateAuthRequest.getClientId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getClientId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (adminInitiateAuthRequest.getClientId() != null && !adminInitiateAuthRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if (adminInitiateAuthRequest.getAuthFlow() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getAuthFlow() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (adminInitiateAuthRequest.getAuthFlow() != null && !adminInitiateAuthRequest.getAuthFlow().equals(getAuthFlow())) {
            return false;
        }
        if (adminInitiateAuthRequest.getAuthParameters() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getAuthParameters() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (adminInitiateAuthRequest.getAuthParameters() != null && !adminInitiateAuthRequest.getAuthParameters().equals(getAuthParameters())) {
            return false;
        }
        if (adminInitiateAuthRequest.getClientMetadata() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getClientMetadata() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (adminInitiateAuthRequest.getClientMetadata() != null && !adminInitiateAuthRequest.getClientMetadata().equals(getClientMetadata())) {
            return false;
        }
        if (adminInitiateAuthRequest.getAnalyticsMetadata() == null) {
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
        if (adminInitiateAuthRequest.getAnalyticsMetadata() != null && !adminInitiateAuthRequest.getAnalyticsMetadata().equals(getAnalyticsMetadata())) {
            return false;
        }
        if (adminInitiateAuthRequest.getContextData() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getContextData() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (adminInitiateAuthRequest.getContextData() == null || adminInitiateAuthRequest.getContextData().equals(getContextData())) {
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

    public ContextDataType getContextData() {
        return this.contextData;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getClientId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getClientId().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getAuthFlow() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getAuthFlow().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getAuthParameters() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getAuthParameters().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getClientMetadata() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getClientMetadata().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getAnalyticsMetadata() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getAnalyticsMetadata().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getContextData() != null) {
            i10 = getContextData().hashCode();
        }
        return i16 + i10;
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

    public void setContextData(ContextDataType contextDataType) {
        this.contextData = contextDataType;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getAuthFlow() != null) {
            sb.append("AuthFlow: " + getAuthFlow() + ",");
        }
        if (getAuthParameters() != null) {
            sb.append("AuthParameters: " + getAuthParameters() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata() + ",");
        }
        if (getAnalyticsMetadata() != null) {
            sb.append("AnalyticsMetadata: " + getAnalyticsMetadata() + ",");
        }
        if (getContextData() != null) {
            sb.append("ContextData: " + getContextData());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminInitiateAuthRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
        return this;
    }

    public AdminInitiateAuthRequest withAuthFlow(String str) {
        this.authFlow = str;
        return this;
    }

    public AdminInitiateAuthRequest withAuthParameters(Map<String, String> map) {
        this.authParameters = map;
        return this;
    }

    public AdminInitiateAuthRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public AdminInitiateAuthRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public AdminInitiateAuthRequest withContextData(ContextDataType contextDataType) {
        this.contextData = contextDataType;
        return this;
    }

    public AdminInitiateAuthRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public void setAuthFlow(AuthFlowType authFlowType) {
        this.authFlow = authFlowType.toString();
    }

    public AdminInitiateAuthRequest withAuthFlow(AuthFlowType authFlowType) {
        this.authFlow = authFlowType.toString();
        return this;
    }
}
