package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CreateAliasRequest extends AmazonWebServiceRequest implements Serializable {
    private String aliasName;
    private String targetKeyId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateAliasRequest)) {
            return false;
        }
        CreateAliasRequest createAliasRequest = (CreateAliasRequest) obj;
        if (createAliasRequest.getAliasName() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getAliasName() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (createAliasRequest.getAliasName() != null && !createAliasRequest.getAliasName().equals(getAliasName())) {
            return false;
        }
        if (createAliasRequest.getTargetKeyId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getTargetKeyId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (createAliasRequest.getTargetKeyId() == null || createAliasRequest.getTargetKeyId().equals(getTargetKeyId())) {
            return true;
        }
        return false;
    }

    public String getAliasName() {
        return this.aliasName;
    }

    public String getTargetKeyId() {
        return this.targetKeyId;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getAliasName() == null) {
            hashCode = 0;
        } else {
            hashCode = getAliasName().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getTargetKeyId() != null) {
            i10 = getTargetKeyId().hashCode();
        }
        return i11 + i10;
    }

    public void setAliasName(String str) {
        this.aliasName = str;
    }

    public void setTargetKeyId(String str) {
        this.targetKeyId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAliasName() != null) {
            sb.append("AliasName: " + getAliasName() + ",");
        }
        if (getTargetKeyId() != null) {
            sb.append("TargetKeyId: " + getTargetKeyId());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateAliasRequest withAliasName(String str) {
        this.aliasName = str;
        return this;
    }

    public CreateAliasRequest withTargetKeyId(String str) {
        this.targetKeyId = str;
        return this;
    }
}
