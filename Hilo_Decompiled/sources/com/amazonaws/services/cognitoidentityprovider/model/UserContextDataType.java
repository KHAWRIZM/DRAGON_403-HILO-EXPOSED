package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class UserContextDataType implements Serializable {
    private String encodedData;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UserContextDataType)) {
            return false;
        }
        UserContextDataType userContextDataType = (UserContextDataType) obj;
        if (userContextDataType.getEncodedData() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getEncodedData() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (userContextDataType.getEncodedData() == null || userContextDataType.getEncodedData().equals(getEncodedData())) {
            return true;
        }
        return false;
    }

    public String getEncodedData() {
        return this.encodedData;
    }

    public int hashCode() {
        int hashCode;
        if (getEncodedData() == null) {
            hashCode = 0;
        } else {
            hashCode = getEncodedData().hashCode();
        }
        return 31 + hashCode;
    }

    public void setEncodedData(String str) {
        this.encodedData = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getEncodedData() != null) {
            sb.append("EncodedData: " + getEncodedData());
        }
        sb.append("}");
        return sb.toString();
    }

    public UserContextDataType withEncodedData(String str) {
        this.encodedData = str;
        return this;
    }
}
