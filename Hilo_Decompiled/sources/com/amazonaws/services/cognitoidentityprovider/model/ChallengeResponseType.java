package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ChallengeResponseType implements Serializable {
    private String challengeName;
    private String challengeResponse;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ChallengeResponseType)) {
            return false;
        }
        ChallengeResponseType challengeResponseType = (ChallengeResponseType) obj;
        if (challengeResponseType.getChallengeName() == null) {
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
        if (challengeResponseType.getChallengeName() != null && !challengeResponseType.getChallengeName().equals(getChallengeName())) {
            return false;
        }
        if (challengeResponseType.getChallengeResponse() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getChallengeResponse() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (challengeResponseType.getChallengeResponse() == null || challengeResponseType.getChallengeResponse().equals(getChallengeResponse())) {
            return true;
        }
        return false;
    }

    public String getChallengeName() {
        return this.challengeName;
    }

    public String getChallengeResponse() {
        return this.challengeResponse;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getChallengeName() == null) {
            hashCode = 0;
        } else {
            hashCode = getChallengeName().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getChallengeResponse() != null) {
            i10 = getChallengeResponse().hashCode();
        }
        return i11 + i10;
    }

    public void setChallengeName(String str) {
        this.challengeName = str;
    }

    public void setChallengeResponse(String str) {
        this.challengeResponse = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getChallengeName() != null) {
            sb.append("ChallengeName: " + getChallengeName() + ",");
        }
        if (getChallengeResponse() != null) {
            sb.append("ChallengeResponse: " + getChallengeResponse());
        }
        sb.append("}");
        return sb.toString();
    }

    public ChallengeResponseType withChallengeName(String str) {
        this.challengeName = str;
        return this;
    }

    public ChallengeResponseType withChallengeResponse(String str) {
        this.challengeResponse = str;
        return this;
    }

    public void setChallengeName(ChallengeName challengeName) {
        this.challengeName = challengeName.toString();
    }

    public void setChallengeResponse(ChallengeResponse challengeResponse) {
        this.challengeResponse = challengeResponse.toString();
    }

    public ChallengeResponseType withChallengeName(ChallengeName challengeName) {
        this.challengeName = challengeName.toString();
        return this;
    }

    public ChallengeResponseType withChallengeResponse(ChallengeResponse challengeResponse) {
        this.challengeResponse = challengeResponse.toString();
        return this;
    }
}
