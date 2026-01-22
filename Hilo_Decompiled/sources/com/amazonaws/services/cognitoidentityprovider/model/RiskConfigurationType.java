package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class RiskConfigurationType implements Serializable {
    private AccountTakeoverRiskConfigurationType accountTakeoverRiskConfiguration;
    private String clientId;
    private CompromisedCredentialsRiskConfigurationType compromisedCredentialsRiskConfiguration;
    private Date lastModifiedDate;
    private RiskExceptionConfigurationType riskExceptionConfiguration;
    private String userPoolId;

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
        if (obj == null || !(obj instanceof RiskConfigurationType)) {
            return false;
        }
        RiskConfigurationType riskConfigurationType = (RiskConfigurationType) obj;
        if (riskConfigurationType.getUserPoolId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserPoolId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (riskConfigurationType.getUserPoolId() != null && !riskConfigurationType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (riskConfigurationType.getClientId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getClientId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (riskConfigurationType.getClientId() != null && !riskConfigurationType.getClientId().equals(getClientId())) {
            return false;
        }
        if (riskConfigurationType.getCompromisedCredentialsRiskConfiguration() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getCompromisedCredentialsRiskConfiguration() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (riskConfigurationType.getCompromisedCredentialsRiskConfiguration() != null && !riskConfigurationType.getCompromisedCredentialsRiskConfiguration().equals(getCompromisedCredentialsRiskConfiguration())) {
            return false;
        }
        if (riskConfigurationType.getAccountTakeoverRiskConfiguration() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getAccountTakeoverRiskConfiguration() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (riskConfigurationType.getAccountTakeoverRiskConfiguration() != null && !riskConfigurationType.getAccountTakeoverRiskConfiguration().equals(getAccountTakeoverRiskConfiguration())) {
            return false;
        }
        if (riskConfigurationType.getRiskExceptionConfiguration() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getRiskExceptionConfiguration() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (riskConfigurationType.getRiskExceptionConfiguration() != null && !riskConfigurationType.getRiskExceptionConfiguration().equals(getRiskExceptionConfiguration())) {
            return false;
        }
        if (riskConfigurationType.getLastModifiedDate() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getLastModifiedDate() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (riskConfigurationType.getLastModifiedDate() == null || riskConfigurationType.getLastModifiedDate().equals(getLastModifiedDate())) {
            return true;
        }
        return false;
    }

    public AccountTakeoverRiskConfigurationType getAccountTakeoverRiskConfiguration() {
        return this.accountTakeoverRiskConfiguration;
    }

    public String getClientId() {
        return this.clientId;
    }

    public CompromisedCredentialsRiskConfigurationType getCompromisedCredentialsRiskConfiguration() {
        return this.compromisedCredentialsRiskConfiguration;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public RiskExceptionConfigurationType getRiskExceptionConfiguration() {
        return this.riskExceptionConfiguration;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getClientId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getClientId().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getCompromisedCredentialsRiskConfiguration() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getCompromisedCredentialsRiskConfiguration().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getAccountTakeoverRiskConfiguration() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getAccountTakeoverRiskConfiguration().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getRiskExceptionConfiguration() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getRiskExceptionConfiguration().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getLastModifiedDate() != null) {
            i10 = getLastModifiedDate().hashCode();
        }
        return i15 + i10;
    }

    public void setAccountTakeoverRiskConfiguration(AccountTakeoverRiskConfigurationType accountTakeoverRiskConfigurationType) {
        this.accountTakeoverRiskConfiguration = accountTakeoverRiskConfigurationType;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setCompromisedCredentialsRiskConfiguration(CompromisedCredentialsRiskConfigurationType compromisedCredentialsRiskConfigurationType) {
        this.compromisedCredentialsRiskConfiguration = compromisedCredentialsRiskConfigurationType;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public void setRiskExceptionConfiguration(RiskExceptionConfigurationType riskExceptionConfigurationType) {
        this.riskExceptionConfiguration = riskExceptionConfigurationType;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getCompromisedCredentialsRiskConfiguration() != null) {
            sb.append("CompromisedCredentialsRiskConfiguration: " + getCompromisedCredentialsRiskConfiguration() + ",");
        }
        if (getAccountTakeoverRiskConfiguration() != null) {
            sb.append("AccountTakeoverRiskConfiguration: " + getAccountTakeoverRiskConfiguration() + ",");
        }
        if (getRiskExceptionConfiguration() != null) {
            sb.append("RiskExceptionConfiguration: " + getRiskExceptionConfiguration() + ",");
        }
        if (getLastModifiedDate() != null) {
            sb.append("LastModifiedDate: " + getLastModifiedDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public RiskConfigurationType withAccountTakeoverRiskConfiguration(AccountTakeoverRiskConfigurationType accountTakeoverRiskConfigurationType) {
        this.accountTakeoverRiskConfiguration = accountTakeoverRiskConfigurationType;
        return this;
    }

    public RiskConfigurationType withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public RiskConfigurationType withCompromisedCredentialsRiskConfiguration(CompromisedCredentialsRiskConfigurationType compromisedCredentialsRiskConfigurationType) {
        this.compromisedCredentialsRiskConfiguration = compromisedCredentialsRiskConfigurationType;
        return this;
    }

    public RiskConfigurationType withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public RiskConfigurationType withRiskExceptionConfiguration(RiskExceptionConfigurationType riskExceptionConfigurationType) {
        this.riskExceptionConfiguration = riskExceptionConfigurationType;
        return this;
    }

    public RiskConfigurationType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
