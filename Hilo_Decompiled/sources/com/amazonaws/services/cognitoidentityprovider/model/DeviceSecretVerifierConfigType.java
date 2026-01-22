package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DeviceSecretVerifierConfigType implements Serializable {
    private String passwordVerifier;
    private String salt;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeviceSecretVerifierConfigType)) {
            return false;
        }
        DeviceSecretVerifierConfigType deviceSecretVerifierConfigType = (DeviceSecretVerifierConfigType) obj;
        if (deviceSecretVerifierConfigType.getPasswordVerifier() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getPasswordVerifier() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (deviceSecretVerifierConfigType.getPasswordVerifier() != null && !deviceSecretVerifierConfigType.getPasswordVerifier().equals(getPasswordVerifier())) {
            return false;
        }
        if (deviceSecretVerifierConfigType.getSalt() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getSalt() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (deviceSecretVerifierConfigType.getSalt() == null || deviceSecretVerifierConfigType.getSalt().equals(getSalt())) {
            return true;
        }
        return false;
    }

    public String getPasswordVerifier() {
        return this.passwordVerifier;
    }

    public String getSalt() {
        return this.salt;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getPasswordVerifier() == null) {
            hashCode = 0;
        } else {
            hashCode = getPasswordVerifier().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getSalt() != null) {
            i10 = getSalt().hashCode();
        }
        return i11 + i10;
    }

    public void setPasswordVerifier(String str) {
        this.passwordVerifier = str;
    }

    public void setSalt(String str) {
        this.salt = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPasswordVerifier() != null) {
            sb.append("PasswordVerifier: " + getPasswordVerifier() + ",");
        }
        if (getSalt() != null) {
            sb.append("Salt: " + getSalt());
        }
        sb.append("}");
        return sb.toString();
    }

    public DeviceSecretVerifierConfigType withPasswordVerifier(String str) {
        this.passwordVerifier = str;
        return this;
    }

    public DeviceSecretVerifierConfigType withSalt(String str) {
        this.salt = str;
        return this;
    }
}
