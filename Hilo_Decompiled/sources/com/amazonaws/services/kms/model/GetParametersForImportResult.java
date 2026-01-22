package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetParametersForImportResult implements Serializable {
    private ByteBuffer importToken;
    private String keyId;
    private Date parametersValidTo;
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
        if (obj == null || !(obj instanceof GetParametersForImportResult)) {
            return false;
        }
        GetParametersForImportResult getParametersForImportResult = (GetParametersForImportResult) obj;
        if (getParametersForImportResult.getKeyId() == null) {
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
        if (getParametersForImportResult.getKeyId() != null && !getParametersForImportResult.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (getParametersForImportResult.getImportToken() == null) {
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
        if (getParametersForImportResult.getImportToken() != null && !getParametersForImportResult.getImportToken().equals(getImportToken())) {
            return false;
        }
        if (getParametersForImportResult.getPublicKey() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getPublicKey() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (getParametersForImportResult.getPublicKey() != null && !getParametersForImportResult.getPublicKey().equals(getPublicKey())) {
            return false;
        }
        if (getParametersForImportResult.getParametersValidTo() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getParametersValidTo() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (getParametersForImportResult.getParametersValidTo() == null || getParametersForImportResult.getParametersValidTo().equals(getParametersValidTo())) {
            return true;
        }
        return false;
    }

    public ByteBuffer getImportToken() {
        return this.importToken;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Date getParametersValidTo() {
        return this.parametersValidTo;
    }

    public ByteBuffer getPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
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
        if (getPublicKey() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getPublicKey().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getParametersValidTo() != null) {
            i10 = getParametersValidTo().hashCode();
        }
        return i13 + i10;
    }

    public void setImportToken(ByteBuffer byteBuffer) {
        this.importToken = byteBuffer;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setParametersValidTo(Date date) {
        this.parametersValidTo = date;
    }

    public void setPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
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
        if (getPublicKey() != null) {
            sb.append("PublicKey: " + getPublicKey() + ",");
        }
        if (getParametersValidTo() != null) {
            sb.append("ParametersValidTo: " + getParametersValidTo());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetParametersForImportResult withImportToken(ByteBuffer byteBuffer) {
        this.importToken = byteBuffer;
        return this;
    }

    public GetParametersForImportResult withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GetParametersForImportResult withParametersValidTo(Date date) {
        this.parametersValidTo = date;
        return this;
    }

    public GetParametersForImportResult withPublicKey(ByteBuffer byteBuffer) {
        this.publicKey = byteBuffer;
        return this;
    }
}
