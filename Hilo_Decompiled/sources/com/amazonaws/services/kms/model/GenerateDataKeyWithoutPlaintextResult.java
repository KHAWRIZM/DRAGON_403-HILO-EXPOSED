package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GenerateDataKeyWithoutPlaintextResult implements Serializable {
    private ByteBuffer ciphertextBlob;
    private String keyId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateDataKeyWithoutPlaintextResult)) {
            return false;
        }
        GenerateDataKeyWithoutPlaintextResult generateDataKeyWithoutPlaintextResult = (GenerateDataKeyWithoutPlaintextResult) obj;
        if (generateDataKeyWithoutPlaintextResult.getCiphertextBlob() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getCiphertextBlob() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextResult.getCiphertextBlob() != null && !generateDataKeyWithoutPlaintextResult.getCiphertextBlob().equals(getCiphertextBlob())) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextResult.getKeyId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getKeyId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (generateDataKeyWithoutPlaintextResult.getKeyId() == null || generateDataKeyWithoutPlaintextResult.getKeyId().equals(getKeyId())) {
            return true;
        }
        return false;
    }

    public ByteBuffer getCiphertextBlob() {
        return this.ciphertextBlob;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getCiphertextBlob() == null) {
            hashCode = 0;
        } else {
            hashCode = getCiphertextBlob().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getKeyId() != null) {
            i10 = getKeyId().hashCode();
        }
        return i11 + i10;
    }

    public void setCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getCiphertextBlob() != null) {
            sb.append("CiphertextBlob: " + getCiphertextBlob() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public GenerateDataKeyWithoutPlaintextResult withCiphertextBlob(ByteBuffer byteBuffer) {
        this.ciphertextBlob = byteBuffer;
        return this;
    }

    public GenerateDataKeyWithoutPlaintextResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }
}
