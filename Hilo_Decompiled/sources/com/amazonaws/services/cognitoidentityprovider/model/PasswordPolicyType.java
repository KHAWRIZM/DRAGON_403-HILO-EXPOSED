package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class PasswordPolicyType implements Serializable {
    private Integer minimumLength;
    private Boolean requireLowercase;
    private Boolean requireNumbers;
    private Boolean requireSymbols;
    private Boolean requireUppercase;
    private Integer temporaryPasswordValidityDays;

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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof PasswordPolicyType)) {
            return false;
        }
        PasswordPolicyType passwordPolicyType = (PasswordPolicyType) obj;
        if (passwordPolicyType.getMinimumLength() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getMinimumLength() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (passwordPolicyType.getMinimumLength() != null && !passwordPolicyType.getMinimumLength().equals(getMinimumLength())) {
            return false;
        }
        if (passwordPolicyType.getRequireUppercase() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getRequireUppercase() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (passwordPolicyType.getRequireUppercase() != null && !passwordPolicyType.getRequireUppercase().equals(getRequireUppercase())) {
            return false;
        }
        if (passwordPolicyType.getRequireLowercase() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getRequireLowercase() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (passwordPolicyType.getRequireLowercase() != null && !passwordPolicyType.getRequireLowercase().equals(getRequireLowercase())) {
            return false;
        }
        if (passwordPolicyType.getRequireNumbers() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getRequireNumbers() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (passwordPolicyType.getRequireNumbers() != null && !passwordPolicyType.getRequireNumbers().equals(getRequireNumbers())) {
            return false;
        }
        if (passwordPolicyType.getRequireSymbols() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getRequireSymbols() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (passwordPolicyType.getRequireSymbols() != null && !passwordPolicyType.getRequireSymbols().equals(getRequireSymbols())) {
            return false;
        }
        if (passwordPolicyType.getTemporaryPasswordValidityDays() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getTemporaryPasswordValidityDays() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (passwordPolicyType.getTemporaryPasswordValidityDays() == null || passwordPolicyType.getTemporaryPasswordValidityDays().equals(getTemporaryPasswordValidityDays())) {
            return true;
        }
        return false;
    }

    public Integer getMinimumLength() {
        return this.minimumLength;
    }

    public Boolean getRequireLowercase() {
        return this.requireLowercase;
    }

    public Boolean getRequireNumbers() {
        return this.requireNumbers;
    }

    public Boolean getRequireSymbols() {
        return this.requireSymbols;
    }

    public Boolean getRequireUppercase() {
        return this.requireUppercase;
    }

    public Integer getTemporaryPasswordValidityDays() {
        return this.temporaryPasswordValidityDays;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int i10 = 0;
        if (getMinimumLength() == null) {
            hashCode = 0;
        } else {
            hashCode = getMinimumLength().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getRequireUppercase() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getRequireUppercase().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getRequireLowercase() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getRequireLowercase().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getRequireNumbers() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getRequireNumbers().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getRequireSymbols() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getRequireSymbols().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getTemporaryPasswordValidityDays() != null) {
            i10 = getTemporaryPasswordValidityDays().hashCode();
        }
        return i15 + i10;
    }

    public Boolean isRequireLowercase() {
        return this.requireLowercase;
    }

    public Boolean isRequireNumbers() {
        return this.requireNumbers;
    }

    public Boolean isRequireSymbols() {
        return this.requireSymbols;
    }

    public Boolean isRequireUppercase() {
        return this.requireUppercase;
    }

    public void setMinimumLength(Integer num) {
        this.minimumLength = num;
    }

    public void setRequireLowercase(Boolean bool) {
        this.requireLowercase = bool;
    }

    public void setRequireNumbers(Boolean bool) {
        this.requireNumbers = bool;
    }

    public void setRequireSymbols(Boolean bool) {
        this.requireSymbols = bool;
    }

    public void setRequireUppercase(Boolean bool) {
        this.requireUppercase = bool;
    }

    public void setTemporaryPasswordValidityDays(Integer num) {
        this.temporaryPasswordValidityDays = num;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getMinimumLength() != null) {
            sb.append("MinimumLength: " + getMinimumLength() + ",");
        }
        if (getRequireUppercase() != null) {
            sb.append("RequireUppercase: " + getRequireUppercase() + ",");
        }
        if (getRequireLowercase() != null) {
            sb.append("RequireLowercase: " + getRequireLowercase() + ",");
        }
        if (getRequireNumbers() != null) {
            sb.append("RequireNumbers: " + getRequireNumbers() + ",");
        }
        if (getRequireSymbols() != null) {
            sb.append("RequireSymbols: " + getRequireSymbols() + ",");
        }
        if (getTemporaryPasswordValidityDays() != null) {
            sb.append("TemporaryPasswordValidityDays: " + getTemporaryPasswordValidityDays());
        }
        sb.append("}");
        return sb.toString();
    }

    public PasswordPolicyType withMinimumLength(Integer num) {
        this.minimumLength = num;
        return this;
    }

    public PasswordPolicyType withRequireLowercase(Boolean bool) {
        this.requireLowercase = bool;
        return this;
    }

    public PasswordPolicyType withRequireNumbers(Boolean bool) {
        this.requireNumbers = bool;
        return this;
    }

    public PasswordPolicyType withRequireSymbols(Boolean bool) {
        this.requireSymbols = bool;
        return this;
    }

    public PasswordPolicyType withRequireUppercase(Boolean bool) {
        this.requireUppercase = bool;
        return this;
    }

    public PasswordPolicyType withTemporaryPasswordValidityDays(Integer num) {
        this.temporaryPasswordValidityDays = num;
        return this;
    }
}
