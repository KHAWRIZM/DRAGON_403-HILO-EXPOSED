package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminCreateUserResult implements Serializable {
    private UserType user;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminCreateUserResult)) {
            return false;
        }
        AdminCreateUserResult adminCreateUserResult = (AdminCreateUserResult) obj;
        if (adminCreateUserResult.getUser() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUser() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (adminCreateUserResult.getUser() == null || adminCreateUserResult.getUser().equals(getUser())) {
            return true;
        }
        return false;
    }

    public UserType getUser() {
        return this.user;
    }

    public int hashCode() {
        int hashCode;
        if (getUser() == null) {
            hashCode = 0;
        } else {
            hashCode = getUser().hashCode();
        }
        return 31 + hashCode;
    }

    public void setUser(UserType userType) {
        this.user = userType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUser() != null) {
            sb.append("User: " + getUser());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminCreateUserResult withUser(UserType userType) {
        this.user = userType;
        return this;
    }
}
