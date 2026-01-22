package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ConfirmDeviceResult implements Serializable {
    private Boolean userConfirmationNecessary;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConfirmDeviceResult)) {
            return false;
        }
        ConfirmDeviceResult confirmDeviceResult = (ConfirmDeviceResult) obj;
        if (confirmDeviceResult.getUserConfirmationNecessary() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserConfirmationNecessary() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (confirmDeviceResult.getUserConfirmationNecessary() == null || confirmDeviceResult.getUserConfirmationNecessary().equals(getUserConfirmationNecessary())) {
            return true;
        }
        return false;
    }

    public Boolean getUserConfirmationNecessary() {
        return this.userConfirmationNecessary;
    }

    public int hashCode() {
        int hashCode;
        if (getUserConfirmationNecessary() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserConfirmationNecessary().hashCode();
        }
        return 31 + hashCode;
    }

    public Boolean isUserConfirmationNecessary() {
        return this.userConfirmationNecessary;
    }

    public void setUserConfirmationNecessary(Boolean bool) {
        this.userConfirmationNecessary = bool;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserConfirmationNecessary() != null) {
            sb.append("UserConfirmationNecessary: " + getUserConfirmationNecessary());
        }
        sb.append("}");
        return sb.toString();
    }

    public ConfirmDeviceResult withUserConfirmationNecessary(Boolean bool) {
        this.userConfirmationNecessary = bool;
        return this;
    }
}
