package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ChangePasswordRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String previousPassword;
    private String proposedPassword;

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
        if (obj == null || !(obj instanceof ChangePasswordRequest)) {
            return false;
        }
        ChangePasswordRequest changePasswordRequest = (ChangePasswordRequest) obj;
        if (changePasswordRequest.getPreviousPassword() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getPreviousPassword() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (changePasswordRequest.getPreviousPassword() != null && !changePasswordRequest.getPreviousPassword().equals(getPreviousPassword())) {
            return false;
        }
        if (changePasswordRequest.getProposedPassword() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getProposedPassword() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (changePasswordRequest.getProposedPassword() != null && !changePasswordRequest.getProposedPassword().equals(getProposedPassword())) {
            return false;
        }
        if (changePasswordRequest.getAccessToken() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getAccessToken() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (changePasswordRequest.getAccessToken() == null || changePasswordRequest.getAccessToken().equals(getAccessToken())) {
            return true;
        }
        return false;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getPreviousPassword() {
        return this.previousPassword;
    }

    public String getProposedPassword() {
        return this.proposedPassword;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getPreviousPassword() == null) {
            hashCode = 0;
        } else {
            hashCode = getPreviousPassword().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getProposedPassword() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getProposedPassword().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getAccessToken() != null) {
            i10 = getAccessToken().hashCode();
        }
        return i12 + i10;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setPreviousPassword(String str) {
        this.previousPassword = str;
    }

    public void setProposedPassword(String str) {
        this.proposedPassword = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getPreviousPassword() != null) {
            sb.append("PreviousPassword: " + getPreviousPassword() + ",");
        }
        if (getProposedPassword() != null) {
            sb.append("ProposedPassword: " + getProposedPassword() + ",");
        }
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ChangePasswordRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public ChangePasswordRequest withPreviousPassword(String str) {
        this.previousPassword = str;
        return this;
    }

    public ChangePasswordRequest withProposedPassword(String str) {
        this.proposedPassword = str;
        return this;
    }
}
