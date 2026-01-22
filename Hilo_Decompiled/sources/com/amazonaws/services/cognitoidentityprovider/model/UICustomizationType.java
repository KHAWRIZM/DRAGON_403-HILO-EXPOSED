package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.Date;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UICustomizationType implements Serializable {
    private String cSS;
    private String cSSVersion;
    private String clientId;
    private Date creationDate;
    private String imageUrl;
    private Date lastModifiedDate;
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
        if (obj == null || !(obj instanceof UICustomizationType)) {
            return false;
        }
        UICustomizationType uICustomizationType = (UICustomizationType) obj;
        if (uICustomizationType.getUserPoolId() == null) {
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
        if (uICustomizationType.getUserPoolId() != null && !uICustomizationType.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (uICustomizationType.getClientId() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getClientId() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (uICustomizationType.getClientId() != null && !uICustomizationType.getClientId().equals(getClientId())) {
            return false;
        }
        if (uICustomizationType.getImageUrl() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getImageUrl() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (uICustomizationType.getImageUrl() != null && !uICustomizationType.getImageUrl().equals(getImageUrl())) {
            return false;
        }
        if (uICustomizationType.getCSS() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getCSS() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (uICustomizationType.getCSS() != null && !uICustomizationType.getCSS().equals(getCSS())) {
            return false;
        }
        if (uICustomizationType.getCSSVersion() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getCSSVersion() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (uICustomizationType.getCSSVersion() != null && !uICustomizationType.getCSSVersion().equals(getCSSVersion())) {
            return false;
        }
        if (uICustomizationType.getLastModifiedDate() == null) {
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
        if (uICustomizationType.getLastModifiedDate() != null && !uICustomizationType.getLastModifiedDate().equals(getLastModifiedDate())) {
            return false;
        }
        if (uICustomizationType.getCreationDate() == null) {
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
        if (uICustomizationType.getCreationDate() == null || uICustomizationType.getCreationDate().equals(getCreationDate())) {
            return true;
        }
        return false;
    }

    public String getCSS() {
        return this.cSS;
    }

    public String getCSSVersion() {
        return this.cSSVersion;
    }

    public String getClientId() {
        return this.clientId;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public Date getLastModifiedDate() {
        return this.lastModifiedDate;
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
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getClientId() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getClientId().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getImageUrl() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getImageUrl().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getCSS() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getCSS().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getCSSVersion() == null) {
            hashCode5 = 0;
        } else {
            hashCode5 = getCSSVersion().hashCode();
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

    public void setCSS(String str) {
        this.cSS = str;
    }

    public void setCSSVersion(String str) {
        this.cSSVersion = str;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setCreationDate(Date date) {
        this.creationDate = date;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }

    public void setLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
    }

    public void setUserPoolId(String str) {
        this.userPoolId = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getUserPoolId() != null) {
            sb.append("UserPoolId: " + getUserPoolId() + ",");
        }
        if (getClientId() != null) {
            sb.append("ClientId: " + getClientId() + ",");
        }
        if (getImageUrl() != null) {
            sb.append("ImageUrl: " + getImageUrl() + ",");
        }
        if (getCSS() != null) {
            sb.append("CSS: " + getCSS() + ",");
        }
        if (getCSSVersion() != null) {
            sb.append("CSSVersion: " + getCSSVersion() + ",");
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

    public UICustomizationType withCSS(String str) {
        this.cSS = str;
        return this;
    }

    public UICustomizationType withCSSVersion(String str) {
        this.cSSVersion = str;
        return this;
    }

    public UICustomizationType withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public UICustomizationType withCreationDate(Date date) {
        this.creationDate = date;
        return this;
    }

    public UICustomizationType withImageUrl(String str) {
        this.imageUrl = str;
        return this;
    }

    public UICustomizationType withLastModifiedDate(Date date) {
        this.lastModifiedDate = date;
        return this;
    }

    public UICustomizationType withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
