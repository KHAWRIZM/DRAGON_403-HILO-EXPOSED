package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class LambdaConfigType implements Serializable {
    private String createAuthChallenge;
    private String customMessage;
    private String defineAuthChallenge;
    private String postAuthentication;
    private String postConfirmation;
    private String preAuthentication;
    private String preSignUp;
    private String preTokenGeneration;
    private String userMigration;
    private String verifyAuthChallengeResponse;

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
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LambdaConfigType)) {
            return false;
        }
        LambdaConfigType lambdaConfigType = (LambdaConfigType) obj;
        if (lambdaConfigType.getPreSignUp() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getPreSignUp() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (lambdaConfigType.getPreSignUp() != null && !lambdaConfigType.getPreSignUp().equals(getPreSignUp())) {
            return false;
        }
        if (lambdaConfigType.getCustomMessage() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getCustomMessage() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (lambdaConfigType.getCustomMessage() != null && !lambdaConfigType.getCustomMessage().equals(getCustomMessage())) {
            return false;
        }
        if (lambdaConfigType.getPostConfirmation() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getPostConfirmation() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (lambdaConfigType.getPostConfirmation() != null && !lambdaConfigType.getPostConfirmation().equals(getPostConfirmation())) {
            return false;
        }
        if (lambdaConfigType.getPreAuthentication() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getPreAuthentication() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (lambdaConfigType.getPreAuthentication() != null && !lambdaConfigType.getPreAuthentication().equals(getPreAuthentication())) {
            return false;
        }
        if (lambdaConfigType.getPostAuthentication() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getPostAuthentication() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (lambdaConfigType.getPostAuthentication() != null && !lambdaConfigType.getPostAuthentication().equals(getPostAuthentication())) {
            return false;
        }
        if (lambdaConfigType.getDefineAuthChallenge() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getDefineAuthChallenge() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (lambdaConfigType.getDefineAuthChallenge() != null && !lambdaConfigType.getDefineAuthChallenge().equals(getDefineAuthChallenge())) {
            return false;
        }
        if (lambdaConfigType.getCreateAuthChallenge() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getCreateAuthChallenge() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (lambdaConfigType.getCreateAuthChallenge() != null && !lambdaConfigType.getCreateAuthChallenge().equals(getCreateAuthChallenge())) {
            return false;
        }
        if (lambdaConfigType.getVerifyAuthChallengeResponse() == null) {
            z24 = true;
        } else {
            z24 = false;
        }
        if (getVerifyAuthChallengeResponse() == null) {
            z25 = true;
        } else {
            z25 = false;
        }
        if (z24 ^ z25) {
            return false;
        }
        if (lambdaConfigType.getVerifyAuthChallengeResponse() != null && !lambdaConfigType.getVerifyAuthChallengeResponse().equals(getVerifyAuthChallengeResponse())) {
            return false;
        }
        if (lambdaConfigType.getPreTokenGeneration() == null) {
            z26 = true;
        } else {
            z26 = false;
        }
        if (getPreTokenGeneration() == null) {
            z27 = true;
        } else {
            z27 = false;
        }
        if (z26 ^ z27) {
            return false;
        }
        if (lambdaConfigType.getPreTokenGeneration() != null && !lambdaConfigType.getPreTokenGeneration().equals(getPreTokenGeneration())) {
            return false;
        }
        if (lambdaConfigType.getUserMigration() == null) {
            z28 = true;
        } else {
            z28 = false;
        }
        if (getUserMigration() == null) {
            z29 = true;
        } else {
            z29 = false;
        }
        if (z28 ^ z29) {
            return false;
        }
        if (lambdaConfigType.getUserMigration() == null || lambdaConfigType.getUserMigration().equals(getUserMigration())) {
            return true;
        }
        return false;
    }

    public String getCreateAuthChallenge() {
        return this.createAuthChallenge;
    }

    public String getCustomMessage() {
        return this.customMessage;
    }

    public String getDefineAuthChallenge() {
        return this.defineAuthChallenge;
    }

    public String getPostAuthentication() {
        return this.postAuthentication;
    }

    public String getPostConfirmation() {
        return this.postConfirmation;
    }

    public String getPreAuthentication() {
        return this.preAuthentication;
    }

    public String getPreSignUp() {
        return this.preSignUp;
    }

    public String getPreTokenGeneration() {
        return this.preTokenGeneration;
    }

    public String getUserMigration() {
        return this.userMigration;
    }

    public String getVerifyAuthChallengeResponse() {
        return this.verifyAuthChallengeResponse;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int hashCode7;
        int hashCode8;
        int hashCode9;
        int i10 = 0;
        if (getPreSignUp() == null) {
            hashCode = 0;
        } else {
            hashCode = getPreSignUp().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getCustomMessage() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getCustomMessage().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getPostConfirmation() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getPostConfirmation().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getPreAuthentication() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getPreAuthentication().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getPostAuthentication() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getPostAuthentication().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getDefineAuthChallenge() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getDefineAuthChallenge().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getCreateAuthChallenge() == null) {
            hashCode7 = 0;
        } else {
            hashCode7 = getCreateAuthChallenge().hashCode();
        }
        int i17 = (i16 + hashCode7) * 31;
        if (getVerifyAuthChallengeResponse() == null) {
            hashCode8 = 0;
        } else {
            hashCode8 = getVerifyAuthChallengeResponse().hashCode();
        }
        int i18 = (i17 + hashCode8) * 31;
        if (getPreTokenGeneration() == null) {
            hashCode9 = 0;
        } else {
            hashCode9 = getPreTokenGeneration().hashCode();
        }
        int i19 = (i18 + hashCode9) * 31;
        if (getUserMigration() != null) {
            i10 = getUserMigration().hashCode();
        }
        return i19 + i10;
    }

    public void setCreateAuthChallenge(String str) {
        this.createAuthChallenge = str;
    }

    public void setCustomMessage(String str) {
        this.customMessage = str;
    }

    public void setDefineAuthChallenge(String str) {
        this.defineAuthChallenge = str;
    }

    public void setPostAuthentication(String str) {
        this.postAuthentication = str;
    }

    public void setPostConfirmation(String str) {
        this.postConfirmation = str;
    }

    public void setPreAuthentication(String str) {
        this.preAuthentication = str;
    }

    public void setPreSignUp(String str) {
        this.preSignUp = str;
    }

    public void setPreTokenGeneration(String str) {
        this.preTokenGeneration = str;
    }

    public void setUserMigration(String str) {
        this.userMigration = str;
    }

    public void setVerifyAuthChallengeResponse(String str) {
        this.verifyAuthChallengeResponse = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPreSignUp() != null) {
            sb.append("PreSignUp: " + getPreSignUp() + ",");
        }
        if (getCustomMessage() != null) {
            sb.append("CustomMessage: " + getCustomMessage() + ",");
        }
        if (getPostConfirmation() != null) {
            sb.append("PostConfirmation: " + getPostConfirmation() + ",");
        }
        if (getPreAuthentication() != null) {
            sb.append("PreAuthentication: " + getPreAuthentication() + ",");
        }
        if (getPostAuthentication() != null) {
            sb.append("PostAuthentication: " + getPostAuthentication() + ",");
        }
        if (getDefineAuthChallenge() != null) {
            sb.append("DefineAuthChallenge: " + getDefineAuthChallenge() + ",");
        }
        if (getCreateAuthChallenge() != null) {
            sb.append("CreateAuthChallenge: " + getCreateAuthChallenge() + ",");
        }
        if (getVerifyAuthChallengeResponse() != null) {
            sb.append("VerifyAuthChallengeResponse: " + getVerifyAuthChallengeResponse() + ",");
        }
        if (getPreTokenGeneration() != null) {
            sb.append("PreTokenGeneration: " + getPreTokenGeneration() + ",");
        }
        if (getUserMigration() != null) {
            sb.append("UserMigration: " + getUserMigration());
        }
        sb.append("}");
        return sb.toString();
    }

    public LambdaConfigType withCreateAuthChallenge(String str) {
        this.createAuthChallenge = str;
        return this;
    }

    public LambdaConfigType withCustomMessage(String str) {
        this.customMessage = str;
        return this;
    }

    public LambdaConfigType withDefineAuthChallenge(String str) {
        this.defineAuthChallenge = str;
        return this;
    }

    public LambdaConfigType withPostAuthentication(String str) {
        this.postAuthentication = str;
        return this;
    }

    public LambdaConfigType withPostConfirmation(String str) {
        this.postConfirmation = str;
        return this;
    }

    public LambdaConfigType withPreAuthentication(String str) {
        this.preAuthentication = str;
        return this;
    }

    public LambdaConfigType withPreSignUp(String str) {
        this.preSignUp = str;
        return this;
    }

    public LambdaConfigType withPreTokenGeneration(String str) {
        this.preTokenGeneration = str;
        return this;
    }

    public LambdaConfigType withUserMigration(String str) {
        this.userMigration = str;
        return this;
    }

    public LambdaConfigType withVerifyAuthChallengeResponse(String str) {
        this.verifyAuthChallengeResponse = str;
        return this;
    }
}
