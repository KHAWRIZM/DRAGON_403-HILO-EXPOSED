package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class PutKeyPolicyRequest extends AmazonWebServiceRequest implements Serializable {
    private Boolean bypassPolicyLockoutSafetyCheck;
    private String keyId;
    private String policy;
    private String policyName;

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
        if (obj == null || !(obj instanceof PutKeyPolicyRequest)) {
            return false;
        }
        PutKeyPolicyRequest putKeyPolicyRequest = (PutKeyPolicyRequest) obj;
        if (putKeyPolicyRequest.getKeyId() == null) {
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
        if (putKeyPolicyRequest.getKeyId() != null && !putKeyPolicyRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (putKeyPolicyRequest.getPolicyName() == null) {
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
        if (putKeyPolicyRequest.getPolicyName() != null && !putKeyPolicyRequest.getPolicyName().equals(getPolicyName())) {
            return false;
        }
        if (putKeyPolicyRequest.getPolicy() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getPolicy() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (putKeyPolicyRequest.getPolicy() != null && !putKeyPolicyRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if (putKeyPolicyRequest.getBypassPolicyLockoutSafetyCheck() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getBypassPolicyLockoutSafetyCheck() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (putKeyPolicyRequest.getBypassPolicyLockoutSafetyCheck() == null || putKeyPolicyRequest.getBypassPolicyLockoutSafetyCheck().equals(getBypassPolicyLockoutSafetyCheck())) {
            return true;
        }
        return false;
    }

    public Boolean getBypassPolicyLockoutSafetyCheck() {
        return this.bypassPolicyLockoutSafetyCheck;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public String getPolicy() {
        return this.policy;
    }

    public String getPolicyName() {
        return this.policyName;
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
        if (getPolicyName() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getPolicyName().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getPolicy() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getPolicy().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getBypassPolicyLockoutSafetyCheck() != null) {
            i10 = getBypassPolicyLockoutSafetyCheck().hashCode();
        }
        return i13 + i10;
    }

    public Boolean isBypassPolicyLockoutSafetyCheck() {
        return this.bypassPolicyLockoutSafetyCheck;
    }

    public void setBypassPolicyLockoutSafetyCheck(Boolean bool) {
        this.bypassPolicyLockoutSafetyCheck = bool;
    }

    public void setKeyId(String str) {
        this.keyId = str;
    }

    public void setPolicy(String str) {
        this.policy = str;
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
            sb.append("PolicyName: " + getPolicyName() + ",");
        }
        if (getPolicy() != null) {
            sb.append("Policy: " + getPolicy() + ",");
        }
        if (getBypassPolicyLockoutSafetyCheck() != null) {
            sb.append("BypassPolicyLockoutSafetyCheck: " + getBypassPolicyLockoutSafetyCheck());
        }
        sb.append("}");
        return sb.toString();
    }

    public PutKeyPolicyRequest withBypassPolicyLockoutSafetyCheck(Boolean bool) {
        this.bypassPolicyLockoutSafetyCheck = bool;
        return this;
    }

    public PutKeyPolicyRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public PutKeyPolicyRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public PutKeyPolicyRequest withPolicyName(String str) {
        this.policyName = str;
        return this;
    }
}
