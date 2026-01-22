package com.amazonaws.services.kms.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListKeyPoliciesResult implements Serializable {
    private String nextMarker;
    private List<String> policyNames = new ArrayList();
    private Boolean truncated;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListKeyPoliciesResult)) {
            return false;
        }
        ListKeyPoliciesResult listKeyPoliciesResult = (ListKeyPoliciesResult) obj;
        if (listKeyPoliciesResult.getPolicyNames() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getPolicyNames() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (listKeyPoliciesResult.getPolicyNames() != null && !listKeyPoliciesResult.getPolicyNames().equals(getPolicyNames())) {
            return false;
        }
        if (listKeyPoliciesResult.getNextMarker() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getNextMarker() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (listKeyPoliciesResult.getNextMarker() != null && !listKeyPoliciesResult.getNextMarker().equals(getNextMarker())) {
            return false;
        }
        if (listKeyPoliciesResult.getTruncated() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getTruncated() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (listKeyPoliciesResult.getTruncated() == null || listKeyPoliciesResult.getTruncated().equals(getTruncated())) {
            return true;
        }
        return false;
    }

    public String getNextMarker() {
        return this.nextMarker;
    }

    public List<String> getPolicyNames() {
        return this.policyNames;
    }

    public Boolean getTruncated() {
        return this.truncated;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getPolicyNames() == null) {
            hashCode = 0;
        } else {
            hashCode = getPolicyNames().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getNextMarker() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getNextMarker().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getTruncated() != null) {
            i10 = getTruncated().hashCode();
        }
        return i12 + i10;
    }

    public Boolean isTruncated() {
        return this.truncated;
    }

    public void setNextMarker(String str) {
        this.nextMarker = str;
    }

    public void setPolicyNames(Collection<String> collection) {
        if (collection == null) {
            this.policyNames = null;
        } else {
            this.policyNames = new ArrayList(collection);
        }
    }

    public void setTruncated(Boolean bool) {
        this.truncated = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPolicyNames() != null) {
            sb.append("PolicyNames: " + getPolicyNames() + ",");
        }
        if (getNextMarker() != null) {
            sb.append("NextMarker: " + getNextMarker() + ",");
        }
        if (getTruncated() != null) {
            sb.append("Truncated: " + getTruncated());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListKeyPoliciesResult withNextMarker(String str) {
        this.nextMarker = str;
        return this;
    }

    public ListKeyPoliciesResult withPolicyNames(String... strArr) {
        if (getPolicyNames() == null) {
            this.policyNames = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.policyNames.add(str);
        }
        return this;
    }

    public ListKeyPoliciesResult withTruncated(Boolean bool) {
        this.truncated = bool;
        return this;
    }

    public ListKeyPoliciesResult withPolicyNames(Collection<String> collection) {
        setPolicyNames(collection);
        return this;
    }
}
