package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class NumberAttributeConstraintsType implements Serializable {
    private String maxValue;
    private String minValue;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NumberAttributeConstraintsType)) {
            return false;
        }
        NumberAttributeConstraintsType numberAttributeConstraintsType = (NumberAttributeConstraintsType) obj;
        if (numberAttributeConstraintsType.getMinValue() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getMinValue() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (numberAttributeConstraintsType.getMinValue() != null && !numberAttributeConstraintsType.getMinValue().equals(getMinValue())) {
            return false;
        }
        if (numberAttributeConstraintsType.getMaxValue() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getMaxValue() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (numberAttributeConstraintsType.getMaxValue() == null || numberAttributeConstraintsType.getMaxValue().equals(getMaxValue())) {
            return true;
        }
        return false;
    }

    public String getMaxValue() {
        return this.maxValue;
    }

    public String getMinValue() {
        return this.minValue;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getMinValue() == null) {
            hashCode = 0;
        } else {
            hashCode = getMinValue().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getMaxValue() != null) {
            i10 = getMaxValue().hashCode();
        }
        return i11 + i10;
    }

    public void setMaxValue(String str) {
        this.maxValue = str;
    }

    public void setMinValue(String str) {
        this.minValue = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getMinValue() != null) {
            sb.append("MinValue: " + getMinValue() + ",");
        }
        if (getMaxValue() != null) {
            sb.append("MaxValue: " + getMaxValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public NumberAttributeConstraintsType withMaxValue(String str) {
        this.maxValue = str;
        return this;
    }

    public NumberAttributeConstraintsType withMinValue(String str) {
        this.minValue = str;
        return this;
    }
}
