package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DescribeUserPoolResult implements Serializable {
    private UserPoolType userPool;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DescribeUserPoolResult)) {
            return false;
        }
        DescribeUserPoolResult describeUserPoolResult = (DescribeUserPoolResult) obj;
        if (describeUserPoolResult.getUserPool() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserPool() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (describeUserPoolResult.getUserPool() == null || describeUserPoolResult.getUserPool().equals(getUserPool())) {
            return true;
        }
        return false;
    }

    public UserPoolType getUserPool() {
        return this.userPool;
    }

    public int hashCode() {
        int hashCode;
        if (getUserPool() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPool().hashCode();
        }
        return 31 + hashCode;
    }

    public void setUserPool(UserPoolType userPoolType) {
        this.userPool = userPoolType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPool() != null) {
            sb.append("UserPool: " + getUserPool());
        }
        sb.append("}");
        return sb.toString();
    }

    public DescribeUserPoolResult withUserPool(UserPoolType userPoolType) {
        this.userPool = userPoolType;
        return this;
    }
}
