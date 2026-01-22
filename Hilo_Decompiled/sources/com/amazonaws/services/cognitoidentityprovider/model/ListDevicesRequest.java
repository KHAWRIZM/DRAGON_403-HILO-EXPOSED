package com.amazonaws.services.cognitoidentityprovider.model;

import com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

/* loaded from: C:\Users\admin\Projects\Archive\SULAIMAN_EMPIRE\DEX_FILES\classes.dex */
public class ListDevicesRequest extends AmazonWebServiceRequest implements Serializable {
    private String accessToken;
    private Integer limit;
    private String paginationToken;

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
        if (obj == null || !(obj instanceof ListDevicesRequest)) {
            return false;
        }
        ListDevicesRequest listDevicesRequest = (ListDevicesRequest) obj;
        if (listDevicesRequest.getAccessToken() == null) {
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
        if (listDevicesRequest.getAccessToken() != null && !listDevicesRequest.getAccessToken().equals(getAccessToken())) {
            return false;
        }
        if (listDevicesRequest.getLimit() == null) {
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
        if (listDevicesRequest.getLimit() != null && !listDevicesRequest.getLimit().equals(getLimit())) {
            return false;
        }
        if (listDevicesRequest.getPaginationToken() == null) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (getPaginationToken() == null) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z14 ^ z15) {
            return false;
        }
        if (listDevicesRequest.getPaginationToken() == null || listDevicesRequest.getPaginationToken().equals(getPaginationToken())) {
            return true;
        }
        return false;
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public String getPaginationToken() {
        return this.paginationToken;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int i10 = 0;
        if (getAccessToken() == null) {
            hashCode = 0;
        } else {
            hashCode = getAccessToken().hashCode();
        }
        int i11 = (hashCode + 31) * 31;
        if (getLimit() == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = getLimit().hashCode();
        }
        int i12 = (i11 + hashCode2) * 31;
        if (getPaginationToken() != null) {
            i10 = getPaginationToken().hashCode();
        }
        return i12 + i10;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setLimit(Integer num) {
        this.limit = num;
    }

    public void setPaginationToken(String str) {
        this.paginationToken = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (getAccessToken() != null) {
            sb.append("AccessToken: " + getAccessToken() + ",");
        }
        if (getLimit() != null) {
            sb.append("Limit: " + getLimit() + ",");
        }
        if (getPaginationToken() != null) {
            sb.append("PaginationToken: " + getPaginationToken());
        }
        sb.append("}");
        return sb.toString();
    }

    public ListDevicesRequest withAccessToken(String str) {
        this.accessToken = str;
        return this;
    }

    public ListDevicesRequest withLimit(Integer num) {
        this.limit = num;
        return this;
    }

    public ListDevicesRequest withPaginationToken(String str) {
        this.paginationToken = str;
        return this;
    }
}
