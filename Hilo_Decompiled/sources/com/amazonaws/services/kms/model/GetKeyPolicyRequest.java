package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetKeyPolicyRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private String policyName;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetKeyPolicyRequest)) {
            return false;
        }
        GetKeyPolicyRequest getKeyPolicyRequest = (GetKeyPolicyRequest) obj;
        if (getKeyPolicyRequest.getKeyId() == null) {
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
        if (getKeyPolicyRequest.getKeyId() != null && !getKeyPolicyRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (getKeyPolicyRequest.getPolicyName() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getPolicyName() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (getKeyPolicyRequest.getPolicyName() == null || getKeyPolicyRequest.getPolicyName().equals(getPolicyName())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getPolicyName() {
        return this.policyName;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getPolicyName() != null) {
            i10 = getPolicyName().hashCode();
        }
        return i11 + i10;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setPolicyName(String str) {
        this.policyName = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getPolicyName() != null) {
            sb.append("PolicyName: " + getPolicyName());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetKeyPolicyRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public GetKeyPolicyRequest withPolicyName(String str) {
        this.policyName = str;
        return this;
    }
}
