package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class SetUICustomizationRequest extends AmazonWebServiceRequest implements Serializable {
    private String cSS;
    private String clientId;
    private ByteBuffer imageFile;
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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof SetUICustomizationRequest)) {
            return false;
        }
        SetUICustomizationRequest setUICustomizationRequest = (SetUICustomizationRequest) obj;
        if (setUICustomizationRequest.getUserPoolId() == null) {
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
        if (setUICustomizationRequest.getUserPoolId() != null && !setUICustomizationRequest.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (setUICustomizationRequest.getClientId() == null) {
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
        if (setUICustomizationRequest.getClientId() != null && !setUICustomizationRequest.getClientId().equals(getClientId())) {
            return false;
        }
        if (setUICustomizationRequest.getCSS() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getCSS() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (setUICustomizationRequest.getCSS() != null && !setUICustomizationRequest.getCSS().equals(getCSS())) {
            return false;
        }
        if (setUICustomizationRequest.getImageFile() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getImageFile() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (setUICustomizationRequest.getImageFile() == null || setUICustomizationRequest.getImageFile().equals(getImageFile())) {
            return true;
        }
        return false;
    }

    public String getCSS() {
        return this.cSS;
    }

    public String getClientId() {
        return this.clientId;
    }

    public ByteBuffer getImageFile() {
        return this.imageFile;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
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
        if (getCSS() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getCSS().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getImageFile() != null) {
            i10 = getImageFile().hashCode();
        }
        return i13 + i10;
    }

    public void setCSS(String str) {
        this.cSS = str;
    }

    public void setClientId(String str) {
        this.clientId = str;
    }

    public void setImageFile(ByteBuffer byteBuffer) {
        this.imageFile = byteBuffer;
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
        if (getCSS() != null) {
            sb.append("CSS: " + getCSS() + ",");
        }
        if (getImageFile() != null) {
            sb.append("ImageFile: " + getImageFile());
        }
        sb.append("}");
        return sb.toString();
    }

    public SetUICustomizationRequest withCSS(String str) {
        this.cSS = str;
        return this;
    }

    public SetUICustomizationRequest withClientId(String str) {
        this.clientId = str;
        return this;
    }

    public SetUICustomizationRequest withImageFile(ByteBuffer byteBuffer) {
        this.imageFile = byteBuffer;
        return this;
    }

    public SetUICustomizationRequest withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }
}
