package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SignUpResult implements Serializable {
    private CodeDeliveryDetailsType codeDeliveryDetails;
    private Boolean userConfirmed;
    private String userSub;

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
        if (obj == null || !(obj instanceof SignUpResult)) {
            return false;
        }
        SignUpResult signUpResult = (SignUpResult) obj;
        if (signUpResult.getUserConfirmed() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserConfirmed() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (signUpResult.getUserConfirmed() != null && !signUpResult.getUserConfirmed().equals(getUserConfirmed())) {
            return false;
        }
        if (signUpResult.getCodeDeliveryDetails() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getCodeDeliveryDetails() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (signUpResult.getCodeDeliveryDetails() != null && !signUpResult.getCodeDeliveryDetails().equals(getCodeDeliveryDetails())) {
            return false;
        }
        if (signUpResult.getUserSub() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getUserSub() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (signUpResult.getUserSub() == null || signUpResult.getUserSub().equals(getUserSub())) {
            return true;
        }
        return false;
    }

    public CodeDeliveryDetailsType getCodeDeliveryDetails() {
        return this.codeDeliveryDetails;
    }

    public Boolean getUserConfirmed() {
        return this.userConfirmed;
    }

    public String getUserSub() {
        return this.userSub;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getUserConfirmed() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserConfirmed().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getCodeDeliveryDetails() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getCodeDeliveryDetails().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getUserSub() != null) {
            i10 = getUserSub().hashCode();
        }
        return i12 + i10;
    }

    public Boolean isUserConfirmed() {
        return this.userConfirmed;
    }

    public void setCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        this.codeDeliveryDetails = codeDeliveryDetailsType;
    }

    public void setUserConfirmed(Boolean bool) {
        this.userConfirmed = bool;
    }

    public void setUserSub(String str) {
        this.userSub = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserConfirmed() != null) {
            sb.append("UserConfirmed: " + getUserConfirmed() + ",");
        }
        if (getCodeDeliveryDetails() != null) {
            sb.append("CodeDeliveryDetails: " + getCodeDeliveryDetails() + ",");
        }
        if (getUserSub() != null) {
            sb.append("UserSub: " + getUserSub());
        }
        sb.append("}");
        return sb.toString();
    }

    public SignUpResult withCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        this.codeDeliveryDetails = codeDeliveryDetailsType;
        return this;
    }

    public SignUpResult withUserConfirmed(Boolean bool) {
        this.userConfirmed = bool;
        return this;
    }

    public SignUpResult withUserSub(String str) {
        this.userSub = str;
        return this;
    }
}
