package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GenerateRandomResult implements Serializable {
    private ByteBuffer plaintext;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GenerateRandomResult)) {
            return false;
        }
        GenerateRandomResult generateRandomResult = (GenerateRandomResult) obj;
        if (generateRandomResult.getPlaintext() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getPlaintext() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (generateRandomResult.getPlaintext() == null || generateRandomResult.getPlaintext().equals(getPlaintext())) {
            return true;
        }
        return false;
    }

    public ByteBuffer getPlaintext() {
        return this.plaintext;
    }

    public int hashCode() {
        int hashCode;
        if (getPlaintext() == null) {
            hashCode = 0;
        } else {
            hashCode = getPlaintext().hashCode();
        }
        return 31 + hashCode;
    }

    public void setPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPlaintext() != null) {
            sb.append("Plaintext: " + getPlaintext());
        }
        sb.append("}");
        return sb.toString();
    }

    public GenerateRandomResult withPlaintext(ByteBuffer byteBuffer) {
        this.plaintext = byteBuffer;
        return this;
    }
}
