package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class DeleteUserRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteUserRequest)) {
            return false;
        }
        DeleteUserRequest deleteUserRequest = (DeleteUserRequest) obj;
        if (deleteUserRequest.getAccessToken() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getAccessToken() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (deleteUserRequest.getAccessToken() == null || deleteUserRequest.getAccessToken().equals(getAccessToken())) {
            return true;
        }
        return false;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public int hashCode() {
        int hashCode;
        if (getAccessToken() == null) {
            hashCode = 0;
        } else {
            hashCode = getAccessToken().hashCode();
        }
        return 31 + hashCode;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public DeleteUserRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }
}
