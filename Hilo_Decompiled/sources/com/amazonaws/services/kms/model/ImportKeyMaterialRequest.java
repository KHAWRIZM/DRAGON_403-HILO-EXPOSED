package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ImportKeyMaterialRequest extends AmazonWebServiceRequest implements Serializable {
    private ByteBuffer encryptedKeyMaterial;
    private String expirationModel;
    private ByteBuffer importToken;
    private String keyId;
    private Date validTo;

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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ImportKeyMaterialRequest)) {
            return false;
        }
        ImportKeyMaterialRequest importKeyMaterialRequest = (ImportKeyMaterialRequest) obj;
        if (importKeyMaterialRequest.getKeyId() == null) {
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
        if (importKeyMaterialRequest.getKeyId() != null && !importKeyMaterialRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (importKeyMaterialRequest.getImportToken() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getImportToken() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (importKeyMaterialRequest.getImportToken() != null && !importKeyMaterialRequest.getImportToken().equals(getImportToken())) {
            return false;
        }
        if (importKeyMaterialRequest.getEncryptedKeyMaterial() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getEncryptedKeyMaterial() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (importKeyMaterialRequest.getEncryptedKeyMaterial() != null && !importKeyMaterialRequest.getEncryptedKeyMaterial().equals(getEncryptedKeyMaterial())) {
            return false;
        }
        if (importKeyMaterialRequest.getValidTo() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getValidTo() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (importKeyMaterialRequest.getValidTo() != null && !importKeyMaterialRequest.getValidTo().equals(getValidTo())) {
            return false;
        }
        if (importKeyMaterialRequest.getExpirationModel() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getExpirationModel() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (importKeyMaterialRequest.getExpirationModel() == null || importKeyMaterialRequest.getExpirationModel().equals(getExpirationModel())) {
            return true;
        }
        return false;
    }

    public ByteBuffer getEncryptedKeyMaterial() {
        return this.encryptedKeyMaterial;
    }

    public String getExpirationModel() {
        return this.expirationModel;
    }

    public ByteBuffer getImportToken() {
        return this.importToken;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Date getValidTo() {
        return this.validTo;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i10 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getImportToken() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getImportToken().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getEncryptedKeyMaterial() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getEncryptedKeyMaterial().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getValidTo() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getValidTo().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getExpirationModel() != null) {
            i10 = getExpirationModel().hashCode();
        }
        return i14 + i10;
    }

    public void setEncryptedKeyMaterial(ByteBuffer byteBuffer) {
        this.encryptedKeyMaterial = byteBuffer;
    }

    public void setExpirationModel(String str) {
        this.expirationModel = str;
    }

    public void setImportToken(ByteBuffer byteBuffer) {
        this.importToken = byteBuffer;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setValidTo(Date date) {
        this.validTo = date;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getImportToken() != null) {
            sb.append("ImportToken: " + getImportToken() + ",");
        }
        if (getEncryptedKeyMaterial() != null) {
            sb.append("EncryptedKeyMaterial: " + getEncryptedKeyMaterial() + ",");
        }
        if (getValidTo() != null) {
            sb.append("ValidTo: " + getValidTo() + ",");
        }
        if (getExpirationModel() != null) {
            sb.append("ExpirationModel: " + getExpirationModel());
        }
        sb.append("}");
        return sb.toString();
    }

    public ImportKeyMaterialRequest withEncryptedKeyMaterial(ByteBuffer byteBuffer) {
        this.encryptedKeyMaterial = byteBuffer;
        return this;
    }

    public ImportKeyMaterialRequest withExpirationModel(String str) {
        this.expirationModel = str;
        return this;
    }

    public ImportKeyMaterialRequest withImportToken(ByteBuffer byteBuffer) {
        this.importToken = byteBuffer;
        return this;
    }

    public ImportKeyMaterialRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ImportKeyMaterialRequest withValidTo(Date date) {
        this.validTo = date;
        return this;
    }

    public void setExpirationModel(ExpirationModelType expirationModelType) {
        this.expirationModel = expirationModelType.toString();
    }

    public ImportKeyMaterialRequest withExpirationModel(ExpirationModelType expirationModelType) {
        this.expirationModel = expirationModelType.toString();
        return this;
    }
}
