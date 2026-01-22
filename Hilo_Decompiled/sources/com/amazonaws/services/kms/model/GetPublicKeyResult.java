package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetPublicKeyResult implements Serializable {
    private String customerMasterKeySpec;
    private String keyId;
    private String keyUsage;
    private ByteBuffer publicKey;
    private List<String> encryptionAlgorithms = new ArrayList();
    private List<String> signingAlgorithms = new ArrayList();

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
        if (obj == null || !(obj instanceof GetPublicKeyResult)) {
            return false;
        }
        GetPublicKeyResult getPublicKeyResult = (GetPublicKeyResult) obj;
        if (getPublicKeyResult.getKeyId() == null) {
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
        if (getPublicKeyResult.getKeyId() != null && !getPublicKeyResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (getPublicKeyResult.getPublicKey() == null) {
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
        if (getPublicKeyResult.getPublicKey() != null && !getPublicKeyResult.getPublicKey().equals(getPublicKey())) {
            return false;
        }
        if (getPublicKeyResult.getCustomerMasterKeySpec() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getCustomerMasterKeySpec() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (getPublicKeyResult.getCustomerMasterKeySpec() != null && !getPublicKeyResult.getCustomerMasterKeySpec().equals(getCustomerMasterKeySpec())) {
            return false;
        }
        if (getPublicKeyResult.getKeyUsage() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getKeyUsage() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (getPublicKeyResult.getKeyUsage() != null && !getPublicKeyResult.getKeyUsage().equals(getKeyUsage())) {
            return false;
        }
        if (getPublicKeyResult.getEncryptionAlgorithms() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getEncryptionAlgorithms() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (getPublicKeyResult.getEncryptionAlgorithms() != null && !getPublicKeyResult.getEncryptionAlgorithms().equals(getEncryptionAlgorithms())) {
            return false;
        }
        if (getPublicKeyResult.getSigningAlgorithms() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getSigningAlgorithms() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (getPublicKeyResult.getSigningAlgorithms() == null || getPublicKeyResult.getSigningAlgorithms().equals(getSigningAlgorithms())) {
            return true;
        }
        return false;
    }

    public String getCustomerMasterKeySpec() {
        return this.customerMasterKeySpec;
    }

    public List<String> getEncryptionAlgorithms() {
        return this.encryptionAlgorithms;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getKeyUsage() {
        return this.keyUsage;
    }

    public ByteBuffer getPublicKey() {
        return this.publicKey;
    }

    public List<String> getSigningAlgorithms() {
        return this.signingAlgorithms;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int i10 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getPublicKey() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getPublicKey().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getCustomerMasterKeySpec() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getCustomerMasterKeySpec().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getKeyUsage() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getKeyUsage().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getEncryptionAlgorithms() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getEncryptionAlgorithms().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getSigningAlgorithms() != null) {
            i10 = getSigningAlgorithms().hashCode();
        }
        return i15 + i10;
    }

    public void setCustomerMasterKeySpec(String str) {
        this.customerMasterKeySpec = str;
    }

    public void setEncryptionAlgorithms(Collection<String> collection) {
        if (collection == null) {
            this.encryptionAlgorithms = null;
        } else {
            this.encryptionAlgorithms = new ArrayList(collection);
        }
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setKeyUsage(String str) {
        this.keyUsage = str;
    }

    public void setPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
    }

    public void setSigningAlgorithms(Collection<String> collection) {
        if (collection == null) {
            this.signingAlgorithms = null;
        } else {
            this.signingAlgorithms = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getPublicKey() != null) {
            sb.append("PublicKey: " + getPublicKey() + ",");
        }
        if (getCustomerMasterKeySpec() != null) {
            sb.append("CustomerMasterKeySpec: " + getCustomerMasterKeySpec() + ",");
        }
        if (getKeyUsage() != null) {
            sb.append("KeyUsage: " + getKeyUsage() + ",");
        }
        if (getEncryptionAlgorithms() != null) {
            sb.append("EncryptionAlgorithms: " + getEncryptionAlgorithms() + ",");
        }
        if (getSigningAlgorithms() != null) {
            sb.append("SigningAlgorithms: " + getSigningAlgorithms());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetPublicKeyResult withCustomerMasterKeySpec(String str) {
        this.customerMasterKeySpec = str;
        return this;
    }

    public GetPublicKeyResult withEncryptionAlgorithms(String... strArr) {
        if (getEncryptionAlgorithms() == null) {
            this.encryptionAlgorithms = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.encryptionAlgorithms.add(str);
        }
        return this;
    }

    public GetPublicKeyResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GetPublicKeyResult withKeyUsage(String str) {
        this.keyUsage = str;
        return this;
    }

    public GetPublicKeyResult withPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
        return this;
    }

    public GetPublicKeyResult withSigningAlgorithms(String... strArr) {
        if (getSigningAlgorithms() == null) {
            this.signingAlgorithms = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.signingAlgorithms.add(str);
        }
        return this;
    }

    public void setCustomerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec) {
        this.customerMasterKeySpec = customerMasterKeySpec.toString();
    }

    public void setKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
    }

    public GetPublicKeyResult withCustomerMasterKeySpec(CustomerMasterKeySpec customerMasterKeySpec) {
        this.customerMasterKeySpec = customerMasterKeySpec.toString();
        return this;
    }

    public GetPublicKeyResult withKeyUsage(KeyUsageType keyUsageType) {
        this.keyUsage = keyUsageType.toString();
        return this;
    }

    public GetPublicKeyResult withEncryptionAlgorithms(Collection<String> collection) {
        setEncryptionAlgorithms(collection);
        return this;
    }

    public GetPublicKeyResult withSigningAlgorithms(Collection<String> collection) {
        setSigningAlgorithms(collection);
        return this;
    }
}
