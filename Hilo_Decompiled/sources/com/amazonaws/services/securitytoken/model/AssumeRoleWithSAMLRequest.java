package com.amazonaws.services.securitytoken.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AssumeRoleWithSAMLRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer durationSeconds;
    private String policy;
    private List<PolicyDescriptorType> policyArns;
    private String principalArn;
    private String roleArn;
    private String sAMLAssertion;

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
        if (obj == null || !(obj instanceof AssumeRoleWithSAMLRequest)) {
            return false;
        }
        AssumeRoleWithSAMLRequest assumeRoleWithSAMLRequest = (AssumeRoleWithSAMLRequest) obj;
        if (assumeRoleWithSAMLRequest.getRoleArn() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getRoleArn() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getRoleArn() != null && !assumeRoleWithSAMLRequest.getRoleArn().equals(getRoleArn())) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPrincipalArn() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getPrincipalArn() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPrincipalArn() != null && !assumeRoleWithSAMLRequest.getPrincipalArn().equals(getPrincipalArn())) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getSAMLAssertion() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getSAMLAssertion() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getSAMLAssertion() != null && !assumeRoleWithSAMLRequest.getSAMLAssertion().equals(getSAMLAssertion())) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPolicyArns() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getPolicyArns() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPolicyArns() != null && !assumeRoleWithSAMLRequest.getPolicyArns().equals(getPolicyArns())) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPolicy() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getPolicy() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getPolicy() != null && !assumeRoleWithSAMLRequest.getPolicy().equals(getPolicy())) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getDurationSeconds() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getDurationSeconds() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (assumeRoleWithSAMLRequest.getDurationSeconds() == null || assumeRoleWithSAMLRequest.getDurationSeconds().equals(getDurationSeconds())) {
            return true;
        }
        return false;
    }

    public Integer getDurationSeconds() {
        return this.durationSeconds;
    }

    public String getPolicy() {
        return this.policy;
    }

    public List<PolicyDescriptorType> getPolicyArns() {
        return this.policyArns;
    }

    public String getPrincipalArn() {
        return this.principalArn;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public String getSAMLAssertion() {
        return this.sAMLAssertion;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int i10 = 0;
        if (getRoleArn() == null) {
            hashCode = 0;
        } else {
            hashCode = getRoleArn().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getPrincipalArn() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getPrincipalArn().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getSAMLAssertion() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getSAMLAssertion().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getPolicyArns() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getPolicyArns().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getPolicy() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getPolicy().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getDurationSeconds() != null) {
            i10 = getDurationSeconds().hashCode();
        }
        return i15 + i10;
    }

    public void setDurationSeconds(Integer num) {
        this.durationSeconds = num;
    }

    public void setPolicy(String str) {
        this.policy = str;
    }

    public void setPolicyArns(Collection<PolicyDescriptorType> collection) {
        if (collection == null) {
            this.policyArns = null;
        } else {
            this.policyArns = new ArrayList(collection);
        }
    }

    public void setPrincipalArn(String str) {
        this.principalArn = str;
    }

    public void setRoleArn(String str) {
        this.roleArn = str;
    }

    public void setSAMLAssertion(String str) {
        this.sAMLAssertion = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getRoleArn() != null) {
            sb.append("RoleArn: " + getRoleArn() + ",");
        }
        if (getPrincipalArn() != null) {
            sb.append("PrincipalArn: " + getPrincipalArn() + ",");
        }
        if (getSAMLAssertion() != null) {
            sb.append("SAMLAssertion: " + getSAMLAssertion() + ",");
        }
        if (getPolicyArns() != null) {
            sb.append("PolicyArns: " + getPolicyArns() + ",");
        }
        if (getPolicy() != null) {
            sb.append("Policy: " + getPolicy() + ",");
        }
        if (getDurationSeconds() != null) {
            sb.append("DurationSeconds: " + getDurationSeconds());
        }
        sb.append("}");
        return sb.toString();
    }

    public AssumeRoleWithSAMLRequest withDurationSeconds(Integer num) {
        this.durationSeconds = num;
        return this;
    }

    public AssumeRoleWithSAMLRequest withPolicy(String str) {
        this.policy = str;
        return this;
    }

    public AssumeRoleWithSAMLRequest withPolicyArns(PolicyDescriptorType... policyDescriptorTypeArr) {
        if (getPolicyArns() == null) {
            this.policyArns = new ArrayList(policyDescriptorTypeArr.length);
        }
        for (PolicyDescriptorType policyDescriptorType : policyDescriptorTypeArr) {
            this.policyArns.add(policyDescriptorType);
        }
        return this;
    }

    public AssumeRoleWithSAMLRequest withPrincipalArn(String str) {
        this.principalArn = str;
        return this;
    }

    public AssumeRoleWithSAMLRequest withRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public AssumeRoleWithSAMLRequest withSAMLAssertion(String str) {
        this.sAMLAssertion = str;
        return this;
    }

    public AssumeRoleWithSAMLRequest withPolicyArns(Collection<PolicyDescriptorType> collection) {
        setPolicyArns(collection);
        return this;
    }
}
