package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SetRiskConfigurationResult implements Serializable {
    private RiskConfigurationType riskConfiguration;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetRiskConfigurationResult)) {
            return false;
        }
        SetRiskConfigurationResult setRiskConfigurationResult = (SetRiskConfigurationResult) obj;
        if (setRiskConfigurationResult.getRiskConfiguration() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getRiskConfiguration() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (setRiskConfigurationResult.getRiskConfiguration() == null || setRiskConfigurationResult.getRiskConfiguration().equals(getRiskConfiguration())) {
            return true;
        }
        return false;
    }

    public RiskConfigurationType getRiskConfiguration() {
        return this.riskConfiguration;
    }

    public int hashCode() {
        int hashCode;
        if (getRiskConfiguration() == null) {
            hashCode = 0;
        } else {
            hashCode = getRiskConfiguration().hashCode();
        }
        return 31 + hashCode;
    }

    public void setRiskConfiguration(RiskConfigurationType riskConfigurationType) {
        this.riskConfiguration = riskConfigurationType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getRiskConfiguration() != null) {
            sb.append("RiskConfiguration: " + getRiskConfiguration());
        }
        sb.append("}");
        return sb.toString();
    }

    public SetRiskConfigurationResult withRiskConfiguration(RiskConfigurationType riskConfigurationType) {
        this.riskConfiguration = riskConfigurationType;
        return this;
    }
}
