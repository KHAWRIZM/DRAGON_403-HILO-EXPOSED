package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminRespondToAuthChallengeRequest extends AmazonWebServiceRequest implements Serializable {
    private AnalyticsMetadataType analyticsMetadata;
    private String challengeName;
    private Map<String, String> challengeResponses;
    private String clientId;
    private Map<String, String> clientMetadata;
    private ContextDataType contextData;
    private String session;
    private String userPoolId;

    public AdminRespondToAuthChallengeRequest addChallengeResponsesEntry(String str, String str2) {
        if (this.challengeResponses == null) {
            this.challengeResponses = new HashMap();
        }
        if (!this.challengeResponses.containsKey(str)) {
            this.challengeResponses.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public AdminRespondToAuthChallengeRequest addClientMetadataEntry(String str, String str2) {
        if (this.clientMetadata == null) {
            this.clientMetadata = new HashMap();
        }
        if (!this.clientMetadata.containsKey(str)) {
            this.clientMetadata.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public AdminRespondToAuthChallengeRequest clearChallengeResponsesEntries() {
        this.challengeResponses = null;
        return this;
    }

    public AdminRespondToAuthChallengeRequest clearClientMetadataEntries() {
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
        if (obj == null || !(obj instanceof AdminRespondToAuthChallengeRequest)) {
            return false;
        }
        AdminRespondToAuthChallengeRequest adminRespondToAuthChallengeRequest = (AdminRespondToAuthChallengeRequest) obj;
        if (adminRespondToAuthChallengeRequest.getUserPoolId() == null) {
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
        if (adminRespondToAuthChallengeRequest.getUserPoolId() != null && !adminRespondToAuthChallengeRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getClientId() == null) {
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
        if (adminRespondToAuthChallengeRequest.getClientId() != null && !adminRespondToAuthChallengeRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getChallengeName() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getChallengeName() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getChallengeName() != null && !adminRespondToAuthChallengeRequest.getChallengeName().equals(getChallengeName())) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getChallengeResponses() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getChallengeResponses() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getChallengeResponses() != null && !adminRespondToAuthChallengeRequest.getChallengeResponses().equals(getChallengeResponses())) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getSession() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getSession() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getSession() != null && !adminRespondToAuthChallengeRequest.getSession().equals(getSession())) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getAnalyticsMetadata() == null) {
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
        if (adminRespondToAuthChallengeRequest.getAnalyticsMetadata() != null && !adminRespondToAuthChallengeRequest.getAnalyticsMetadata().equals(getAnalyticsMetadata())) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getContextData() == null) {
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
        if (adminRespondToAuthChallengeRequest.getContextData() != null && !adminRespondToAuthChallengeRequest.getContextData().equals(getContextData())) {
            return false;
        }
        if (adminRespondToAuthChallengeRequest.getClientMetadata() == null) {
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
        if (adminRespondToAuthChallengeRequest.getClientMetadata() == null || adminRespondToAuthChallengeRequest.getClientMetadata().equals(getClientMetadata())) {
            return true;
        }
        return false;
    }

    public AnalyticsMetadataType getAnalyticsMetadata() {
        return this.analyticsMetadata;
    }

    public String getChallengeName() {
        return this.challengeName;
    }

    public Map<String, String> getChallengeResponses() {
        return this.challengeResponses;
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

    public String getSession() {
        return this.session;
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
        int hashCode7;
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
        if (getChallengeName() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getChallengeName().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getChallengeResponses() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getChallengeResponses().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getSession() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getSession().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getAnalyticsMetadata() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getAnalyticsMetadata().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getContextData() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getContextData().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getClientMetadata() != null) {
            i10 = getClientMetadata().hashCode();
        }
        return i17 + i10;
    }

    public void setAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
    }

    public void setChallengeName(String str) {
        this.challengeName = str;
    }

    public void setChallengeResponses(Map<String, String> map) {
        this.challengeResponses = map;
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

    public void setSession(String str) {
        this.session = str;
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
        if (getChallengeName() != null) {
            sb.append("ChallengeName: " + getChallengeName() + ",");
        }
        if (getChallengeResponses() != null) {
            sb.append("ChallengeResponses: " + getChallengeResponses() + ",");
        }
        if (getSession() != null) {
            sb.append("Session: " + getSession() + ",");
        }
        if (getAnalyticsMetadata() != null) {
            sb.append("AnalyticsMetadata: " + getAnalyticsMetadata() + ",");
        }
        if (getContextData() != null) {
            sb.append("ContextData: " + getContextData() + ",");
        }
        if (getClientMetadata() != null) {
            sb.append("ClientMetadata: " + getClientMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminRespondToAuthChallengeRequest withAnalyticsMetadata(AnalyticsMetadataType analyticsMetadataType) {
        this.analyticsMetadata = analyticsMetadataType;
        return this;
    }

    public AdminRespondToAuthChallengeRequest withChallengeName(String str) {
        this.challengeName = str;
        return this;
    }

    public AdminRespondToAuthChallengeRequest withChallengeResponses(Map<String, String> map) {
        this.challengeResponses = map;
        return this;
    }

    public AdminRespondToAuthChallengeRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public AdminRespondToAuthChallengeRequest withClientMetadata(Map<String, String> map) {
        this.clientMetadata = map;
        return this;
    }

    public AdminRespondToAuthChallengeRequest withContextData(ContextDataType contextDataType) {
        this.contextData = contextDataType;
        return this;
    }

    public AdminRespondToAuthChallengeRequest withSession(String str) {
        this.session = str;
        return this;
    }

    public AdminRespondToAuthChallengeRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public void setChallengeName(ChallengeNameType challengeNameType) {
        this.challengeName = challengeNameType.toString();
    }

    public AdminRespondToAuthChallengeRequest withChallengeName(ChallengeNameType challengeNameType) {
        this.challengeName = challengeNameType.toString();
        return this;
    }
}
