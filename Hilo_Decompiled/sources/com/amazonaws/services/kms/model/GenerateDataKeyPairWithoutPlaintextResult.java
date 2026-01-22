package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GenerateDataKeyPairWithoutPlaintextResult implements Serializable {
    private String keyId;
    private String keyPairSpec;
    private ByteBuffer privateKeyCiphertextBlob;
    private ByteBuffer publicKey;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateDataKeyPairWithoutPlaintextResult)) {
            return false;
        }
        GenerateDataKeyPairWithoutPlaintextResult generateDataKeyPairWithoutPlaintextResult = (GenerateDataKeyPairWithoutPlaintextResult) obj;
        if (generateDataKeyPairWithoutPlaintextResult.getPrivateKeyCiphertextBlob() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getPrivateKeyCiphertextBlob() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getPrivateKeyCiphertextBlob() != null && !generateDataKeyPairWithoutPlaintextResult.getPrivateKeyCiphertextBlob().equals(getPrivateKeyCiphertextBlob())) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getPublicKey() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getPublicKey() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getPublicKey() != null && !generateDataKeyPairWithoutPlaintextResult.getPublicKey().equals(getPublicKey())) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getKeyId() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getKeyId() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getKeyId() != null && !generateDataKeyPairWithoutPlaintextResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getKeyPairSpec() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getKeyPairSpec() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (generateDataKeyPairWithoutPlaintextResult.getKeyPairSpec() == null || generateDataKeyPairWithoutPlaintextResult.getKeyPairSpec().equals(getKeyPairSpec())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getKeyPairSpec() {
        return this.keyPairSpec;
    }

    public ByteBuffer getPrivateKeyCiphertextBlob() {
        return this.privateKeyCiphertextBlob;
    }

    public ByteBuffer getPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i10 = 0;
        if (getPrivateKeyCiphertextBlob() == null) {
            hashCode = 0;
        } else {
            hashCode = getPrivateKeyCiphertextBlob().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getPublicKey() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getPublicKey().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getKeyId() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getKeyId().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getKeyPairSpec() != null) {
            i10 = getKeyPairSpec().hashCode();
        }
        return i13 + i10;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setKeyPairSpec(String str) {
        this.keyPairSpec = str;
    }

    public void setPrivateKeyCiphertextBlob(ByteBuffer byteBuffer) {
        this.privateKeyCiphertextBlob = byteBuffer;
    }

    public void setPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPrivateKeyCiphertextBlob() != null) {
            sb.append("PrivateKeyCiphertextBlob: " + getPrivateKeyCiphertextBlob() + ",");
        }
        if (getPublicKey() != null) {
            sb.append("PublicKey: " + getPublicKey() + ",");
        }
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getKeyPairSpec() != null) {
            sb.append("KeyPairSpec: " + getKeyPairSpec());
        }
        sb.append("}");
        return sb.toString();
    }

    public GenerateDataKeyPairWithoutPlaintextResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextResult withKeyPairSpec(String str) {
        this.keyPairSpec = str;
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextResult withPrivateKeyCiphertextBlob(ByteBuffer byteBuffer) {
        this.privateKeyCiphertextBlob = byteBuffer;
        return this;
    }

    public GenerateDataKeyPairWithoutPlaintextResult withPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
        return this;
    }

    public void setKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
    }

    public GenerateDataKeyPairWithoutPlaintextResult withKeyPairSpec(DataKeyPairSpec dataKeyPairSpec) {
        this.keyPairSpec = dataKeyPairSpec.toString();
        return this;
    }
}
