package com.amazonaws.services.kms.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class VerifyResult implements Serializable {
    private String keyId;
    private Boolean signatureValid;
    private String signingAlgorithm;

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
        if (obj == null || !(obj instanceof VerifyResult)) {
            return false;
        }
        VerifyResult verifyResult = (VerifyResult) obj;
        if (verifyResult.getKeyId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getKeyId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (verifyResult.getKeyId() != null && !verifyResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (verifyResult.getSignatureValid() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getSignatureValid() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (verifyResult.getSignatureValid() != null && !verifyResult.getSignatureValid().equals(getSignatureValid())) {
            return false;
        }
        if (verifyResult.getSigningAlgorithm() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getSigningAlgorithm() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (verifyResult.getSigningAlgorithm() == null || verifyResult.getSigningAlgorithm().equals(getSigningAlgorithm())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Boolean getSignatureValid() {
        return this.signatureValid;
    }

    public String getSigningAlgorithm() {
        return this.signingAlgorithm;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getSignatureValid() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSignatureValid().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getSigningAlgorithm() != null) {
            i10 = getSigningAlgorithm().hashCode();
        }
        return i12 + i10;
    }

    public Boolean isSignatureValid() {
        return this.signatureValid;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setSignatureValid(Boolean bool) {
        this.signatureValid = bool;
    }

    public void setSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getSignatureValid() != null) {
            sb.append("SignatureValid: " + getSignatureValid() + ",");
        }
        if (getSigningAlgorithm() != null) {
            sb.append("SigningAlgorithm: " + getSigningAlgorithm());
        }
        sb.append("}");
        return sb.toString();
    }

    public VerifyResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public VerifyResult withSignatureValid(Boolean bool) {
        this.signatureValid = bool;
        return this;
    }

    public VerifyResult withSigningAlgorithm(String str) {
        this.signingAlgorithm = str;
        return this;
    }

    public void setSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
    }

    public VerifyResult withSigningAlgorithm(SigningAlgorithmSpec signingAlgorithmSpec) {
        this.signingAlgorithm = signingAlgorithmSpec.toString();
        return this;
    }
}
