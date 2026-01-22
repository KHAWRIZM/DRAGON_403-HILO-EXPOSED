package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminListGroupsForUserResult implements Serializable {
    private List<GroupType> groups;
    private String nextToken;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminListGroupsForUserResult)) {
            return false;
        }
        AdminListGroupsForUserResult adminListGroupsForUserResult = (AdminListGroupsForUserResult) obj;
        if (adminListGroupsForUserResult.getGroups() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getGroups() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (adminListGroupsForUserResult.getGroups() != null && !adminListGroupsForUserResult.getGroups().equals(getGroups())) {
            return false;
        }
        if (adminListGroupsForUserResult.getNextToken() == null) {
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
        if (adminListGroupsForUserResult.getNextToken() == null || adminListGroupsForUserResult.getNextToken().equals(getNextToken())) {
            return true;
        }
        return false;
    }

    public List<GroupType> getGroups() {
        return this.groups;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getGroups() == null) {
            hashCode = 0;
        } else {
            hashCode = getGroups().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getNextToken() != null) {
            i10 = getNextToken().hashCode();
        }
        return i11 + i10;
    }

    public void setGroups(Collection<GroupType> collection) {
        if (collection == null) {
            this.groups = null;
        } else {
            this.groups = new ArrayList(collection);
        }
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getGroups() != null) {
            sb.append("Groups: " + getGroups() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminListGroupsForUserResult withGroups(GroupType... groupTypeArr) {
        if (getGroups() == null) {
            this.groups = new ArrayList(groupTypeArr.length);
        }
        for (GroupType groupType : groupTypeArr) {
            this.groups.add(groupType);
        }
        return this;
    }

    public AdminListGroupsForUserResult withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public AdminListGroupsForUserResult withGroups(Collection<GroupType> collection) {
        setGroups(collection);
        return this;
    }
}
