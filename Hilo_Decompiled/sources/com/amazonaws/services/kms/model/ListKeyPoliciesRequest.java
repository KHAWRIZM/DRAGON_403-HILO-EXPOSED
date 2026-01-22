package com.amazonaws.services.kms.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListKeyPoliciesRequest extends AmazonWebServiceRequest implements Serializable {
    private String keyId;
    private Integer limit;
    private String marker;

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
        if (obj == null || !(obj instanceof ListKeyPoliciesRequest)) {
            return false;
        }
        ListKeyPoliciesRequest listKeyPoliciesRequest = (ListKeyPoliciesRequest) obj;
        if (listKeyPoliciesRequest.getKeyId() == null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (getKeyId() == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z10 ^ z11) {
            return false;
        }
        if (listKeyPoliciesRequest.getKeyId() != null && !listKeyPoliciesRequest.getKeyId().equals(getKeyId())) {
            return false;
        }
        if (listKeyPoliciesRequest.getLimit() == null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (getLimit() == null) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z12 ^ z13) {
            return false;
        }
        if (listKeyPoliciesRequest.getLimit() != null && !listKeyPoliciesRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if (listKeyPoliciesRequest.getMarker() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getMarker() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (listKeyPoliciesRequest.getMarker() == null || listKeyPoliciesRequest.getMarker().equals(getMarker())) {
            return true;
        }
        return false;
    }

    public String getKeyId() {
        return this.keyId;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getMarker() {
        return this.marker;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getKeyId() == null) {
            hashCode = 0;
        } else {
            hashCode = getKeyId().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getLimit() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getLimit().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getMarker() != null) {
            i10 = getMarker().hashCode();
        }
        return i12 + i10;
    }

    public void setKeyId(String str) {
        this.keyId = str;
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
        if (getKeyId() != null) {
            sb.append("KeyId: " + getKeyId() + ",");
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getMarker() != null) {
            sb.append("Marker: " + getMarker());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListKeyPoliciesRequest withKeyId(String str) {
        this.keyId = str;
        return this;
    }

    public ListKeyPoliciesRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListKeyPoliciesRequest withMarker(String str) {
        this.marker = str;
        return this;
    }
}
