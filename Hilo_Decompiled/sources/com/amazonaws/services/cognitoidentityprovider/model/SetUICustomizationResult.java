package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SetUICustomizationResult implements Serializable {
    private UICustomizationType uICustomization;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetUICustomizationResult)) {
            return false;
        }
        SetUICustomizationResult setUICustomizationResult = (SetUICustomizationResult) obj;
        if (setUICustomizationResult.getUICustomization() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUICustomization() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (setUICustomizationResult.getUICustomization() == null || setUICustomizationResult.getUICustomization().equals(getUICustomization())) {
            return true;
        }
        return false;
    }

    public UICustomizationType getUICustomization() {
        return this.uICustomization;
    }

    public int hashCode() {
        int hashCode;
        if (getUICustomization() == null) {
            hashCode = 0;
        } else {
            hashCode = getUICustomization().hashCode();
        }
        return 31 + hashCode;
    }

    public void setUICustomization(UICustomizationType uICustomizationType) {
        this.uICustomization = uICustomizationType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUICustomization() != null) {
            sb.append("UICustomization: " + getUICustomization());
        }
        sb.append("}");
        return sb.toString();
    }

    public SetUICustomizationResult withUICustomization(UICustomizationType uICustomizationType) {
        this.uICustomization = uICustomizationType;
        return this;
    }
}
