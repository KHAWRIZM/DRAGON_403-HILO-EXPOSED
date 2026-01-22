package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class HttpHeader implements Serializable {
    private String headerName;
    private String headerValue;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof HttpHeader)) {
            return false;
        }
        HttpHeader httpHeader = (HttpHeader) obj;
        if (httpHeader.getHeaderName() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getHeaderName() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (httpHeader.getHeaderName() != null && !httpHeader.getHeaderName().equals(getHeaderName())) {
            return false;
        }
        if (httpHeader.getHeaderValue() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getHeaderValue() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (httpHeader.getHeaderValue() == null || httpHeader.getHeaderValue().equals(getHeaderValue())) {
            return true;
        }
        return false;
    }

    public String getHeaderName() {
        return this.headerName;
    }

    public String getHeaderValue() {
        return this.headerValue;
    }

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getHeaderName() == null) {
            hashCode = 0;
        } else {
            hashCode = getHeaderName().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getHeaderValue() != null) {
            i10 = getHeaderValue().hashCode();
        }
        return i11 + i10;
    }

    public void setHeaderName(String str) {
        this.headerName = str;
    }

    public void setHeaderValue(String str) {
        this.headerValue = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getHeaderName() != null) {
            sb.append("headerName: " + getHeaderName() + ",");
        }
        if (getHeaderValue() != null) {
            sb.append("headerValue: " + getHeaderValue());
        }
        sb.append("}");
        return sb.toString();
    }

    public HttpHeader withHeaderName(String str) {
        this.headerName = str;
        return this;
    }

    public HttpHeader withHeaderValue(String str) {
        this.headerValue = str;
        return this;
    }
}
