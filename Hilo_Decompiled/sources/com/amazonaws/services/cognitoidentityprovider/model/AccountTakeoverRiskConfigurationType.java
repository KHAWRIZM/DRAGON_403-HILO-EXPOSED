package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AccountTakeoverRiskConfigurationType implements Serializable {
    private AccountTakeoverActionsType actions;
    private NotifyConfigurationType notifyConfiguration;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccountTakeoverRiskConfigurationType)) {
            return false;
        }
        AccountTakeoverRiskConfigurationType accountTakeoverRiskConfigurationType = (AccountTakeoverRiskConfigurationType) obj;
        if (accountTakeoverRiskConfigurationType.getNotifyConfiguration() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getNotifyConfiguration() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (accountTakeoverRiskConfigurationType.getNotifyConfiguration() != null && !accountTakeoverRiskConfigurationType.getNotifyConfiguration().equals(getNotifyConfiguration())) {
            return false;
        }
        if (accountTakeoverRiskConfigurationType.getActions() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getActions() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (accountTakeoverRiskConfigurationType.getActions() == null || accountTakeoverRiskConfigurationType.getActions().equals(getActions())) {
            return true;
        }
        return false;
    }

    public AccountTakeoverActionsType getActions() {
        return this.actions;
    }

    public NotifyConfigurationType getNotifyConfiguration() {
        return this.notifyConfiguration;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getNotifyConfiguration() == null) {
            hashCode = 0;
        } else {
            hashCode = getNotifyConfiguration().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getActions() != null) {
            i10 = getActions().hashCode();
        }
        return i11 + i10;
    }

    public void setActions(AccountTakeoverActionsType accountTakeoverActionsType) {
        this.actions = accountTakeoverActionsType;
    }

    public void setNotifyConfiguration(NotifyConfigurationType notifyConfigurationType) {
        this.notifyConfiguration = notifyConfigurationType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getNotifyConfiguration() != null) {
            sb.append("NotifyConfiguration: " + getNotifyConfiguration() + ",");
        }
        if (getActions() != null) {
            sb.append("Actions: " + getActions());
        }
        sb.append("}");
        return sb.toString();
    }

    public AccountTakeoverRiskConfigurationType withActions(AccountTakeoverActionsType accountTakeoverActionsType) {
        this.actions = accountTakeoverActionsType;
        return this;
    }

    public AccountTakeoverRiskConfigurationType withNotifyConfiguration(NotifyConfigurationType notifyConfigurationType) {
        this.notifyConfiguration = notifyConfigurationType;
        return this;
    }
}
