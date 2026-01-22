package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AccountTakeoverActionsType implements Serializable {
    private AccountTakeoverActionType highAction;
    private AccountTakeoverActionType lowAction;
    private AccountTakeoverActionType mediumAction;

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
        if (obj == null || !(obj instanceof AccountTakeoverActionsType)) {
            return false;
        }
        AccountTakeoverActionsType accountTakeoverActionsType = (AccountTakeoverActionsType) obj;
        if (accountTakeoverActionsType.getLowAction() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getLowAction() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (accountTakeoverActionsType.getLowAction() != null && !accountTakeoverActionsType.getLowAction().equals(getLowAction())) {
            return false;
        }
        if (accountTakeoverActionsType.getMediumAction() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getMediumAction() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (accountTakeoverActionsType.getMediumAction() != null && !accountTakeoverActionsType.getMediumAction().equals(getMediumAction())) {
            return false;
        }
        if (accountTakeoverActionsType.getHighAction() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getHighAction() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (accountTakeoverActionsType.getHighAction() == null || accountTakeoverActionsType.getHighAction().equals(getHighAction())) {
            return true;
        }
        return false;
    }

    public AccountTakeoverActionType getHighAction() {
        return this.highAction;
    }

    public AccountTakeoverActionType getLowAction() {
        return this.lowAction;
    }

    public AccountTakeoverActionType getMediumAction() {
        return this.mediumAction;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getLowAction() == null) {
            hashCode = 0;
        } else {
            hashCode = getLowAction().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getMediumAction() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getMediumAction().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getHighAction() != null) {
            i10 = getHighAction().hashCode();
        }
        return i12 + i10;
    }

    public void setHighAction(AccountTakeoverActionType accountTakeoverActionType) {
        this.highAction = accountTakeoverActionType;
    }

    public void setLowAction(AccountTakeoverActionType accountTakeoverActionType) {
        this.lowAction = accountTakeoverActionType;
    }

    public void setMediumAction(AccountTakeoverActionType accountTakeoverActionType) {
        this.mediumAction = accountTakeoverActionType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getLowAction() != null) {
            sb.append("LowAction: " + getLowAction() + ",");
        }
        if (getMediumAction() != null) {
            sb.append("MediumAction: " + getMediumAction() + ",");
        }
        if (getHighAction() != null) {
            sb.append("HighAction: " + getHighAction());
        }
        sb.append("}");
        return sb.toString();
    }

    public AccountTakeoverActionsType withHighAction(AccountTakeoverActionType accountTakeoverActionType) {
        this.highAction = accountTakeoverActionType;
        return this;
    }

    public AccountTakeoverActionsType withLowAction(AccountTakeoverActionType accountTakeoverActionType) {
        this.lowAction = accountTakeoverActionType;
        return this;
    }

    public AccountTakeoverActionsType withMediumAction(AccountTakeoverActionType accountTakeoverActionType) {
        this.mediumAction = accountTakeoverActionType;
        return this;
    }
}
