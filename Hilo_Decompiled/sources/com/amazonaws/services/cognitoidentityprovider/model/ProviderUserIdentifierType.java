package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ProviderUserIdentifierType implements Serializable {
    private String providerAttributeName;
    private String providerAttributeValue;
    private String providerName;

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
        if (obj == null || !(obj instanceof ProviderUserIdentifierType)) {
            return false;
        }
        ProviderUserIdentifierType providerUserIdentifierType = (ProviderUserIdentifierType) obj;
        if (providerUserIdentifierType.getProviderName() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getProviderName() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (providerUserIdentifierType.getProviderName() != null && !providerUserIdentifierType.getProviderName().equals(getProviderName())) {
            return false;
        }
        if (providerUserIdentifierType.getProviderAttributeName() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getProviderAttributeName() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (providerUserIdentifierType.getProviderAttributeName() != null && !providerUserIdentifierType.getProviderAttributeName().equals(getProviderAttributeName())) {
            return false;
        }
        if (providerUserIdentifierType.getProviderAttributeValue() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getProviderAttributeValue() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (providerUserIdentifierType.getProviderAttributeValue() == null || providerUserIdentifierType.getProviderAttributeValue().equals(getProviderAttributeValue())) {
            return true;
        }
        return false;
    }

    public String getProviderAttributeName() {
        return this.providerAttributeName;
    }

    public String getProviderAttributeValue() {
        return this.providerAttributeValue;
    }

    public String getProviderName() {
        return this.providerName;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getProviderName() == null) {
            hashCode = 0;
        } else {
            hashCode = getProviderName().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getProviderAttributeName() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getProviderAttributeName().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getProviderAttributeValue() != null) {
            i10 = getProviderAttributeValue().hashCode();
        }
        return i12 + i10;
    }

    public void setProviderAttributeName(String str) {
        this.providerAttributeName = str;
    }

    public void setProviderAttributeValue(String str) {
        this.providerAttributeValue = str;
    }

    public void setProviderName(String str) {
        this.providerName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getProviderName() != null) {
            sb.append("ProviderName: " + getProviderName() + ",");
        }
        if (getProviderAttributeName() != null) {
            sb.append("ProviderAttributeName: " + getProviderAttributeName() + ",");
        }
        if (getProviderAttributeValue() != null) {
            sb.append("ProviderAttributeValue: " + getProviderAttributeValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public ProviderUserIdentifierType withProviderAttributeName(String str) {
        this.providerAttributeName = str;
        return this;
    }

    public ProviderUserIdentifierType withProviderAttributeValue(String str) {
        this.providerAttributeValue = str;
        return this;
    }

    public ProviderUserIdentifierType withProviderName(String str) {
        this.providerName = str;
        return this;
    }
}
