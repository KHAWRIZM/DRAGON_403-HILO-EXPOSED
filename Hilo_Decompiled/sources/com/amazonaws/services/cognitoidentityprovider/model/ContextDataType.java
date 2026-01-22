package com.amazonaws.services.cognitoidentityprovider.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ContextDataType implements Serializable {
    private String encodedData;
    private List<HttpHeader> httpHeaders;
    private String ipAddress;
    private String serverName;
    private String serverPath;

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
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ContextDataType)) {
            return false;
        }
        ContextDataType contextDataType = (ContextDataType) obj;
        if (contextDataType.getIpAddress() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getIpAddress() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (contextDataType.getIpAddress() != null && !contextDataType.getIpAddress().equals(getIpAddress())) {
            return false;
        }
        if (contextDataType.getServerName() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getServerName() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (contextDataType.getServerName() != null && !contextDataType.getServerName().equals(getServerName())) {
            return false;
        }
        if (contextDataType.getServerPath() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getServerPath() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (contextDataType.getServerPath() != null && !contextDataType.getServerPath().equals(getServerPath())) {
            return false;
        }
        if (contextDataType.getHttpHeaders() == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (getHttpHeaders() == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z16 ^ z17) {
            return false;
        }
        if (contextDataType.getHttpHeaders() != null && !contextDataType.getHttpHeaders().equals(getHttpHeaders())) {
            return false;
        }
        if (contextDataType.getEncodedData() == null) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (getEncodedData() == null) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z18 ^ z19) {
            return false;
        }
        if (contextDataType.getEncodedData() == null || contextDataType.getEncodedData().equals(getEncodedData())) {
            return true;
        }
        return false;
    }

    public String getEncodedData() {
        return this.encodedData;
    }

    public List<HttpHeader> getHttpHeaders() {
        return this.httpHeaders;
    }

    public String getIpAddress() {
        return this.ipAddress;
    }

    public String getServerName() {
        return this.serverName;
    }

    public String getServerPath() {
        return this.serverPath;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        int i10 = 0;
        if (getIpAddress() == null) {
            hashCode = 0;
        } else {
            hashCode = getIpAddress().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getServerName() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getServerName().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getServerPath() == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = getServerPath().hashCode();
        }
        int i13 = (i12 + hashCode3) * 31;
        if (getHttpHeaders() == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = getHttpHeaders().hashCode();
        }
        int i14 = (i13 + hashCode4) * 31;
        if (getEncodedData() != null) {
            i10 = getEncodedData().hashCode();
        }
        return i14 + i10;
    }

    public void setEncodedData(String str) {
        this.encodedData = str;
    }

    public void setHttpHeaders(Collection<HttpHeader> collection) {
        if (collection == null) {
            this.httpHeaders = null;
        } else {
            this.httpHeaders = new ArrayList(collection);
        }
    }

    public void setIpAddress(String str) {
        this.ipAddress = str;
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    public void setServerPath(String str) {
        this.serverPath = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getIpAddress() != null) {
            sb.append("IpAddress: " + getIpAddress() + ",");
        }
        if (getServerName() != null) {
            sb.append("ServerName: " + getServerName() + ",");
        }
        if (getServerPath() != null) {
            sb.append("ServerPath: " + getServerPath() + ",");
        }
        if (getHttpHeaders() != null) {
            sb.append("HttpHeaders: " + getHttpHeaders() + ",");
        }
        if (getEncodedData() != null) {
            sb.append("EncodedData: " + getEncodedData());
        }
        sb.append("}");
        return sb.toString();
    }

    public ContextDataType withEncodedData(String str) {
        this.encodedData = str;
        return this;
    }

    public ContextDataType withHttpHeaders(HttpHeader... httpHeaderArr) {
        if (getHttpHeaders() == null) {
            this.httpHeaders = new ArrayList(httpHeaderArr.length);
        }
        for (HttpHeader httpHeader : httpHeaderArr) {
            this.httpHeaders.add(httpHeader);
        }
        return this;
    }

    public ContextDataType withIpAddress(String str) {
        this.ipAddress = str;
        return this;
    }

    public ContextDataType withServerName(String str) {
        this.serverName = str;
        return this;
    }

    public ContextDataType withServerPath(String str) {
        this.serverPath = str;
        return this;
    }

    public ContextDataType withHttpHeaders(Collection<HttpHeader> collection) {
        setHttpHeaders(collection);
        return this;
    }
}
