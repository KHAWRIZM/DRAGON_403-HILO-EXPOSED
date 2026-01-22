package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AttributeType implements Serializable {
    private String name;
    private String value;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AttributeType)) {
            return false;
        }
        AttributeType attributeType = (AttributeType) obj;
        if (attributeType.getName() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getName() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (attributeType.getName() != null && !attributeType.getName().equals(getName())) {
            return false;
        }
        if (attributeType.getValue() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getValue() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (attributeType.getValue() == null || attributeType.getValue().equals(getValue())) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getName() == null) {
            hashCode = 0;
        } else {
            hashCode = getName().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getValue() != null) {
            i10 = getValue().hashCode();
        }
        return i11 + i10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getName() != null) {
            sb.append("Name: " + getName() + ",");
        }
        if (getValue() != null) {
            sb.append("Value: " + getValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public AttributeType withName(String str) {
        this.name = str;
        return this;
    }

    public AttributeType withValue(String str) {
        this.value = str;
        return this;
    }
}
