package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UpdateGroupResult implements Serializable {
    private GroupType group;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateGroupResult)) {
            return false;
        }
        UpdateGroupResult updateGroupResult = (UpdateGroupResult) obj;
        if (updateGroupResult.getGroup() == null) {
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
        if (updateGroupResult.getGroup() == null || updateGroupResult.getGroup().equals(getGroup())) {
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

    public UpdateGroupResult withGroup(GroupType groupType) {
        this.group = groupType;
        return this;
    }
}
