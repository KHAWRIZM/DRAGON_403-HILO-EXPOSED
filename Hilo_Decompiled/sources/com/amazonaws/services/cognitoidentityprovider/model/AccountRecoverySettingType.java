package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AccountRecoverySettingType implements Serializable {
    private List<RecoveryOptionType> recoveryMechanisms;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccountRecoverySettingType)) {
            return false;
        }
        AccountRecoverySettingType accountRecoverySettingType = (AccountRecoverySettingType) obj;
        if (accountRecoverySettingType.getRecoveryMechanisms() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getRecoveryMechanisms() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (accountRecoverySettingType.getRecoveryMechanisms() == null || accountRecoverySettingType.getRecoveryMechanisms().equals(getRecoveryMechanisms())) {
            return true;
        }
        return false;
    }

    public List<RecoveryOptionType> getRecoveryMechanisms() {
        return this.recoveryMechanisms;
    }

    public int hashCode() {
        int hashCode;
        if (getRecoveryMechanisms() == null) {
            hashCode = 0;
        } else {
            hashCode = getRecoveryMechanisms().hashCode();
        }
        return 31 + hashCode;
    }

    public void setRecoveryMechanisms(Collection<RecoveryOptionType> collection) {
        if (collection == null) {
            this.recoveryMechanisms = null;
        } else {
            this.recoveryMechanisms = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getRecoveryMechanisms() != null) {
            sb.append("RecoveryMechanisms: " + getRecoveryMechanisms());
        }
        sb.append("}");
        return sb.toString();
    }

    public AccountRecoverySettingType withRecoveryMechanisms(RecoveryOptionType... recoveryOptionTypeArr) {
        if (getRecoveryMechanisms() == null) {
            this.recoveryMechanisms = new ArrayList(recoveryOptionTypeArr.length);
        }
        for (RecoveryOptionType recoveryOptionType : recoveryOptionTypeArr) {
            this.recoveryMechanisms.add(recoveryOptionType);
        }
        return this;
    }

    public AccountRecoverySettingType withRecoveryMechanisms(Collection<RecoveryOptionType> collection) {
        setRecoveryMechanisms(collection);
        return this;
    }
}
