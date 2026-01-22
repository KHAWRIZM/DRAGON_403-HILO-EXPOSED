package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class EventRiskType implements Serializable {
    private Boolean compromisedCredentialsDetected;
    private String riskDecision;
    private String riskLevel;

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
        if (obj == null || !(obj instanceof EventRiskType)) {
            return false;
        }
        EventRiskType eventRiskType = (EventRiskType) obj;
        if (eventRiskType.getRiskDecision() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getRiskDecision() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (eventRiskType.getRiskDecision() != null && !eventRiskType.getRiskDecision().equals(getRiskDecision())) {
            return false;
        }
        if (eventRiskType.getRiskLevel() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getRiskLevel() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (eventRiskType.getRiskLevel() != null && !eventRiskType.getRiskLevel().equals(getRiskLevel())) {
            return false;
        }
        if (eventRiskType.getCompromisedCredentialsDetected() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getCompromisedCredentialsDetected() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (eventRiskType.getCompromisedCredentialsDetected() == null || eventRiskType.getCompromisedCredentialsDetected().equals(getCompromisedCredentialsDetected())) {
            return true;
        }
        return false;
    }

    public Boolean getCompromisedCredentialsDetected() {
        return this.compromisedCredentialsDetected;
    }

    public String getRiskDecision() {
        return this.riskDecision;
    }

    public String getRiskLevel() {
        return this.riskLevel;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getRiskDecision() == null) {
            hashCode = 0;
        } else {
            hashCode = getRiskDecision().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getRiskLevel() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getRiskLevel().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getCompromisedCredentialsDetected() != null) {
            i10 = getCompromisedCredentialsDetected().hashCode();
        }
        return i12 + i10;
    }

    public Boolean isCompromisedCredentialsDetected() {
        return this.compromisedCredentialsDetected;
    }

    public void setCompromisedCredentialsDetected(Boolean bool) {
        this.compromisedCredentialsDetected = bool;
    }

    public void setRiskDecision(String str) {
        this.riskDecision = str;
    }

    public void setRiskLevel(String str) {
        this.riskLevel = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getRiskDecision() != null) {
            sb.append("RiskDecision: " + getRiskDecision() + ",");
        }
        if (getRiskLevel() != null) {
            sb.append("RiskLevel: " + getRiskLevel() + ",");
        }
        if (getCompromisedCredentialsDetected() != null) {
            sb.append("CompromisedCredentialsDetected: " + getCompromisedCredentialsDetected());
        }
        sb.append("}");
        return sb.toString();
    }

    public EventRiskType withCompromisedCredentialsDetected(Boolean bool) {
        this.compromisedCredentialsDetected = bool;
        return this;
    }

    public EventRiskType withRiskDecision(String str) {
        this.riskDecision = str;
        return this;
    }

    public EventRiskType withRiskLevel(String str) {
        this.riskLevel = str;
        return this;
    }

    public void setRiskDecision(RiskDecisionType riskDecisionType) {
        this.riskDecision = riskDecisionType.toString();
    }

    public void setRiskLevel(RiskLevelType riskLevelType) {
        this.riskLevel = riskLevelType.toString();
    }

    public EventRiskType withRiskDecision(RiskDecisionType riskDecisionType) {
        this.riskDecision = riskDecisionType.toString();
        return this;
    }

    public EventRiskType withRiskLevel(RiskLevelType riskLevelType) {
        this.riskLevel = riskLevelType.toString();
        return this;
    }
}
