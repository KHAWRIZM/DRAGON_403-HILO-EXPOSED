package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UserPoolPolicyType implements Serializable {
    private PasswordPolicyType passwordPolicy;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserPoolPolicyType)) {
            return false;
        }
        UserPoolPolicyType userPoolPolicyType = (UserPoolPolicyType) obj;
        if (userPoolPolicyType.getPasswordPolicy() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getPasswordPolicy() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (userPoolPolicyType.getPasswordPolicy() == null || userPoolPolicyType.getPasswordPolicy().equals(getPasswordPolicy())) {
            return true;
        }
        return false;
    }

    public PasswordPolicyType getPasswordPolicy() {
        return this.passwordPolicy;
    }

    public int hashCode() {
        int hashCode;
        if (getPasswordPolicy() == null) {
            hashCode = 0;
        } else {
            hashCode = getPasswordPolicy().hashCode();
        }
        return 31 + hashCode;
    }

    public void setPasswordPolicy(PasswordPolicyType passwordPolicyType) {
        this.passwordPolicy = passwordPolicyType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPasswordPolicy() != null) {
            sb.append("PasswordPolicy: " + getPasswordPolicy());
        }
        sb.append("}");
        return sb.toString();
    }

    public UserPoolPolicyType withPasswordPolicy(PasswordPolicyType passwordPolicyType) {
        this.passwordPolicy = passwordPolicyType;
        return this;
    }
}
