package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class StringAttributeConstraintsType implements Serializable {
    private String maxLength;
    private String minLength;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof StringAttributeConstraintsType)) {
            return false;
        }
        StringAttributeConstraintsType stringAttributeConstraintsType = (StringAttributeConstraintsType) obj;
        if (stringAttributeConstraintsType.getMinLength() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getMinLength() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (stringAttributeConstraintsType.getMinLength() != null && !stringAttributeConstraintsType.getMinLength().equals(getMinLength())) {
            return false;
        }
        if (stringAttributeConstraintsType.getMaxLength() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getMaxLength() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (stringAttributeConstraintsType.getMaxLength() == null || stringAttributeConstraintsType.getMaxLength().equals(getMaxLength())) {
            return true;
        }
        return false;
    }

    public String getMaxLength() {
        return this.maxLength;
    }

    public String getMinLength() {
        return this.minLength;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getMinLength() == null) {
            hashCode = 0;
        } else {
            hashCode = getMinLength().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getMaxLength() != null) {
            i10 = getMaxLength().hashCode();
        }
        return i11 + i10;
    }

    public void setMaxLength(String str) {
        this.maxLength = str;
    }

    public void setMinLength(String str) {
        this.minLength = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getMinLength() != null) {
            sb.append("MinLength: " + getMinLength() + ",");
        }
        if (getMaxLength() != null) {
            sb.append("MaxLength: " + getMaxLength());
        }
        sb.append("}");
        return sb.toString();
    }

    public StringAttributeConstraintsType withMaxLength(String str) {
        this.maxLength = str;
        return this;
    }

    public StringAttributeConstraintsType withMinLength(String str) {
        this.minLength = str;
        return this;
    }
}
