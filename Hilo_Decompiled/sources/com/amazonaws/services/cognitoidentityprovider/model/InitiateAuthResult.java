package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class InitiateAuthResult implements Serializable {
    private AuthenticationResultType authenticationResult;
    private String challengeName;
    private Map<String, String> challengeParameters;
    private String session;

    public InitiateAuthResult addChallengeParametersEntry(String str, String str2) {
        if (this.challengeParameters == null) {
            this.challengeParameters = new HashMap();
        }
        if (!this.challengeParameters.containsKey(str)) {
            this.challengeParameters.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public InitiateAuthResult clearChallengeParametersEntries() {
        this.challengeParameters = null;
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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof InitiateAuthResult)) {
            return false;
        }
        InitiateAuthResult initiateAuthResult = (InitiateAuthResult) obj;
        if (initiateAuthResult.getChallengeName() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getChallengeName() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (initiateAuthResult.getChallengeName() != null && !initiateAuthResult.getChallengeName().equals(getChallengeName())) {
            return false;
        }
        if (initiateAuthResult.getSession() == null) {
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
        if (initiateAuthResult.getSession() != null && !initiateAuthResult.getSession().equals(getSession())) {
            return false;
        }
        if (initiateAuthResult.getChallengeParameters() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getChallengeParameters() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (initiateAuthResult.getChallengeParameters() != null && !initiateAuthResult.getChallengeParameters().equals(getChallengeParameters())) {
            return false;
        }
        if (initiateAuthResult.getAuthenticationResult() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getAuthenticationResult() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (initiateAuthResult.getAuthenticationResult() == null || initiateAuthResult.getAuthenticationResult().equals(getAuthenticationResult())) {
            return true;
        }
        return false;
    }

    public AuthenticationResultType getAuthenticationResult() {
        return this.authenticationResult;
    }

    public String getChallengeName() {
        return this.challengeName;
    }

    public Map<String, String> getChallengeParameters() {
        return this.challengeParameters;
    }

    public String getSession() {
        return this.session;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i10 = 0;
        if (getChallengeName() == null) {
            hashCode = 0;
        } else {
            hashCode = getChallengeName().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getSession() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSession().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getChallengeParameters() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getChallengeParameters().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getAuthenticationResult() != null) {
            i10 = getAuthenticationResult().hashCode();
        }
        return i13 + i10;
    }

    public void setAuthenticationResult(AuthenticationResultType authenticationResultType) {
        this.authenticationResult = authenticationResultType;
    }

    public void setChallengeName(String str) {
        this.challengeName = str;
    }

    public void setChallengeParameters(Map<String, String> map) {
        this.challengeParameters = map;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getChallengeName() != null) {
            sb.append("ChallengeName: " + getChallengeName() + ",");
        }
        if (getSession() != null) {
            sb.append("Session: " + getSession() + ",");
        }
        if (getChallengeParameters() != null) {
            sb.append("ChallengeParameters: " + getChallengeParameters() + ",");
        }
        if (getAuthenticationResult() != null) {
            sb.append("AuthenticationResult: " + getAuthenticationResult());
        }
        sb.append("}");
        return sb.toString();
    }

    public InitiateAuthResult withAuthenticationResult(AuthenticationResultType authenticationResultType) {
        this.authenticationResult = authenticationResultType;
        return this;
    }

    public InitiateAuthResult withChallengeName(String str) {
        this.challengeName = str;
        return this;
    }

    public InitiateAuthResult withChallengeParameters(Map<String, String> map) {
        this.challengeParameters = map;
        return this;
    }

    public InitiateAuthResult withSession(String str) {
        this.session = str;
        return this;
    }

    public void setChallengeName(ChallengeNameType challengeNameType) {
        this.challengeName = challengeNameType.toString();
    }

    public InitiateAuthResult withChallengeName(ChallengeNameType challengeNameType) {
        this.challengeName = challengeNameType.toString();
        return this;
    }
}
