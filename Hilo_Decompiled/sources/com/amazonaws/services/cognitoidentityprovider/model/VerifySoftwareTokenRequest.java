package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class VerifySoftwareTokenRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private String friendlyDeviceName;
    private String session;
    private String userCode;

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
        if (obj == null || !(obj instanceof VerifySoftwareTokenRequest)) {
            return false;
        }
        VerifySoftwareTokenRequest verifySoftwareTokenRequest = (VerifySoftwareTokenRequest) obj;
        if (verifySoftwareTokenRequest.getAccessToken() == null) {
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
        if (verifySoftwareTokenRequest.getAccessToken() != null && !verifySoftwareTokenRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if (verifySoftwareTokenRequest.getSession() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getSession() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (verifySoftwareTokenRequest.getSession() != null && !verifySoftwareTokenRequest.getSession().equals(getSession())) {
            return false;
        }
        if (verifySoftwareTokenRequest.getUserCode() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getUserCode() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (verifySoftwareTokenRequest.getUserCode() != null && !verifySoftwareTokenRequest.getUserCode().equals(getUserCode())) {
            return false;
        }
        if (verifySoftwareTokenRequest.getFriendlyDeviceName() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getFriendlyDeviceName() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (verifySoftwareTokenRequest.getFriendlyDeviceName() == null || verifySoftwareTokenRequest.getFriendlyDeviceName().equals(getFriendlyDeviceName())) {
            return true;
        }
        return false;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getFriendlyDeviceName() {
        return this.friendlyDeviceName;
    }

    public String getSession() {
        return this.session;
    }

    public String getUserCode() {
        return this.userCode;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int i10 = 0;
        if (getAccessToken() == null) {
            hashCode = 0;
        } else {
            hashCode = getAccessToken().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getSession() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getSession().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getUserCode() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getUserCode().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getFriendlyDeviceName() != null) {
            i10 = getFriendlyDeviceName().hashCode();
        }
        return i13 + i10;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setFriendlyDeviceName(String str) {
        this.friendlyDeviceName = str;
    }

    public void setSession(String str) {
        this.session = str;
    }

    public void setUserCode(String str) {
        this.userCode = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getSession() != null) {
            sb.append("Session: " + getSession() + ",");
        }
        if (getUserCode() != null) {
            sb.append("UserCode: " + getUserCode() + ",");
        }
        if (getFriendlyDeviceName() != null) {
            sb.append("FriendlyDeviceName: " + getFriendlyDeviceName());
        }
        sb.append("}");
        return sb.toString();
    }

    public VerifySoftwareTokenRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public VerifySoftwareTokenRequest withFriendlyDeviceName(String str) {
        this.friendlyDeviceName = str;
        return this;
    }

    public VerifySoftwareTokenRequest withSession(String str) {
        this.session = str;
        return this;
    }

    public VerifySoftwareTokenRequest withUserCode(String str) {
        this.userCode = str;
        return this;
    }
}
