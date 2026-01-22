package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AdminDeleteUserAttributesRequest extends AmazonWebServiceRequest implements Serializable {
    private List<String> userAttributeNames;
    private String userPoolId;
    private String username;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AdminDeleteUserAttributesRequest)) {
            return false;
        }
        AdminDeleteUserAttributesRequest adminDeleteUserAttributesRequest = (AdminDeleteUserAttributesRequest) obj;
        if (adminDeleteUserAttributesRequest.getUserPoolId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserPoolId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (adminDeleteUserAttributesRequest.getUserPoolId() != null && !adminDeleteUserAttributesRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (adminDeleteUserAttributesRequest.getUsername() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getUsername() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (adminDeleteUserAttributesRequest.getUsername() != null && !adminDeleteUserAttributesRequest.getUsername().equals(getUsername())) {
            return false;
        }
        if (adminDeleteUserAttributesRequest.getUserAttributeNames() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getUserAttributeNames() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (adminDeleteUserAttributesRequest.getUserAttributeNames() == null || adminDeleteUserAttributesRequest.getUserAttributeNames().equals(getUserAttributeNames())) {
            return true;
        }
        return false;
    }

    public List<String> getUserAttributeNames() {
        return this.userAttributeNames;
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
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getUsername() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getUsername().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getUserAttributeNames() != null) {
            i10 = getUserAttributeNames().hashCode();
        }
        return i12 + i10;
    }

    public void setUserAttributeNames(Collection<String> collection) {
        if (collection == null) {
            this.userAttributeNames = null;
        } else {
            this.userAttributeNames = new ArrayList(collection);
        }
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
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getUsername() != null) {
            sb.append("Username: " + getUsername() + ",");
        }
        if (getUserAttributeNames() != null) {
            sb.append("UserAttributeNames: " + getUserAttributeNames());
        }
        sb.append("}");
        return sb.toString();
    }

    public AdminDeleteUserAttributesRequest withUserAttributeNames(String... strArr) {
        if (getUserAttributeNames() == null) {
            this.userAttributeNames = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.userAttributeNames.add(str);
        }
        return this;
    }

    public AdminDeleteUserAttributesRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public AdminDeleteUserAttributesRequest withUsername(String str) {
        this.username = str;
        return this;
    }

    public AdminDeleteUserAttributesRequest withUserAttributeNames(Collection<String> collection) {
        setUserAttributeNames(collection);
        return this;
    }
}
