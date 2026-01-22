package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DeleteUserAttributesRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private List<String> userAttributeNames;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteUserAttributesRequest)) {
            return false;
        }
        DeleteUserAttributesRequest deleteUserAttributesRequest = (DeleteUserAttributesRequest) obj;
        if (deleteUserAttributesRequest.getUserAttributeNames() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getUserAttributeNames() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (deleteUserAttributesRequest.getUserAttributeNames() != null && !deleteUserAttributesRequest.getUserAttributeNames().equals(getUserAttributeNames())) {
            return false;
        }
        if (deleteUserAttributesRequest.getAccessToken() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getAccessToken() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (deleteUserAttributesRequest.getAccessToken() == null || deleteUserAttributesRequest.getAccessToken().equals(getAccessToken())) {
            return true;
        }
        return false;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public List<String> getUserAttributeNames() {
        return this.userAttributeNames;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getUserAttributeNames() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserAttributeNames().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getAccessToken() != null) {
            i10 = getAccessToken().hashCode();
        }
        return i11 + i10;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setUserAttributeNames(Collection<String> collection) {
        if (collection == null) {
            this.userAttributeNames = null;
        } else {
            this.userAttributeNames = new ArrayList(collection);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserAttributeNames() != null) {
            sb.append("UserAttributeNames: " + getUserAttributeNames() + ",");
        }
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public DeleteUserAttributesRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public DeleteUserAttributesRequest withUserAttributeNames(String... strArr) {
        if (getUserAttributeNames() == null) {
            this.userAttributeNames = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.userAttributeNames.add(str);
        }
        return this;
    }

    public DeleteUserAttributesRequest withUserAttributeNames(Collection<String> collection) {
        setUserAttributeNames(collection);
        return this;
    }
}
