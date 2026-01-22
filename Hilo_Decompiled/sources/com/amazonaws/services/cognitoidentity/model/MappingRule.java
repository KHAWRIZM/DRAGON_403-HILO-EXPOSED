package com.amazonaws.services.cognitoidentity.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class MappingRule implements Serializable {
    private String claim;
    private String matchType;
    private String roleARN;
    private String value;

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
        if (obj == null || !(obj instanceof MappingRule)) {
            return false;
        }
        MappingRule mappingRule = (MappingRule) obj;
        if (mappingRule.getClaim() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getClaim() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (mappingRule.getClaim() != null && !mappingRule.getClaim().equals(getClaim())) {
            return false;
        }
        if (mappingRule.getMatchType() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getMatchType() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (mappingRule.getMatchType() != null && !mappingRule.getMatchType().equals(getMatchType())) {
            return false;
        }
        if (mappingRule.getValue() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getValue() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (mappingRule.getValue() != null && !mappingRule.getValue().equals(getValue())) {
            return false;
        }
        if (mappingRule.getRoleARN() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getRoleARN() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (mappingRule.getRoleARN() == null || mappingRule.getRoleARN().equals(getRoleARN())) {
            return true;
        }
        return false;
    }

    public String getClaim() {
        return this.claim;
    }

    public String getMatchType() {
        return this.matchType;
    }

    public String getRoleARN() {
        return this.roleARN;
    }

    public String getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i10 = 0;
        if (getClaim() == null) {
            hashCode = 0;
        } else {
            hashCode = getClaim().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getMatchType() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getMatchType().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getValue() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getValue().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getRoleARN() != null) {
            i10 = getRoleARN().hashCode();
        }
        return i13 + i10;
    }

    public void setClaim(String str) {
        this.claim = str;
    }

    public void setMatchType(String str) {
        this.matchType = str;
    }

    public void setRoleARN(String str) {
        this.roleARN = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getClaim() != null) {
            sb.append("Claim: " + getClaim() + ",");
        }
        if (getMatchType() != null) {
            sb.append("MatchType: " + getMatchType() + ",");
        }
        if (getValue() != null) {
            sb.append("Value: " + getValue() + ",");
        }
        if (getRoleARN() != null) {
            sb.append("RoleARN: " + getRoleARN());
        }
        sb.append("}");
        return sb.toString();
    }

    public MappingRule withClaim(String str) {
        this.claim = str;
        return this;
    }

    public MappingRule withMatchType(String str) {
        this.matchType = str;
        return this;
    }

    public MappingRule withRoleARN(String str) {
        this.roleARN = str;
        return this;
    }

    public MappingRule withValue(String str) {
        this.value = str;
        return this;
    }

    public void setMatchType(MappingRuleMatchType mappingRuleMatchType) {
        this.matchType = mappingRuleMatchType.toString();
    }

    public MappingRule withMatchType(MappingRuleMatchType mappingRuleMatchType) {
        this.matchType = mappingRuleMatchType.toString();
        return this;
    }
}
