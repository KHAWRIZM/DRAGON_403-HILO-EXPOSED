package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetGroupResult implements Serializable {
    private GroupType group;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetGroupResult)) {
            return false;
        }
        GetGroupResult getGroupResult = (GetGroupResult) obj;
        if (getGroupResult.getGroup() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getGroup() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (getGroupResult.getGroup() == null || getGroupResult.getGroup().equals(getGroup())) {
            return true;
        }
        return false;
    }

    public GroupType getGroup() {
        return this.group;
    }

    public int hashCode() {
        int hashCode;
        if (getGroup() == null) {
            hashCode = 0;
        } else {
            hashCode = getGroup().hashCode();
        }
        return 31 + hashCode;
    }

    public void setGroup(GroupType groupType) {
        this.group = groupType;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getGroup() != null) {
            sb.append("Group: " + getGroup());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetGroupResult withGroup(GroupType groupType) {
        this.group = groupType;
        return this;
    }
}
