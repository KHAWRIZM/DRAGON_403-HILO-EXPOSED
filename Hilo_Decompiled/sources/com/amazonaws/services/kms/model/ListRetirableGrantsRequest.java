package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListRetirableGrantsRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer limit;
    private String marker;
    private String retiringPrincipal;

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
        if (obj == null || !(obj instanceof ListRetirableGrantsRequest)) {
            return false;
        }
        ListRetirableGrantsRequest listRetirableGrantsRequest = (ListRetirableGrantsRequest) obj;
        if (listRetirableGrantsRequest.getLimit() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getLimit() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (listRetirableGrantsRequest.getLimit() != null && !listRetirableGrantsRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if (listRetirableGrantsRequest.getMarker() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getMarker() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (listRetirableGrantsRequest.getMarker() != null && !listRetirableGrantsRequest.getMarker().equals(getMarker())) {
            return false;
        }
        if (listRetirableGrantsRequest.getRetiringPrincipal() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getRetiringPrincipal() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (listRetirableGrantsRequest.getRetiringPrincipal() == null || listRetirableGrantsRequest.getRetiringPrincipal().equals(getRetiringPrincipal())) {
            return true;
        }
        return false;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getMarker() {
        return this.marker;
    }

    public String getRetiringPrincipal() {
        return this.retiringPrincipal;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getLimit() == null) {
            hashCode = 0;
        } else {
            hashCode = getLimit().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getMarker() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getMarker().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getRetiringPrincipal() != null) {
            i10 = getRetiringPrincipal().hashCode();
        }
        return i12 + i10;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public void setRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getMarker() != null) {
            sb.append("Marker: " + getMarker() + ",");
        }
        if (getRetiringPrincipal() != null) {
            sb.append("RetiringPrincipal: " + getRetiringPrincipal());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListRetirableGrantsRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListRetirableGrantsRequest withMarker(String str) {
        this.marker = str;
        return this;
    }

    public ListRetirableGrantsRequest withRetiringPrincipal(String str) {
        this.retiringPrincipal = str;
        return this;
    }
}
