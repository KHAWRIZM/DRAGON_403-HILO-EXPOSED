package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UserPoolClientDescription implements Serializable {
    private String clientId;
    private String clientName;
    private String userPoolId;

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
        if (obj == null || !(obj instanceof UserPoolClientDescription)) {
            return false;
        }
        UserPoolClientDescription userPoolClientDescription = (UserPoolClientDescription) obj;
        if (userPoolClientDescription.getClientId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getClientId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (userPoolClientDescription.getClientId() != null && !userPoolClientDescription.getClientId().equals(getClientId())) {
            return false;
        }
        if (userPoolClientDescription.getUserPoolId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getUserPoolId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (userPoolClientDescription.getUserPoolId() != null && !userPoolClientDescription.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (userPoolClientDescription.getClientName() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getClientName() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (userPoolClientDescription.getClientName() == null || userPoolClientDescription.getClientName().equals(getClientName())) {
            return true;
        }
        return false;
    }

    public String getClientId() {
        return this.clientId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getClientId() == null) {
            hashCode = 0;
        } else {
            hashCode = getClientId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUserPoolId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getUserPoolId().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getClientName() != null) {
            i10 = getClientName().hashCode();
        }
        return i12 + i10;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setClientName(String str) {
        this.clientName = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getClientName() != null) {
            sb.append("ClientName: " + getClientName());
        }
        sb.append("}");
        return sb.toString();
    }

    public UserPoolClientDescription withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public UserPoolClientDescription withClientName(String str) {
        this.clientName = str;
        return this;
    }

    public UserPoolClientDescription withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
