package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetUserAttributeVerificationCodeResult implements Serializable {
    private CodeDeliveryDetailsType codeDeliveryDetails;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetUserAttributeVerificationCodeResult)) {
            return false;
        }
        GetUserAttributeVerificationCodeResult getUserAttributeVerificationCodeResult = (GetUserAttributeVerificationCodeResult) obj;
        if (getUserAttributeVerificationCodeResult.getCodeDeliveryDetails() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getCodeDeliveryDetails() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (getUserAttributeVerificationCodeResult.getCodeDeliveryDetails() == null || getUserAttributeVerificationCodeResult.getCodeDeliveryDetails().equals(getCodeDeliveryDetails())) {
            return true;
        }
        return false;
    }

    public CodeDeliveryDetailsType getCodeDeliveryDetails() {
        return this.codeDeliveryDetails;
    }

    public int hashCode() {
        int hashCode;
        if (getCodeDeliveryDetails() == null) {
            hashCode = 0;
        } else {
            hashCode = getCodeDeliveryDetails().hashCode();
        }
        return 31 + hashCode;
    }

    public void setCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        this.codeDeliveryDetails = codeDeliveryDetailsType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCodeDeliveryDetails() != null) {
            sb.append("CodeDeliveryDetails: " + getCodeDeliveryDetails());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetUserAttributeVerificationCodeResult withCodeDeliveryDetails(CodeDeliveryDetailsType codeDeliveryDetailsType) {
        this.codeDeliveryDetails = codeDeliveryDetailsType;
        return this;
    }
}
