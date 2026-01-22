package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DeleteGroupRequest extends AmazonWebServiceRequest implements Serializable {
    private String groupName;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteGroupRequest)) {
            return false;
        }
        DeleteGroupRequest deleteGroupRequest = (DeleteGroupRequest) obj;
        if (deleteGroupRequest.getGroupName() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getGroupName() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (deleteGroupRequest.getGroupName() != null && !deleteGroupRequest.getGroupName().equals(getGroupName())) {
            return false;
        }
        if (deleteGroupRequest.getUserPoolId() == null) {
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
        if (deleteGroupRequest.getUserPoolId() == null || deleteGroupRequest.getUserPoolId().equals(getUserPoolId())) {
            return true;
        }
        return false;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getGroupName() == null) {
            hashCode = 0;
        } else {
            hashCode = getGroupName().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUserPoolId() != null) {
            i10 = getUserPoolId().hashCode();
        }
        return i11 + i10;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getGroupName() != null) {
            sb.append("GroupName: " + getGroupName() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId());
        }
        sb.append("}");
        return sb.toString();
    }

    public DeleteGroupRequest withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public DeleteGroupRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
