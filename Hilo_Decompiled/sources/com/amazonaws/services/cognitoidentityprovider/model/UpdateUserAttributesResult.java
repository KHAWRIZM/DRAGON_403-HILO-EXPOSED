package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UpdateUserAttributesResult implements Serializable {
    private List<CodeDeliveryDetailsType> codeDeliveryDetailsList;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateUserAttributesResult)) {
            return false;
        }
        UpdateUserAttributesResult updateUserAttributesResult = (UpdateUserAttributesResult) obj;
        if (updateUserAttributesResult.getCodeDeliveryDetailsList() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getCodeDeliveryDetailsList() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (updateUserAttributesResult.getCodeDeliveryDetailsList() == null || updateUserAttributesResult.getCodeDeliveryDetailsList().equals(getCodeDeliveryDetailsList())) {
            return true;
        }
        return false;
    }

    public List<CodeDeliveryDetailsType> getCodeDeliveryDetailsList() {
        return this.codeDeliveryDetailsList;
    }

    public int hashCode() {
        int hashCode;
        if (getCodeDeliveryDetailsList() == null) {
            hashCode = 0;
        } else {
            hashCode = getCodeDeliveryDetailsList().hashCode();
        }
        return 31 + hashCode;
    }

    public void setCodeDeliveryDetailsList(Collection<CodeDeliveryDetailsType> collection) {
        if (collection == null) {
            this.codeDeliveryDetailsList = null;
        } else {
            this.codeDeliveryDetailsList = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCodeDeliveryDetailsList() != null) {
            sb.append("CodeDeliveryDetailsList: " + getCodeDeliveryDetailsList());
        }
        sb.append("}");
        return sb.toString();
    }

    public UpdateUserAttributesResult withCodeDeliveryDetailsList(CodeDeliveryDetailsType... codeDeliveryDetailsTypeArr) {
        if (getCodeDeliveryDetailsList() == null) {
            this.codeDeliveryDetailsList = new ArrayList(codeDeliveryDetailsTypeArr.length);
        }
        for (CodeDeliveryDetailsType codeDeliveryDetailsType : codeDeliveryDetailsTypeArr) {
            this.codeDeliveryDetailsList.add(codeDeliveryDetailsType);
        }
        return this;
    }

    public UpdateUserAttributesResult withCodeDeliveryDetailsList(Collection<CodeDeliveryDetailsType> collection) {
        setCodeDeliveryDetailsList(collection);
        return this;
    }
}
