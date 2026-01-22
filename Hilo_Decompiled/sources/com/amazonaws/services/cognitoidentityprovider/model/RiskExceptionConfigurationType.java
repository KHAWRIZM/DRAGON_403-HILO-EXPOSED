package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class RiskExceptionConfigurationType implements Serializable {
    private List<String> blockedIPRangeList;
    private List<String> skippedIPRangeList;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof RiskExceptionConfigurationType)) {
            return false;
        }
        RiskExceptionConfigurationType riskExceptionConfigurationType = (RiskExceptionConfigurationType) obj;
        if (riskExceptionConfigurationType.getBlockedIPRangeList() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getBlockedIPRangeList() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (riskExceptionConfigurationType.getBlockedIPRangeList() != null && !riskExceptionConfigurationType.getBlockedIPRangeList().equals(getBlockedIPRangeList())) {
            return false;
        }
        if (riskExceptionConfigurationType.getSkippedIPRangeList() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getSkippedIPRangeList() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (riskExceptionConfigurationType.getSkippedIPRangeList() == null || riskExceptionConfigurationType.getSkippedIPRangeList().equals(getSkippedIPRangeList())) {
            return true;
        }
        return false;
    }

    public List<String> getBlockedIPRangeList() {
        return this.blockedIPRangeList;
    }

    public List<String> getSkippedIPRangeList() {
        return this.skippedIPRangeList;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getBlockedIPRangeList() == null) {
            hashCode = 0;
        } else {
            hashCode = getBlockedIPRangeList().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getSkippedIPRangeList() != null) {
            i10 = getSkippedIPRangeList().hashCode();
        }
        return i11 + i10;
    }

    public void setBlockedIPRangeList(Collection<String> collection) {
        if (collection == null) {
            this.blockedIPRangeList = null;
        } else {
            this.blockedIPRangeList = new ArrayList(collection);
        }
    }

    public void setSkippedIPRangeList(Collection<String> collection) {
        if (collection == null) {
            this.skippedIPRangeList = null;
        } else {
            this.skippedIPRangeList = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getBlockedIPRangeList() != null) {
            sb.append("BlockedIPRangeList: " + getBlockedIPRangeList() + ",");
        }
        if (getSkippedIPRangeList() != null) {
            sb.append("SkippedIPRangeList: " + getSkippedIPRangeList());
        }
        sb.append("}");
        return sb.toString();
    }

    public RiskExceptionConfigurationType withBlockedIPRangeList(String... strArr) {
        if (getBlockedIPRangeList() == null) {
            this.blockedIPRangeList = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.blockedIPRangeList.add(str);
        }
        return this;
    }

    public RiskExceptionConfigurationType withSkippedIPRangeList(String... strArr) {
        if (getSkippedIPRangeList() == null) {
            this.skippedIPRangeList = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.skippedIPRangeList.add(str);
        }
        return this;
    }

    public RiskExceptionConfigurationType withBlockedIPRangeList(Collection<String> collection) {
        setBlockedIPRangeList(collection);
        return this;
    }

    public RiskExceptionConfigurationType withSkippedIPRangeList(Collection<String> collection) {
        setSkippedIPRangeList(collection);
        return this;
    }
}
