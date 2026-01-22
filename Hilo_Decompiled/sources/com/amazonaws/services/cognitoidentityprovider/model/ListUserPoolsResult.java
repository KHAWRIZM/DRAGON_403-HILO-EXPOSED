package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListUserPoolsResult implements Serializable {
    private String nextToken;
    private List<UserPoolDescriptionType> userPools;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUserPoolsResult)) {
            return false;
        }
        ListUserPoolsResult listUserPoolsResult = (ListUserPoolsResult) obj;
        if (listUserPoolsResult.getUserPools() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserPools() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (listUserPoolsResult.getUserPools() != null && !listUserPoolsResult.getUserPools().equals(getUserPools())) {
            return false;
        }
        if (listUserPoolsResult.getNextToken() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getNextToken() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (listUserPoolsResult.getNextToken() == null || listUserPoolsResult.getNextToken().equals(getNextToken())) {
            return true;
        }
        return false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<UserPoolDescriptionType> getUserPools() {
        return this.userPools;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getUserPools() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPools().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getNextToken() != null) {
            i10 = getNextToken().hashCode();
        }
        return i11 + i10;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setUserPools(Collection<UserPoolDescriptionType> collection) {
        if (collection == null) {
            this.userPools = null;
        } else {
            this.userPools = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPools() != null) {
            sb.append("UserPools: " + getUserPools() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListUserPoolsResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListUserPoolsResult withUserPools(UserPoolDescriptionType... userPoolDescriptionTypeArr) {
        if (getUserPools() == null) {
            this.userPools = new ArrayList(userPoolDescriptionTypeArr.length);
        }
        for (UserPoolDescriptionType userPoolDescriptionType : userPoolDescriptionTypeArr) {
            this.userPools.add(userPoolDescriptionType);
        }
        return this;
    }

    public ListUserPoolsResult withUserPools(Collection<UserPoolDescriptionType> collection) {
        setUserPools(collection);
        return this;
    }
}
