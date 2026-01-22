package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListKeysRequest extends AmazonWebServiceRequest implements Serializable {
    private Integer limit;
    private String marker;

    public boolean equals(Object obj) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ListKeysRequest)) {
            return false;
        }
        ListKeysRequest listKeysRequest = (ListKeysRequest) obj;
        if (listKeysRequest.getLimit() == null) {
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
        if (listKeysRequest.getLimit() != null && !listKeysRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if (listKeysRequest.getMarker() == null) {
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
        if (listKeysRequest.getMarker() == null || listKeysRequest.getMarker().equals(getMarker())) {
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

    public int hashCode() {
        int hashCode;
        int i10 = 0;
        if (getLimit() == null) {
            hashCode = 0;
        } else {
            hashCode = getLimit().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getMarker() != null) {
            i10 = getMarker().hashCode();
        }
        return i11 + i10;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setMarker(String str) {
        this.marker = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getMarker() != null) {
            sb.append("Marker: " + getMarker());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListKeysRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListKeysRequest withMarker(String str) {
        this.marker = str;
        return this;
    }
}
