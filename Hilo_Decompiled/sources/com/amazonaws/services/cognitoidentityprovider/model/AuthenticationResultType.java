package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class AuthenticationResultType implements Serializable {
    private String accessToken;
    private Integer expiresIn;
    private String idToken;
    private NewDeviceMetadataType newDeviceMetadata;
    private String refreshToken;
    private String tokenType;

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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AuthenticationResultType)) {
            return false;
        }
        AuthenticationResultType authenticationResultType = (AuthenticationResultType) obj;
        if (authenticationResultType.getAccessToken() == null) {
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
        if (authenticationResultType.getAccessToken() != null && !authenticationResultType.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if (authenticationResultType.getExpiresIn() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getExpiresIn() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (authenticationResultType.getExpiresIn() != null && !authenticationResultType.getExpiresIn().equals(getExpiresIn())) {
            return false;
        }
        if (authenticationResultType.getTokenType() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getTokenType() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (authenticationResultType.getTokenType() != null && !authenticationResultType.getTokenType().equals(getTokenType())) {
            return false;
        }
        if (authenticationResultType.getRefreshToken() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getRefreshToken() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (authenticationResultType.getRefreshToken() != null && !authenticationResultType.getRefreshToken().equals(getRefreshToken())) {
            return false;
        }
        if (authenticationResultType.getIdToken() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getIdToken() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (authenticationResultType.getIdToken() != null && !authenticationResultType.getIdToken().equals(getIdToken())) {
            return false;
        }
        if (authenticationResultType.getNewDeviceMetadata() == null) {
            z20 = true;
        } else {
            z20 = false;
        }
        if (getNewDeviceMetadata() == null) {
            z21 = true;
        } else {
            z21 = false;
        }
        if (z20 ^ z21) {
            return false;
        }
        if (authenticationResultType.getNewDeviceMetadata() == null || authenticationResultType.getNewDeviceMetadata().equals(getNewDeviceMetadata())) {
            return true;
        }
        return false;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public Integer getExpiresIn() {
        return this.expiresIn;
    }

    public String getIdToken() {
        return this.idToken;
    }

    public NewDeviceMetadataType getNewDeviceMetadata() {
        return this.newDeviceMetadata;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int hashCode5;
        int i10 = 0;
        if (getAccessToken() == null) {
            hashCode = 0;
        } else {
            hashCode = getAccessToken().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getExpiresIn() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getExpiresIn().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getTokenType() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getTokenType().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getRefreshToken() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getRefreshToken().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getIdToken() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getIdToken().hashCode();
        }
        int i15 = (i14 + hashCode5) * 31;
        if (getNewDeviceMetadata() != null) {
            i10 = getNewDeviceMetadata().hashCode();
        }
        return i15 + i10;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setExpiresIn(Integer num) {
        this.expiresIn = num;
    }

    public void setIdToken(String str) {
        this.idToken = str;
    }

    public void setNewDeviceMetadata(NewDeviceMetadataType newDeviceMetadataType) {
        this.newDeviceMetadata = newDeviceMetadataType;
    }

    public void setRefreshToken(String str) {
        this.refreshToken = str;
    }

    public void setTokenType(String str) {
        this.tokenType = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getExpiresIn() != null) {
            sb.append("ExpiresIn: " + getExpiresIn() + ",");
        }
        if (getTokenType() != null) {
            sb.append("TokenType: " + getTokenType() + ",");
        }
        if (getRefreshToken() != null) {
            sb.append("RefreshToken: " + getRefreshToken() + ",");
        }
        if (getIdToken() != null) {
            sb.append("IdToken: " + getIdToken() + ",");
        }
        if (getNewDeviceMetadata() != null) {
            sb.append("NewDeviceMetadata: " + getNewDeviceMetadata());
        }
        sb.append("}");
        return sb.toString();
    }

    public AuthenticationResultType withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public AuthenticationResultType withExpiresIn(Integer num) {
        this.expiresIn = num;
        return this;
    }

    public AuthenticationResultType withIdToken(String str) {
        this.idToken = str;
        return this;
    }

    public AuthenticationResultType withNewDeviceMetadata(NewDeviceMetadataType newDeviceMetadataType) {
        this.newDeviceMetadata = newDeviceMetadataType;
        return this;
    }

    public AuthenticationResultType withRefreshToken(String str) {
        this.refreshToken = str;
        return this;
    }

    public AuthenticationResultType withTokenType(String str) {
        this.tokenType = str;
        return this;
    }
}
