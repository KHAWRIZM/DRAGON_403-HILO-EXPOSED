package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GrantConstraints implements Serializable {
    private Map<String, String> encryptionContextSubset = new HashMap();
    private Map<String, String> encryptionContextEquals = new HashMap();

    public GrantConstraints addEncryptionContextEqualsEntry(String str, String str2) {
        if (this.encryptionContextEquals == null) {
            this.encryptionContextEquals = new HashMap();
        }
        if (!this.encryptionContextEquals.containsKey(str)) {
            this.encryptionContextEquals.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GrantConstraints addEncryptionContextSubsetEntry(String str, String str2) {
        if (this.encryptionContextSubset == null) {
            this.encryptionContextSubset = new HashMap();
        }
        if (!this.encryptionContextSubset.containsKey(str)) {
            this.encryptionContextSubset.put(str, str2);
            return this;
        }
        throw new IllegalArgumentException("Duplicated keys (" + str.toString() + ") are provided.");
    }

    public GrantConstraints clearEncryptionContextEqualsEntries() {
        this.encryptionContextEquals = null;
        return this;
    }

    public GrantConstraints clearEncryptionContextSubsetEntries() {
        this.encryptionContextSubset = null;
        return this;
    }

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GrantConstraints)) {
            return false;
        }
        GrantConstraints grantConstraints = (GrantConstraints) obj;
        if (grantConstraints.getEncryptionContextSubset() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getEncryptionContextSubset() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (grantConstraints.getEncryptionContextSubset() != null && !grantConstraints.getEncryptionContextSubset().equals(getEncryptionContextSubset())) {
            return false;
        }
        if (grantConstraints.getEncryptionContextEquals() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getEncryptionContextEquals() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (grantConstraints.getEncryptionContextEquals() == null || grantConstraints.getEncryptionContextEquals().equals(getEncryptionContextEquals())) {
            return true;
        }
        return false;
    }

    public Map<String, String> getEncryptionContextEquals() {
        return this.encryptionContextEquals;
    }

    public Map<String, String> getEncryptionContextSubset() {
        return this.encryptionContextSubset;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getEncryptionContextSubset() == null) {
            hashCode = 0;
        } else {
            hashCode = getEncryptionContextSubset().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getEncryptionContextEquals() != null) {
            i10 = getEncryptionContextEquals().hashCode();
        }
        return i11 + i10;
    }

    public void setEncryptionContextEquals(Map<String, String> map) {
        this.encryptionContextEquals = map;
    }

    public void setEncryptionContextSubset(Map<String, String> map) {
        this.encryptionContextSubset = map;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEncryptionContextSubset() != null) {
            sb.append("EncryptionContextSubset: " + getEncryptionContextSubset() + ",");
        }
        if (getEncryptionContextEquals() != null) {
            sb.append("EncryptionContextEquals: " + getEncryptionContextEquals());
        }
        sb.append("}");
        return sb.toString();
    }

    public GrantConstraints withEncryptionContextEquals(Map<String, String> map) {
        this.encryptionContextEquals = map;
        return this;
    }

    public GrantConstraints withEncryptionContextSubset(Map<String, String> map) {
        this.encryptionContextSubset = map;
        return this;
    }
}
