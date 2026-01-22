package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListUsersResult implements Serializable {
    private String paginationToken;
    private List<UserType> users;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListUsersResult)) {
            return false;
        }
        ListUsersResult listUsersResult = (ListUsersResult) obj;
        if (listUsersResult.getUsers() == null) {
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
        if (listUsersResult.getUsers() != null && !listUsersResult.getUsers().equals(getUsers())) {
            return false;
        }
        if (listUsersResult.getPaginationToken() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getPaginationToken() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (listUsersResult.getPaginationToken() == null || listUsersResult.getPaginationToken().equals(getPaginationToken())) {
            return true;
        }
        return false;
    }

    public String getPaginationToken() {
        return this.paginationToken;
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
        if (getPaginationToken() != null) {
            i10 = getPaginationToken().hashCode();
        }
        return i11 + i10;
    }

    public void setPaginationToken(String str) {
        this.paginationToken = str;
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
        if (getPaginationToken() != null) {
            sb.append("PaginationToken: " + getPaginationToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListUsersResult withPaginationToken(String str) {
        this.paginationToken = str;
        return this;
    }

    public ListUsersResult withUsers(UserType... userTypeArr) {
        if (getUsers() == null) {
            this.users = new ArrayList(userTypeArr.length);
        }
        for (UserType userType : userTypeArr) {
            this.users.add(userType);
        }
        return this;
    }

    public ListUsersResult withUsers(Collection<UserType> collection) {
        setUsers(collection);
        return this;
    }
}
