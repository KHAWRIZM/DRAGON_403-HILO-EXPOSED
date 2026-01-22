package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GroupType implements Serializable {
    private Date creationDate;
    private String description;
    private String groupName;
    private Date lastModifiedDate;
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
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GroupType)) {
            return false;
        }
        GroupType groupType = (GroupType) obj;
        if (groupType.getGroupName() == null) {
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
        if (groupType.getGroupName() != null && !groupType.getGroupName().equals(getGroupName())) {
            return false;
        }
        if (groupType.getUserPoolId() == null) {
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
        if (groupType.getUserPoolId() != null && !groupType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (groupType.getDescription() == null) {
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
        if (groupType.getDescription() != null && !groupType.getDescription().equals(getDescription())) {
            return false;
        }
        if (groupType.getRoleArn() == null) {
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
        if (groupType.getRoleArn() != null && !groupType.getRoleArn().equals(getRoleArn())) {
            return false;
        }
        if (groupType.getPrecedence() == null) {
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
        if (groupType.getPrecedence() != null && !groupType.getPrecedence().equals(getPrecedence())) {
            return false;
        }
        if (groupType.getLastModifiedDate() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getLastModifiedDate() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (groupType.getLastModifiedDate() != null && !groupType.getLastModifiedDate().equals(getLastModifiedDate())) {
            return false;
        }
        if (groupType.getCreationDate() == null) {
            z22 = true;
        } else {
            z22 = false;
        }
        if (getCreationDate() == null) {
            z23 = true;
        } else {
            z23 = false;
        }
        if (z22 ^ z23) {
            return false;
        }
        if (groupType.getCreationDate() == null || groupType.getCreationDate().equals(getCreationDate())) {
            return true;
        }
        return false;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getDescription() {
        return this.description;
    }

    public String getGroupName() {
        return this.groupName;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
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
        int hashCode5;
        int hashCode6;
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
        if (getPrecedence() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getPrecedence().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getLastModifiedDate() == null) {
            hashCode6 = 0;
        } else {
            hashCode6 = getLastModifiedDate().hashCode();
        }
        int i16 = (i15 + hashCode6) * 31;
        if (getCreationDate() != null) {
            i10 = getCreationDate().hashCode();
        }
        return i16 + i10;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setGroupName(String str) {
        this.groupName = str;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
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
            sb.append("Precedence: " + getPrecedence() + ",");
        }
        if (getLastModifiedDate() != null) {
            sb.append("LastModifiedDate: " + getLastModifiedDate() + ",");
        }
        if (getCreationDate() != null) {
            sb.append("CreationDate: " + getCreationDate());
        }
        sb.append("}");
        return sb.toString();
    }

    public GroupType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public GroupType withDescription(String str) {
        this.description = str;
        return this;
    }

    public GroupType withGroupName(String str) {
        this.groupName = str;
        return this;
    }

    public GroupType withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public GroupType withPrecedence(Integer num) {
        this.precedence = num;
        return this;
    }

    public GroupType withRoleArn(String str) {
        this.roleArn = str;
        return this;
    }

    public GroupType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
