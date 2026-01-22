package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class GetCSVHeaderResult implements Serializable {
    private List<String> cSVHeader;
    private String userPoolId;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof GetCSVHeaderResult)) {
            return false;
        }
        GetCSVHeaderResult getCSVHeaderResult = (GetCSVHeaderResult) obj;
        if (getCSVHeaderResult.getUserPoolId() == null) {
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
        if (getCSVHeaderResult.getUserPoolId() != null && !getCSVHeaderResult.getUserPoolId().equals(getUserPoolId())) {
            return false;
        }
        if (getCSVHeaderResult.getCSVHeader() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getCSVHeader() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (getCSVHeaderResult.getCSVHeader() == null || getCSVHeaderResult.getCSVHeader().equals(getCSVHeader())) {
            return true;
        }
        return false;
    }

    public List<String> getCSVHeader() {
        return this.cSVHeader;
    }

    public String getUserPoolId() {
        return this.userPoolId;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getUserPoolId() == null) {
            hashCode = 0;
        } else {
            hashCode = getUserPoolId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getCSVHeader() != null) {
            i10 = getCSVHeader().hashCode();
        }
        return i11 + i10;
    }

    public void setCSVHeader(Collection<String> collection) {
        if (collection == null) {
            this.cSVHeader = null;
        } else {
            this.cSVHeader = new ArrayList(collection);
        }
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
        if (getCSVHeader() != null) {
            sb.append("CSVHeader: " + getCSVHeader());
        }
        sb.append("}");
        return sb.toString();
    }

    public GetCSVHeaderResult withCSVHeader(String... strArr) {
        if (getCSVHeader() == null) {
            this.cSVHeader = new ArrayList(strArr.length);
        }
        for (String str : strArr) {
            this.cSVHeader.add(str);
        }
        return this;
    }

    public GetCSVHeaderResult withUserPoolId(String str) {
        this.userPoolId = str;
        return this;
    }

    public GetCSVHeaderResult withCSVHeader(Collection<String> collection) {
        setCSVHeader(collection);
        return this;
    }
}
