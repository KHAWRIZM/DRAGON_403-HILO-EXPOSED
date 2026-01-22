package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SchemaAttributeType implements Serializable {
    private String attributeDataType;
    private Boolean developerOnlyAttribute;
    private Boolean mutable;
    private String name;
    private NumberAttributeConstraintsType numberAttributeConstraints;
    private Boolean required;
    private StringAttributeConstraintsType stringAttributeConstraints;

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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SchemaAttributeType)) {
            return false;
        }
        SchemaAttributeType schemaAttributeType = (SchemaAttributeType) obj;
        if (schemaAttributeType.getName() == null) {
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
        if (schemaAttributeType.getName() != null && !schemaAttributeType.getName().equals(getName())) {
            return false;
        }
        if (schemaAttributeType.getAttributeDataType() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getAttributeDataType() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (schemaAttributeType.getAttributeDataType() != null && !schemaAttributeType.getAttributeDataType().equals(getAttributeDataType())) {
            return false;
        }
        if (schemaAttributeType.getDeveloperOnlyAttribute() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getDeveloperOnlyAttribute() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (schemaAttributeType.getDeveloperOnlyAttribute() != null && !schemaAttributeType.getDeveloperOnlyAttribute().equals(getDeveloperOnlyAttribute())) {
            return false;
        }
        if (schemaAttributeType.getMutable() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getMutable() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (schemaAttributeType.getMutable() != null && !schemaAttributeType.getMutable().equals(getMutable())) {
            return false;
        }
        if (schemaAttributeType.getRequired() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getRequired() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (schemaAttributeType.getRequired() != null && !schemaAttributeType.getRequired().equals(getRequired())) {
            return false;
        }
        if (schemaAttributeType.getNumberAttributeConstraints() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getNumberAttributeConstraints() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (schemaAttributeType.getNumberAttributeConstraints() != null && !schemaAttributeType.getNumberAttributeConstraints().equals(getNumberAttributeConstraints())) {
            return false;
        }
        if (schemaAttributeType.getStringAttributeConstraints() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getStringAttributeConstraints() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (schemaAttributeType.getStringAttributeConstraints() == null || schemaAttributeType.getStringAttributeConstraints().equals(getStringAttributeConstraints())) {
            return true;
        }
        return false;
    }

    public String getAttributeDataType() {
        return this.attributeDataType;
    }

    public Boolean getDeveloperOnlyAttribute() {
        return this.developerOnlyAttribute;
    }

    public Boolean getMutable() {
        return this.mutable;
    }

    public String getName() {
        return this.name;
    }

    public NumberAttributeConstraintsType getNumberAttributeConstraints() {
        return this.numberAttributeConstraints;
    }

    public Boolean getRequired() {
        return this.required;
    }

    public StringAttributeConstraintsType getStringAttributeConstraints() {
        return this.stringAttributeConstraints;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int hashCode6;
        int i10 = 0;
        if (getName() == null) {
            hashCode = 0;
        } else {
            hashCode = getName().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getAttributeDataType() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getAttributeDataType().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getDeveloperOnlyAttribute() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getDeveloperOnlyAttribute().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getMutable() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getMutable().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getRequired() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getRequired().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getNumberAttributeConstraints() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getNumberAttributeConstraints().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getStringAttributeConstraints() != null) {
            i10 = getStringAttributeConstraints().hashCode();
        }
        return i16 + i10;
    }

    public Boolean isDeveloperOnlyAttribute() {
        return this.developerOnlyAttribute;
    }

    public Boolean isMutable() {
        return this.mutable;
    }

    public Boolean isRequired() {
        return this.required;
    }

    public void setAttributeDataType(String str) {
        this.attributeDataType = str;
    }

    public void setDeveloperOnlyAttribute(Boolean bool) {
        this.developerOnlyAttribute = bool;
    }

    public void setMutable(Boolean bool) {
        this.mutable = bool;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNumberAttributeConstraints(NumberAttributeConstraintsType numberAttributeConstraintsType) {
        this.numberAttributeConstraints = numberAttributeConstraintsType;
    }

    public void setRequired(Boolean bool) {
        this.required = bool;
    }

    public void setStringAttributeConstraints(StringAttributeConstraintsType stringAttributeConstraintsType) {
        this.stringAttributeConstraints = stringAttributeConstraintsType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getName() != null) {
            sb.append("Name: " + getName() + ",");
        }
        if (getAttributeDataType() != null) {
            sb.append("AttributeDataType: " + getAttributeDataType() + ",");
        }
        if (getDeveloperOnlyAttribute() != null) {
            sb.append("DeveloperOnlyAttribute: " + getDeveloperOnlyAttribute() + ",");
        }
        if (getMutable() != null) {
            sb.append("Mutable: " + getMutable() + ",");
        }
        if (getRequired() != null) {
            sb.append("Required: " + getRequired() + ",");
        }
        if (getNumberAttributeConstraints() != null) {
            sb.append("NumberAttributeConstraints: " + getNumberAttributeConstraints() + ",");
        }
        if (getStringAttributeConstraints() != null) {
            sb.append("StringAttributeConstraints: " + getStringAttributeConstraints());
        }
        sb.append("}");
        return sb.toString();
    }

    public SchemaAttributeType withAttributeDataType(String str) {
        this.attributeDataType = str;
        return this;
    }

    public SchemaAttributeType withDeveloperOnlyAttribute(Boolean bool) {
        this.developerOnlyAttribute = bool;
        return this;
    }

    public SchemaAttributeType withMutable(Boolean bool) {
        this.mutable = bool;
        return this;
    }

    public SchemaAttributeType withName(String str) {
        this.name = str;
        return this;
    }

    public SchemaAttributeType withNumberAttributeConstraints(NumberAttributeConstraintsType numberAttributeConstraintsType) {
        this.numberAttributeConstraints = numberAttributeConstraintsType;
        return this;
    }

    public SchemaAttributeType withRequired(Boolean bool) {
        this.required = bool;
        return this;
    }

    public SchemaAttributeType withStringAttributeConstraints(StringAttributeConstraintsType stringAttributeConstraintsType) {
        this.stringAttributeConstraints = stringAttributeConstraintsType;
        return this;
    }

    public void setAttributeDataType(AttributeDataType attributeDataType) {
        this.attributeDataType = attributeDataType.toString();
    }

    public SchemaAttributeType withAttributeDataType(AttributeDataType attributeDataType) {
        this.attributeDataType = attributeDataType.toString();
        return this;
    }
}
