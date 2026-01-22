package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminListGroupsForUserRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer limit;
    private String nextToken;
    private String userPoolId;
    private String username;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminListGroupsForUserRequest)) {
            return false;
        }
        AdminListGroupsForUserRequest adminListGroupsForUserRequest = (AdminListGroupsForUserRequest) obj;
        if (adminListGroupsForUserRequest.getUsername() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUsername() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (adminListGroupsForUserRequest.getUsername() != null && !adminListGroupsForUserRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if (adminListGroupsForUserRequest.getUserPoolId() == null) {
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
        if (adminListGroupsForUserRequest.getUserPoolId() != null && !adminListGroupsForUserRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (adminListGroupsForUserRequest.getLimit() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getLimit() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (adminListGroupsForUserRequest.getLimit() != null && !adminListGroupsForUserRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if (adminListGroupsForUserRequest.getNextToken() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getNextToken() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (adminListGroupsForUserRequest.getNextToken() == null || adminListGroupsForUserRequest.getNextToken().equals(getNextToken())) {
            return true;
        }
        return false;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getNextToken() {
        return this.nextToken;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i10 = 0;
        if (getUsername() == null) {
            hashCode = 0;
        } else {
            hashCode = getUsername().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUserPoolId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getUserPoolId().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getLimit() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getLimit().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getNextToken() != null) {
            i10 = getNextToken().hashCode();
        }
        return i13 + i10;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setNextToken(String str) {
        this.nextToken = str;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public void setUsername(String str) {
        this.username = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getNextToken() != null) {
            sb.append("NextToken: " + getNextToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminListGroupsForUserRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public AdminListGroupsForUserRequest withNextToken(String str) {
        this.nextToken = str;
        return this;
    }

    public AdminListGroupsForUserRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminListGroupsForUserRequest withUsername(String str) {
        this.username = str;
        return this;
    }
}
