package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListUsersInGroupResult implements Serializable {
    private String nextToken;
    private List<UserType> users;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUsersInGroupResult)) {
            return false;
        }
        ListUsersInGroupResult listUsersInGroupResult = (ListUsersInGroupResult) obj;
        if (listUsersInGroupResult.getUsers() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUsers() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (listUsersInGroupResult.getUsers() != null && !listUsersInGroupResult.getUsers().equals(getUsers())) {
            return false;
        }
        if (listUsersInGroupResult.getNextToken() == null) {
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
        if (listUsersInGroupResult.getNextToken() == null || listUsersInGroupResult.getNextToken().equals(getNextToken())) {
            return true;
        }
        return false;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public List<UserType> getUsers() {
        return this.users;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getUsers() == null) {
            hashCode = 0;
        } else {
            hashCode = getUsers().hashCode();
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

    public void setUsers(Collection<UserType> collection) {
        if (collection == null) {
            this.users = null;
        } else {
            this.users = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUsers() != null) {
            sb.append("Users: " + getUsers() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListUsersInGroupResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public ListUsersInGroupResult withUsers(UserType... userTypeArr) {
        if (getUsers() == null) {
            this.users = new ArrayList(userTypeArr.length);
        }
        for (UserType userType : userTypeArr) {
            this.users.add(userType);
        }
        return this;
    }

    public ListUsersInGroupResult withUsers(Collection<UserType> collection) {
        setUsers(collection);
        return this;
    }
}
