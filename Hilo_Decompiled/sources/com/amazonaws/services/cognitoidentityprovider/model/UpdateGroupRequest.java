package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UpdateGroupRequest extends AmazonWebServiceRequest implements Serializable {
    private String description;
    private String groupName;
    private Integer precedence;
    private String roleArn;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UpdateGroupRequest)) {
            return false;
        }
        UpdateGroupRequest updateGroupRequest = (UpdateGroupRequest) obj;
        if (updateGroupRequest.getGroupName() == null) {
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
        if (updateGroupRequest.getGroupName() != null && !updateGroupRequest.getGroupName().equals(getGroupName())) {
            return false;
        }
        if (updateGroupRequest.getUserPoolId() == null) {
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
        if (updateGroupRequest.getUserPoolId() != null && !updateGroupRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (updateGroupRequest.getDescription() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getDescription() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (updateGroupRequest.getDescription() != null && !updateGroupRequest.getDescription().equals(getDescription())) {
            return false;
        }
        if (updateGroupRequest.getRoleArn() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getRoleArn() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (updateGroupRequest.getRoleArn() != null && !updateGroupRequest.getRoleArn().equals(getRoleArn())) {
            return false;
        }
        if (updateGroupRequest.getPrecedence() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getPrecedence() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (updateGroupRequest.getPrecedence() == null || updateGroupRequest.getPrecedence().equals(getPrecedence())) {
            return true;
        }
        return false;
    }

    public String getDescription() {
        return this.description;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public Integer getPrecedence() {
        return this.precedence;
    }

    public String getRoleArn() {
        return this.roleArn;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i10 = 0;
        if (getGroupName() == null) {
            hashCode = 0;
        } else {
            hashCode = getGroupName().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUserPoolId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getUserPoolId().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getDescription() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getDescription().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getRoleArn() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getRoleArn().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getPrecedence() != null) {
            i10 = getPrecedence().hashCode();
        }
        return i14 + i10;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setPrecedence(Integer num) {
        this.precedence = num;
    }

    public void setRoleArn(String str) {
        this.roleArn = str;
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
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getDescription() != null) {
            sb.append("Description: " + getDescription() + ",");
        }
        if (getRoleArn() != null) {
            sb.append("RoleArn: " + getRoleArn() + ",");
        }
        if (getPrecedence() != null) {
            sb.append("Precedence: " + getPrecedence());
        }
        sb.append("}");
        return sb.toString();
    }

    public UpdateGroupRequest withDescription(String str) {
        this.description = str;
        return this;
    }

    public UpdateGroupRequest withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public UpdateGroupRequest withPrecedence(Integer num) {
        this.precedence = num;
        return this;
    }

    public UpdateGroupRequest withRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public UpdateGroupRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
