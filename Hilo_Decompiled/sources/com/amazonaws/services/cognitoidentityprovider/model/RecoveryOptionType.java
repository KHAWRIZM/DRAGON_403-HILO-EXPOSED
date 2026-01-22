package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class RecoveryOptionType implements Serializable {
    private String name;
    private Integer priority;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RecoveryOptionType)) {
            return false;
        }
        RecoveryOptionType recoveryOptionType = (RecoveryOptionType) obj;
        if (recoveryOptionType.getPriority() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getPriority() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (recoveryOptionType.getPriority() != null && !recoveryOptionType.getPriority().equals(getPriority())) {
            return false;
        }
        if (recoveryOptionType.getName() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getName() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (recoveryOptionType.getName() == null || recoveryOptionType.getName().equals(getName())) {
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public Integer getPriority() {
        return this.priority;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getPriority() == null) {
            hashCode = 0;
        } else {
            hashCode = getPriority().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getName() != null) {
            i10 = getName().hashCode();
        }
        return i11 + i10;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPriority(Integer num) {
        this.priority = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPriority() != null) {
            sb.append("Priority: " + getPriority() + ",");
        }
        if (getName() != null) {
            sb.append("Name: " + getName());
        }
        sb.append("}");
        return sb.toString();
    }

    public RecoveryOptionType withName(String str) {
        this.name = str;
        return this;
    }

    public RecoveryOptionType withPriority(Integer num) {
        this.priority = num;
        return this;
    }

    public void setName(RecoveryOptionNameType recoveryOptionNameType) {
        this.name = recoveryOptionNameType.toString();
    }

    public RecoveryOptionType withName(RecoveryOptionNameType recoveryOptionNameType) {
        this.name = recoveryOptionNameType.toString();
        return this;
    }
}
