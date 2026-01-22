package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class CreateUserPoolClientResult implements Serializable {
    private UserPoolClientType userPoolClient;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof CreateUserPoolClientResult)) {
            return false;
        }
        CreateUserPoolClientResult createUserPoolClientResult = (CreateUserPoolClientResult) obj;
        if (createUserPoolClientResult.getUserPoolClient() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserPoolClient() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (createUserPoolClientResult.getUserPoolClient() == null || createUserPoolClientResult.getUserPoolClient().equals(getUserPoolClient())) {
            return true;
        }
        return false;
    }

    public UserPoolClientType getUserPoolClient() {
        return this.userPoolClient;
    }

    public int hashCode() {
        int hashCode;
        if (getUserPoolClient() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolClient().hashCode();
        }
        return 31 + hashCode;
    }

    public void setUserPoolClient(UserPoolClientType userPoolClientType) {
        this.userPoolClient = userPoolClientType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolClient() != null) {
            sb.append("UserPoolClient: " + getUserPoolClient());
        }
        sb.append("}");
        return sb.toString();
    }

    public CreateUserPoolClientResult withUserPoolClient(UserPoolClientType userPoolClientType) {
        this.userPoolClient = userPoolClientType;
        return this;
    }
}
